package security;



import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class email {
	static final String from = "thanvanhuyy@gmail.com";
	static final String pass = "kzfqwzbuuhmzvjzc"; // google cung cap
	
	public static void sendEmail (String to, String title, String body) {
		// khai bao thuoc tinh
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.protocols","TLSv1.2");
		
		// creat Authenticator
		Authenticator authen = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, pass);
				
			}
		};
 		
 		// phien lam viec
 		Session session = Session.getInstance(props, authen);
 		
 		// tao tin nhan can gui
 		Message msg = new MimeMessage(session);
 		
 		try {
 			// kieu noi dung
			msg.addHeader("Content-type","text/HTML;charset= UTF8");
			
			// nguoi gui
			msg.setFrom(new InternetAddress(from));
			
			// nguoi nhan
			msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
			
			// tieu de cho email
			msg.setSubject(title);
			
			//quy dinh ngay gio
			msg.setSentDate(new Date());
			
			// noi dung
			msg.setContent(body, "text/HTML; charset=UTF8");
			
			// gui mail
			Transport.send(msg);
			System.out.println(1);
			
		} catch (MessagingException e) {
			System.out.println(0);
			e.printStackTrace();
		}
 		
	} 
//	public static void main(String[] args) {
//		sendEmail("thanvanhuyy@gmail.com", "DEV VIP", "Qua vippro");
//	}
}
