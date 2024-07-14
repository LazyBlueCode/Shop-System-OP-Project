package Asaf_Banani_Oz_Yosef_Yochai;

import java.util.Comparator;

public class CompareSellerByNumOfProducts implements Comparator<Sellers> {

    @Override
    public int compare(Sellers s1, Sellers s2) {
        return s2.getShop().getProducts_count() - s1.getShop().getProducts_count();
    }


}
