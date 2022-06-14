package Models;

public class Product {
    private int Id;
    private String name;
    private float price;
    private int amount;
    private String describe;

    public Product(int id, String name, float price, int amount, String describe) {
        Id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.describe = describe;
    }

    public Product() {
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescribe() {
        return describe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", describe='" + describe + '\'' +
                '}';
    }

    public String write (){
        return Id + "," + name + "," + price + "," + amount  + "," + describe;
    }
}