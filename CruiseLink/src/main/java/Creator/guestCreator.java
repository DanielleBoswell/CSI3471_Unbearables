package Creator;

import Domain.Guest;
import Repository.AccountDBO;
import Repository.AccountDatabase;

import java.sql.SQLException;

public class guestCreator {

    Guest newUser = new Guest();
    AccountDatabase foundation = new AccountDatabase();

    /**
     * author Nicholas Revard
     *
     * creates the account database connection
     * @throws SQLException
     */
    public guestCreator() throws SQLException {
        foundation.createAccountDatabase();

    }
    AccountDBO accounts = new AccountDBO(foundation.getDBConnection());

    /**
     * author Nicholas Revard
     *
     * @param username
     * @param pass
     * @param cpass
     * @return
     */
    public boolean newUsernamePassword(String username, String pass, String cpass){
        if(!pass.equals(cpass)){
            return false;
        }
        newUser.setUsername(username);
        newUser.setPassword(pass);
        return true;
    }

    /**
     * author Nicholas Revard
     *
     * @param email
     * @param name
     * @param age
     * @param password
     */
    public void setDetails(String email, String name, String age, String password){

        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setAge(Integer.parseInt(age));
        newUser.setPassword(password);
    }

    /**
     * author Nicholas Revard
     *
     */

    public void saveUser(){

        accounts.save(newUser);

    }

    /**
     * @author Nicholas Revard
     * @return
     */
    public Guest getNewUser() {
        return newUser;
    }
}