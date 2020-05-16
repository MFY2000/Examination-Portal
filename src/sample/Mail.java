//package sample;
//
//import java.util.Properties;
//import javax.mail.Session;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//
//public class Mail{
//    public static void main(String[] args) throws MessagingException {
//        SendMail("FA19BSSE0014@maju.edu.pk");
//    }
//    public static void SendMail(String recepient) throws MessagingException {
//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth","true");
//        properties.put("mail.smtp.starttls.enable","true");
//        properties.put("mail.smtp.host","smtp.gmail.com");
//        properties.put("mail.smtp.port","587");
//        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//
//        String myAccoutEmail = "gamaportal8@gmail.com";
//        String password = "DARKLORD1399";
//
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(myAccoutEmail,password);
//            }
//        });
//
//            Message message = prepareMessage(session,myAccoutEmail,recepient);
//            Transport.send(message);
//           System.out.println("Complete the proccess");
//    }
//
//    private static Message prepareMessage(Session session,String myAccoutEmail,String recepient){
//            System.out.println("Perpareing mail");
//         try {
//             Message message  = new MimeMessage(session);
//             message.setFrom(new InternetAddress(myAccoutEmail));
//            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
//            message.setSubject("Forget Password email");
//            message.setText("Hi guy \n, hjadi785");
//            return message;
//        } catch (MessagingException e) {
//            System.out.println("error error");
//        }
//
//        return null;
//    }
//}