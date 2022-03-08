public class CoffeeKiosk {
    public static void main(String[] args) {
        OrderKiosk newOrder = new OrderKiosk();

        newOrder.addMenuItem( 0, "Banana", 2.5 );
        newOrder.addMenuItem( 1, "Oranges", 0.5 );
        newOrder.addMenuItem( 2, "Biscuits", 1.5 );
        newOrder.addMenuItem( 3, "Chips", 1.0 );
        newOrder.addMenuItem( 4, "Coca Cola", 3.5 );

        newOrder.displayMenu();
        newOrder.newOrder();


    }
}
