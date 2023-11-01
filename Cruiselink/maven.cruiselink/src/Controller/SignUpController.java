package Cruiselink.maven.cruiselink.src.Controller;

public interface SignUpController {
    void onSignUpSubmit(String firstName, String lastName, String age, String email,
                        String username, String password, String confirmPassword);
}