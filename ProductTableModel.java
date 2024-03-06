import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    private ArrayList<Product> products;
    public ProductTableModel() {
        products = new ArrayList<Product>();
    }
    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0) {
            return "Product Name";
        }
        else if(column == 1) {
            return "Barcode";
        }
        else {
            return "Price";
        }
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        if(columnIndex == 0) {
            return product.getName();
        }
        else if(columnIndex == 1) {
            return product.getBarcode();
        }
        else {
            return product.getPrice();
        }
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public Product getProduct(int index) {
        return products.get(index);
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
}
