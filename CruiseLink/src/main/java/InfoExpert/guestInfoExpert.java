package InfoExpert;

import Domain.Guest;

import java.util.Map;

public class guestInfoExpert {

    Map<Integer, Guest> accounts;

    public guestInfoExpert(Map<Integer, Guest> n){
        accounts = n;
    }

    /*
     * Author: Nicholas Revard
     * Function: doesUsernameExist
     *
     * Description: It will check in the guest database if the username already
     * exists false it exist true if not
     */
    public boolean doesUsernameExist(String username){
        String taken = null;
        taken = String.valueOf(accounts.values().stream().
                filter(e-> e.getUsername().equals(username)).findFirst().get());
        return taken != null;
    }

    /*
     * Author: Nicholas Revard
     * Function: doesEmailExist
     *
     * Description: It will check in the guest database if the email already
     * exists false it exist true if not
     */
    public boolean doesEmailExist(String email){
        String taken = null;
        taken = String.valueOf(accounts.values().stream().
                filter(e-> e.getEmail().equals(email)).findFirst().get());
        return taken != null;
    }
}