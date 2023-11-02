package Cruiselink.maven.cruiselink.src.Controller;

import Cruiselink.maven.cruiselink.src.Domain.Agent;

public interface CreateAgentController {

    boolean doesUserExist(String username);

    boolean doesPasswordMatch(String pass, String cpass);

    boolean doesEmailExist(String email);


    Agent createAgent(String username, String pass, String cpass);

    void saveAgent();

    Agent saveDetails(Agent fng, String email);




}
