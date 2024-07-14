package Asaf_Banani_Oz_Yosef_Yochai;

public interface IMarket {
    boolean AddSeller(String name, String password);
    boolean AddBuyer(String name, String password, Adress address);
    void AddProduct(String sellerName, Product product);
    void AddProductToBuyer(String buyerName, Product product);
    Product GetProduct(String productName, String sellerName);
    Cart GetProductByCategory(Category category);
    String SellersList();
    String BuyerList();
    String BuyerInfo();
    String SellersInfo();
    String HistoryList(String buyerName);
    void HistoryCartSwap(String buyerName, int cartNumber);
    void checkout(Buyers buyer);
    int getSerialNum();
    Buyers findBuyer(String buyerName);
    Sellers findSeller(String sellerName);
    String processInputOption(String input);
    String processInputString(String input);
    String processInputPassword(String input);
    String processInputSentece(String input);
    String processInputAddress(String input);
    String processInputDouble(String input);
    String processInputAnswer(String input);
    String processInputCategory(String input);
    String processInputDynamicOption(String input, int min, int max);
    String proccesInputEmptyCart(Cart cart);
    String proccesInputEmptyHistoryCart(Cart[] history);
}


