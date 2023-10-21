package CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Person;

import java.util.Map;

public class guestInfoExpert {
    Map<Integer, Person> accounts;

    public  void guestInfoExpert(Map<Integer, Person> n){
        accounts = n;
    }
    public boolean doesUsernameExist(String username){
        String taken = null;
        taken = String.valueOf(accounts.values().stream().
                filter(e-> e.getUsername().equals(username)).findFirst().get());
        return taken != null;

    }
    public boolean doesEmailExist(String email){
        String taken = null;
        taken = String.valueOf(accounts.values().stream().
                filter(e-> e.getEmail().equals(email)).findFirst().get());
        return taken != null;

    }
}
