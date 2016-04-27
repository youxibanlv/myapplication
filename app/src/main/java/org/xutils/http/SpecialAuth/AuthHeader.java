package org.xutils.http.SpecialAuth;

/**
 * Created by jacky on 16/1/22.
 * username、password、uri 需要在 发送请求时即设置
 * nc 暂不实现
 * cnonce 固定值smarthome_client用于标识请求平台，algorithm 固定为MD5
 * realm、nonce、qop 初始值通过的401请求失败后获取
 */
public class AuthHeader {
    public String username="hoa";
    public String password = "hoa";
    public String realm="";
    public String nonce="";
    public String uri="/";
    public String qop="";
    public String nc="00000001";
    public String cnonce="igapp";
    public String algorithm="MD5";
    public String response="";
    public String opaque="";
    static AuthHeader mAuthHeader = null;
    public static AuthHeader getInstance(){
        if(mAuthHeader==null){
            mAuthHeader = new AuthHeader();
        }
        return mAuthHeader;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getQop() {
        return qop;
    }

    public void setQop(String qop) {
        this.qop = qop;
    }

    public String getNc() {
        return nc;
    }

    public void setNc(String nc) {
        this.nc = nc;
    }

    public String getCnonce() {
        return cnonce;
    }

    public void setCnonce(String cnonce) {
        this.cnonce = cnonce;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getOpaque() {
        return opaque;
    }

    public void setOpaque(String opaque) {
        this.opaque = opaque;
    }

    public String toAuthHeader(){
        String responseStr = AuthUtils.generateResponse(this,"POST");
        this.setResponse(responseStr);

        StringBuilder hv = new StringBuilder();
        hv.append("Digest ");
        hv.append("username=\"" + getUsername() + "\"");
        hv.append(", realm=\"" + getRealm() + "\"");
        hv.append(", nonce=\"" + getNonce() + "\"");
        hv.append(", uri=\"" + getUri() + "\"");
//        hv.append(", algorithm=\"" + getAlgorithm() + "\"");
        hv.append(", qop=\"" + getQop() + "\"");
        hv.append(", nc=\"" + getNc()+"\"");
        hv.append(", cnonce=\"" + getCnonce() + "\"");
        hv.append(", response=\"" + responseStr + "\"");
        hv.append(", opaque=\"" + getOpaque() + "\"");

        return hv.toString();
    }


    public boolean parserAuthenHeader(String headStr)
    {
        if (!headStr.startsWith("Digest "))
        {
            return false;
        }
        AuthHeader authHeader = getInstance();
        headStr = headStr.substring(7);
        String[] subHeads = headStr.split(",");
        for (int i = 0; i < subHeads.length; i++)
        {
            String subStr = subHeads[i].trim();
            String[] strList = subStr.split("=");
            if (strList.length != 2)
            {
                continue;
            }

            String tag = strList[0];
            String value = strList[1];
            if (tag.equals("nextnonce"))
            {
                value = AuthUtils.trimQuot(value);
                authHeader.setNonce(value);
            }
            else if (tag.equals("nonce"))
            {
                value = AuthUtils.trimQuot(value);
                authHeader.setNonce(value);
            }
            else if (tag.equals("opaque"))
            {
                value = AuthUtils.trimQuot(value);
                authHeader.setOpaque(value);
            }
            else if (tag.equals("realm"))
            {
                value = AuthUtils.trimQuot(value);
                authHeader.setRealm(value);
            }
            else if (tag.equals("qop"))
            {
                value = AuthUtils.trimQuot(value);
                authHeader.setQop(value);
            }
        }
        return true;
    }
}
