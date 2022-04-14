package BL;

import DL.*;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.*;

public class BL implements IBL {
    @Override
    public Product getProductById(long productId) {
        try {
            return DataSource.readProductsfromFile()
                    .stream()
                    .filter(p -> p.getProductId() == productId)
                    .findFirst()
                    .orElse(null);
        }catch (IOException ignored) {}
        return null;
    }

    @Override
    public Order getOrderById(long orderId) {
        try {
            return DataSource.readOrdersfromFile()
                    .stream()
                    .filter(p -> p.getOrderId() == orderId)
                    .findFirst()
                    .orElse(null);
        }catch (IOException ignored) {}
        return null;
    }

    @Override
    public Customer getCustomerById(long customerId) {
        try {
            return DataSource.readCustomersfromFile()
                    .stream()
                    .filter(p -> p.getId() == customerId)
                    .findFirst()
                    .orElse(null);
        }catch (IOException ignored) {}
        return null;
    }


    @Override
    public List<Product> getProducts(ProductCategory cat, double price) {
        //To do
        return null;
    }

    @Override
    public List<Customer> popularCustomers() {
        //To do
        return null;
    }

    @Override
    public List<Order> getCustomerOrders(long customerId) {
        //To do
        return null;
    }

    @Override
    public long numberOfProductInOrder(long orderId) {
        //To do
        return 0;
    }

    @Override
    public List<Product> getPopularOrderedProduct(int orderedtimes) {
        //To do
        return null;
    }

    @Override
    public List<Product> getOrderProducts(long orderId)
    {
        //To do
        return null;
    }

    @Override
    public List<Customer> getCustomersWhoOrderedProduct(long productId) {
        //To do
        return null;
    }

    @Override
    public Product getMaxOrderedProduct() {
        //To do
        return null;

    }
    @Override
    public double sumOfOrder(long orderID) {
        //To do
        return 0;
    }

    @Override
    public List<Order> getExpensiveOrders(double price) {
        //To do
        return null;
    }

    @Override
    public List<Customer> ThreeTierCustomerWithMaxOrders() {
        //To do
        return null;

    }

}
