package my.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaEmail
{

    Properties emailProperties;
    Session mailSession;
    MimeMessage emailMessage;

    public static void main(String args[])
    {

        JavaEmail javaEmail = new JavaEmail();

        javaEmail.setMailServerProperties();
        try
        {
            javaEmail.createEmailMessage();
            javaEmail.sendEmail();
        }
        catch (AddressException e)
        {
            System.out.println("Address Exception:" + e.getMessage());
            e.printStackTrace();
        }
        catch (MessagingException e)
        {
            System.out.println("Message Exception:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void setMailServerProperties()
    {

//        String emailPort = "587";// gmail's smtp port
        String emailPort = "465";// gmail's smtp port

        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");

    }

    public void createEmailMessage() throws AddressException,
            MessagingException
    {
        // 要发送的邮箱
        String[] toEmails =
                { "yakin881021@gmail.com" };
        String emailSubject = "Java Email";
        String emailBody = "This is an email sent by <b>JavaMail</b> api.";

        mailSession = Session.getDefaultInstance(emailProperties, null);
        emailMessage = new MimeMessage(mailSession);

        for (int i = 0; i < toEmails.length; i++)
        {
            emailMessage.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(toEmails[i]));
        }

        emailMessage.setSubject(emailSubject);
        emailMessage.setContent(emailBody, "text/html");// for a html email
        // emailMessage.setText(emailBody);// for a text email

    }

    public void sendEmail() throws AddressException, MessagingException
    {

        String emailHost = "smtp.gmail.com";
        String fromUser = "yakin881021@gmail.com";// just the id alone without
        // @gmail.com
        String fromUserEmailPassword = "19881021Yakin";

        Transport transport = mailSession.getTransport("smtp");

        transport.connect(emailHost, fromUser, fromUserEmailPassword);
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully.");
    }

}
