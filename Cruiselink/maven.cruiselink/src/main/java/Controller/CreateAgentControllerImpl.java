package Cruiselink.maven.cruiselink.src.Controller;

import Cruiselink.maven.cruiselink.src.Domain.Agent;

public class CreateAgentControllerImpl {

    boolean doesUserExist(String username) {
        return false;
    }

    boolean doesPasswordMatch(String pass, String cpass) {

        return pass.equals(cpass);
    }

    boolean doesEmailExist(String email) {
        return false;
    }


    Agent createAgent(String username, String pass, String cpass) {
        Agent fng = new Agent();
        fng.setUsername(username);
        fng.setPassword(pass);

        return fng;
    }

    void saveAgent() {


    }

    Agent saveDetails(Agent fng, String email) {
        fng.setEmail(email);

        return fng;

    }
}
