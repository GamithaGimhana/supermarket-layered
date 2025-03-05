package lk.ijse.gdse.supermarket.bo.custom;

import lk.ijse.gdse.supermarket.bo.SuperBO;
import lk.ijse.gdse.supermarket.dto.CustomerDTO;
import lk.ijse.gdse.supermarket.dto.ItemDTO;
import lk.ijse.gdse.supermarket.dto.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBO extends SuperBO {
    public String getNextId() throws SQLException, ClassNotFoundException;
    public boolean save(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
    public ArrayList<String> getAllItemIds() throws SQLException, ClassNotFoundException;
    public ArrayList<String> getAllCustomerIds() throws SQLException, ClassNotFoundException;
    public CustomerDTO findCustomerById(String selectedCusId) throws SQLException, ClassNotFoundException;
    public ItemDTO findItemById(String selectedItemId) throws SQLException, ClassNotFoundException;
}
