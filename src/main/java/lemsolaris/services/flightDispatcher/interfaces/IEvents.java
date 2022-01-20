package lemsolaris.services.flightDispatcher.interfaces;

public interface IEvents {
    void setResultOfFlight();
    void kill_phantom(int phantom_id);
    void kill_human(int human_id);
}
