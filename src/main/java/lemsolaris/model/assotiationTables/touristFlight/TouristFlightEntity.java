package lemsolaris.model.assotiationTables.touristFlight;

import javax.persistence.*;

@Entity
@Table(name = "tourist_flight")
@IdClass(TouristFlightEntityPK.class)
public class TouristFlightEntity {
    private int touristId;
    private int flightId;

    @Id
    @Column(name = "tourist_id", nullable = false)
    public int getTouristId() {
        return touristId;
    }

    public void setTouristId(int touristId) {
        this.touristId = touristId;
    }

    @Id
    @Column(name = "flight_id", nullable = false)
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

        TouristFlightEntity that = (TouristFlightEntity) o;

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
