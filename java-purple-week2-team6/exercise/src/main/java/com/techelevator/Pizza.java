package com.techelevator;

import java.util.Arrays;

public class Pizza {
    private String crustType;
    private String size;
    private String[] toppings = new String[]{"none", "none", "none", "none", "none", "none", "none", "none"};
    private double price;
    private final double SMALL_PIZZA = 6.99;
    private final double MEDIUM_PIZZA = 8.99;
    private final double LARGE_PIZZA = 10.99;
    private final double EXTRA_LARGE_PIZZA = 11.99;
    private final double JUMBO_PIZZA = 13.99;
    private final double PARMESAN = 0.50;
    private final double FLAVORED = 1.00;
    private final double EXTRA_TOPPING = 0.75;
    private boolean isSpecial = false;

    public boolean isSpecial() {
        return isSpecial;
    }

    public Pizza(String crustType, String size, String[] toppings) {
        this.crustType = crustType;
        this.size = size;
        this.toppings = toppings;
    }

    public Pizza() {
    }

    public void setSpecial(boolean special) {
        this.isSpecial = special;
    }

    public String getCrustType() {
        return crustType;
    }

    public String getSize() {
        return size;
    }

    public String[] getToppings() {
        return toppings;
    }

    public double getPrice() {
        return price;
    }

    public void setCrustType(String crustType) {
        this.crustType = crustType;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    public void getOrderInfo() {
        System.out.println();
        System.out.println("Crust type: " + this.getCrustType());
        System.out.println("Pizza size: " + this.getSize());
        System.out.println("Pizza toppings: " + Arrays.toString(this.toppings));
        System.out.println("Total price: " + this.calculatePrice());
        System.out.println();
    }

    public double calculatePrice() {
        double finalPrice = 0.0;
        double crustPrice = 0.0;
        double pizzaToppingPrice = 0.0;
        double sizePrice = 0.0;

        if (this.crustType.equals("Parmesan Crust")) {
            crustPrice = PARMESAN;
        } else if (this.crustType.equals("Flavored Crust")) {
            crustPrice = FLAVORED;
        } else {
            crustPrice = 0.0;
        }

        if (isSpecial == true) {
            pizzaToppingPrice = 5.00;
        } else {
            if (toppings.length > 2) {
                pizzaToppingPrice = (toppings.length - 2) * EXTRA_TOPPING;
            }
            }

            if (this.size.equalsIgnoreCase("Small")) {
                sizePrice = SMALL_PIZZA;
            } else if (this.size.equalsIgnoreCase("Medium")) {
                sizePrice = MEDIUM_PIZZA;
            } else if (this.size.equalsIgnoreCase("Large")) {
                sizePrice = LARGE_PIZZA;
            } else if (this.size.equalsIgnoreCase("Extra Large")) {
                sizePrice = EXTRA_LARGE_PIZZA;
            } else if (this.size.equalsIgnoreCase("Jumbo")) {
                sizePrice = JUMBO_PIZZA;
            }

            finalPrice = sizePrice + crustPrice + pizzaToppingPrice;
            return finalPrice;
        }

    }

