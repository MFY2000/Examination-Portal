package sample;

public class test {
    public static void main(String[] args) {
        MailMessage send1 = new MailMessage();
        send1.SendMailMessage();
    }
}

class MailMessage{
    private Header header;
    private Body bd;
    private Attachment attachment;

    MailMessage(){
        header = new Header();
        bd = new Body();
        attachment = new Attachment();
    }

    public void SendMailMessage(){
        System.out.println(toString());
    }

    public String toString(){
        return (header.getTitle()+" "+bd.getMessage()+" "+attachment.getFileName());
    }
}

class Header{
    public String Title =   "This is the Header of the mail message";

    public String getTitle() {
        return Title;
    }
}

class Body{
    public String message =   "This is the Body of the mail message";

    public String getMessage() {
        return message;
    }
}

class Attachment{
    public String fileName =   "This is the Attachment of the mail message";

    public String getFileName() {
        return fileName;
    }
}