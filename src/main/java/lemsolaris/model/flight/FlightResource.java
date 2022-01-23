package lemsolaris.model.flight;

import lemsolaris.model.other.StockResource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "flight_resources")
@IdClass(FlightResource.FlightResourceId.class)
@NoArgsConstructor
public class FlightResource { // todo
    @Column(name = "resource_id")
    @Id
    private Long resourceId;

    @Column(name = "flight_id")
    @Id
    private Long flightId;

    @Column(name = "quantity")
    private int quantity;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FlightResourceId implements Serializable {
        private StockResource resourceId;
        private Flight flightId;
    }

    public FlightResource(Long resourceId, Long flightId, int quantity) {
        this.resourceId = resourceId;
        this.flightId = flightId;
        this.quantity = quantity;
    }
}
