package lemsolaris.model.other;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resources_in_stock")
@Getter
@Setter
public class StockResource {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "resource_type")
    private String type;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "market_price")
    private int marketPrice;
}