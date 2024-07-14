package Asaf_Banani_Oz_Yosef_Yochai;
// this is the manager class

import java.util.Arrays;
import java.util.InputMismatchException;

public class Market implements IMarket{
    private Sellers[] sellerArray;
    private Buyers[] buyersArray;
    private int SerialCounter;
    private ExceptionUtill exceptionUtill;
    private int NumOfBuyers;
    private int NumOfSellers;

    public Market() {
        sellerArray = new Sellers[1];
        buyersArray = new Buyers[1];
        exceptionUtill = new ExceptionUtill();

        SerialCounter = 111111111;
        NumOfBuyers = 0;
        NumOfSellers = 0;
    }

    public int getSerialNum() {
        SerialCounter++;
        return this.SerialCounter;
    }

    public Buyers[] getBuyersArray() {
        return buyersArray;
    }

    public Sellers[] getSellerArray() {
        return sellerArray;
    }

    public int getNumOfSellers() {
        return NumOfSellers;
    }

    public int getNumOfBuyers() {
        return NumOfBuyers;
    }

    public void setNumOfBuyers(int numOfBuyers) {
        NumOfBuyers = numOfBuyers;
    }

    public void setNumOfSellers(int numOfSellers) {
        NumOfSellers = numOfSellers;
    }


    public boolean SellerExists(String sellerName) {
        for (int i = 0; i < sellerArray.length; i++) {
            if (sellerArray[i] != null) {
                if (sellerArray[i].getName().equalsIgnoreCase(sellerName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Product GetProduct(String productName, String sellerName) {
        Cart cart;
        for (int i = 0; i < sellerArray.length; i++) {
            if (sellerArray[i] != null && sellerArray[i].getName().equalsIgnoreCase(sellerName)) {
                cart = sellerArray[i].getShop();
                return cart.findProduct(productName);
            }
        }
        return null;
    }

    public String ProductListSellers(String sellerName) {
        for (int i = 0; i < sellerArray.length; i++) {
            if (sellerArray[i] != null && sellerArray[i].getShop().getProducts()[0] != null) {
                if (sellerArray[i].getName().equalsIgnoreCase(sellerName)) {
                    return sellerArray[i].getShop().ProductList();
                }
            }
        }
        return null;
    }

    public String SellersList() {
        String res = "";
        for (int i = 0; i < sellerArray.length; i++) {
            if (sellerArray[i] != null) {
                res += (i + 1) + ") " + sellerArray[i].getName() + "\n";

            }
        }
        return res;
    }

    public String BuyerList() {
        String res = "";
        for (int i = 0; i < buyersArray.length; i++) {
            if (buyersArray[i] != null) {
                res += (i + 1) + ") " + buyersArray[i].getName() + "\n";

            }
        }
        return res;
    }

    public boolean AddProduct(String sellerName, Product product) {
        for (int i = 0; i < sellerArray.length; i++) {
            if (sellerArray[i] != null) {
                if (sellerArray[i].getName().equalsIgnoreCase(sellerName)) {
                    sellerArray[i].AddToShop(product);
                    return true;
                }
            }

        }
        return false;
    }

    public boolean AddSeller(String username, String password) {
        Sellers new_seller = new Sellers(username, password, new Cart());
        for (int i = 0; i < this.sellerArray.length; i++) {
            if (this.sellerArray[i] == null) {
                this.sellerArray[i] = new_seller;
                this.NumOfSellers++;
                return true;
            }
        }
        this.SellersArrayExpend();
        return this.AddSeller(username, password);
    }

    public Sellers findSeller(String username) {
        for (int i = 0; i < sellerArray.length; i++) {
            if (sellerArray[i] != null) {
                if (sellerArray[i].getName().equalsIgnoreCase(username))
                    return sellerArray[i];
            }
        }
        return null;
    }

    public void SellersArrayExpend() {
        if (this.sellerArray.length == 0) {
            this.sellerArray = new Sellers[10];
        } else {
            Sellers[] res = new Sellers[this.sellerArray.length * 2];
            for (int i = 0; i < this.sellerArray.length; i++) {
                if (this.sellerArray[i] != null) {
                    res[i] = this.sellerArray[i];

                }
            }
            this.sellerArray = res;
        }
    }

    public boolean AddBuyer(String username, String password, Adress adress) {
        Buyers new_buyer = new Buyers(username, password, new Cart(), adress);
        for (int i = 0; i < this.buyersArray.length; i++) {
            if (this.buyersArray[i] == null) {
                this.buyersArray[i] = new_buyer;
                NumOfBuyers++;
                return true;
            }
        }
        this.BuyerArrayExpend();
        return this.AddBuyer(username, password, adress);
    }

    public Buyers findBuyer(String username) {
        for (int i = 0; i < this.buyersArray.length; i++) {
            if (this.buyersArray[i] != null) {
                if (this.buyersArray[i].getName().equalsIgnoreCase(username)) {
                    return buyersArray[i];
                }
            }

        }
        return null;
    }

    public void BuyerArrayExpend() {
        if (this.buyersArray.length == 0) {
            this.buyersArray = new Buyers[10];
        } else {
            Buyers[] res = new Buyers[this.buyersArray.length * 2];
            for (int i = 0; i < this.buyersArray.length; i++) {
                res[i] = this.buyersArray[i];
            }
            this.buyersArray = res;
        }
    }

    public String HistoryList(String buyer) {
        String res = "";
        for (int i = 0; i < this.buyersArray.length; i++) {
            if (this.buyersArray[i] != null) {
                if (this.buyersArray[i].getName().equalsIgnoreCase(buyer)) {
                    res += "_____________________________________ \n";
                    res += "History cart: \n" + this.buyersArray[i].HistoryCart();
                }
            }
        }
        return res;
    }

    public int HistoryCartLength(String buyer) {
        int res = 0;
        for (int i = 0; i < this.buyersArray.length; i++) {
            if (this.buyersArray[i] != null) {
                if (this.buyersArray[i].getName().equalsIgnoreCase(buyer)) {
                 for (int j = 0; j < this.buyersArray[i].getHistory().length; j++) {
                     if (this.buyersArray[i].getHistory()[j] != null) {
                         res += 1;
                     }
                 }
                }
            }
        }
        return res;
    }

    public void HistoryCartSwap(String buyer, int cart) {
        for (int i = 0; i < this.buyersArray.length; i++) {
            if (this.buyersArray[i] != null) {
                if (this.buyersArray[i].getName().equalsIgnoreCase(buyer)) {
                    this.buyersArray[i].getCart().setProducts(new Product[this.buyersArray[i].getHistory()[cart - 1].getProducts().length],0);
                    for (int j = 0; j < this.buyersArray[i].getHistory()[cart - 1].getProducts().length; j++) {
                        if (this.buyersArray[i].getHistory()[cart - 1].getProducts()[j] != null)
                            this.buyersArray[i].getCart().getProducts()[j] = this.buyersArray[i].getHistory()[cart - 1].getProducts()[j];
                    }
                }
            }
        }

    }

    public void checkout(Buyers buyer) {
        buyer.AddToHistory();
        buyer.setCart(new Cart());
    }

    public void AddProductToBuyer(String buyer, Product product) {
        this.findBuyer(buyer).AddToBuyerCart(product);
    }

    public String BuyerInfo() {
        User[] sorted_array = removeNull(getBuyersArray(), getNumOfBuyers());
        Arrays.sort(sorted_array, new CompareUserByName());
        String res = "";
        for (int i = 0; i < sorted_array.length; i++) {
            if (sorted_array != null) {
                if (sorted_array[i] instanceof Buyers) {
                    Buyers temp_buyer = (Buyers) sorted_array[i];
                    res += "________________________\n";
                    res += "Buyer " + (i + 1) + ":\n";
                    res += "Name: " + temp_buyer.getName() + "\n";
                    res += "Country: " + temp_buyer.getAdress().getCountry() + "\n";
                    res += "City:  " + temp_buyer.getAdress().getCity() + "\n";
                    res += "Address:  " + temp_buyer.getAdress().getAdress() + "\n";
                    res += "Current cart: \n" + temp_buyer.getCart().ProductList() + "\n";
                    if (temp_buyer.getCart().getSum() != 0.0)
                        res += "Left to pay: " + temp_buyer.getCart().getSum() + "$\n";
                    res += "History Carts: \n" + temp_buyer.HistoryCart();
                }

            }
        }
        return res;
    }

    public String SellersInfo() {
        String res = "";
        User[] sorted_array = removeNull(getSellerArray(), getNumOfSellers());
        Arrays.sort(sorted_array, new CompareUserByName());
        for (int i = 0; i < sorted_array.length; i++) {
            if (sorted_array[i] != null) {
                if (sorted_array[i] instanceof Sellers) {
                    Sellers temp_seller = (Sellers) sorted_array[i];
                    res += "________________________\n";
                    res += "Seller " + (i + 1) + ": " + temp_seller.getName() + "\n";
                    res += "    Shop: \n" + temp_seller.getShop().ProductList() + "\n";
                }
            }
        }
        return res;
    }

    public Cart GetProductByCategory(Category category) {
        Cart res = new Cart();
        Cart temp = new Cart();
        for (int i = 0; i < this.sellerArray.length; i++) {
            if (this.sellerArray[i] != null) {
                temp = this.sellerArray[i].getShop();
                for (int j = 0; j < temp.getProducts().length; j++) {
                    if (temp.getProducts()[j] != null && temp.getProducts()[j].getCategory() == category) {
                        res.AddToCart(temp.getProducts()[j]);
                    }
                }

            }
        }
        return res;
    }


    public User[] removeNull(User[] users, int count) {
        User[] res = new User[count];
        int j = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                res[j] = users[i];
                j++;
            }
        }
        return res;
    }

    //EXCEPTIONS
    public String processInputString(String str) {
        try {
            exceptionUtill.checkStringInput(str);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return null;
    }

    public String processInputPassword(String password) {
        try {
            exceptionUtill.checkPasswordInput(password);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return null;
    }

    public String processInputAddress(String address) {
        try {
            exceptionUtill.checkAddressInput(address);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return null;
    }

    public String processInputSentece(String str) {
        try {
            exceptionUtill.checkSentenceInput(str);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return null;
    }

    public String processInputCategory(String category) {
        try {
            exceptionUtill.checkCategoryInput(category);
        } catch (IllegalArgumentException e) {
            return "Not a valid category: (KIDS/CLOTHING/ELECTRONIC/OFFICE)";
        }
        return null;
    }

    public String processInputDouble(String price) {
        try {
            exceptionUtill.checkDoubleInput(price);
        } catch (NumberFormatException e) {
            return "Please enter a valid number.";
        }
        return null;
    }

    public String processInputInt(String integer) {
        try {
            exceptionUtill.checkIntegerInput(integer);
        } catch (NumberFormatException e) {
            return "Input must contains only numbers.";
        }
        return null;
    }

    public String processInputAnswer(String ans) {
        try {
            exceptionUtill.checkAnswerInput(ans);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return null;
    }

    public String processInputOption(String option) {
        try {
            exceptionUtill.checkMenuInput(option);
        } catch (InputMismatchException e) {
            return e.getMessage();
        }
        return null;
    }
    public String processInputDynamicOption(String option,int min, int max) {
        try {
            exceptionUtill.checkDynamicMenuInput(option,min,max);
        } catch (InputMismatchException e) {
            return e.getMessage();
        }
        return null;
    }

    public String proccesInputEmptyCart(Cart cart) {
        try {
            exceptionUtill.checkCartInput(cart);
        } catch (InputMismatchException e) {
            return e.getMessage();
        }
        return null;
    }
    public String proccesInputEmptyHistoryCart(Cart[] history) {
        for (int i = 0; i < history.length; i++) {
            if (history[i]!= null&&this.proccesInputEmptyCart(history[i]) == null) {
                return null;
            }
        }
        return "History is empty, or only has empty carts.";
    }

    public String proccesInputHistoryCart(Buyers buyer, int index) {
        try {
            exceptionUtill.checkHistoryCartInput(buyer, index);
        } catch(IndexOutOfBoundsException e){
            return e.getMessage();
        }
        return null;
    }

}

