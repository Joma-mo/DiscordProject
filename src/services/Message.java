package services;

import java.time.LocalDateTime;

public class Message {
    private String nameOfSender;
    private String messageText;
    private LocalDateTime dateTime;

    public Message(String nameOfSender, String messageText, LocalDateTime dateTime) {
        this.nameOfSender = nameOfSender;
        this.messageText = messageText;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return nameOfSender + ": " + messageText + "\n" + dateTime.toString();
    }
}
