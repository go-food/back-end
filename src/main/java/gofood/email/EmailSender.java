package gofood.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class EmailSender {
    static final String FROM = "terrymillenium@gmail.com";
    static final String FROMNAME = "Terry";

//    static final String TO = "recipient@example.com";

    static final String SMTP_USERNAME = "AKIAUW7SAPPVSAGUXMFT";

    static final String SMTP_PASSWORD = "BGcRaNrMx8s3RWgf9RAePPiGtEBQRwo+6AorNjaT3OUc";

    static final String CONFIGSET = "ConfigSet";

    static final String HOST = "email-smtp.ap-southeast-1.amazonaws.com";

    // The port you will connect to on the Amazon SES SMTP endpoint.
    static final int PORT = 587;

    static final String SUBJECT = "Amazon SES test (SMTP interface accessed using Java)";

    public void sendEmail(String toEmail, String message) throws UnsupportedEncodingException, MessagingException {
        // Create a Properties object to contain connection configuration information.
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");

        // Create a Session object to represent a mail session with the specified properties.
        Session session = Session.getDefaultInstance(props);

        String BODY = String.join(
                System.getProperty("line.separator"),
                "<h1>Amazon SES SMTP Email Test</h1>",
                "<p>",
                message,
                "</p>"
        );

        // Create a message with the specified information.
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(FROM, FROMNAME));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject(SUBJECT);
            msg.setContent(BODY, "text/html");


        } catch (MessagingException e) {
            e.printStackTrace();
        }

        // Create a transport.
        Transport transport = null;
        try {
            transport = session.getTransport();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        // Send the message.
        try {
            System.out.println("Sending...");


            // Connect to Amazon SES using the SMTP username and password you specified above.
            assert transport != null;
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        } catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        } finally {
            // Close and terminate the connection.
            assert transport != null;
            transport.close();
        }

    }
}
