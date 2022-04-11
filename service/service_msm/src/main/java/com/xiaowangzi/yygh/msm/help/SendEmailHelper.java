package com.xiaowangzi.yygh.msm.help;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class SendEmailHelper {

    public static boolean sendEmail(String account, String code) {
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.qq.com");//邮箱的SMTP服务器，一般126邮箱的是smtp.126.com，qq邮箱为smtp.qq.com
            email.setCharset("utf-8");
            email.addTo(account);//收件人
            email.setFrom("893511872@qq.com", "xiaowangzi");//发件人,用户名可随便填写
            email.setAuthentication("893511872@qq.com", "crbnhrxpofyibbaj");
            email.setSubject("登陆验证码");
            email.setMsg("你好,欢迎登陆仿京医通平台,你的验证码：" + code + "。有效时间2分钟");
            email.send();
            return true;
        } catch (EmailException exception) {
            exception.printStackTrace();
        }
        return false;

    }
}
