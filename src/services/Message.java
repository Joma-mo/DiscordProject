package services;

import java.time.LocalDateTime;

public class Message {
    private String nameOfSender;
    private String messageText;
    private LocalDateTime dateTime;

    /**
     * @param nameOfSender receives the message sender,
     * @param messageText receives the message text to send,
     * @param dateTime receives the time.
     */
    public Message(String nameOfSender, String messageText, LocalDateTime dateTime) {
        this.nameOfSender = nameOfSender;
        this.messageText = messageText;
        this.dateTime = dateTime;
    }

    /**
     * @return String representation of message.
     */
    @Override
    public String toString() {
        return nameOfSender + ": " + messageText + "\n" + dateTime.toString();
    }
}
