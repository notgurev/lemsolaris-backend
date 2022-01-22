package lemsolaris.model.assotiationTables.weather;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

public class WeatherForecastEntityPK implements Serializable {
    private int coordsId;
    private Timestamp startTime;

    @Column(name = "coords_id", nullable = false)
    @Id
    public int getCoordsId() {
        return coordsId;
    }

    public void setCoordsId(int coordsId) {
        this.coordsId = coordsId;
    }

    @Column(name = "start_time", nullable = false)
    @Id
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherForecastEntityPK that = (WeatherForecastEntityPK) o;

        if (coordsId != that.coordsId) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = coordsId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        return result;
    }
}
