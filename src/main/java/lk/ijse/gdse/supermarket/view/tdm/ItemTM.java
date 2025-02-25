package lk.ijse.gdse.supermarket.view.tdm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemTM {
    private String itemId;
    private String name;
    private int quantity;
    private double price;
}
