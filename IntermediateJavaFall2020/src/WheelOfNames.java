import java.util.Scanner;
public class WheelOfNames {
   public static void main (String[] args){
       String [] names={"Maggie","Joey","Erika","Anthony"};
       boolean[] picked=new boolean[names.length];
       while(true) {
           System.out.println("Hit the key s to spin!");
           Scanner sc = new Scanner(System.in);
           String s = sc.next();
           if (s.equals("s")) {
               while(true) {
                   int n = (int) (Math.random() * names.length);
                   if (!picked[n]) {
                       System.out.println("Yay! " + names[n] + "!");
                       picked[n] = true;
                       break;
                   }
               }
           }
           else{
               break;
           }
       }
   }
}

