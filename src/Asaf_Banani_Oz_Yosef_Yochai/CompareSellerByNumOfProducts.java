package Asaf_Banani_Oz_Yosef_Yochai;

import java.util.Comparator;

public class CompareSellerByNumOfProducts implements Comparator<Sellers> {

    @Override
    public int compare(Sellers s1, Sellers s2) {
        return s1.getShop().getProducts().length-s2.getShop().getProducts().length;
    }


}
