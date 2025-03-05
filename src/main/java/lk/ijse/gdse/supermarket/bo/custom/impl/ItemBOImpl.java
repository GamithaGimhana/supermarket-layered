package lk.ijse.gdse.supermarket.bo.custom.impl;

import lk.ijse.gdse.supermarket.bo.custom.ItemBO;
import lk.ijse.gdse.supermarket.dao.DAOFactory;
import lk.ijse.gdse.supermarket.dao.custom.ItemDAO;
import lk.ijse.gdse.supermarket.dto.ItemDTO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.entity_old.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ITEM);

    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
        ArrayList<Item> items = itemDAO.getAll();
        for (Item item : items) {
            itemDTOS.add(new ItemDTO(item.getItemId(), item.getItemName(), item.getQuantity(), item.getPrice()));
        }
        return itemDTOS;
    }

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        return itemDAO.getAllIds();
    }

    @Override
    public ItemDTO findById(String selectedItemId) throws SQLException, ClassNotFoundException {
        Item item = itemDAO.findById(selectedItemId);
        return new ItemDTO(item.getItemId(), item.getItemName(), item.getQuantity(), item.getPrice());
    }

    @Override
    public boolean reduceQty(OrderDetailsDTO orderDetailsDTO) throws SQLException, ClassNotFoundException {
//        return itemDAO.reduceQty(new OrderDetails(orderDetailsDTO));
        return itemDAO.reduceQty(orderDetailsDTO);
    }

    @Override
    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new Item(itemDTO.getItemId(), itemDTO.getItemName(), itemDTO.getQuantity(), itemDTO.getPrice()));
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return itemDAO.getNextId();
    }

    @Override
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(itemDTO.getItemId(), itemDTO.getItemName(), itemDTO.getQuantity(), itemDTO.getPrice()));
    }

    @Override
    public boolean delete(String itemId) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(itemId);
    }
}

