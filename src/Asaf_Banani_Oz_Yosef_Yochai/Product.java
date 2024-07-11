package Asaf_Banani_Oz_Yosef_Yochai;

public class Product {
    private String name;
    private Double value;
    private Category category;
    private double PackagePrice;
    private int SerialNumber;
    private Boolean isWrapped;

    public Product(String name, Double value, Category category,double packagePrice, int SerialNumber) {
        this.name = name;
        this.value = value;
        this.category = category;
        this.PackagePrice = packagePrice;
        this.SerialNumber = SerialNumber;
        this.isWrapped = false;
    }

    public Boolean getWrapped() {
        return isWrapped;
    }

    public void setWrapped(Boolean wrapped) {
        isWrapped = wrapped;
    }


    public int getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        SerialNumber = serialNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public double getPackagePrice() {
        return PackagePrice;
    }
    public void setPackagePrice(double packagePrice) {
        PackagePrice = packagePrice;
    }
    public double getTotalPrice() {
        if (isWrapped)
            return PackagePrice + value;
        else
            return value;
    }
}
