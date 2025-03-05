package lk.ijse.gdse.supermarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_detail")
public class OrderDetails implements SuperEntity {

//    private int id;

    @EmbeddedId
    private OrderDetailsId id;   // wena entity ekakin id ek gnne mrthndi
//  ------------------
//  | name           |
//  |   firstName    |
//  |   lastName     |
//  ------------------
//  | id             |
//  |   order_id     |
//  |   item_id      |
//  ------------------

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private Item item;

    private int qty;

    @Column(name = "unit_price",precision = 10,scale = 2)
    private BigDecimal unitPrice;
}
