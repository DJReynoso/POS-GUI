public class Product {
    private String name;
    private String barcode;
    private double price;

    private int quantity = 1;

    public Product(String name, String barcode, double price) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return this.name;
    }
    public String getBarcode() {
        return this.barcode;
    }
    public double getPrice() {
        return this.price;
    }
    public void addQuantity() {
        quantity++;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public double getTotalPrice() {
        return price * quantity;
    }
}
