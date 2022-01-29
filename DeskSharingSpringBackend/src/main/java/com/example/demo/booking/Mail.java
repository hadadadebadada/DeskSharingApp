package com.example.demo.booking;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {

    //Variablen
    private String pname;
    private String pmailadresse;
    private String pstatus;
    private String text;

    // Von uns benutzte Mail fuer das Projekt
    final String username = "DS.WS.2021.2022@gmail.com";
    final String password = "SoftwareprojektFun#";

    public  void sendMail(){

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        System.out.println(pname);
        System.out.println(pmailadresse);
        System.out.println(pstatus);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("DS.WS.2021.2022@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(pmailadresse)
            );
            message.setSubject("Info DeskSharingApp");
            message.setText("Hallo "+ pname+","
                    + "\n\n Der Status der Reservierung lautet: "+ pstatus+
                    "\n\n" +
                    "\n\n" + "Ihr Desksharing-Team ");

            Transport.send(message);

            System.out.println("Mail send Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public Mail(String pName,String pMailAdresse,String pStatus) {
        this.pname=pName;
        this.pstatus=pStatus;
        this.pmailadresse=pMailAdresse;
        //this.sendMail();
    }

    public Mail() {
    }

    public String getpName() {
        return pname;
    }

    public void setpName(String pName) {
        this.pname = pName;
    }

    public String getpMailAdresse() {
        return pmailadresse;
    }

    public void setpMailAdresse(String pMailAdresse) {
        this.pmailadresse = pMailAdresse;
    }

    public String getpStatus() {
        return pstatus;
    }

    public void setpStatus(String pStatus) {
        this.pstatus = pStatus;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "pName='" + pname + '\'' +
                ", pMailAdresse='" + pmailadresse + '\'' +
                ", pStatus='" + pstatus + '\'' +
                '}';
    }
}
