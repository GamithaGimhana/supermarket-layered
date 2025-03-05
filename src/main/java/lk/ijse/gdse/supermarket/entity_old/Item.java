package lk.ijse.gdse.supermarket.entity_old;

import lk.ijse.gdse.supermarket.entity.SuperEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    private String itemId;
    private String itemName;
    private int quantity;
    private double price;
}
