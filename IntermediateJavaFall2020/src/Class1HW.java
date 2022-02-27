public class Class1HW {
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            for(int j=0;j<11;j++){
                if(i==0||i==9) {
                    System.out.print("*");
                }
                else if(i>0&&i<9){
                    if(j==5){
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
