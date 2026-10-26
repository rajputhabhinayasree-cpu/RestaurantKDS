public class Main {
    public static void main(String[] args) {

        // Test the emergency exception using a separate queue
        KitchenOrderQueue testKitchen = new KitchenOrderQueue();

        try {
            for (int i = 1; i <= 5; i++) {
                testKitchen.placeEmergencyOrder(
                        new FoodOrder(i, "Test Food " + i)
                );
            }

            testKitchen.placeEmergencyOrder(
                    new FoodOrder(6, "Emergency Pizza")
            );

        } catch (KitchenOverloadException e) {
            System.out.println(e.getMessage());
        }

        // Create a fresh queue for the actual simulation
        KitchenOrderQueue kitchen = new KitchenOrderQueue();

        // Create waiter and chef threads
        Thread waiter = new Thread(new OrderTakerThread(kitchen));
        Thread chef = new Thread(new ChefStationThread(kitchen));

        // Start both threads
        waiter.start();
        chef.start();

        // Wait for both threads to finish
        try {
            waiter.join();
            chef.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Simulation interrupted.");
        }

        System.out.println("Restaurant simulation finished.");
    }
}

