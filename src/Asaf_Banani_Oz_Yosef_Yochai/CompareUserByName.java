package Asaf_Banani_Oz_Yosef_Yochai;

import java.util.Comparator;

public class CompareUserByName implements Comparator<User> {
    @Override
    public int compare(User o1,User o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
