package Asaf_Banani_Oz_Yosef_Yochai;


import java.util.Date;

public class Cart{
    private Date date;
    private Product[] products;
    private int products_count;
    public Cart() {
        this.products = new Product[10];
        this.date = null;
        this.products_count = 0;
    }

    public void setProducts(Product[] products, int products_count) {
        this.products = products;
        this.products_count = products_count;
    }
    public Date getDate(){
        return this.date;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public double getSum(){
        double sum = 0.0;
        for(Product p : products){
            if(p != null){
                sum += p.getTotalPrice();
            }
        }
        return sum;
    }
    public String ProductList(){
        String res = "";
        if(products[0] != null){
            for(int i = 0; i < products.length; i++) {
                if (products[i] != null) {
                    res += "        " + (i + 1) + ") Name:" + products[i].getName() + ", Price:" + products[i].getValue() +
                            "$, Package Price:" + products[i].getPackagePrice() + "$," +
                            "Is warped: " +products[i].getWrapped() +
                            ", Serial Number: "+products[i].getSerialNumber()+"\n";
                }
            }
        }
        else {
            res += "No Products Found";
        }
            return res;
    }

    public Product[] getProducts() {
        return products;
    }
    public int getProducts_count() {
        return products_count;
    }
    public Product findProduct(String name){
        for(int i = 0; i < products.length; i++){
            if(products[i] != null && products[i].getName().equals(name)){
                return products[i];
            }
        }
        return null;
    }

    public void AddToCart(Product prod) {
        for(int i = 0; i<this.products.length;i++) {
            if(this.products[i]==null) {
                this.products[i]=prod;
                this.products_count++;
                return;
            }
        }
        this.CartExpend();
        this.AddToCart(prod);

    }

    public void CartExpend() {
        if(this.products.length == 0) {
            this.products = new Product[10];
        }
        else{
            Product[] res = new Product[this.products.length * 2];
            for(int i = 0; i < this.products.length; i ++) {
                res[i] = this.products[i];
            }
            this.products = res;
        }

    }




}
