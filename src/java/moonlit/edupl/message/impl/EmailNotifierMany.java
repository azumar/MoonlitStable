/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moonlit.edupl.message.impl;
import java.util.concurrent.Future;

import java.util.Properties;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import moonlit.edupl.account.config.AbstractMessageConfig;
import moonlit.edupl.account.data.Account;
import moonlit.edupl.message.interfaces.IMessageManager;
import moonlit.edupl.validation.controller.AccountCreationEvent;

/**
 *
 * @author umar_
 */
//@Named
@Stateless
public class EmailNotifierMany implements IMessageManager{
      private static  String SMTP_HOST_NAME = "smtp.gmail.com";
	private static  String SMTP_AUTH_USER = "umararmayau@gmail.com";
	private static String SMTP_AUTH_PWD = "Aishat@Zango3579";
        Session session;

    public EmailNotifierMany() {
        Properties props = new Properties();
			props.put("mail.smtp.host", SMTP_HOST_NAME);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			Authenticator auth = new SMTPAuthenticator();
			 session = Session.getInstance(props, auth);
                         session.setDebug(false);
    }
        
        
@Asynchronous
    @Override
    public void sendNotification(Account messageReceiver, AbstractMessageConfig messageObject) {
         try {


			Message message = new MimeMessage(session);

			InternetAddress addressFrom = new InternetAddress(messageObject.getSignature());
			message.setFrom(addressFrom);
			InternetAddress addressTo = new InternetAddress(messageReceiver.getEmail());
			
			message.setRecipient(Message.RecipientType.TO, addressTo);

			message.setSubject(messageObject.getSubject());

			message.setContent(messageObject.getContent(), "text/plain");

			Transport.send(message);

		} catch (Throwable e) {
			e.printStackTrace();
		}
    }
   //
//@Asynchronous
    @Override
    public void sendNotification( @Observes  AccountCreationEvent event) {
        
         try {
			

			Message message = new MimeMessage(session);

			InternetAddress addressFrom = new InternetAddress(event.getAccountMessage().getSignature());
			message.setFrom(addressFrom);
			InternetAddress addressTo = new InternetAddress(event.getAccount().getEmail());
			
			message.setRecipient(Message.RecipientType.TO, addressTo);

			message.setSubject(event.getAccountMessage().getSubject());

			message.setContent(event.getAccountMessage().getContent(), "text/plain");

			Transport.send(message);
                        System.err.println("EMAIL YA TAFI!");

		} catch (Throwable e) {
			e.printStackTrace();
		}
       
    }
    private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			String username = SMTP_AUTH_USER;
			String password = SMTP_AUTH_PWD;
			return new PasswordAuthentication(username, password);
		}
	}
    public static void setSMTP_HOST_NAME(String sMTP_HOST_NAME) {
		SMTP_HOST_NAME = sMTP_HOST_NAME;
	}



	public static void setSMTP_AUTH_USER(String sMTP_AUTH_USER) {
		SMTP_AUTH_USER = sMTP_AUTH_USER;
	}



	public static void setSMTP_AUTH_PWD(String sMTP_AUTH_PWD) {
		SMTP_AUTH_PWD = sMTP_AUTH_PWD;
	}
    
}
