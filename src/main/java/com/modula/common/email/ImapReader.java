package com.modula.common.email;

import com.modula.common.email.dto.ResponseEmailBody;
import jakarta.mail.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

public class ImapReader {
    private static final int IMAP_PORT = 993;
    private final String imapHost;
    private final Store store;

    public ImapReader(String imapHost) throws NoSuchProviderException {
        this.imapHost = imapHost;
        store = Session.getInstance(getImapProperties()).getStore("imaps");
    }

    public Message[] getAllMessages(String email, String password) throws MessagingException {
        store.connect(imapHost, email, password);
        return getFolder().getMessages();
    }

    public List<ResponseEmailBody> getAllResponseEmailBodies(String email, String password) throws MessagingException {
        return Arrays.stream(getAllMessages(email, password))
                .map(message -> {
                    try {
                        return new ResponseEmailBody(message);
                    } catch (MessagingException | IOException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public Message getMessage(String email, String password, int index) throws MessagingException {
        store.connect(imapHost, email, password);
        return getFolder().getMessage(index);
    }

    public ResponseEmailBody getResponseEmailBody(String email, String password, int index)
            throws MessagingException, IOException {
        return new ResponseEmailBody(getMessage(email, password, index));
    }

    public int getMessageCount(String email, String password) throws MessagingException {
        store.connect(imapHost, email, password);
        return getFolder().getMessageCount();
    }

    private Folder getFolder() throws MessagingException {
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);
        return folder;
    }

    private Store getImapStore(String email, String password) throws MessagingException {
        Store store = Session.getInstance(getImapProperties()).getStore("imaps");
        store.connect(imapHost, email, password);
        return store;
    }

    private Properties getImapProperties() {
        Properties props = new Properties();
        props.put("mail.imaps.host", imapHost);
        props.put("mail.imaps.ssl.trust", imapHost);
        props.put("mail.imaps.port", IMAP_PORT);
        props.put("mail.imaps.starttls.enable", "true");
        props.put("mail.imaps.connectiontimeout", "10000");
        props.put("mail.imaps.timeout", "10000");
        return props;
    }
}
