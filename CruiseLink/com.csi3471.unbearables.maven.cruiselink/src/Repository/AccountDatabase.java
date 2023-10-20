package CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Repository;

import java.util.HashMap;
import java.util.Map;

class guest{}
class agent{}
class admin{}
public class AccountDatabase {
    private Map<Integer,guest> guestAccounts;
    private Map<Integer,agent> agentAccounts;
    private Map<Integer,admin> adminAccounts;

    AccountDatabase(){
        guestAccounts = new HashMap<>();
        agentAccounts = new HashMap<>();
        adminAccounts = new HashMap<>();
    }

}

