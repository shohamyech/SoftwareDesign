package DL;


public class Customer {
    private long id;
    private String name;
    private int tier;

    public Customer(String customerInfo) {
        String[] arrayOfArgs = customerInfo.split(" ");
        setId(Long.parseLong(arrayOfArgs[1]));
        setName(arrayOfArgs[3]);
        setTier(Integer.parseInt(arrayOfArgs[5]));
    }

    public Customer(long Cid, String Cname, int Ctier) {
        setId(Cid);
        setName(Cname);
        setTier(Ctier);
    }

    public String toString() {
        return "customer: " + getId() + " name: " + getName() + " tier: " + getTier() + "\n";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }
}