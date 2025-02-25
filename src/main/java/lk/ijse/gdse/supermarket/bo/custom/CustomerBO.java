package lk.ijse.gdse.supermarket.bo.custom;


import lk.ijse.gdse.supermarket.bo.SuperBO;
import lk.ijse.gdse.supermarket.dao.CrudDAO;
import lk.ijse.gdse.supermarket.dto.CustomerDTO;
import lk.ijse.gdse.supermarket.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public String getNextId() throws SQLException, ClassNotFoundException;
    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException;
    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public boolean delete(String customerId) throws SQLException, ClassNotFoundException;
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException;
    public CustomerDTO findById(String selectedCusId) throws SQLException, ClassNotFoundException;
}
