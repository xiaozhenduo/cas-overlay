package com.cas;

/**
 * @program com.com.cas-overlay
 * @description:
 * @author: 肖振铎
 * @create: 2019/10/14 20:59
 */
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.apache.commons.lang3.StringUtils;

import org.springframework.security.crypto.password.PasswordEncoder;



/**
 * @author: wangsaichao
 * @date: 2018/7/8
 * @description: 自定义密码验证
 */
public class CustomPasswordEncoder implements PasswordEncoder{

    private static final String SALT = "1qazxsw2";

    private static final String ALGORITH_NAME = "md5";

    private static final int HASH_ITERATIONS = 2;



    /**
     * 对密码进行加密
     * @param rawPassword
     * @return
     */
    @Override
    public String encode(CharSequence rawPassword) {
        try {
            String newPassword = new SimpleHash(ALGORITH_NAME, rawPassword, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
            return newPassword;
        } catch (Exception e) {
            System.out.println("对密码进行md5异常");
            return null;
        }
    }

    /**
     * 判断密码是否匹配
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // 判断密码为空,直接返回false
        System.out.println("对密码进行md5异常");
        if (StringUtils.isBlank(rawPassword)) {
            return false;
        }

        //调用上面的encode 对请求密码进行MD5处理
        String pass = this.encode(rawPassword.toString());


        //比较密码是否相等
        return pass.equals(encodedPassword);
    }
}
