package Controller;

public interface LoginController {
    void onLoginPressed(String username, String password);
    void onSignUpPressed();
    void onForgotPasswordPressed(String email);
}
