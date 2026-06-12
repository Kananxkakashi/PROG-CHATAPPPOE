
package chatapppoe;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Chatapppoe {
    
    private static User registeredUser = null;
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
         MessageService.loadstoredMessagesFromJson();
        
        System.out.println("=== CHAT APP REGISTRATION ===");
        
        // USERNAME
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        if (validator.isValidUsername(username)) {
            System.out.println("Username successfully captured");
        } else {
            System.out.println("Username is not correctly formatted; "
                    + "please ensure that your username contains an underscore and "
                    + "is no more than five characters in legnth.");
            return;
        }
        
        // PASSWORD
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        if (validator.isValidPassword(password)) {
            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password is not correctly formatted; "
                    + "please ensure that the password contains at least eight "
                    + "characters, a capital letter, a number, and a special character. ");
            return;
        }
        
        //CELLPHONE
        System.out.print("Enter South African cell number: ");
        String cellphone = scanner.nextLine();
        
        if (!validator.isValidSouthAfricanNumber(cellphone)) {
            System.out.println("Invalid South African cellphone number format. ");
            return;
        }
        
        // SAVE USER
        registeredUser = new User(username, password, cellphone);
        System.out.println("\nRegistration complete!");
        
        // LOGIN
        System.out.println("\n=== LOGIN ===");
        System.out.print("Enter username: ");
        String loginUser = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String loginpass = scanner.nextLine();
        
        if (registeredUser.getUsername().equals(loginUser)&&
            registeredUser.getPassword().equals(loginpass)) {
            
            System.out.println("Login successful - welcome!");
            
            // ========================
            // QUICKCHAT starts here
            // =========================
            
            System.out.println("\nWelcome to QuickChat");

System.out.print("How many messages would you like to send? ");
int totalMessages = Integer.parseInt(scanner.nextLine());

while (true) {

    System.out.println("""
            
            ===== MENU =====
            1. Send Messages
            2. Stored Messages
            3. Quit
            4. Reports
            """);

    int option = Integer.parseInt(scanner.nextLine());

    switch (option) {

        case 1:

            if (MessageService.getTotalSentMessage()
                    >= totalMessages) {

                System.out.println("Message limit reached.");
                System.out.println("Total messages sent: "
                        + MessageService.getTotalSentMessage());

                break;
            }

            System.out.print("Enter message: ");
            String text = scanner.nextLine();

            if (text.length() > 250) {

                System.out.println(
                        "Please enter a message of less than 250 characters.");

                break;
            }

            Message msg =
                    MessageService.createMessage(text);

            System.out.println(
                    "Recipient: "
                            + msg.getRecipient());

            System.out.println(
                    "Hash: "
                            + msg.getmessageHash());

            System.out.println("""
                    
                    1. Send Message
                    2. Disregard Message
                    3. Store Message
                    """);

            int action =
                    Integer.parseInt(scanner.nextLine());

            switch (action) {

                case 1:

                    MessageService.sendMessage(msg);
                    break;

                case 2:

                    MessageService.disregardMessage(msg);
                    break;

                case 3:

                    MessageService.storeMessage(msg);
                    break;

                default:

                    System.out.println("Invalid option.");
            }

            break;

        case 2:

            System.out.println("""
                    
                    STORED MESSAGES
                    1. Display Senders and Recipients
                    2. Display Longest Message
                    3. Search by Message ID
                    4. Search by Recipient
                    5. Delete by Hash
                    6. Display Full Report
                    """);

            int choice =
                    Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    MessageService
                            .displaySendersAndRecipients();

                    break;

                case 2:

                    MessageService
                            .displayLongestMessage();

                    break;

                case 3:

                    System.out.print(
                            "Enter Message ID: ");

                    MessageService
                            .searchbymessageIDs(
                                    scanner.nextLine());

                    break;

                case 4:

                    System.out.print(
                            "Enter Recipient: ");

                    MessageService
                            .searchByRecipient(
                                    scanner.nextLine());

                    break;

                case 5:

                    System.out.print(
                            "Enter Hash: ");

                    MessageService
                            .deleteByHash(
                                    scanner.nextLine());

                    break;

                case 6:

                    MessageService
                            .displayReport();

                    break;

                default:

                    System.out.println(
                            "Invalid option.");
            }

            break;

        case 3:

            System.out.println(
                    "Total messages sent: "
                            + MessageService
                            .getTotalSentMessage());

            System.out.println("Goodbye!");

            return;

        case 4:

            MessageService.displayReport();

            break;

        default:

            System.out.println("Invalid option.");
    }
}

        } else {
            System.out.println("Login failed - username or password incorrect.");
        }
        
        scanner.close();
    }
}
