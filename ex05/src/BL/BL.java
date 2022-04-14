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
        } catch (IOException ignored) {}
        return null;
    }

    @Override
    public Order getOrderById(long orderId) {
        try {
            return DataSource.readOrdersfromFile()
                    .stream()
                    .filter(o -> o.getOrderId() == orderId)
                    .findFirst()
                    .orElse(null);
        } catch (IOException ignored) {}
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
        } catch (IOException ignored) {}
        return null;
    }


    @Override
    public List<Product> getProducts(ProductCategory cat, double price) {
        try {
            return DataSource.readProductsfromFile()
                    .stream()
                    .filter(p -> p.getPrice() <= price)
                    .sorted(Comparator.comparing(Product::getProductId))
                    .toList();
        } catch (IOException ignored) {
        }
        return null;
    }

    @Override
    public List<Customer> popularCustomers() {
        try {
            return DataSource.readCustomersfromFile()
                    .stream()
                    .filter(c -> c.getTier() == 3)
                    .filter(c -> getCustomerOrders(c.getId()).size() > 10)
                    .sorted(Comparator.comparing(Customer::getId))
                    .toList();
        } catch (IOException ignored) {
        }
        return null;
    }

    @Override
    public List<Order> getCustomerOrders(long customerId) {
        try {
            return DataSource.readOrdersfromFile()
                    .stream()
                    .filter(o -> o.getCustomrId() == customerId)
                    .sorted(Comparator.comparing(Order::getOrderId))
                    .toList();
        } catch (IOException ignored) {
        }
        return null;
    }

    @Override
    public long numberOfProductInOrder(long orderId) {
        try {
            return DataSource.readOrderProductsfromFile()
                    .stream()
                    .filter(op -> op.getOrderId() == orderId)
                    .findFirst()
                    .get()
                    .getQuantity();
        } catch (IOException ignored) {}
        return 0;
    }

    @Override
    public List<Product> getPopularOrderedProduct(int orderedtimes) {
        try {
            return DataSource.readProductsfromFile()
                    .stream()
                    .filter(p -> getOrdersOfProduct(p.getProductId()).size() >= orderedtimes)
                    .sorted(Comparator.comparing(Product::getProductId))
                    .toList();
        } catch (IOException ignored) {
        }
        return null;
    }

    @Override
    public List<Product> getOrderProducts(long orderId) {
        try {
            return DataSource.readOrderProductsfromFile()
                    .stream()
                    .filter(op -> op.getOrderId() == orderId)
                    .map(op -> getProductById(op.getProductId()))
                    .sorted(Comparator.comparing(Product::getProductId))
                    .toList();
        } catch (IOException ignored) {}
        return null;
    }

    @Override
    public List<Customer> getCustomersWhoOrderedProduct(long productId) {
        getOrdersOfProduct(productId)
                .stream()
                .map(o -> getCustomerById(o.getCustomrId()))
                .sorted(Comparator.comparing(Customer::getId))
                .toList();
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

    public List<Order> getOrdersOfProduct(long productId)
    {
        try {
            return DataSource.readOrderProductsfromFile()
                    .stream()
                    .filter(op -> op.getProductId() == productId)
                    .map(op -> getOrderById(op.getOrderId()))
                    .toList();
        } catch (IOException ignored) {}
        return null;
    }


}
