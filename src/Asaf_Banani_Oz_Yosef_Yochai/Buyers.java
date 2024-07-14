package Asaf_Banani_Oz_Yosef_Yochai;

import java.time.LocalDate;
import java.util.Date;

public class Buyers extends User {
    private Cart cart;
    private Cart[] history;
    private int history_count;
    private Adress adress;

    public Buyers(String name, String password, Cart cart, Adress adress) {
        super(name, password);
        this.cart = cart;
        this.adress = adress;
        history = new Cart[10];
        history_count = 0;

    }

    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public Cart[] getHistory() {
        return history;
    }
    public int getHistory_count() {
        return history_count;
    }
    public Adress getAdress() {
        return adress;
    }
    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public void AddToBuyerCart(Product prod) {
        this.cart.AddToCart(prod);
    }
    public void AddToHistory(Cart oldCart) {
        for(int i = 0; i<this.history.length;i++) {
            if(this.history[i]==null) {
                this.history[i]=cart;
                this.history[i].setDate(new Date());
                this.history_count++;
                return;
            }
        }
        //went throgh history, did not find an empty space so must expend
        this.HistoryExpend();
        this.AddToHistory(oldCart);
    }
    public void HistoryExpend() {
        if(this.history.length == 0) {
            this.history = new Cart[10];
        }
        else{
            Cart[] res = new Cart[this.history.length * 2];
            for(int i = 0; i < this.history.length; i ++) {
                res[i] = this.history[i];
            }
            this.history = res;
        }

    }
    public String HistoryCart(){
        String res = "";
        if (this.history[0] != null){
            for(int i = 0; i<this.history.length; i ++) {
                if(this.history[i]!=null) {
                    res += "Cart " + (i+1) +":\n";
                    res += "Purchase Date: " + this.history[i].getDate() + "\n";
                    res += "Total Paid: " + this.history[i].getSum() + "$\n";
                    res += this.history[i].ProductList();
                }
            }
        }
        else{
            res += "There's no history carts for this buyer yet.\n";
        }

        return res;
    }

}

