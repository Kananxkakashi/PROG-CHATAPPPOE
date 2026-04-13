
package chatapppoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chatapppoe extends JFrame {
    
    private JTextField usernameField, cellphoneField, loginUserField;
    private JPasswordField passwordField, loginPassField;
    private JButton registerButton, loginButton;
   
    private static User registeredUser = null;
    private  validator validator = new validator();
    
    public Chatapppoe() {
        
        setTitle("ChatApp");
        setSize(400, 450);
        setLayout(new GridLayout(0, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //REGISTER
        add(new JLabel("CHAT APP REGISTRATION"));
        
        // USERNAME
        add(new JLabel("Enter username: "));
        usernameField = new JTextField();
        add(usernameField);
        
              
        // PASSWORD
        add(new JLabel("Enter password: "));
        passwordField = new JPasswordField();
        add(passwordField);
        
        
        //CELLPHONE
        add(new JLabel("Enter South African cell number: "));
        cellphoneField = new JTextField();
        add(cellphoneField);
        
        // LOGIN
        add(new JLabel("\n=== LOGIN ==="));
        
        add(new JLabel("Enter username: "));
        loginUserField = new JTextField();
        add(loginUserField);
        
        add(new JLabel("Enter password: "));
        loginPassField = new JPasswordField();
        add(loginPassField);
        
        //BUTTONS
        registerButton = new JButton("Register");
        add(registerButton);
        registerButton.addActionListener(e -> registerUser());
        
        loginButton = new JButton("Login");
        add(loginButton);
        loginButton.addActionListener(e -> loginUser());
        
        setVisible(true);
        
    }
        
    private void registerUser() {
        
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String cellphone = cellphoneField.getText();
        
        //USER VALIDATE
        if (validator.isValidUsername(username)) {
            JOptionPane.showMessageDialog(this, "Username successfully captured");
        } else {
            JOptionPane.showMessageDialog(this, "Username is not correctly formatted; "
                    + "please ensure that your username contains an underscore and "
                    + "is no more than five characters in legnth.");
            return;
        }
       
        //PASSWORD VALIDATE
        if (validator.isValidPassword(password)) {
            JOptionPane.showMessageDialog(this, "Password successfully captured");
        } else {
            JOptionPane.showMessageDialog(this, "Password is not correctly formatted; "
                    + "please ensure that the password contains at least eight "
                    + "characters, a capital letter, a number, and a special character. ");
            return;
        }
       
        //CELLPHONE VALIDATE
        if (!validator.isValidSouthAfricanNumber(cellphone)) {
            JOptionPane.showMessageDialog(this, "Invalid South African cellphone number format. ");
            return;
        }
        
        // SAVE USER
        registeredUser = new User(username, password, cellphone);
        JOptionPane.showMessageDialog(this, "\nRegistration complete!");
        
    }
    
    private void loginUser() {
        
        if (registeredUser == null) {
            JOptionPane.showMessageDialog(this, "No user registered yet");
            return;
        }
        
        String loginUser = loginUserField.getText();
        String loginPass = new String(loginPassField.getPassword());
        
        if (registeredUser.getUsername().equals(loginUser) &&
                registeredUser.getPassword().equals(loginPass)) {
            
            JOptionPane.showMessageDialog(this, "Login successful - welcome!" + "it is great to see you again" );
        } else {
            JOptionPane.showMessageDialog(this, "Login failed - username or password incorrect.");
        }
    }
    
    public static void main(String[] args) {
        new Chatapppoe();
    }

    private void registeredUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
