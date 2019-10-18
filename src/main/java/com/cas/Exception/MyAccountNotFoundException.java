package com.cas.Exception;



/**
 * @program cas-overlay
 * @description:
 * @author: 肖振铎
 * @create: 2019/10/18 11:33
 *
 * import org.apereo.cas.authentication.RememberMeUsernamePasswordCredential;
 */
import javax.security.auth.login.AccountException;


public class MyAccountNotFoundException extends AccountException {
    public MyAccountNotFoundException() {
        super();
    }

    public MyAccountNotFoundException(String msg) {
        super(msg);
    }
}
