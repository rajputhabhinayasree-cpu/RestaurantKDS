public class ChefStationThread implements Runnable {

    private final KitchenOrderQueue kitchen;

    public ChefStationThread(KitchenOrderQueue kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public void run() {

        try {
            for (int i = 1; i <= 10; i++) {

                FoodOrder order = kitchen.cookNextOrder();

                Thread.sleep(700);

                System.out.println("Order completed: " + order);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Chef interrupted.");
        }
    }
}