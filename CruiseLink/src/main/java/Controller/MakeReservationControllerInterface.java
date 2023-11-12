package Controller;

public interface MakeReservationControllerInterface {
    public String[] getRoomInfo();
    public boolean canReserve(String start, String end, int total);
    public void reserveRoom();
}
