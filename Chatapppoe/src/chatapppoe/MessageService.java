
package chatapppoe;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.io.*;
import com.google.gson.Gson;
import java.util.ArrayList;

public class MessageService {
   
    //arrays
    private static ArrayList<Message> sentMessage = new ArrayList<>();
    private static ArrayList<Message> storedMessages = new ArrayList<>();
    private static ArrayList<Message> disregardedMessage = new ArrayList<>();
    
    private static ArrayList<String> messageHashes = new ArrayList<>();
    private static ArrayList<String> messageIDs = new ArrayList<>();
    
    private static int counter = 0;
    
    public static String generateMessageID() {
        
        Random random = new Random();
        
        long num = 1000000000L +
                (long)(random.nextDouble() * 9000000000L);
        
        return String.valueOf(num);
    }
    
    //Auto recipient number
    public static String generateRecipientNumber() {
        
        Random random = new Random();
        
        int number = 100000000 + random.nextInt(900000000);
        
        return "+27" + number;
    }
    
    public static String createHash(String id,int messageNum,String text) {
        
        String[] words = text.split(" ");
        
        String first = words[0];
        String last = words[words.length - 1];
        
        return id.substring(0,2)
                + ":" + messageNum
                + ":" + (first + last).toUpperCase();
    }
    
    public static Message createMessage(String text) {
        
        counter++;
        
        String id = generateMessageID();
        
        String recipient = generateRecipientNumber();
        
        String hash =
                createHash(id, counter, text);
        
        return new Message(id,counter,recipient,text,hash);
    }
    
    //store message
    public static void storeMessage(Message msg) {
        
        storedMessages.add(msg);
        
        messageHashes.add(msg.getmessageHash());
        
        messageIDs.add(msg.getMessageID());
        
        saveStoredMessagesToJson();
        
        System.out.println("Message sucessfully stored.");
    }
    //send message
    public static void sendMessage(Message msg) {
        
        sentMessage.add(msg);
        
        messageHashes.add(msg.getmessageHash());
        
        messageIDs.add(msg.getMessageID());
        
        System.out.println("Message successfully sent.");
        
  
       }   
    //delete message
     public static void disregardMessage(Message msg) {
         
         disregardedMessage.add(msg);
         
         System.out.println("Message disregarded.");
         
     }
     
     //saving stored messages
     public static void saveStoredMessagesToJson() {
         
         Gson gson = new Gson();
         
         try (FileWriter writer = new FileWriter("storedMessages.json")) {
             
             gson.toJson(storedMessages, writer);
             
         } catch (IOException e) {
             
             System.out.println("Error saving messages to JSON.");
         }
     }
     
     //Show sender and reciever
     public static void displaySendersAndRecipients() {
         
         if (storedMessages.isEmpty()) {
             System.out.println("No stored messages.");
             return;
         }
         
         for (Message msg : sentMessage) {
             
             System.out.println("Sender: User");
             System.out.println("Recipient: " + msg.getRecipient());
             System.out.println();
         }
     }
     
     //Show longest message
     public static void displayLongestMessage() {
         
         if (storedMessages.isEmpty()) {
             
             System.out.println("No sent messages.");
             return;
         }
         
         Message longest = storedMessages.get(0);
         
         for (Message msg : storedMessages) {
             
             if (msg.getMessage().length() > longest.getMessage().length()) {
                 
                 longest = msg;
             }
         }
         
         System.out.println("Longest Message:");
         System.out.println(longest);
     }
     
     //search by messageID
     public static void searchbymessageIDs(String id) {
         
         boolean found = false;
         
         for (Message msg : sentMessage) {
             
             if (msg.getMessageID().equals(id)) {
                 
                 System.out.println(msg);
                 
                 found = true;
             }
         }
         
         if (!found) {
             
             System.out.println("Message not found.");
         }
     }
     
     // search by recipient
     public static void searchByRecipient(String recipient) {
         
         boolean found = false;
         
         for (Message msg : storedMessages) {
             
             if (msg.getRecipient().equals(recipient)) {
                 
                 System.out.println(msg);
                 
                 found = true;
             }
         }
         
         if (!found) {
             
             System.out.println("No messages found.");
         }
     }
     
     //delete by hash
     public static void deleteByHash(String hash) {
         
         boolean deleted = storedMessages.removeIf(msg -> msg.getmessageHash().equals(hash));
         
         if (deleted) {
             
             System.out.println("Message deleted.");
             
         } else {
             
             System.out.println("Hash not found.");
         }
     }
     
     //FULL REPORT
     public static void displayReport() {
         
         if (storedMessages.isEmpty()) {
             
             System.out.println("No stored messages.");
             return;
         }
         
         System.out.println("===== MESSAGE REPORT =====");
         
         for (Message msg : storedMessages) {
             
             System.out.println(msg);
         }
     }
     
     //total messages
     public static int getTotalSentMessage() {
         
         return sentMessage.size();
     }
     
     //sent message testing
     public static ArrayList<Message> getSentMessage() {
         
         return sentMessage;    
     }
     
     //stored message testing
     public static ArrayList<Message> getStoredMessages() {
         
         return storedMessages;
     }
     
     //disregarded message testing
     public static ArrayList<Message> getDisregardedMessages() {
         
         return disregardedMessage;
     }
     
     //hash testing
     public static ArrayList<String> getMessageHashes() {
         
         return messageHashes;
     }
     
     //ID testing
     public static ArrayList<String> getmessageIDs() {
         
         return messageIDs;
     }
     
     public static void loadstoredMessagesFromJson() {

    Gson gson = new Gson();

    try (Reader reader = new FileReader("storedMessages.json")) {

        Message[] messages = gson.fromJson(reader, Message[].class);

        if (messages != null) {

            storedMessages.clear();

            for (Message msg : messages) {

                storedMessages.add(msg);
            }
        }

    } catch (IOException e) {

        // Ignore if file doesn't exist yet
    }
}

     
}
     
