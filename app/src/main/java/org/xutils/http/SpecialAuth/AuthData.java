package org.xutils.http.SpecialAuth;

/**
 * Created by jacky on 16/1/22.
 */
public class AuthData {
    private AuthData mAuthData = null;
    private String Realm;
    private String nonce;
    private String qop;

    public AuthData getInstance(){
        if (mAuthData==null){
            mAuthData = new AuthData();
        }
        return mAuthData;
    }

    public String getRealm() {
        return Realm;
    }

    public void setRealm(String realm) {
        Realm = realm;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getQop() {
        return qop;
    }

    public void setQop(String qop) {
        this.qop = qop;
    }
}
