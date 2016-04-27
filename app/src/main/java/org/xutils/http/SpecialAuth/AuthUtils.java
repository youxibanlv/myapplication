package org.xutils.http.SpecialAuth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jacky on 16/1/22.
 */
public class AuthUtils {

    /**
     * response生成算法
     * KD（H（A1），unq（nonce-value）“:”nonce-value“:”unq(cnonce-value)“:”unq(qop-value)“:”H（A2））
     *
     *  A1=unq(username-value)”:”unq(real-value)”:”passwd
     如果qop等于auth，A2=Method”:”digest-uri-value
     其中：
     H(data)=MD5(data)
     KD(secret，data)=H(concat(secret,”:”data))
     unq(X)代表取消X前后的引号
     Method=GET或者POST
     * @param da
     * @param method
     * @return [参数说明]
     *
     * @return String [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String generateResponse(AuthHeader da, String method)
    {
        MessageDigest digest = null;
        try
        {
            digest = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new IllegalStateException("No MD5 algorithm available!");
        }

        //A1=unq(username-value)”:”unq(real-value)”:”passwd
        String a1 =
                trimQuot(da.getUsername()) + ":" + trimQuot(da.getRealm()) + ":" + da.getPassword();
        //第一个参数为h_a1
        String hA1 = new String(Hex.encode(digest.digest(a1.getBytes())));

        //A2=Method”:”digest-uri-value
        String a2 = method + ":" + da.getUri();
        String hS2 = new String(Hex.encode(digest.digest(a2.getBytes())));

        //第二个参数为 unq（nonce-value）“:”nonce-value“:”unq(cnonce-value)“:”unq(qop-value)“:”H（A2）
        String data =
                trimQuot(da.getNonce()) + ":" + da.getNc() + ":" + trimQuot(da.getCnonce()) + ":"
                        + trimQuot(da.getQop()) + ":" + hS2;

        String kdsd = hA1 + ":" + data;
        String result = new String(Hex.encode(digest.digest(kdsd.getBytes())));
        return result;
    }
    /**
     * 去掉字符串前后的 引号
     * <功能详细描述>
     * @param str
     * @return [参数说明]
     *
     * @return String [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String trimQuot(String str)
    {
        String[] quots = {"\"", "'"};
        if (str == null)
        {
            return str;
        }
        str = str.trim();
        for (String quot : quots)
        {
            if (str.startsWith(quot))
            {
                str = str.substring(quot.length());
            }
            if (str.endsWith(quot))
            {
                str = str.substring(0, str.length() - quot.length());
            }
        }

        return str;
    }

}
