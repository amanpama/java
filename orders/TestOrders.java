import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();

        //set price and name
        item1.name = "mocha";
        item2.name = "capuccino";
        item3.name = "latte";
        item4.name = "drip coffee";

        item1.price =2.0;
        item2.price = 3.0;
        item3.price =4.0;
        item4.price = 5.0;

        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();

        order1.name = "Cindhuri";
        order2.name = "Jimmy";
        order3.name = "Noah";
        order4.name = "Sam";

        System.out.println(order1.name);

        order2.items.add(item1);
        order2.items.add(item2);
        order2.total += item1.price;
        order2.total += item2.price;
        System.out.println(order2.items);

        order3.items.add(item2);
        order3.total += item2.price;
        System.out.println(order3.items);

        order4.items.add(item3);
        order4.total += item3.price;
        System.out.println(order4.items);

        for(int i = 0; i<order2.items.size(); i++){
            System.out.println(order2.items.get(i).name + " , " + order2.items.get(i).price);
        }


        // Application Simulations
        // Use this example code to test various orders' updates
        // System.out.printf("Name: %s\n", order1.name);
        // System.out.printf("Total: %s\n", order1.total);
        // System.out.printf("Ready: %s\n", order1.ready);
    }
}
