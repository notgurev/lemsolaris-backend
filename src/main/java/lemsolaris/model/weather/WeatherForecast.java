package lemsolaris.model.weather;

import lemsolaris.model.assotiationTables.weather.WeatherForecastEntityPK;
import lemsolaris.model.other.Coordinates;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "weather_forecast")
@IdClass(WeatherForecastEntityPK.class)
public class WeatherForecast {
    private Integer weatherType;
    private int coordsId;
    private Timestamp startTime;
    private Timestamp endTime;
    private WeatherType weatherTypeByWeatherType;
    private Coordinates coordinatesByCoordsId;

    @Basic
    @Column(name = "weather_type", nullable = true)
    public Integer getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(Integer weatherType) {
        this.weatherType = weatherType;
    }

    @Id
    @Column(name = "coords_id", nullable = false)
    public int getCoordsId() {
        return coordsId;
    }

    public void setCoordsId(int coordsId) {
        this.coordsId = coordsId;
    }

    @Id
    @Column(name = "start_time", nullable = false)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = true)
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherForecast that = (WeatherForecast) o;

        if (coordsId != that.coordsId) return false;
        if (weatherType != null ? !weatherType.equals(that.weatherType) : that.weatherType != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = weatherType != null ? weatherType.hashCode() : 0;
        result = 31 * result + coordsId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "weather_type", referencedColumnName = "id", insertable = false, updatable = false)
    public WeatherType getWeatherTypeByWeatherType() {
        return weatherTypeByWeatherType;
    }

    public void setWeatherTypeByWeatherType(WeatherType weatherTypeByWeatherType) {
        this.weatherTypeByWeatherType = weatherTypeByWeatherType;
    }

    @ManyToOne
    @JoinColumn(name = "coords_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Coordinates getCoordinatesByCoordsId() {
        return coordinatesByCoordsId;
    }

    public void setCoordinatesByCoordsId(Coordinates coordinatesByCoordsId) {
        this.coordinatesByCoordsId = coordinatesByCoordsId;
    }
}
