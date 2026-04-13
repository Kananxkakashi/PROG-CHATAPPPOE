
package chatapppoe;

public class Login {
    
    private User user;
    
    public void register(User user) {
        this.user = user;
    }
    
    public boolean loginUser(String username, String password) {
        return user.username.equals(username) && user.password.equals(password);
    }
    
    public String returnLoginStatus(boolean status) {
        if (status) {
            return "Welcome " + user.firstName + "' " + user.lastName + " it is great to see you again";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
