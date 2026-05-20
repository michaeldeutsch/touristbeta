package unit08.readEmail;

import jakarta.mail.*;
import jakarta.mail.internet.MimeBodyPart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;
import java.util.function.Consumer;

public class MailService {

    private final Path receivedDir = Paths.get("empfangen");
    private final Path processedDir = Paths.get("processed");

    public MailService() throws IOException {
        Files.createDirectories(receivedDir);
        Files.createDirectories(processedDir);
    }

    public void checkMails(Consumer<MailMessage> onMailProcessed, Consumer<Exception> onError) {
        new Thread(() -> {
            try {
                Properties props = new Properties();
                props.put("mail.pop3.host", "pop.gmx.net");
                props.put("mail.pop3.port", "995");
                props.put("mail.pop3.ssl.enable", "true");
                props.put("mail.pop3.auth", "true");
                props.put("mail.debug", "true");
                props.put("mail.pop3.ssl.protocols", "TLSv1.2");
                props.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.pop3.socketFactory.fallback", "false");
                props.put("mail.pop3.socketFactory.port", "995");

                Session session = Session.getInstance(props);
                Store store = session.getStore("pop3");

                store.connect(
                        "pop.gmx.net",
                        "fhbfi-softwareproject@gmx.at",
                        "fhbfi-softwareproject"
                );

                Folder inbox = store.getFolder("INBOX");
                inbox.open(Folder.READ_WRITE);

                Message[] messages = inbox.getMessages();

                for (Message msg : messages) {
                    if (msg.isSet(Flags.Flag.SEEN)) {
                        continue;
                    }

                    String subject = msg.getSubject();
                    Object content = msg.getContent();

                    if (content instanceof Multipart multipart) {
                        for (int i = 0; i < multipart.getCount(); i++) {
                            BodyPart part = multipart.getBodyPart(i);
                            if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())
                                    && part.getFileName() != null
                                    && part.getFileName().endsWith(".txt")) {

                                String text = saveReadAndMove((MimeBodyPart) part);
                                onMailProcessed.accept(new MailMessage(subject, text));
                            }
                        }
                    }

                    msg.setFlag(Flags.Flag.SEEN, true);
                }

                inbox.close(true);
                store.close();

            } catch (AuthenticationFailedException authEx) {
                System.err.println("AUTHENTICATION FAILED!");
                System.err.println("1. Check if POP3 is enabled in GMX settings.");
                System.err.println("2. Check for Application-Specific Password.");
                System.err.println("3. Verify credentials.");
                onError.accept(authEx);
            } catch (Exception ex) {
                onError.accept(ex);
            }
        }).start();
    }

    private String saveReadAndMove(MimeBodyPart part) throws Exception {
        Path receivedFile = receivedDir.resolve(part.getFileName());
        part.saveFile(receivedFile.toFile());

        String text = Files.readString(receivedFile);

        Path processedFile = processedDir.resolve(receivedFile.getFileName());
        Files.move(receivedFile, processedFile, StandardCopyOption.REPLACE_EXISTING);

        return text;
    }
}
