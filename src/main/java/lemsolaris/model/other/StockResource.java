package lemsolaris.model.other;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "resources_in_stock")
@Data
@NoArgsConstructor
public class StockResource {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="resources_in_stock_seq")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "market_price")
    private int marketPrice;

    public StockResource(String type, int quantity, int marketPrice) {
        this.type = type;
        this.quantity = quantity;
        this.marketPrice = marketPrice;
    }
}