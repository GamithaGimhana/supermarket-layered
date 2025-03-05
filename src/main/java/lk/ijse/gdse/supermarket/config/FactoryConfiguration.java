package lk.ijse.gdse.supermarket.config;

import lk.ijse.gdse.supermarket.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure();

        // hadana hama entity ekkm methana add krnn
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Item.class);
        configuration.addAnnotatedClass(Order.class);
        configuration.addAnnotatedClass(OrderDetails.class);
        configuration.addAnnotatedClass(OrderDetailsId.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
//        if(factoryConfiguration == null) {
//            factoryConfiguration = new FactoryConfiguration();
//        }
//        return factoryConfiguration;

        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession(); // methana open session ekk gnn hamathissem mokd methndi aluth session ekk hadenw
    }
}
