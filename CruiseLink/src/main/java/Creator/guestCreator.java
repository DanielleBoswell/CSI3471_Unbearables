package Creator;

import Domain.Guest;
import Repository.AccountDBO;
import Repository.AccountDatabase;

import java.sql.SQLException;

public class guestCreator {

    Guest newUser = new Guest();
    AccountDatabase foundation = new AccountDatabase();
    public guestCreator() throws SQLException {
        foundation.createAccountDatabase();

    }
    AccountDBO accounts = new AccountDBO(foundation.getDBConnection());
    public boolean newUsernamePassword(String username, String pass, String cpass){
        if(!pass.equals(cpass)){
            return false;
        }
        newUser.setUsername(username);
        newUser.setPassword(pass);
        return true;
    }

    public void setDetails(String email, String name, String age, String password){

        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setAge(Integer.parseInt(age));
        newUser.setPassword(password);
    }

    public void saveUser(){

        accounts.save(newUser);

    }
    public Guest getNewUser() {
        return newUser;
    }
}