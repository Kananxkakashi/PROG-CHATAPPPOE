
package chatapppoe;

import java.io.*;

public class LoginSystem {
    
    private static final String FILE_NAME = "login.txt";
    
    public static void saveUser(String username,String password,String phone) {
        
        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter(FILE_NAME))) {
            
            writer.write(username + "," + password + "," + phone);
            
        } catch (IOException e) {
            System.out.println("Error saving user.");
        }
    }
    
    public static boolean login(String username,String password) {
        
        try (BufferedReader reader =
                new BufferedReader(new FileReader(FILE_NAME))) {
            
            String line = reader.readLine();
            
            if (line != null) {
                
                String[] parts = line.split(",");
                
                return parts[0].equals(username)
                        && parts[1].equals(password);
            }
            
        } catch (IOException e) {
            System.out.println("Error reading login file.");
        }
        
        return false;
    }
    
}
