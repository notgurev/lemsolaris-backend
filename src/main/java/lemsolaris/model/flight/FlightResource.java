package lemsolaris.model.flight;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "flight_resources")
public class FlightResource { // todo
    @EmbeddedId
    private FlightResourcePK flightResourcePK;

    @Column(name = "quantity")
    private int quantity;

    @Embeddable
    @Data
    public static class FlightResourcePK implements Serializable {
        @Column(name = "resource_id")
        private Long resourceId;

        @Column(name = "flight_id")
        private Long flightId;
    }
}
