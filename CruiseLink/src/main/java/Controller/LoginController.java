package Controller;

import java.sql.SQLException;

public interface LoginController {
    void onLoginPressed(String username, String password) throws SQLException;
    void onSignUpPressed();
    void onForgotPasswordPressed(String email);
}
