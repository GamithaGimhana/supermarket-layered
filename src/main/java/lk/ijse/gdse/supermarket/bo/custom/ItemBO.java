package lk.ijse.gdse.supermarket.bo.custom;


import lk.ijse.gdse.supermarket.bo.SuperBO;
import lk.ijse.gdse.supermarket.dto.ItemDTO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public String getNextId() throws SQLException, ClassNotFoundException;
    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public boolean delete(String customerId) throws SQLException, ClassNotFoundException;
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException;
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException;
    public ItemDTO findById(String selectedItemId) throws SQLException, ClassNotFoundException;
    public boolean reduceQty(OrderDetailsDTO orderDetailsDTO) throws SQLException, ClassNotFoundException;
}
