package Cruiselink.maven.cruiselink.src.Controller;

import Cruiselink.maven.cruiselink.src.UI.LaunchGUI;
import Cruiselink.maven.cruiselink.src.UI.LoginGUI;
import Cruiselink.maven.cruiselink.src.UI.SignUpGUI;

import javax.swing.*;

public class LoginControllerImpl implements LoginController {

    @Override
    public void onLoginPressed(String username, String password) {

        //Implement my logic here
        System.out.println("Login button pressed");
    }

    @Override
    public void onSignUpPressed() {

        //Initializing the controller responsible for sign up logic
        SignUpController signUpController = new SignUpControllerImpl();

        //Creating the sign-up user interface and linking it to the controller
        SignUpGUI signUpGUI = new SignUpGUI(signUpController);

        //Displaying the sign up user interface to the user
        signUpGUI.createGUI();
    }

    @Override
    public void onForgotPasswordPressed() {

        //Implement my forgot password logic here
        System.out.println("Forgot Password link clicked");
    }
}
