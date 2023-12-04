package Repository;

import Domain.Country;
import Domain.Ship;
import Domain.TravelPath;

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

        try {
            TravelPath p1 = new TravelPath();
            p1.addCountry(new Country("USA", sdf.parse("01-06-2023"), sdf.parse("01-07-2023")));
            p1.addCountry(new Country("Puerto Rico", sdf.parse("01-09-2023"), sdf.parse("01-10-2023")));
            p1.addCountry(new Country("Bahamas", sdf.parse("01-11-2023"), sdf.parse("01-12-2023")));
            p1.addCountry(new Country("Mexico", sdf.parse("01-15-2023"), sdf.parse("01-16-2023")));
            p1.addCountry(new Country("USA", sdf.parse("01-17-2023"), sdf.parse("01-17-2023")));

            ship1.path = p1;

            TravelPath p2= new TravelPath();
            p2.addCountry(new Country("Spain", sdf.parse("01-06-2023"), sdf.parse("01-07-2023")));
            p2.addCountry(new Country("France", sdf.parse("01-08-2023"), sdf.parse("01-09-2023")));
            p2.addCountry(new Country("England", sdf.parse("01-11-2023"), sdf.parse("01-12-2023")));
            p2.addCountry(new Country("Norway", sdf.parse("01-15-2023"), sdf.parse("01-16-2023")));
            p2.addCountry(new Country("Spain", sdf.parse("01-22-2023"), sdf.parse("01-22-2023")));

            ship2.path = p2;

            TravelPath p3= new TravelPath();
            p3.addCountry(new Country("Sweden", sdf.parse("01-06-2023"), sdf.parse("01-07-2023")));
            p3.addCountry(new Country("Finland", sdf.parse("01-08-2023"), sdf.parse("01-09-2023")));
            p3.addCountry(new Country("Sweden", sdf.parse("01-10-2023"), sdf.parse("01-10-2023")));

            ship3.path = p3;


        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        shipMap.put(ship1.getId(),ship1);
        shipMap.put(ship2.getId(),ship1);
        shipMap.put(ship3.getId(),ship1);
    }


    public Ship getById(long id){
        return shipMap.get(id);
    }

}
