package DL;

public class OrderProduct {
    private long orderId;
    private long productId;
    private int quantity;

    public OrderProduct(String orderInfo) {
        String[] arrayOfArgs = orderInfo.split(" ");
        setOrderId(Long.parseLong(arrayOfArgs[2]));
        setProductId(Long.parseLong(arrayOfArgs[5]));
        setQuantity(Integer.parseInt(arrayOfArgs[7]));
    }

    public OrderProduct(long oId, long pId, int quantity) {
        setOrderId(oId);
        setProductId(pId);
        setQuantity(quantity);
    }

    public String toString() {
        return "ord id: " + getOrderId() + " prod id: " + getProductId() + " quantity: " + getQuantity() + "\n";
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
