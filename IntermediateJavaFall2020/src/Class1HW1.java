public class Class1HW1 {
    public static void main (String[] args){
        for(int i=0;i<10;i++){
            for(int j=0;j<11;j++){
                if(i==0){
                    System.out.print("*");
                }
                else if(i<7){
                    if(j==5){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                else if(i<9){
                    if (j==0||j==5){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                else if(i==9){
                    if(j>0&&j<5){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
