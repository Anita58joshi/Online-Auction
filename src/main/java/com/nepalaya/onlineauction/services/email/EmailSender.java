package com.nepalaya.onlineauction.services.email;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.StringWriter;
import java.util.Properties;

public class EmailSender {
    public static void sendEmail(EmailRequest request) {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", request.getHost());
        properties.put("mail.smtp.port", request.getPort());
        properties.put("mail.smtp.ssl.enable", request.isSslEnable());
        properties.put("mail.smtp.auth", request.isAuth());

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(request.getSenderEmail(), request.getPassword());
            }

        });
        session.setDebug(true);
        try {
            MimeMessage message;
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(request.getSenderEmail()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(request.getReceiverEmail()));
            message.setSubject(request.getSubject());
            message.setContent(prepareBody(request), "text/html");
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    private static String prepareBody(EmailRequest request) {
        VelocityContext context = new VelocityContext();
        for (String key : request.getDataMap().keySet()) {
            context.put(key, request.getDataMap().get(key));
        }
        StringWriter writer = new StringWriter();
        Velocity.evaluate(context, writer, "TemplateName", request.getBody());
        return writer.toString();
    }
}
