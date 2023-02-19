package com.techelevator;

import java.util.Arrays;

public class PizzaOrder {
    private Pizza order = new Pizza();
    private PizzaDelivery delivery = new PizzaDelivery();
    private double SPECIAL_DISCOUNT = 0.90;
    private boolean isDelivery = false;
    private String customToppings = "";

    public PizzaOrder(String crust, String size, String[] toppings) {
        this.order.setCrustType(crust);
        this.order.setSize(size);
        this.order.setToppings(toppings);
    }

    public PizzaOrder(String crust, String size, String[] toppings, String firstName, String lastName, int zipCode) {
        this.order.setCrustType(crust);
        this.order.setSize(size);
        this.order.setToppings(toppings);
        this.delivery.setFirstName(firstName);
        this.delivery.setLastName(lastName);
        this.delivery.setZipCode(zipCode);

    }

    public void setCustomToppings(String customToppings) {
        this.customToppings = customToppings;
        this.order.setToppings(this.customToppings.split(","));
    }

    public void setZipCode(String zipCode) {
        this.delivery.setZipCode(Integer.parseInt(zipCode));
    }

    public double getDeliveryPrice() {
        return this.delivery.calculateDeliveryPrice();
    }

    public Pizza getOrder() {
        return order;
    }

    public void setSpecial(boolean isSpecial) {
        this.order.setSpecial(isSpecial);
    }

    public void setDelivery (boolean isDelivery){
        this.isDelivery = isDelivery;
    }

    public void setOrder(Pizza order) {
        this.order = order;
    }

    public PizzaDelivery getDelivery() {
        return delivery;
    }

    public void setDelivery(PizzaDelivery delivery) {
        this.delivery = delivery;
    }

    public double calculatePizzaOnly() {
        if ((order.isSpecial() == true) && (isDelivery == true)) {
            return (this.order.calculatePrice() * SPECIAL_DISCOUNT);
        } else {
            return this.order.calculatePrice();
        }
    }

    public double calculatePizzaOrder(){
        if ((order.isSpecial() == true) && (isDelivery == true)) {
            return (this.order.calculatePrice() * SPECIAL_DISCOUNT) + this.delivery.calculateDeliveryPrice();
        } else {
            return this.order.calculatePrice() + this.delivery.calculateDeliveryPrice();
        }
    }

    public String toString(){
     return "Order for delivery to " + this.delivery.getZipCode() + " for " + this.delivery.getFullName() + ", " + this.order.getSize() + " " + this.order.getCrustType() + " pizza, with " + Arrays.toString(this.order.getToppings()) + " on top. Pizza price: $" + this.order.calculatePrice() + ", " + " delivery fee: $" + this.delivery.calculateDeliveryPrice() + ", Total price: $" + this.calculatePizzaOrder() + ".";
        }

    }


