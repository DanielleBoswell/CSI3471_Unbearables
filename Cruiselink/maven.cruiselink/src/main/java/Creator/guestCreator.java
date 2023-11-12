package Cruiselink.maven.cruiselink.src.Creator;

import Cruiselink.maven.cruiselink.src.Domain.Guest;

public class guestCreator {

    Guest newUser = new Guest();

    public boolean newUsernamePassword(String username, String pass, String cpass){
        if(!pass.equals(cpass)){
            return false;
        }
        newUser.setUsername(username);
        newUser.setPassword(pass);
        return true;
    }

    public void setDetails(String email, String name, String card, String address){

        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setCard(card);
        newUser.setAddress(address);
    }

    public Guest getNewUser() {
        return newUser;
    }
}