package lk.ijse.gdse.supermarket.dao.custom.impl;

import com.sun.mail.imap.protocol.ID;
import lk.ijse.gdse.supermarket.config.FactoryConfiguration;
import lk.ijse.gdse.supermarket.dao.custom.ItemDAO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.dao.SQLUtil;
import lk.ijse.gdse.supermarket.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean reduceQty(OrderDetailsDTO orderDetails) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean save(Item dto) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(dto);   // save = persist
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean update(Item dto) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(dto);     // update = merge
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean deleteByPK(ID pk) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Item item = session.get(Item.class, pk);
            if (item == null) {
                return false;
            }
            session.remove(item);   // delete = remove
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Item> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<Item> query = session.createQuery("from Item", Item.class);
        List<Item> items = query.list();
        return items;
    }

    @Override
    public Optional<Item> findByPK(ID pk) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Item item = session.get(Item.class, pk);
        session.close();
        if (item == null) {
            return Optional.empty();
        }
        return Optional.of(item);
    }

    @Override
    public Optional<Item> getLastPK() {
        Session session = FactoryConfiguration.getInstance().getSession();
        String lastPK = session
                .createQuery("SELECT i.id FROM Item i ORDER BY i.id DESC ", String.class)
                .setMaxResults(1)
                .uniqueResult();
        return Optional.empty();
    }

//    @Override
//    public String getNextId() throws SQLException, ClassNotFoundException {
//        return "";
//    }
//
//    @Override
//    public boolean save(Item dto) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.execute("select * from item");
//
//        ArrayList<Item> items = new ArrayList<>();
//
//        while (rst.next()) {
//            Item item = new Item(
//                    rst.getString(1),
//                    rst.getString(2),
//                    rst.getInt(3),
//                    rst.getInt(4)
//            );
//            items.add(item);
//        }
//        return items;
//    }
//
//    @Override
//    public boolean update(Item dto) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public boolean delete(String id) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public ArrayList<String> getAllIds() throws SQLException {
//        // Execute SQL query to get all item IDs
//        ResultSet rst = SQLUtil.execute("select item_id from item");
//
//        // Create an ArrayList to store the item IDs
//        ArrayList<String> itemIds = new ArrayList<>();
//
//        // Iterate through the result set and add each item ID to the list
//        while (rst.next()) {
//            itemIds.add(rst.getString(1));
//        }
//
//        // Return the list of item IDs
//        return itemIds;
//    }
//
//    @Override
//    public Item findById(String selectedItemId) throws SQLException {
//        // Execute SQL query to find the item by ID
//        ResultSet rst = SQLUtil.execute("select * from item where item_id=?", selectedItemId);
//
//        // If the item is found, create an ItemDTO object with the retrieved data
//        if (rst.next()) {
//            return new Item(
//                    rst.getString(1),  // Item ID
//                    rst.getString(2),  // Item Name
//                    rst.getInt(3),     // Item Quantity
//                    rst.getDouble(4)   // Item Price
//            );
//        }
//
//        // Return null if the item is not found
//        return null;
//    }
//
//    @Override
//    public boolean reduceQty(OrderDetailsDTO orderDetails) throws SQLException {
//        // Execute SQL query to update the item quantity in the database
//        return SQLUtil.execute(
//                "update item set quantity = quantity - ? where item_id = ?",
//                orderDetails.getQuantity(),   // Quantity to reduce
//                orderDetails.getItemId()      // Item ID
//        );
//    }
}

