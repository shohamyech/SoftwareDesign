package DL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

    private long orderId;
    private Date orderDate;
    private Date deliveryDate;
    private OrderStatus status;

    private long costumerId;

    public Order(String orderInfo) {
        String[] arrayOfArgs = orderInfo.split(" ");
        setOrderId(Long.parseLong(arrayOfArgs[1]));
        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
        try {
            setOrderDate(parser.parse(arrayOfArgs[4]));
        }
        catch(ParseException e)
        {
            System.out.println("Bad date");
        }
        try {
            setDeliveryDate(parser.parse(arrayOfArgs[7]));
        }
        catch(ParseException e)
        {
            System.out.println("Bad date");
        }
        setStatus(OrderStatus.valueOf(arrayOfArgs[9]));
        setCustomrId(Long.parseLong(arrayOfArgs[12]));
    }

    public Order(long Oid, Date ODate, Date OdeliveryDate, OrderStatus Ostatus, long OcustomrId)
    {
        setOrderId(Oid);
        setOrderDate(ODate);
        setDeliveryDate(OdeliveryDate);
        setStatus(Ostatus);
        setCustomrId(OcustomrId);
    }



    public String toString()
    {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        return "order: "+ getOrderId() + " order date: "+ ft.format(getOrderDate()) +" delivery date: "+ ft.format(getDeliveryDate()) + " status: "+ getStatus() + " customr id: "+ getCustomrId()+"\n";
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public long getCustomrId() {
        return costumerId;
    }

    public void setCustomrId(long customrId) {
        this.costumerId = customrId;
    }
}