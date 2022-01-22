package lemsolaris.model.assotiationTables.touristFlight;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TouristFlightEntityPK implements Serializable {
    private int touristId;
    private int flightId;

    @Column(name = "tourist_id", nullable = false)
    @Id
    public int getTouristId() {
        return touristId;
    }

    public void setTouristId(int touristId) {
        this.touristId = touristId;
    }

    @Column(name = "flight_id", nullable = false)
    @Id
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TouristFlightEntityPK that = (TouristFlightEntityPK) o;

        if (touristId != that.touristId) return false;
        if (flightId != that.flightId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = touristId;
        result = 31 * result + flightId;
        return result;
    }
}
