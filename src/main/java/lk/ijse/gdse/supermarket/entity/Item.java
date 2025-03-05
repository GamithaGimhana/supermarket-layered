package lk.ijse.gdse.supermarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")
public class Item implements SuperEntity {
    @Id
    @Column(name = "item_id")
    private int id;
    @Column(length = 100)   // column length eka
    private String name;
    private int quantity;
    @Column(name = "unit_price", precision = 10, scale = 2) // number format eka
    private BigDecimal unitPrice;

//    @OneToMany(mappedBy = "item")
//    private List<OrderDetails> orderDetails;
}
