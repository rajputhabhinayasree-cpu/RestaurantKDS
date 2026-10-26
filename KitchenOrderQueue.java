import java.util.LinkedList;
import java.util.Queue;

public class KitchenOrderQueue {

    private final Queue<FoodOrder> orders = new LinkedList<>();
    private final int capacity = 5;

    public synchronized void placeOrder(FoodOrder order)
            throws InterruptedException {

        while (orders.size() >= capacity) {
            System.out.println("Kitchen full. Waiter is waiting...");
            wait();
        }

        orders.add(order);
        System.out.println("Order placed: " + order);

        notifyAll();
    }

    public synchronized FoodOrder cookNextOrder()
            throws InterruptedException {

        while (orders.isEmpty()) {
            System.out.println("No orders. Chef is waiting...");
            wait();
        }

        FoodOrder order = orders.remove();

        System.out.println("Chef is cooking: " + order);

        notifyAll();

        return order;
    }

    public synchronized void placeEmergencyOrder(FoodOrder order)
            throws KitchenOverloadException {

        if (orders.size() >= capacity) {
            throw new KitchenOverloadException(
                    "Kitchen overload! Cannot accept emergency order."
            );
        }

        orders.add(order);
        System.out.println("Emergency order placed: " + order);

        notifyAll();
    }
}