package com.chaitanya.schoolmanagement.service.notification;

import com.chaitanya.schoolmanagement.payload.EmailDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class NotificationService {
    /*@Autowired
    private JavaMailSender javaMailSender;


    public void sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("chaitanya@nexthoughts.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }*/
    @Autowired
    private JavaMailSender javaMailSender;


    public void sendEmail(EmailDto emailDto) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            mimeMessage.setRecipients(Message.RecipientType.TO, emailDto.getTo());
            mimeMessage.setFrom(new InternetAddress(emailDto.getFrom(), "School-Management"));
            mimeMessage.setSubject(emailDto.getSubject());
            mimeMessage.setText(emailDto.getContent());
            javaMailSender.send(mimeMessage);
            log.info("*************Sending Mail To {} *****************" + emailDto.getTo());
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
