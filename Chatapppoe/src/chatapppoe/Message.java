
package chatapppoe;

public class Message {
    
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;
    
    public Message(String messageID,int messageNumber,String recipient,String message,String messageHash) {
        
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;
        this.messageHash = messageHash;
    }
    
    public String getmessageHash() {
        return messageHash;
    }
    
    public String getMessageID() {
        return messageID;
    }
    
    public int getMessageNumber() {
        return messageNumber;
    }
    
    public String getMessage() {
        return message;
    }
    
    public String getRecipient() {
        return recipient;
    }
    
    public String toString() {
        
        return "Message ID: " + messageID
                + "\nMessage Number: " + messageNumber
                + "\nRecipient: " + recipient
                + "\nMessage: " + message
                + "\nHash: " + messageHash
                + "\n----------------------";
    }
    
}
