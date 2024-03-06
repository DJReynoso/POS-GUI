import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class listFrame extends JFrame {
    JPanel productPanel, tablePanel;
    JLabel nameLabel, barcodeLabel, priceLabel;
    JTextField nameField, barcodeField, priceField;
    JTable table;
    ProductTableModel productTableModel;
    boolean duplicate;
    public listFrame() {
        init();
    }
    public void init() {
        this.setTitle("Product Master List");
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        productPanel = new JPanel();
        productPanel.setLayout(new GridBagLayout());

        nameLabel = new JLabel("NAME:");
        barcodeLabel = new JLabel("BARCODE:");
        priceLabel = new JLabel("PRICE:");

        GridBagConstraints c = new GridBagConstraints();


        nameField = new JTextField(10);
        barcodeField = new JTextField(10);
        priceField = new JTextField(10);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        productPanel.add(nameLabel, c);
        c.gridx = 1;
        c.gridwidth = 2;
        productPanel.add(nameField, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        productPanel.add(barcodeLabel, c);
        c.gridx = 1;
        c.gridwidth = 2;
        productPanel.add(barcodeField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        productPanel.add(priceLabel, c);
        c.gridx = 1;
        c.gridwidth = 2;
        productPanel.add(priceField, c);

        JButton addBtn = new JButton("Add");
        c.gridy = 3;
        c.gridx = 1;
        c.gridwidth = 1;
        productPanel.add(addBtn, c);

        productTableModel = new ProductTableModel();
        table = new JTable(productTableModel);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 3;

        productPanel.add(new JScrollPane(table), c);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean doubleValue = true;
                duplicate = false;
                try {
                    Double.valueOf(priceField.getText());
                }
                catch (Exception exception) {
                    doubleValue = false;
                }
                for(int i = 0; i < productTableModel.getProducts().size(); i++) {
                    if(barcodeField.getText().equals( productTableModel.getProduct(i).getBarcode())) {
                        duplicate = true;
                    }
                }
                if(nameField.getText().isBlank() || barcodeField.getText().isBlank() || priceField.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Please enter the proper product details.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(duplicate) {
                    JOptionPane.showMessageDialog(null, "This barcode is already registered in the list.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    double price = 0;
                    price = Double.parseDouble(priceField.getText());

                    productTableModel.addProduct(new Product(nameField.getText(), barcodeField.getText(), price));

                    nameField.setText("");
                    barcodeField.setText("");
                    priceField.setText("");

                    nameField.requestFocus();
                    barcodeField.requestFocus();
                    priceField.requestFocus();

                    productTableModel.fireTableDataChanged();
                }
            }
        });

        container.add(productPanel, BorderLayout.CENTER);
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                boolean doubleValue = true;

                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    duplicate = false;
                    try {
                        Double.valueOf(priceField.getText());
                    }
                    catch (Exception exception) {
                        doubleValue = false;
                    }
                    for(int i = 0; i < productTableModel.getProducts().size(); i++) {
                        if(barcodeField.getText().equals( productTableModel.getProduct(i).getBarcode())) {
                            duplicate = true;
                        }
                    }
                    if(nameField.getText().isBlank() || barcodeField.getText().isBlank() || priceField.getText().isBlank()) {
                        JOptionPane.showMessageDialog(null, "Please enter the proper product details.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(duplicate) {
                        JOptionPane.showMessageDialog(null, "This barcode is already registered in the list.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        double price = 0;
                        price = Double.parseDouble(priceField.getText());

                        productTableModel.addProduct(new Product(nameField.getText(), barcodeField.getText(), price));

                        nameField.setText("");
                        barcodeField.setText("");
                        priceField.setText("");

                        nameField.requestFocus();
                        barcodeField.requestFocus();
                        priceField.requestFocus();

                        productTableModel.fireTableDataChanged();
                    }
                }
            }
        });
        barcodeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                boolean doubleValue = true;

                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    duplicate = false;
                    try {
                        Double.valueOf(priceField.getText());
                    }
                    catch (Exception exception) {
                        doubleValue = false;
                    }
                    for(int i = 0; i < productTableModel.getProducts().size(); i++) {
                        if(barcodeField.getText().equals( productTableModel.getProduct(i).getBarcode())) {
                            duplicate = true;
                        }
                    }
                    if(nameField.getText().isBlank() || barcodeField.getText().isBlank() || priceField.getText().isBlank()) {
                        JOptionPane.showMessageDialog(null, "Please enter the proper product details.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(duplicate) {
                        JOptionPane.showMessageDialog(null, "This barcode is already registered in the list.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        double price = 0;
                        price = Double.parseDouble(priceField.getText());

                        productTableModel.addProduct(new Product(nameField.getText(), barcodeField.getText(), price));

                        nameField.setText("");
                        barcodeField.setText("");
                        priceField.setText("");

                        nameField.requestFocus();
                        barcodeField.requestFocus();
                        priceField.requestFocus();

                        productTableModel.fireTableDataChanged();
                    }
                }
            }
        });

        priceField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                boolean doubleValue = true;

                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    duplicate = false;
                    try {
                        Double.valueOf(priceField.getText());
                    }
                    catch (Exception exception) {
                        doubleValue = false;
                    }
                    for(int i = 0; i < productTableModel.getProducts().size(); i++) {
                        if(barcodeField.getText().equals( productTableModel.getProduct(i).getBarcode())) {
                            duplicate = true;
                        }
                    }
                    if(nameField.getText().isBlank() || barcodeField.getText().isBlank() || priceField.getText().isBlank()) {
                        JOptionPane.showMessageDialog(null, "Please enter the proper product details.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(duplicate) {
                        JOptionPane.showMessageDialog(null, "This barcode is already registered in the list.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        double price = 0;
                        price = Double.parseDouble(priceField.getText());

                        productTableModel.addProduct(new Product(nameField.getText(), barcodeField.getText(), price));

                        nameField.setText("");
                        barcodeField.setText("");
                        priceField.setText("");

                        nameField.requestFocus();
                        barcodeField.requestFocus();
                        priceField.requestFocus();

                        productTableModel.fireTableDataChanged();
                    }
                }
            }
        });

        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
