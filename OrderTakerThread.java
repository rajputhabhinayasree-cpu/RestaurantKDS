public class OrderTakerThread implements Runnable {

    private final KitchenOrderQueue kitchen;

    public OrderTakerThread(KitchenOrderQueue kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public void run() {

        try {
            for (int i = 1; i <= 10; i++) {

                FoodOrder order =
                        new FoodOrder(i, "Food Item " + i);

                kitchen.placeOrder(order);

                Thread.sleep(300);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Waiter interrupted.");
        }
    }
}