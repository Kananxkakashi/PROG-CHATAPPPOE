
package chatapppoe;

public class validator {
    
    public static boolean isValidUsername(String username) {
        return username.contains("_") && username.length() <=5;
    }
    
    public static boolean isValidPassword(String password) {
        boolean longEnough = password.length() >=8;
        boolean hasCapital = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*()<>?\":{}|<>].*");
        
        return longEnough && hasCapital && hasNumber && hasSpecialChar;
    }
    
    public static boolean isValidSouthAfricanNumber(String number) {
        return number.matches("^\\+27\\d{8}$");
    }
            
    
}