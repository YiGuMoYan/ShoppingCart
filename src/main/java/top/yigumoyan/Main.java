package top.yigumoyan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product laptop = new Product("笔记本电脑", 999.99);
        Product phone = new Product("智能手机", 499.99);
        Product headphones = new Product("耳机", 99.99);

        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println(Constant.WELCOME_MESSAGE);
            System.out.println(Constant.AVAILABLE_PRODUCTS);
            System.out.println("1. 笔记本电脑 - ￥999.99");
            System.out.println("2. 智能手机 - ￥499.99");
            System.out.println("3. 耳机 - ￥99.99");
            System.out.println("4. " + Constant.VIEW_CART);
            System.out.println("5. " + Constant.CHECKOUT);
            System.out.println("6. " + Constant.EXITING_MESSAGE);
            System.out.print("请输入您的选择: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    cart.addItem(laptop, 1);
                    System.out.println(String.format(Constant.ADDED_TO_CART_MESSAGE, laptop.getName()));
                    break;
                case 2:
                    cart.addItem(phone, 1);
                    System.out.println(String.format(Constant.ADDED_TO_CART_MESSAGE, phone.getName()));
                    break;
                case 3:
                    cart.addItem(headphones, 1);
                    System.out.println(String.format(Constant.ADDED_TO_CART_MESSAGE, headphones.getName()));
                    break;
                case 4:
                    cart.viewCart();
                    break;
                case 5:
                    double total = cart.calculateTotal(0.08); // 假设税率为8%
                    System.out.printf("%s%s%.2f\n", Constant.THANK_YOU_MESSAGE, Constant.TOTAL_LABEL, total);
                    System.exit(0);
                case 6:
                    System.out.println(Constant.EXITING_MESSAGE);
                    System.exit(0);
                default:
                    System.out.println(Constant.INVALID_CHOICE_MESSAGE);
            }
        }
    }
}