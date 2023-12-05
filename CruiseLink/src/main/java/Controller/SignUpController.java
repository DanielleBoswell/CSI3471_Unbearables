package Controller;

import java.sql.SQLException;

public interface SignUpController {

    String onSignUpSubmit(String firstName, String lastName, String age, String email, String username,
                          String password, String confirmPassword) throws SQLException;
}