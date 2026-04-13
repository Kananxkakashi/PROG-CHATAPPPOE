
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
        } else {
            System.out.println("Login failed - username or password incorrect.");
        }
        
        scanner.close();
    }
}
