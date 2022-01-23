package lemsolaris.model.other;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "resources_in_stock")
@Data
public class StockResource {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "market_price")
    private int marketPrice;
}