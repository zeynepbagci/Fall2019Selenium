package com.automation.tests.office_hours;

import java.util.*;

public class SeleniumOH1 {
    /**
     * -Iterator
     *    -List, Set, Map and other type of collections can use Iterator class  to iterate over that collection.
     *    -List has indexes(for i, for each, while, Iterator)
     *    -Map(for each, Iterator)
     * -Basic Selenium Navigations -
     */

    public static void main(String[] args) {

        //Create arraylist of Strings - iterate over it

        ArrayList<String> lst = new ArrayList<>();

        //iterator method will returns Iterator type which we can use with all iterator methods.

        lst.add("fruits");
        lst.add("veggies");
        lst.add("berries");

        Iterator<String> iter = lst.iterator();//iterator list olusturduktn sonra olustur
        //oncesine yapince exception veriyor


        while(iter.hasNext()){
            System.out.println(iter.next());

            //print before modification and
            //add * to each string and print again
            Iterator<String> iter1 = lst.iterator();
            while (iter1.hasNext()){
                String item = iter1.next();
                System.out.println(item);
                System.out.println("*"+item);
            }

        }

        //create a map with <String, String>

        Map<String, String> map = new HashMap<>();
        map.put("name","Bryan");
        map.put("studentId","12345");
        map.put("major","computer science");

        Iterator<String> mapIterator = map.keySet().iterator();
        while(mapIterator.hasNext()){
            String key = mapIterator.next();
            System.out.println(key+" : "+map.get(key));
        }

        //===============================================




    }
}
