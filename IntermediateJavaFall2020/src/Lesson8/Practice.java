package Lesson8;
import java.util.ArrayList;

public class Practice {
    public static void main(String[] args) {
        int[] arr = new int[5];
        ArrayList<Integer> aList = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            aList.add(arr[i]);
        }
        ArrayList<Integer> aList1 = new ArrayList<>();
        for(int i=aList.size()-1;i>=0;i--){
            aList1.add(aList.get(i));
        }

        ArrayList<Character> aList2=new ArrayList<>();
        for(int i=0;i<aList2.size();i++){
            if(aList2.get(i)=='z'){
                aList2.set(i,'a');
            }
            else {
                aList2.set(i,(char)(aList2.get(i)+1));
            }
        }
    }
}
