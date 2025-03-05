package lk.ijse.gdse.supermarket.dao;

import lk.ijse.gdse.supermarket.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
//        if (daoFactory == null) {
//            daoFactory = new DAOFactory();
//        }
//        return daoFactory;
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOType {
        CUSTOMER, ITEM, ORDER, ORDERDETAIL, QUERY
    }

    public SuperDAO getDAO(DAOType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDERDETAIL:
                return new OrderDetailsDAOImpl();
            case QUERY:
//                return new QueryDAOImpl();
            default:
                return null;
        }
//        return new CustomerDAOImpl();
    }

//    @SuppressWarnings("unchecked")
//    // prevent compiler warning about unchecked type casting
//    public <T extends SuperDAO>T getDAO(DAOType type) {
//        switch (type) {
//            case CUSTOMER:
//                return (T) new CustomerDAOImpl();
//                // methnin cast klama bo impl ekedi cast krnn oni naa
//            case ITEM:
//                return (T) new ItemDAOImpl();
//            case ORDER:
//                return (T) new OrderDAOImpl();
//            case ORDERDETAIL:
//                return (T) new OrderDetailsDAOImpl();
//            case QUERY:
////                return (T) new QueryDAOImpl();
//            default:
//                return null;
//        }
////        return new CustomerDAOImpl();
//    }
}
