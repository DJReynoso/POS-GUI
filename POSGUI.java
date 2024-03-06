import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class POSGUI extends JFrame {
    JTextField enterField;
    JList<Product> productList;
    ArrayList<String> content;
    String enteredBarcode = "";
    boolean existingProduct;
    boolean productFound;
    boolean empty;
    boolean newProductFound;
    double total = 0;
    JLabel totalLabel;

    listFrame window1;
    public POSGUI() {
        init();
    }
    public void init() {
        window1 = new listFrame();
        this.setTitle("Point of Sales GUI");

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        enterField = new JTextField(25);


        container.add(enterField, BorderLayout.NORTH);

        ContentListModel contentListModel = new ContentListModel();

        productList = new JList<Product>(contentListModel);

        enterField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                productFound = false;
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    productFound = false;
                    empty = false;
                    enteredBarcode = enterField.getText();
                    for(int i = 0; i < window1.productTableModel.getProducts().size(); i++){
                        if(enteredBarcode.equals(window1.productTableModel.getValueAt(i, 1))) {
                            productFound = true;
                            productList.updateUI();
                            break;
                        }
                    }
                    for(int i = 0; i < contentListModel.getSize(); i++) {
                        if(enteredBarcode.equals(contentListModel.getProduct(i).getBarcode())) {
                            existingProduct = true;
                            break;
                        }
                        else {
                            existingProduct = false;
                        }
                    }
                    if(enteredBarcode.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a barcode.", "Error", JOptionPane.ERROR_MESSAGE);
                        empty = true;
                    }
                    else if(existingProduct) {
                        for(int i = 0; i < contentListModel.getSize(); i++) {
                            if(enteredBarcode.equals(contentListModel.getProduct(i).getBarcode())) {
                                contentListModel.getProduct(i).addQuantity();
                                total = contentListModel.totalPriceResult();


                                for(int j = 0; j < contentListModel.getSize(); j++) {
                                    if(!(enteredBarcode.equals(contentListModel.getProduct(j).getBarcode()))) {


                                    }
                                }
                                totalLabel.setText("Total: " + total);
                                existingProduct = false;
                                productList.updateUI();
                                break;
                            }
                        }
                    }
                    else if(productFound) {
                        for(int i = 0; i < window1.productTableModel.getProducts().size(); i++) {
                            if(enteredBarcode.equals(window1.productTableModel.getValueAt(i, 1)) &&
                                    !(window1.productTableModel.getValueAt(i, 1).toString().isEmpty())) {
                                Product product = window1.productTableModel.getProduct(i);
                                contentListModel.addProduct(product);
                                for(int j = 0; j < contentListModel.getSize(); j++) {
                                    if(!(enteredBarcode.equals(contentListModel.getProduct(j).getBarcode()))) {

                                    }
                                    else {
                                        total = contentListModel.totalPriceResult();
                                        totalLabel.setText("Total: " + total);
                                    }
                                }

                                productList.updateUI();
                                break;
                            }
                        }
                    }
                    if(!productFound && !existingProduct && !empty) {
                        JOptionPane.showMessageDialog(null, "PRODUCT NOT FOUND!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    productList.updateUI();

                }
            }
        });
        container.add(new JScrollPane(productList), BorderLayout.CENTER);

        totalLabel = new JLabel("Total: " + total);
        totalLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

        container.add(totalLabel, BorderLayout.SOUTH);
        totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        productList.setCellRenderer(new ListCellRenderer<Product>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Product> list, Product value, int index, boolean isSelected, boolean cellHasFocus) {
                JPanel midPanel = new JPanel(new BorderLayout());
                JPanel lowerPanel = new JPanel(new BorderLayout());
                JPanel upperPanel = new JPanel(new BorderLayout());


                String name = value.getName();
                String barcode = value.getBarcode();
                double price = value.getPrice();
                int quantity = value.getQuantity();
                double amount = value.getTotalPrice();

                JLabel left = new JLabel(name + " - " + barcode);
                JLabel bottom = new JLabel(quantity + "x " + " @ " + price);
                JLabel right = new JLabel(String.valueOf(amount));

                JLabel leftLabel = new JLabel("<html> Name - Barcode" + "<br>Qty @ Price");
                JLabel rightLabel = new JLabel("Amount");

                upperPanel.add(leftLabel, BorderLayout.WEST);
                upperPanel.add(rightLabel, BorderLayout.EAST);

                midPanel.add(left, BorderLayout.WEST);
                midPanel.add(right, BorderLayout.EAST);
                lowerPanel.add(bottom, BorderLayout.WEST);
                JPanel wholePanel = new JPanel(new GridLayout(3, 1));

                wholePanel.add(upperPanel);
                wholePanel.add(midPanel);
                wholePanel.add(lowerPanel);

                return wholePanel;
            }
        });

        this.pack();
        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        new POSGUI();
    }
}
