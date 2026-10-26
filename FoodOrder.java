public class FoodOrder {

        private int orderId;
        private String foodName;

        public FoodOrder(int orderId, String foodName) {
            this.orderId = orderId;
            this.foodName = foodName;
        }

        public int getOrderId() {
            return orderId;
        }

        public String getFoodName() {
            return foodName;
        }

        @Override
        public String toString() {
            return "Order #" + orderId + " - " + foodName;
        }
    }

