package lk.ijse.gdse.supermarket.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrderDetailsId implements SuperEntity {
    private String orderId;

    private String itemId;
}
