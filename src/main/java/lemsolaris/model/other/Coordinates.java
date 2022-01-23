package lemsolaris.model.other;

import lemsolaris.model.anomaly.Anomaly;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "coordinates")
public class Coordinates {
    private int id;
    private int x;
    private int y;
    private Collection<Anomaly> anomaliesById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "x", nullable = false)
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Basic
    @Column(name = "y", nullable = false)
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (id != that.id) return false;
        if (x != that.x) return false;
        if (y != that.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }

    @OneToMany(mappedBy = "coordinatesByCoordsId")
    public Collection<Anomaly> getAnomaliesById() {
        return anomaliesById;
    }

    public void setAnomaliesById(Collection<Anomaly> anomaliesById) {
        this.anomaliesById = anomaliesById;
    }

}
