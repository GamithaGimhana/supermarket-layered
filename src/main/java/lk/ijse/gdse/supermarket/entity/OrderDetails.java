package lk.ijse.gdse.supermarket.entity;

import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetails {
    private String orderId;
    private String itemId;
    private int quantity;
    private double price;

    public OrderDetails(OrderDetailsDTO orderDetailsDTO) {
        this.orderId = orderDetailsDTO.getOrderId();
        this.itemId = orderDetailsDTO.getItemId();
        this.quantity = orderDetailsDTO.getQuantity();
        this.price = orderDetailsDTO.getPrice();
    }
}
