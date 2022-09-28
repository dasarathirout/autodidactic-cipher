package org.concept.collections.set;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class ContainerSet {

    Integer value;

    public static void main(String[] arrays) {
        unSortedSetE11();
        sortedSetE12();
    }

    public static final void unSortedSetE11(){
        LinkedHashSet hashSet = new LinkedHashSet();

        hashSet.add(new ProductP1(1));//1
        hashSet.add(new ProductP1(2));// Override As Because Of Equals()
        hashSet.add(new ProductP1(3));// Override As Because Of Equals()

        hashSet.add(new ProductP2(2));// New Entry
        hashSet.add(new ProductP2(2));// New Entry

        System.out.println(hashSet.size());// 2
    }

    public static final void sortedSetE12(){
        TreeSet treeSet = new TreeSet<>();// Need Sort => Compare => Exception
        treeSet.add(new ProductP1(1));
        treeSet.add(new ProductP2(2));// ClassCastEx

        System.out.println(treeSet.size());
    }
}


abstract class Product{

}

class ProductP1 extends Product {
    int id;
    public ProductP1(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object that) {
        // return this.equals(that);
        return false;
    }

    @Override
    public int hashCode() {
        //return super.hashCode();
        return 11;
    }
}



class ProductP2 extends Product implements Comparator  {
    int id;
    public ProductP2(int id) {
        this.id = id;
    }

    @Override
    public int compare(Object P1, Object P2) {
        return 0;
    }

    @Override
    public boolean equals(Object that) {
        return this.equals(that);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}