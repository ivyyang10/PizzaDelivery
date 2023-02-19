# Week 2 Pair Exercise - PizzaByte

The PizzaByte Place Pizzeria sells only pizza, but they do it well.  They offer delivery to certain local areas, or you can get carryout.  They offer eight different toppings (Pepperoni, Sausage, Chicken, Ham, Anchovies, Roasted Peppers, Mushrooms, and Tomatoes) as well as three kinds of specialty pizzas (the RAM – Roasted Red Peppers, Tomatoes and Mushrooms; the Nerd – Chicken, Roasted Red Peppers, fresh Basil and Feta cheese; and the Oracle – all 8 topping choices). 

## Classes

The core of this application consists of two classes, which you'll create in the main package `com.techelevator`. Make sure to read through the requirements for each class before writing any code.


### Step One: Create the `Pizza` class

Create a new class called `Pizza.java` with the following requirements.

#### Instance variables

| Name | Type | Getter | Setter |
|------|------|--------|--------|
| crustType | String | x | x |
| size | String | x | x |
| toppings | String array | x | x | 
| price | double | x |  |

> NOTE: The toppings array should be filled with the word "none" to start

#### Static constants

The default starting price for a Small pizza that is $6.99 and is stored in a static constant variable of type `double`.
The default starting price for a Medium pizza that is $8.99 and is stored in a static constant variable of type `double`.
The default starting price for a Large pizza that is $10.99 and is stored in a static constant variable of type `double`.
The default starting price for a X-Large pizza that is $11.99 and is stored in a static constant variable of type `double`.
The default starting price for a Jumbo pizza that is $13.99 and is stored in a static constant variable of type `double`.

#### Constructors

`Pizza` must have two constructors.
The first one accepts three parameters: `crustType`, `size`, and `toppings`.

> Note: The first constructor doesn't include a `double` argument for the price. Make sure to initialize each pizza object to the static constant you created.

The second constructor is a no-argument constructor. This constructor allows you to create your `Pizza` objects in multiple ways.

#### Methods

| Method Name        | Description |
|--------------------| ----------- |
| `calculatePrice()` | A derived property that returns the final cost of the pizza.  Each pizza comes with two toppings for free 
|                    |- additional toppings are $.75 each
|                    | - specialty pizzas add $5.00 to the size price.                                                                
|                    | - plain and whole wheat crusts are free, parmesan crust is $.50 extra, any other flavored crust is $1.00 more. 


### Step Two: Create the `PizzaDelivery` class

Create a new class called `PizzaDelivery.java` with the following requirements.

#### Instance variables

| Name | Type | Getter | Setter |
|------|------|--------|--------|
| firstName | String | x | x |
| lastName | String | x | x |
| zipCode | int | x | x |
| deliveryPrice | double | x | x |


#### Constructors

`PizzaDelivery` needs two constructors.

The first one accepts all the arguments needed to create a new `PizzaDelivery`: `firstName`, `lastName`, and `zipCode`.

> Note: The first constructor doesn't include a `double` argument for the deliveryPrice. 
> Note: the only zipCodes allowed are: 48120, 48124, and 48128. Incorrect zipCodes will be set to 48120.

The second constructor is a no-argument constructor.

#### Methods

| Method Name                | Description |
|----------------------------| ----------- |
| `getFullName()`            | A derived property that returns the order's full name in the following format: "Last, First"|
| `calculateDeliveryPrice()` | A method that determines their deliveryPrice based on their zipCode
|                            |- 48120 has a delivery fee of $2.00
|                            | - 48124 has a delivery fee of $3.00 
|                            | - 48128 has a delivery fee of $5.00 

## Step Three - Application

Now that you've created the core classes for this application, you'll write some code to test them in `/src/main/java/com/techelevator/Application.java`.  Create a main method and create at least 4 Pizza objects, testing both constructors and at least 3 Pizza Delivery objects, again, testing both constructors and your setters.  Print out all information for all objects in a neat format.

### Step Four: Create and print pizza orders by creating the `PizzaOrder` class

Create a new class called `PizzaOrder.java` with the following requirements.

#### Instance variables

| Name | Type | Getter | Setter |
|------|------|--------|--------|
| order | Pizza | x | x |
| delivery | PizzaDelivery | x | x |


#### Constructors

***** `PizzaOrder` must have one constructor that accepts six parameters: `crust`, `size`, `toppings`, `firstName`, `lastName`, and `zipCode`.

#### Methods

| Method Name | Description |
| ----------- | ----------- |
| `calculatePizzaOrder()`| A method that calculates the total price of a delivered pizza.  If you buy a specialty pizza and get it delivered, you receive a 10% discount on the price of the pizza.|
| `toString()` | A method returns a String that nicely formats all information for the delivered Pizza order.


### Step Five: Test your `PizzaOrder` class in the `Application` class

In the `Application.java` class, create a `Scanner` object to ask for user input.
Create a List of `PizzaOrder` objects.
Write a `while` loop that allows the user to create `PizzaOrder` objects until they are done.
In the loop, ask the user for PizzaOrders, gathering the six parameters.  Create a `PizzaOrder` object and load it in the List.
Continue this until the user is done entering information (test by creating at least 3 PizzaOrder objects)
Create a total variable that will calculate the toal cost of all `PizzaOrders`.
Print out all PizzaOrder information in a neat format and total up all costs.  
Print out the total cost of all sales.
