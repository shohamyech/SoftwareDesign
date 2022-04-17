package DL;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DataSource {

    public static List<Customer> allCustomers;
    public static List<Order> allOrders;
    public static List<Product> allProducts;
    public static List<OrderProduct> allOrderProducts;
    // Update this path according to your data files location
    public static String basePath = "data\\";
    public static String customersPath = basePath + "customers.txt";
    public static String ordersPath = basePath + "orders.txt";
    public static String productsPath = basePath + "products.txt";
    public static String orderProductPath = basePath + "orderProduct.txt";

    static {
        try {
            allCustomers = readCustomersFromFile();
            allOrders = readOrdersFromFile();
            allProducts = readProductsFromFile();
            allOrderProducts = readOrderProductsFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readCustomersFromFile() throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(customersPath))) {
            return stream.map(Customer::new).collect(Collectors.toList());
        }
    }

    public static List<Order> readOrdersFromFile() throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(ordersPath))) {
            return stream.map(Order::new).collect(Collectors.toList());
        }
    }

    public static List<Product> readProductsFromFile() throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(productsPath))) {
            return stream.map(Product::new).collect(Collectors.toList());
        }
    }

    public static List<OrderProduct> readOrderProductsFromFile() throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(orderProductPath))) {
            return stream.map(OrderProduct::new).collect(Collectors.toList());
        }
    }
}


