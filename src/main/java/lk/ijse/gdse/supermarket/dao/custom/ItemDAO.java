package lk.ijse.gdse.supermarket.dao.custom;


import lk.ijse.gdse.supermarket.dao.CrudDAO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.entity.Item;
import lk.ijse.gdse.supermarket.entity.OrderDetails;

import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<Item> {
//    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException;
//    public Item findById(String selectedItemId) throws SQLException, ClassNotFoundException;
    public boolean reduceQty(OrderDetailsDTO orderDetails) throws SQLException, ClassNotFoundException;
}
