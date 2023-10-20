import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AccountDatabase {
    private Map<Integer,person> accounts = new HashMap<>();

    public AccountDatabase(Map<Integer, person> accounts) {
        this.accounts = accounts;
    }

    public boolean personExists(person p){
        return (accounts.containsKey(p));
    }

    public person returnPerson(person p){
        return accounts.get(p);
    }
}

