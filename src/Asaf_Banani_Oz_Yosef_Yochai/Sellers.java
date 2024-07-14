package Asaf_Banani_Oz_Yosef_Yochai;

public class Sellers extends User {
    private Cart shop;

    public Sellers(String name, String password, Cart cart) {
        super(name, password);
        this.shop = cart;
    }

    public Cart getShop() {
        return shop;
    }

    public void setShop(Cart shop) {
        this.shop = shop;
    }

    public void AddToShop(Product prod) {
        this.shop.AddToCart(prod);
    }
}
