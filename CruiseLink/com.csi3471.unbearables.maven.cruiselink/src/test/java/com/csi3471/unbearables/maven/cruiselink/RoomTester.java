package person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.test.java.com.csi3471.unbearables.maven.cruiselink;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import person.CruiseLink.com.csi3471.unbearables.maven.cruiselink.src.main.java.com.csi3471.unbearables.maven.cruiselink.Room;

public class RoomTester {
    @Test
    void BeforeAll() {

    }

    @DisplayName("Reading from Room csv")
    @ParameterizedTest(name = "{index => isSmoking={0}, bedType={1}, roomNumber={2}, numBeds={3}")
    @CsvFileSource(resources = "/CruiseLink/com.csi3471.unbearables.maven.cruiselink/src/test/java/com/csi3471/unbearables/maven/cruiselink/Room.csv")
    void printRoom(boolean isSmoking, Room.BedType bedType, int roomNumber, int numBeds) {
        Room room = new Room(isSmoking, bedType, roomNumber, numBeds);
        System.out.println(room.toString());
    }

    @Test
    void AfterAll() {

    }
}
