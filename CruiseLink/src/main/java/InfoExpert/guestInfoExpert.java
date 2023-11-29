package InfoExpert;

import Domain.Guest;
import Domain.Person;
import Repository.AccountDBO;
import Repository.AccountDatabase;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class guestInfoExpert {

    Map<Integer, Guest> accounts1;
    AccountDatabase foundation = new AccountDatabase();
    public guestInfoExpert() throws SQLException {
        foundation.createAccountDatabase();

    }

    AccountDBO accounts = new AccountDBO(foundation.getDBConnection());

/*    public guestInfoExpert(Map<Integer, Guest> n){
        accounts = n;
    }*/

    /*
     * Author: Nicholas Revard
     * Function: doesUsernameExist
     *
     * Description: It will check in the guest database if the username already
     * exists false it exist true if not
     */
    public boolean doesUsernameExist(String username){

        List<Person> possible = accounts.find(username);

        String taken = null;
        taken = String.valueOf(possible.stream().
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
        List<Person> possible = accounts.find(email);

        String taken = null;
        taken = String.valueOf(possible.stream().
                filter(e-> e.getEmail().equals(email)).findFirst().get());
        return taken != null;
    }

    /*
     * Author: Kyle Hoang
     * Function: deleteAccountDatabase
     *
     * Description: It will call the deleteAccountDatabase function
     * from the AccountDatabase object
     */
    public void deleteAccountDatabase() {
        foundation.deleteAccountDatabase();
    }
}