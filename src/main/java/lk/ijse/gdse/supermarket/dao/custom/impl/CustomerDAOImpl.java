package lk.ijse.gdse.supermarket.dao.custom.impl;

import com.sun.mail.imap.protocol.ID;
import lk.ijse.gdse.supermarket.config.FactoryConfiguration;
import lk.ijse.gdse.supermarket.dao.custom.CustomerDAO;
import lk.ijse.gdse.supermarket.dao.SQLUtil;
import lk.ijse.gdse.supermarket.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(Customer dto) {
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
    public boolean update(Customer dto) {
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
            Customer customer = session.get(Customer.class, pk);
            if (customer == null) {
                return false;
            }
            session.remove(customer);   // delete = remove
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
    public List<Customer> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        List<Customer> customers = query.list();
        return customers;
    }

    @Override
    public Optional<Customer> findByPK(ID pk) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Customer customer = session.get(Customer.class, pk);
        session.close();
        if (customer == null) {
            return Optional.empty();
        }
        return Optional.of(customer);
    }

    @Override
    public Optional<Customer> getLastPK() {
        Session session = FactoryConfiguration.getInstance().getSession();
        String lastPK = session
                .createQuery("SELECT c.id FROM customer c ORDER BY c.id DESC ", String.class)
                .setMaxResults(1)
                .uniqueResult();
        return Optional.empty();
    }


//    @Override
//    public String getNextId() throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.execute("select customer_id from customer order by customer_id desc limit 1");
//
//        if (rst.next()) {
//            String lastId = rst.getString(1); // Last customer ID
//            String substring = lastId.substring(1); // Extract the numeric part
//            int i = Integer.parseInt(substring); // Convert the numeric part to integer
//            int newIdIndex = i + 1; // Increment the number by 1
//            return String.format("C%03d", newIdIndex); // Return the new customer ID in format Cnnn
//        }
//        return "C001"; // Return the default customer ID if no data is found
//    }
//
//    @Override
//    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
//        return SQLUtil.execute(
//                "insert into customer values (?,?,?,?,?)",
//                customer.getId(),
//                customer.getName(),
//                customer.getNic(),
//                customer.getEmail(),
//                customer.getPhone()
//        );
//    }
//
//    @Override
//    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.execute("select * from customer");
//
//        ArrayList<Customer> customers = new ArrayList<>();
//
//        while (rst.next()) {
//            Customer customer = new Customer(
//                    rst.getString(1),  // Customer ID
//                    rst.getString(2),  // Name
//                    rst.getString(3),  // NIC
//                    rst.getString(4),  // Email
//                    rst.getString(5)   // Phone
//            );
//            customers.add(customer);
//        }
//        return customers;
//    }
//
//    @Override
//    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
//        return SQLUtil.execute(
//                "update customer set name=?, nic=?, email=?, phone=? where customer_id=?",
//                customer.getName(),
//                customer.getNic(),
//                customer.getEmail(),
//                customer.getPhone(),
//                customer.getId()
//        );
//    }
//
//    @Override
//    public boolean delete(String customerId) throws SQLException, ClassNotFoundException {
//        return SQLUtil.execute("delete from customer where customer_id=?", customerId);
//    }
//
//    @Override
//    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.execute("select customer_id from customer");
//
//        ArrayList<String> customerIds = new ArrayList<>();
//
//        while (rst.next()) {
//            customerIds.add(rst.getString(1));
//        }
//
//        return customerIds;
//    }
//
//    @Override
//    public Customer findById(String selectedCusId) throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.execute("select * from customer where customer_id=?", selectedCusId);
//
//        if (rst.next()) {
//            return new Customer(
//                    rst.getString(1),  // Customer ID
//                    rst.getString(2),  // Name
//                    rst.getString(3),  // NIC
//                    rst.getString(4),  // Email
//                    rst.getString(5)   // Phone
//            );
//        }
//        return null;
//    }
}






