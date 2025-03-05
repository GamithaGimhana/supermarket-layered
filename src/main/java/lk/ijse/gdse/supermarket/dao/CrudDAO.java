package lk.ijse.gdse.supermarket.dao;

import com.sun.mail.imap.protocol.ID;
import jakarta.persistence.Id;
import lk.ijse.gdse.supermarket.entity.SuperEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//public interface CrudDAO<T> extends SuperDAO {
//    public String getNextId() throws SQLException, ClassNotFoundException;
//    public boolean save(T dto) throws SQLException, ClassNotFoundException;
//    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
//    public boolean update(T dto) throws SQLException, ClassNotFoundException;
//    public boolean delete(String id) throws SQLException, ClassNotFoundException;
//    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException;
//    public T findById(String selectedId) throws SQLException, ClassNotFoundException;
//}

public interface CrudDAO<T extends SuperEntity,ID> extends SuperDAO {

    public boolean save(T dto);
    public boolean update(T dto);
    public boolean deleteByPK(ID pk);
    public List<T> getAll();
    public Optional<T> findByPK(ID pk);
    public Optional<T> getLastPK();

}
