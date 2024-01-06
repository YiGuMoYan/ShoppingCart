package top.yigumoyan;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items;
    private double subtotal;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.subtotal = 0.0;
    }

    public void addItem(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(product);
            subtotal += product.getPrice();
        }
    }

    public void removeItem(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.remove(product);
            subtotal -= product.getPrice();
        }
    }

    public void viewCart() {
        System.out.println(Constant.VIEW_CART);
        for (Product item : items) {
            System.out.println(item.getName() + " - ￥" + item.getPrice());
        }
        System.out.println(Constant.SUBTOTAL_LABEL + subtotal);
    }

    public double calculateTotal(double taxRate) {
        double tax = subtotal * taxRate;
        double total = subtotal + tax;
        System.out.println(Constant.TAX_LABEL + tax);
        System.out.println(Constant.TOTAL_LABEL + total);
        return total;
    }
}
