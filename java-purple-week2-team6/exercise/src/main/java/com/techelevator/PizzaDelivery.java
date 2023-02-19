package com.techelevator;

public class PizzaDelivery {
    private String firstName;
    private String lastName;
    private int zipCode;
    private double deliveryPrice = 0.0;

    public PizzaDelivery(String firstName, String lastName, int zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    public PizzaDelivery(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PizzaDelivery(){
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getZipCode() {
        if(zipCode != 48124 && zipCode != 48128){
            this.zipCode = 48120;
        }
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = Integer.parseInt(zipCode);
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getFullName(){
        return lastName+", "+firstName;
    }

    public void getDeliveryInfo() {
        System.out.println("Order name: " + this.getFullName());
        System.out.println("Zip code: " + this.getZipCode());
        System.out.println("Delivery price: " + this.calculateDeliveryPrice());
    }

    public double calculateDeliveryPrice(){
        if(zipCode == 48128 ){
            deliveryPrice=5.00;
        }else if(zipCode == 48124){
            deliveryPrice =3.00;
        }else{
            this.zipCode=48120;
            deliveryPrice=2.00;
        }
        return deliveryPrice;
    }
}
