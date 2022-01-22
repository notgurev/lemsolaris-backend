package lemsolaris.model.weather;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "weather_type")
public class WeatherType {
    private int id;
    private String weatherType;
    private int minShipDurability;
    private Collection<WeatherForecast> weatherForecastsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "weather_type", nullable = false, length = -1)
    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    @Basic
    @Column(name = "min_ship_durability", nullable = false)
    public int getMinShipDurability() {
        return minShipDurability;
    }

    public void setMinShipDurability(int minShipDurability) {
        this.minShipDurability = minShipDurability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherType that = (WeatherType) o;

        if (id != that.id) return false;
        if (minShipDurability != that.minShipDurability) return false;
        if (weatherType != null ? !weatherType.equals(that.weatherType) : that.weatherType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (weatherType != null ? weatherType.hashCode() : 0);
        result = 31 * result + minShipDurability;
        return result;
    }

    @OneToMany(mappedBy = "weatherTypeByWeatherType")
    public Collection<WeatherForecast> getWeatherForecastsById() {
        return weatherForecastsById;
    }

    public void setWeatherForecastsById(Collection<WeatherForecast> weatherForecastsById) {
        this.weatherForecastsById = weatherForecastsById;
    }
}
