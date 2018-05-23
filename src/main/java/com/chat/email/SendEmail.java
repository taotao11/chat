package com.chat.email;

import com.chat.email.entity.EmailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件
 */
public class SendEmail {
    @Autowired
    private JavaMailSender javaMailSender;
    //发送邮件
    public void send(EmailEntity email) throws MessagingException {
        //
        MimeMessage mimeMailMessage = this.javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMailMessage);
        //发送方
        messageHelper.setFrom("920518289@qq.com");
        //接收方
        messageHelper.setTo(email.getToFrom());
        //主题
        messageHelper.setSubject(email.getSubject());
        //内容
        messageHelper.setText(email.getText());
        //发送
        this.javaMailSender.send(mimeMailMessage);
        System.out.println("success");

    }
}
