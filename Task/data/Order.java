package task.Task.data;

import task.Task.dao.OrderDao;

public class Order {
    private OrderDao orderDao = new OrderDao();
    private final int ID;


    public Order() {
        this.ID = orderDao.getNewOrderID();
    }

    public int getID() {
        return ID;
    }
}




