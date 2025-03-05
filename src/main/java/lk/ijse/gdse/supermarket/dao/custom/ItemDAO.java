package lk.ijse.gdse.supermarket.dao.custom;


import com.sun.mail.imap.protocol.ID;
import lk.ijse.gdse.supermarket.dao.CrudDAO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.entity.Item;

import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<Item, ID> {
//    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException;
//    public Item findById(String selectedItemId) throws SQLException, ClassNotFoundException;
    public boolean reduceQty(OrderDetailsDTO orderDetails) throws SQLException, ClassNotFoundException;
}
