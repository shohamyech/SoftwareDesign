package BL;

import DL.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BL implements IBL {
    @Override
    public Product getProductById(long productId) {
        return DataSource.allProducts
                .stream()
                .filter(p -> p.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Order getOrderById(long orderId) {
        return DataSource.allOrders
                .stream()
                .filter(o -> o.getOrderId() == orderId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Customer getCustomerById(long customerId) {
        return DataSource.allCustomers
                .stream()
                .filter(p -> p.getId() == customerId)
                .findFirst()
                .orElse(null);

    }


    @Override
    public List<Product> getProducts(ProductCategory cat, double price) {
        return DataSource.allProducts
                .stream()
                .filter(p -> p.getCategory().equals(cat))
                .filter(p -> p.getPrice() <= price)
                .sorted(Comparator.comparing(Product::getProductId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> popularCustomers() {
        return DataSource.allCustomers
                .stream()
                .filter(c -> c.getTier() == 3)
                .filter(c -> getCustomerOrders(c.getId()).size() > 10)
                .sorted(Comparator.comparing(Customer::getId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getCustomerOrders(long customerId) {
        return DataSource.allOrders
                .stream()
                .filter(o -> o.getCustomrId() == customerId)
                .sorted(Comparator.comparing(Order::getOrderId))
                .collect(Collectors.toList());
    }

    @Override
    public long numberOfProductInOrder(long orderId) {
        return DataSource.allOrderProducts
                .stream()
                .filter(op -> op.getOrderId() == orderId)
                .count();
    }

    @Override
    public List<Product> getPopularOrderedProduct(int orderedtimes) {
        return DataSource.allProducts
                .stream()
                .filter(p -> getOrdersOfProduct(p.getProductId()).size() >= orderedtimes)
                .sorted(Comparator.comparing(Product::getProductId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getOrderProducts(long orderId) {
        return DataSource.allOrderProducts
                .stream()
                .filter(op -> op.getOrderId() == orderId)
                .map(op -> getProductById(op.getProductId()))
                .sorted(Comparator.comparing(Product::getProductId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> getCustomersWhoOrderedProduct(long productId) {
        return getOrdersOfProduct(productId)
                .stream()
                .map(o -> getCustomerById(o.getCustomrId()))
                .sorted(Comparator.comparing(Customer::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Product getMaxOrderedProduct() {
        return DataSource.allProducts
                .stream()
                .reduce((cur, next) -> getOrdersOfProduct(cur.getProductId()).size() >=
                        getOrdersOfProduct(next.getProductId()).size() ? cur : next)
                .orElse(null);
    }

    @Override
    public double sumOfOrder(long orderID) {
        return DataSource.allOrderProducts
                .stream()
                .filter(o -> o.getOrderId() == orderID)
                .map(op -> op.getQuantity() * getProductById(op.getProductId()).getPrice())
                .reduce(Double::sum)
                .orElse(0D);
    }

    @Override
    public List<Order> getExpensiveOrders(double price) {
        return DataSource.allOrders
                .stream()
                .filter(o -> sumOfOrder(o.getOrderId()) >= price)
                .sorted(Comparator.comparing(Order::getOrderId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> ThreeTierCustomerWithMaxOrders() {
        int maxOrders = DataSource.allCustomers
                .stream()
                .filter(c -> c.getTier() == 3)
                .max(Comparator.comparing(c -> getCustomerOrders(c.getId()).size()))
                .map(c -> getCustomerOrders(c.getId()).size())
                .orElse(0);
        return DataSource.allCustomers
                .stream()
                .filter(c -> c.getTier() == 3)
                .filter(c -> getCustomerOrders(c.getId()).size() == maxOrders)
                .collect(Collectors.toList());
    }

    private List<Order> getOrdersOfProduct(long productId) {
        return DataSource.allOrderProducts
                .stream()
                .filter(op -> op.getProductId() == productId)
                .map(op -> getOrderById(op.getOrderId()))
                .collect(Collectors.toList());
    }
}
