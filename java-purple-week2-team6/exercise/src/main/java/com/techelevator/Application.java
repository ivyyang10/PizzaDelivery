package com.techelevator;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        //***** TEST PIZZAS *****

        Pizza orderOne = new Pizza();
            orderOne.setCrustType("Parmesan Crust");
            orderOne.setSize("Extra Large");
            orderOne.setToppings(new String[] {"Pepperoni"});

        Pizza orderTwo = new Pizza("Whole Wheat", "Medium", new String[] {"Tomatoes", "Mushrooms", "Roasted Red Peppers"});

        Pizza orderThree = new Pizza("Parmesan Crust", "Jumbo", new String[] {"Chicken", "Roasted Red Peppers", "Basil", "Feta"});

        Pizza orderFour = new Pizza("Flavored Crust", "Small", new String[] {"Pepperoni", "Sausage", "Chicken", "Ham", "Roasted Peppers", "Mushrooms", "Anchovies", "Tomatoes"});

        PizzaDelivery deliveryOne = new PizzaDelivery();

        PizzaDelivery deliveryTwo = new PizzaDelivery("Conor", "Parnell", 48124);

        PizzaDelivery deliveryThree = new PizzaDelivery("Cameron", "Eric", 11204);

        PizzaOrder fullOrder = new PizzaOrder("Parmesan Crust", "Large", new String[] {"Pepperoni", "Ham", "Chicken"}, "Conor", "Parnell", 11204);

        //***** PIZZA APPLICATION *****

        Map<String, Double> pizzaList = new HashMap<>();
        String end = "";
        boolean isDelivery = false;
        boolean isSpecial = false;
        String ramToppings = "Roasted Peppers,Mushrooms,Tomatoes";
        String nerdToppings = "Chicken,Roasted Red Peppers,Basil,Feta";
        String oracleToppings = "Pepperoni,Sausage,Chicken,Ham,Anchovies,Roasted Peppers,Mushrooms,Tomatoes";
        String pizzaName = "";
        String[] pizzaToppings = new String[8];

        System.out.println("Hello. Welcome to Ivy & Conor's Pizza Place.");

        System.out.print("Will this order be a delivery, or for pick-up? ['d' / 'p']: ");
        String deliveryChoice = userInput.nextLine();
            if (deliveryChoice.equalsIgnoreCase("d")) {
                isDelivery = true;
            }

        do {
            isSpecial = false;
            System.out.print("Great! What size pizza would you like? ['Small', 'Medium', 'Large', 'Extra Large', 'Jumbo']: ");
            String pizzaSize = userInput.nextLine();
            System.out.print("What kind of crust would you like? ['Plain', 'Whole Wheat', 'Parmesan Crust', 'Flavored Crust']: ");
            String pizzaCrust = userInput.nextLine();
            System.out.print("Would you like a specialty pizza or customized toppings? ['special'/'custom']: ");
            String special = userInput.nextLine();
                if (special.equalsIgnoreCase("special")) {
                    System.out.println("Great! Here are our specials for today: ");
                    System.out.println("    -the RAM ['ram']: Roasted Peppers, Mushrooms, and Tomatoes");
                    System.out.println("    -the Nerd ['nerd']: Chicken, Roasted Red Peppers, fresh Basil, and Feta cheese");
                    System.out.println("    -the Oracle ['oracle']: Pepperoni, Sausage, Chicken, Ham, Anchovies, Roasted Peppers, Mushrooms, and Tomatoes");
                    System.out.print("Which would you like?: ");
                    String specialToppings = userInput.nextLine();
                        if (specialToppings.equalsIgnoreCase("ram")){
                            pizzaToppings = ramToppings.split(",");
                            pizzaName = pizzaSize + " RAM [Roasted Peppers, Mushrooms, Tomatoes]";
                            isSpecial = true;
                        } else if (specialToppings.equalsIgnoreCase("nerd")) {
                            pizzaToppings = nerdToppings.split(",");
                            pizzaName = pizzaSize + " Nerd [Chicken, Roasted Red Peppers, Basil, Feta]";
                            isSpecial = true;
                        } else if (specialToppings.equalsIgnoreCase("oracle")) {
                            pizzaToppings = oracleToppings.split(",");
                            pizzaName = pizzaSize + " Oracle [Pepperoni, Sausage, Chicken, Ham, Anchovies, Roasted Peppers, Mushrooms, Tomatoes]";
                            isSpecial = true;
                        } else {
                            System.out.println("Hmm. I don't think we have that special today.");
                        }
                } else {
                    System.out.println("What toppings would you like? Please choose up to 8 (comma separated, no space between)");
                    System.out.println("['Pepperoni', 'Sausage', 'Chicken', 'Ham', 'Anchovies', 'Roasted Peppers', 'Mushrooms','Tomatoes']");
                    isSpecial = false;
                    pizzaToppings = userInput.nextLine().split(",");
                    pizzaName = pizzaSize + " " + Arrays.toString(pizzaToppings);
                }

                PizzaOrder newOrder = new PizzaOrder(pizzaCrust, pizzaSize, new String[] {Arrays.toString(pizzaToppings)});
                newOrder.setCustomToppings(Arrays.toString(pizzaToppings));
                newOrder.setSpecial(isSpecial);
                newOrder.setDelivery(isDelivery);

                pizzaList.put(pizzaName, newOrder.calculatePizzaOnly());

            System.out.println("If you would like to add another pizza, please say 'y', otherwise say 'n' to calculate total: ");
            end = userInput.nextLine();
        } while (!end.equals("n"));

        System.out.print("May I have a first name for your order?: ");
        String firstName = userInput.nextLine();
        System.out.print("May I have your last name?: ");
        String lastName = userInput.nextLine();
        PizzaDelivery delivery = new PizzaDelivery(firstName, lastName);
        if (isDelivery == true) {
            System.out.print("And what is your zip code?: ");
            String zipCode = userInput.nextLine();
            delivery.setZipCode(zipCode);
        } else {
            //do nothing
        }

        double totalPrice = 0.0;
        for(Map.Entry<String, Double> pizza : pizzaList.entrySet()) {
            System.out.println(pizza.getKey() + ": $" + pizza.getValue());
            totalPrice += pizza.getValue();
        }
        if (isDelivery == true) {
            System.out.println("Delivery price: $" + delivery.calculateDeliveryPrice());
            totalPrice += delivery.calculateDeliveryPrice();
        }

        System.out.println("Your total cost is: $" + totalPrice);

        if (isDelivery == true) {
            System.out.println("Thank you, " + firstName + "! Pizza will be there in 30 minutes.");
        } else {
            System.out.println("Thank you, " + firstName + "! Pizza will be ready for pick-up in 30 minutes.");
        }
    }
}
