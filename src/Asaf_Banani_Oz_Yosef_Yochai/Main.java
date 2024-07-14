package Asaf_Banani_Oz_Yosef_Yochai;

import java.util.Scanner;

//Name of presenters = ASAF BANANI 211961933, OZ YOSEF YOCHAI 213263262
//Lecturer: Eyal Haizenshtein

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Market market = new Market();

    public static void main(String[] args) {
        market.AddSeller("Asaf", "Pie314");
        market.AddSeller("Oz", "secret333");
        market.AddSeller("Ron", "password12");
        market.AddSeller("Rotem", "Pie314");

        // Adding buyers with addresses and passwords
        market.AddBuyer("Bar", "Pie314", new Adress("Hamapilim 13", "Pardes Hana", "Israel"));
        market.AddBuyer("Paz", "secret333", new Adress("Gibor 2", "Hod Hasharon", "Israel"));
        market.AddBuyer("Sahar", "password12", new Adress("Halozim 55", "Paris", "France"));

        // Adding products to sellers
        market.AddProduct("Asaf", new Product("Car", 5000.0, Category.KIDS, 100.0, market.getSerialNum()));
        market.AddProduct("Oz", new Product("Laptop", 1500.0, Category.ELECTRONICS, 100.0, market.getSerialNum()));
        market.AddProduct("Rotem", new Product("Chair", 200.0, Category.OFFICE, 0, market.getSerialNum()));
        market.AddProduct("Asaf", new Product("Doll", 30.0, Category.KIDS, 5.0, market.getSerialNum()));
        market.AddProduct("Ron", new Product("shirt", 25.0, Category.CLOTHING, 3.0, market.getSerialNum()));
        market.AddProduct("Asaf", new Product("Light", 80.0, Category.ELECTRONICS, 15.0, market.getSerialNum()));
        market.AddProduct("Oz", new Product("Printer", 300.0, Category.OFFICE, 30.0, market.getSerialNum()));

        // Adding products to carts
        market.AddProductToBuyer("Bar", market.GetProduct("Car", "Asaf"));
        market.AddProductToBuyer("Paz", market.GetProduct("Laptop", "Oz"));
        market.AddProductToBuyer("Sahar", market.GetProduct("Chair", "Rotem"));
        market.AddProductToBuyer("Bar", market.GetProduct("light", "Asaf"));
        market.AddProductToBuyer("Paz", market.GetProduct("Printer", "Oz"));

        // Displaying menu
        menu();


    }
    public static void menu() {

        String choose;
        String text = " 0. Exit \n 1. Add Seller \n 2. Add Buyer \n 3. Add Product for Seller"
                + "\n 4. Add Product for Buyer \n 5. Checkout \n 6. Display All Buyers \n"
                + " 7. Display All Sellers \n 8. Display All Products By Category \n 9. Renew History Cart";

        System.out.println(text);
        String curretntMessage = null;//While !=null, there is an unresolved error in the code
        do{
            if (curretntMessage != null) {
                System.out.println(curretntMessage);
            }
            System.out.print("Enter option: ");
            choose = sc.nextLine();
            curretntMessage =market.processInputOption(choose);
        }while(curretntMessage!=null);

        String name=null;
        String password;
        String city;
        String country;
        String address;
        String price;
        while(!choose.equals("0")) {
            switch (choose) {
                case "1" -> {
                    do {
                        if (name != null && market.findSeller(name) != null)
                            System.out.println("Seller already exists!");
                        if (curretntMessage != null) {
                            System.out.println(curretntMessage);
                        }
                        System.out.print("Add Name of seller: ");
                        name = sc.nextLine();
                        curretntMessage = market.processInputString(name);
                    } while (curretntMessage!= null || market.findSeller(name) != null);
                    do {
                        if (curretntMessage != null) {
                            System.out.println(curretntMessage);
                        }
                        System.out.print("Add password: ");
                        password = sc.nextLine();
                        curretntMessage = market.processInputPassword(password);
                    } while (curretntMessage != null);
                    market.AddSeller(name, password);
                    System.out.println("Added new seller.");
                }
                case "2" -> {
                    do {
                        if (name != null && market.findBuyer(name) != null)
                            System.out.println("Buyer already exists!");
                        if (curretntMessage != null) {
                            System.out.println(curretntMessage);
                        }
                        System.out.print("Add Name of buyer: ");
                        name = sc.nextLine();
                        curretntMessage = market.processInputString(name);
                    } while (curretntMessage!=null || market.findBuyer(name) != null);
                    do {
                        if (curretntMessage != null) {
                            System.out.println(curretntMessage);
                        }
                        System.out.print("Add password: ");
                        password = sc.nextLine();
                        curretntMessage = market.processInputPassword(password);
                    } while (curretntMessage!=null);
                    do {
                        if (curretntMessage != null) {
                            System.out.println(curretntMessage);
                        }
                        System.out.print("Add city: ");
                        city = sc.nextLine();
                        curretntMessage =market.processInputSentece(city);
                    } while (curretntMessage!=null);
                    do {
                        if (curretntMessage != null) {
                            System.out.println(curretntMessage);
                        }
                        System.out.print("Add country: ");
                        country = sc.nextLine();
                        curretntMessage = market.processInputString(country);
                    } while (curretntMessage!=null);
                    do {
                        if (curretntMessage != null) {
                            System.out.println(curretntMessage);
                        }
                        System.out.print("Add address: ");
                        address = sc.nextLine();
                        curretntMessage = market.processInputAddress(address);
                    } while (curretntMessage!=null);
                    market.AddBuyer(name, password, new Adress(address, city, country));
                    System.out.println("Added new buyer.");
                }
                case "3" -> {
                    do {
                        if (name != null && market.findSeller(name) == null)
                            System.out.println("Seller doesnt exist!");
                        if (curretntMessage != null) {
                            System.out.println(curretntMessage);
                        }
                        System.out.print(market.SellersList());
                        System.out.print("Choose seller: ");
                        name = sc.nextLine();
                        curretntMessage = market.processInputString(name);
                    } while (curretntMessage !=null|| market.findSeller(name) == null);

                    String itemName;
                    do {
                        if (curretntMessage != null) {
                            System.out.println(curretntMessage);
                        }
                        System.out.print("Add product name for sale: ");
                        itemName = sc.nextLine();
                        curretntMessage = market.processInputSentece(itemName);
                    } while (curretntMessage!=null);

                    do {
                        if (curretntMessage != null) {
                            System.out.println(curretntMessage);
                        }
                        System.out.print("Add a price to the product you would like to sell: ");
                        price = sc.nextLine();
                        curretntMessage =market.processInputDouble(price);
                    } while (curretntMessage!=null);
                    String wrap;
                    do {
                        if (curretntMessage != null) {
                            System.out.println(curretntMessage);
                        }
                        System.out.print("Do you want to add packge price to products? (y/n): ");
                        wrap = sc.nextLine();
                        curretntMessage = market.processInputAnswer(wrap);
                    } while (curretntMessage!=null);
                    double packagePrice;
                    if (wrap.equals("y")) {
                        String packageInput;
                        do {
                            if (curretntMessage != null) {
                                System.out.println(curretntMessage);
                            }
                            System.out.print("Add a price to Package the product: ");
                            packageInput = sc.nextLine();
                            curretntMessage = market.processInputDouble(packageInput);
                        } while (curretntMessage!=null);
                        packagePrice = Double.parseDouble(packageInput);
                    } else
                        packagePrice = 0;

                    Category category;
                    String categoryInput;
                    do {
                        if (curretntMessage != null) {
                            System.out.println(curretntMessage);
                        }
                        System.out.print("Add a category to the product you would like to sell: KIDS/CLOTHING/ELECTRONICS/OFFICE: ");
                        categoryInput = sc.nextLine().toUpperCase();
                        curretntMessage = market.processInputCategory(categoryInput);
                    } while (curretntMessage!=null);
                    category = Category.valueOf(categoryInput);
                    Product product = new Product(itemName, Double.parseDouble(price), category, packagePrice, market.getSerialNum());
                    market.AddProduct(name, product);
                    System.out.println("Product Name: " + itemName + ", Price : $" + price + " Registered to seller: "
                            + name);
                }
                case "4" -> {
                    if (market.getBuyersArray()[0] != null) {
                        String buyer = null;
                        do {
                            if (buyer != null && market.findBuyer(buyer) == null)
                                System.out.println("buyer doesnt exist!");
                            if (curretntMessage != null) {
                                System.out.println(curretntMessage);
                            }
                            System.out.print(market.BuyerList());
                            System.out.print("Choose Buyer to add Product: ");
                            buyer = sc.nextLine();
                            curretntMessage = market.processInputString(buyer);
                        } while (curretntMessage!=null|| market.findBuyer(buyer) == null);

                        String seller = null;
                        do {
                            if (seller != null && market.findSeller(seller) == null)
                                System.out.println("seller doesnt exist!");
                            if (curretntMessage != null) {
                                System.out.println(curretntMessage);
                            }
                            System.out.print(market.SellersList());
                            System.out.print("Choose a Seller to buy from: ");
                            seller = sc.nextLine();
                            curretntMessage = market.processInputString(seller);
                        } while (curretntMessage!=null|| market.findSeller(seller) == null);


                        if (market.ProductListSellers(seller) == null) {
                            System.out.print("Seller has no items \n");
                        } else {
                            String itemName = null;
                            do {
                                if (curretntMessage ==null && itemName != null && market.GetProduct(itemName, seller) == null) {
                                    System.out.println("Product doesnt exist! Returning to main menu.");
                                    break;
                                }
                                if (curretntMessage != null) {
                                    System.out.println(curretntMessage);
                                }
                                System.out.print(market.ProductListSellers(seller));
                                System.out.print("Choose Product to add to cart: ");
                                itemName = sc.nextLine();
                                curretntMessage = market.processInputSentece(itemName);
                            } while (curretntMessage!=null|| market.GetProduct(itemName, seller) == null);
                            Product selected = market.GetProduct(itemName, seller);
                            if (selected != null) {
                                if (selected.getPackagePrice() != 0) {
                                    String answer;
                                    do {
                                        if (curretntMessage !=null) {
                                            System.out.println(curretntMessage);
                                        }
                                        System.out.println("Do you want to wrap the product? (y/n) ");
                                        answer = sc.nextLine();
                                        curretntMessage = market.processInputAnswer(answer);
                                    } while (curretntMessage!=null);
                                    if (answer.toLowerCase().equals("y"))
                                        selected.setWrapped(true);
                                }
                                market.AddProductToBuyer(buyer, selected);
                                System.out.println("Added product to buyer: " + buyer);
                            }
                        }

                    } else {
                        System.out.println("There is No buyers yet, Returing to main menu");
                    }
                }
                case "5" -> {
                    String buyer = null;
                    do {
                        if (buyer != null && market.findBuyer(buyer) == null)
                            System.out.println("buyer doesnt exist!");
                        if (curretntMessage !=null) {
                            System.out.println(curretntMessage);
                        }
                        System.out.print(market.BuyerList());
                        System.out.print("Choose Buyer to checkout: ");
                        buyer = sc.nextLine();
                        curretntMessage = market.processInputString(buyer);
                    } while (curretntMessage!=null || market.findBuyer(buyer) == null);
                    if (market.proccesInputEmptyCart(market.findBuyer(buyer).getCart())==null) {
                        String answer;
                        do {
                            if (curretntMessage !=null) {
                                System.out.println(curretntMessage);
                            }
                            System.out.println("Chosen Cart:\n" + market.findBuyer(buyer).getCart().ProductList());
                            System.out.print("Sum: " + market.findBuyer(buyer).getCart().getSum() + "$ ,Want to checkout? (y/n): ");
                            answer = sc.nextLine();
                            curretntMessage = market.processInputAnswer(answer);
                        } while (curretntMessage!=null);
                        if (answer.equals("y")) {
                            market.checkout(market.findBuyer(buyer));
                            System.out.println("Checkout successful.");
                        } else {
                            System.out.println("Did not checkout, Goodbye.");
                        }
                    }
                    else{
                        System.out.println("Cart empty, returing to main menu");
                    }
                    //array_handler.shoppingCart();
                }
                case "6" -> {
                    if (market.getBuyersArray()[0] != null)
                        System.out.println(market.BuyerInfo());
                    else
                        System.out.println("There is no buyers yet.");
                }
                case "7" -> {
                    if (market.getSellerArray()[0] != null) {
                        System.out.println(market.SellersInfo());
                    } else {
                        System.out.println("There is no sellers yet.");
                    }
                }
                case "8" -> {

                    Category category;
                    String categoryInput;
                    System.out.print("Select a category to display products: KIDS/CLOTHING/ELECTRONICS/OFFICE: ");
                    do {
                        if (curretntMessage !=null) {
                            System.out.println(curretntMessage);
                        }
                        System.out.print("Please enter a valid Category (KIDS/CLOTHING/ELECTRONICS/OFFICE): ");
                        categoryInput = sc.nextLine().toUpperCase();
                        curretntMessage = market.processInputCategory(categoryInput);
                    } while (curretntMessage!=null);
                    category = Category.valueOf(categoryInput);
                    Cart res = market.GetProductByCategory(category);
                    System.out.println("Category: " + category);
                    System.out.println(res.ProductList());

                }
                case "9" -> {
                    String choice = null;
                    String buyer = null;
                    do {
                        if (buyer != null && market.findBuyer(buyer) == null)
                            System.out.println("buyer doesnt exist!");
                        if (curretntMessage !=null) {
                            System.out.println(curretntMessage);
                        }
                        System.out.print(market.BuyerList());
                        System.out.print("Choose Buyer to view history carts: ");
                        buyer = sc.nextLine();
                        curretntMessage = market.processInputString(buyer);
                    } while (curretntMessage!=null|| market.findBuyer(buyer) == null);
                    if (market.proccesInputEmptyHistoryCart(market.findBuyer(buyer).getHistory())!=null)
                        System.out.println("There's no history carts for this buyer yet.");
                    else {
                        do {
                            if (curretntMessage !=null) {
                                System.out.println(curretntMessage);
                            }
                            System.out.println(market.HistoryList(buyer));
                            System.out.println("Choose Cart you would like to replace current cart with, (by number): ");
                            choice = sc.nextLine();
                            curretntMessage = market.processInputDynamicOption(choice,1,market.findBuyer(buyer).getHistory_count());
                        } while (curretntMessage!=null || choice == null);
                        int cart = Integer.parseInt(choice);
                        market.HistoryCartSwap(buyer, cart);
                        System.out.println("Current Cart has been updated to chosen cart.");
//                        if (cart > market.HistoryCartLength(buyer) || cart < 1) {
//                            System.out.println("Invalid Cart choice input back the main menu. ");
//                        } else {
//                            market.HistoryCartSwap(buyer, cart);
//                            System.out.println("Current Cart has been updated to chosen cart.");
//                        }
                    }


                }
            }
            choose = null;
            name=null;
            password=null;
            city=null;
            country=null;
            address=null;
            System.out.println(text);
            do{
                if (curretntMessage !=null) {
                    System.out.println(curretntMessage);
                }
                System.out.print("Enter option: ");
                choose = sc.nextLine();
                curretntMessage = market.processInputOption(choose);
            }while(curretntMessage!=null);

        }
        //}

    }


}