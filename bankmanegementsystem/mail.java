/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanegementsystem;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Lakshya
 */
public class mail{
    mail(String message,String subject,String to)
    {
        String from ="slbank0001@gmail.com";
        Properties property=new Properties();
        property.put("mail.smtp.host","smtp.gmail.com");
        property.put("mail.smtp.port","465");
        property.put("mail.smtp.ssl.enable","true");
        property.put("mail.smtp.auth","true");
        
        Session session=Session.getInstance(property, new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("slbank0001@gmail.com","Lak&Sim@code"); //To change body of generated methods, choose Tools | Templates.
            }
        }
        );
       // session.setDebug(true);
        MimeMessage m=new MimeMessage(session);
        try
        {
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            m.setSubject(subject);
            m.setText(message);
            
            Transport.send(m);  
            JOptionPane.showMessageDialog(null,"Message sent");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
    }

   }
