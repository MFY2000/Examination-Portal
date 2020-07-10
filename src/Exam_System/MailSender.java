package Exam_System;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MailSender {
    public static String Random;
    public static void SendMail(String recepient) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String myAccoutEmail = "gamaportal8@gmail.com";
        String password = "DARKLORD1399";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccoutEmail,password);
            }
        });

        Message message = prepareMessage(session,myAccoutEmail,recepient);
        Transport.send(message);
        System.out.println("Complete the proccess");
    }

    public static String RandomPassword(){

        Random rand = new Random();

        int check;

        int MAX = 26;

        char []alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z' };

        String res = "";
        for (int i = 0; i < 3; i++) {
            res = res + alphabet[rand.nextInt(3) % MAX];
        }
        //(int) (Math.random() * 3 % MAX)
        //alphabet
        String c = res.toUpperCase();
        System.out.print("Number plate is : ");
        System.out.print(c+" ");
        //number
        int[] arr = new int[3];
        for (int i =0 ;i <= 2 ; i++)
        {
            arr[i] = rand.nextInt(10);
        }
        for (int i =0 ;i <= 2 ; i++)
        {
            System.out.println(arr[i]);
        }
        int a =rand.nextInt(10);
        int b = rand.nextInt(10);
        int d = rand.nextInt(10);
        Random = c+"@"+a+""+b+""+d;
        return Random;
    }


    public static Message prepareMessage(Session session,String myAccoutEmail,String recepient){
        System.out.println("Perpareing mail");
        Message message  = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccoutEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("Forget Password email");
            message.setText(RandomPassword());
            return message;
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e);
        }

        return null;
    }
}
