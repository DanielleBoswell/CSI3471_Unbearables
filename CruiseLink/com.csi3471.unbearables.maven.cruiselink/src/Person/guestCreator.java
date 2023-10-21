/*
 * Author: Nicholas Revard
 * Course: CSI 3471
 * Assignment: Project
 * File: guestCreator.java
 * Description:
 */
package CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Person;

public class guestCreator {

    Guest newUser = new Guest();

    public boolean newUsernamePassword(String username, String pass, String cpass){
        if(!pass.equals(cpass)){
            return false;
        }
        newUser.setUsername(username);
        newUser.setPassword(pass);
        return true;
    }
    public void setDetails(String email, String name, String card, String address){
        //if()
        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setCard(card);
        newUser.setAddress(address);
    }

    public Guest getNewUser() {
        return newUser;
    }
}
