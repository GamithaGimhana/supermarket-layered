package lk.ijse.gdse.supermarket.dao.custom;

import lk.ijse.gdse.supermarket.dao.CrudDAO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailsDAO extends CrudDAO<OrderDetails> {
    public boolean saveOrderDetailsList(ArrayList<OrderDetailsDTO> orderDetails) throws SQLException, ClassNotFoundException;
    public boolean save(OrderDetailsDTO orderDetailsDTO) throws SQLException, ClassNotFoundException;
}
