package lk.ijse.gdse.supermarket.dao.custom.impl;

import lk.ijse.gdse.supermarket.dao.custom.OrderDetailsDAO;
import lk.ijse.gdse.supermarket.dao.SQLUtil;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    // @itemModel: Reference to the ItemModel, used to update the item quantity after saving order details
    private final ItemDAOImpl itemDAOImpl = new ItemDAOImpl();

    @Override
    public boolean saveOrderDetailsList(ArrayList<OrderDetailsDTO> orderDetailss) throws SQLException {
        // Iterate through each order detail in the list
        for (OrderDetailsDTO orderDetails : orderDetailss) {
            // @isOrderDetailsSaved: Saves the individual order detail
            boolean isOrderDetailsSaved = save(orderDetails);
            if (!isOrderDetailsSaved) {
                // Return false if saving any order detail fails
                return false;
            }

            // @isItemUpdated: Updates the item quantity in the stock for the corresponding order detail
            boolean isItemUpdated = itemDAOImpl.reduceQty(orderDetails);
            if (!isItemUpdated) {
                // Return false if updating the item quantity fails
                return false;
            }
        }
        // Return true if all order details are saved and item quantities updated successfully
        return true;
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return "";
    }

    @Override
    public boolean save(OrderDetails dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean save(OrderDetailsDTO orderDetails) throws SQLException {
        // Executes an insert query to save the order detail into the database
        return SQLUtil.execute(
                "insert into orderdetails values (?,?,?,?)",
                orderDetails.getOrderId(),
                orderDetails.getItemId(),
                orderDetails.getQuantity(),
                orderDetails.getPrice()
        );
    }

    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(OrderDetails dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderDetails findById(String selectedId) throws SQLException, ClassNotFoundException {
        return null;
    }
}
