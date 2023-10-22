package CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Repository;

import CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Person.Admin;
import CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Person.Agent;
import CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.Person.Guest;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AccountDatabase {

    private Map<Integer, Guest> guestAccounts;
    private Map<Integer, Agent> agentAccounts;
    private Map<Integer, Admin> adminAccounts;

    public AccountDatabase(){
        guestAccounts = new TreeMap<>();
        agentAccounts = new TreeMap<>();
        adminAccounts = new TreeMap<>();
    }

    public void addGuest(Guest member){
        guestAccounts.put(guestAccounts.size() +1, member);
    }
    public void addAgent(Agent member){
        agentAccounts.put(guestAccounts.size() +1, member);
    }
    public void addAdmin(Admin member){
        adminAccounts.put(guestAccounts.size() +1, member);
    }

    public Map<Integer, Agent> getAgentAccounts() {
        return agentAccounts;
    }

    public Map<Integer, Admin> getAdminAccounts() {
        return adminAccounts;
    }

    public Map<Integer, Guest> getGuestAccounts() {
        return guestAccounts;
    }
}


