package Lesson8;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListPractice {
    public static void main(String[] args){
        int []arr=new int[5];
        Scanner sc=new Scanner (System.in);
        ArrayList<Integer> aList=new ArrayList<>();
        aList.add(6);
        aList.add(2);
        System.out.println(aList);
        aList.get(0);
        int sum=0;
        /*
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            arr[i]=50;
        }
         */
        for(int i=0;i<aList.size();i++){
            sum+= aList.get(i);
            aList.set(i,50);
        }
        System.out.println("sum="+sum);
        System.out.println(aList);
        aList.add(10);
        aList.add(2);
        aList.remove(0);
        System.out.println(aList);
        aList.remove(0);
        System.out.println(aList);
        aList.remove((Integer)10);
        System.out.println(aList);
        ArrayList<String> stringList=new ArrayList<>();
        stringList.add("234");
        stringList.add("hello");
        stringList.add("intrigue");
        stringList.add("ice cream");
        System.out.println(stringList);
        stringList.add(1,"afternoon");
        System.out.println(stringList);

        stringList.remove("hello");
        System.out.println(stringList);
    }
}
