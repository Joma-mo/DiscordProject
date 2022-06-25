package services;

public class Message {
    private String nameOfSender;
    private String messageText;

    public Message(String nameOfSender, String messageText) {
        this.nameOfSender = nameOfSender;
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return nameOfSender + ": " + messageText;
    }
}
