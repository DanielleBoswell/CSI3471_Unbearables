package Controller;

import Creator.guestCreator;
import InfoExpert.guestInfoExpert;
import Repository.AccountDatabase;

import java.sql.SQLException;

public class SignUpControllerImpl implements SignUpController {

    @Override
    public String onSignUpSubmit(String firstName, String lastName, String age, String email, String username,
                                 String password, String confirmPassword) throws SQLException {

        //Here the account info will be sent to database and the account will be created

            //--------------- This is for checking if email and username already exist in the database ---------------
            //Need to check if the username and email exist first in the database before I create a guest
            AccountDatabase database = new AccountDatabase();

            //database.getGuestAccounts() Returns (Map<Integer, Guest>)
            guestInfoExpert guestInfoExpertObj = new guestInfoExpert();

            boolean emailExists = guestInfoExpertObj.doesEmailExist(email);
            boolean usernameExists = guestInfoExpertObj.doesUsernameExist(username);

            if (emailExists) { //if true
                //Will need to ask guest to enter a different email
                return "email";
            }
            if (usernameExists) { //if true
                //Will need to ask guest to enter a different username
                return "username";


            }

            //Otherwise I can create a guest account

            //Passwords will be tested for equivalence in the guestCreator class using the newUsernamePassword() method
            //guestCreator is for creating a new guest
            guestCreator newGuest = new guestCreator();
            newGuest.setDetails(email,firstName + " " + lastName, age, password);

            boolean passwordsMatch = newGuest.newUsernamePassword(username, password, confirmPassword);

            System.out.println("passwordsMatch value: " + passwordsMatch); // ----- works -------

            //String fullName = firstName + " " + lastName;
            newGuest.saveUser();
        return "true";

    }
}