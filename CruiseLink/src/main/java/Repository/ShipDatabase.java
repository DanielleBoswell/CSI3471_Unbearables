package Repository;

import Domain.Country;
import Domain.Ship;
import Domain.TravelPath;

import java.sql.Date;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;

public class ShipDatabase {
    static final private Map<Long,Ship> shipMap = new HashMap<>();
    static final private SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");


    static{
        Ship ship1 = new Ship("Cruise 1",40,null);
        ship1.setId(1);
        Ship ship2 = new Ship("Cruise 2",40,null);
        ship2.setId(2);
        Ship ship3 = new Ship("Cruise 3",40,null);
        ship3.setId(3);


        TravelPath p1 = new TravelPath();
        p1.addCountry(new Country("USA", new Date(2024,1,6), new Date(2024,1,7)));
        p1.addCountry(new Country("Puerto Rico", new Date(2024,1,9), new Date(2024,1,10)));
        p1.addCountry(new Country("Bahamas", new Date(2024,1,11), new Date(2024,1,12)));
        p1.addCountry(new Country("Mexico", new Date(2024,1,15), new Date(2024,1,16)));
        p1.addCountry(new Country("USA", new Date(2024,1,17), new Date(2024,1,18)));

        ship1.path = p1;

        TravelPath p2= new TravelPath();
        p2.addCountry(new Country("Spain", new Date(2024,1,6), new Date(2024,1,7)));
        p2.addCountry(new Country("France", new Date(2024,1,8), new Date(2024,1,9)));
        p2.addCountry(new Country("England", new Date(2024,1,11), new Date(2024,1,12)));
        p2.addCountry(new Country("Norway", new Date(2024,1,15), new Date(2024,1,16)));
        p2.addCountry(new Country("Spain", new Date(2024,1,22), new Date(2024,1,22)));

        ship2.path = p2;

        TravelPath p3= new TravelPath();
        p3.addCountry(new Country("Sweden", new Date(2024,1,6), new Date(2024,1,7)));
        p3.addCountry(new Country("Finland", new Date(2024,1,8), new Date(2024,1,9)));
        p3.addCountry(new Country("Sweden", new Date(2024,1,10), new Date(2024,1,10)));

        ship3.path = p3;


        shipMap.put(ship1.getId(),ship1);
        shipMap.put(ship2.getId(),ship1);
        shipMap.put(ship3.getId(),ship1);
    }


    static public Ship getById(long id){
        return shipMap.get(id);
    }

}
