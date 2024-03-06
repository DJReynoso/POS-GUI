import javax.swing.*;
import java.util.ArrayList;

public class ContentListModel extends AbstractListModel {

    private ArrayList<Product> products;
    private double totalPrice = 0;

    public ContentListModel() {
        products = new ArrayList<Product>();
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public Product getProduct(int index) {
        return products.get(index);
    }
    public double totalPriceResult() {
        totalPrice = 0;
        for(int i = 0; i < products.size(); i++) {
            totalPrice = totalPrice + products.get(i).getTotalPrice();
        }
        return totalPrice;
    }
    @Override
    public int getSize() {
        return products.size();
    }

    @Override
    public Object getElementAt(int index) {
        return products.get(index);
    }
}
