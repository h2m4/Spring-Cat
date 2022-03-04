package com.springcat.Utility;

import com.springcat.Model.Cat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Slf4j
@Component
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    // send email with pictures
    public void sendEmailWithAttachment(List<Cat> cats, String receiverEmail, String subject) {
        try {
            MimeMessage msg = javaMailSender.createMimeMessage();
            // true = multipart message
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo(receiverEmail);
            helper.setSubject(subject);
            helper.setText("<h3>Check attachment for cutes cats!</h3>", true);

            for (Cat cat: cats) {
                String picPath = cat.getPicPath().substring(2);
                log.info(picPath);
                helper.addAttachment(cat.getName()+".jpeg", new ClassPathResource(picPath));
            }
            javaMailSender.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
