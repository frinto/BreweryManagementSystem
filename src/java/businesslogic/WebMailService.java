package businesslogic;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * This class manages sending an email to a user. It is used by the ResetPasswordServlet to send an email to an existing user's email address.
 * @author Martin Czerwinski
 */
public class WebMailService {
    
    /**
     * This method creates the information in our email message by taking in a template parameter and contents parameter and organizing these into a body. This body is specifically designed to be used as a Reset Password email.
     * @param to
     * @param subject
     * @param template
     * @param contents
     * @throws MessagingException
     * @throws NamingException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void sendMail(String to, String subject, String template, HashMap<String, String> contents) throws MessagingException, NamingException, FileNotFoundException, IOException {
        String body = "";
        StringBuilder st = new StringBuilder();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(template)));
        String line = br.readLine();
        while(line != null) {
            st.append(line);
            line = br.readLine();
        }
        
        body = st.toString();
        
        for(String key : contents.keySet()) {
            body = body.replace("{{" + key + "}}", contents.get(key));
        }
        
        sendMail(to, subject, body, true);
    } 
    
    /**
     * This method is used by the previous sendMail method to send mail using the Transport class. This is a generic method that could be used to send any format of email that is passed to it.
     * @param to
     * @param subject
     * @param body
     * @param bodyIsHTML
     * @throws MessagingException
     * @throws NamingException 
     */
    public static void sendMail(String to, String subject, String body, boolean bodyIsHTML) throws MessagingException, NamingException {
        Context env = (Context) new InitialContext().lookup("java:comp/env");
        String username = (String) env.lookup("webmail-username");
        String password = (String) env.lookup("webmail-password");

        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.port", 465);
        props.put("mail.smtps.auth", "true");
        props.put("mai.smtps.quitwait", "false");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        // create a message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML) {
            message.setContent(body, "text/html");
        } else {
            message.setText(body);
        }

        // address the message
        Address fromAddress = new InternetAddress("czerwinski.cprg352@gmail.com");
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);

        // send the message
        Transport transport = session.getTransport();
        transport.connect(username, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
