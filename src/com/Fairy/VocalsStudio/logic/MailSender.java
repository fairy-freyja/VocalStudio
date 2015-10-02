package com.Fairy.VocalsStudio.logic;

/**
 * Created by Fairy on 6/5/2015.
 */

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {

    private static final MailSender instance = new MailSender();
    private final Properties properties;
    private final Session session;
    private final String senderMail = "fairy.freyja@gmail.com";
    private final String password = "";
    private String recipientMail;

    private MailSender() {
        properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.debug", "true");
        properties.put("mail.smtp.port", 25);
        properties.put("mail.smtp.socketFactory.port", 25);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.transport.protocol", "smtp");

        session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, password);
            }
        });
    }

    public static MailSender getInstance() {
        return instance;
    }

    public void send(final String recipientMail, final String userName, final String password) {
        try {
            Transport transport = session.getTransport();
            MimeMessage msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(senderMail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientMail));
            msg.setSubject("Your TestingApp account has been activated");
            String body = "Hello, " + userName + ".\n" +
                    "Use your email, to enter tests. Your temporary password is <" + password + "> .";
            msg.setContent(body, "text/html");
            transport.connect();

            transport.sendMessage(msg, msg.getRecipients(Message.RecipientType.TO));
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MailSender sender = getInstance();
        sender.send("yami.ross@gmail.com", "Andrii", "ololo");
    }
}


