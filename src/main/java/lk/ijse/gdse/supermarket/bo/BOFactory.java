package lk.ijse.gdse.supermarket.bo;

import lk.ijse.gdse.supermarket.bo.custom.impl.CustomerBOImpl;
import lk.ijse.gdse.supermarket.bo.custom.impl.ItemBOImpl;
import lk.ijse.gdse.supermarket.bo.custom.impl.PlaceOrderBOImpl;

public class BOFactory {
    public static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOType {
        CUSTOMER, ITEM, PLACE_ORDER
    }

    public SuperBO getBO(BOType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }
    }
}
