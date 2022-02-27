public class Class2HW {
    public static void main(String[] args){
        int[][] arr={{20,-10,12,3},{0,1,-9,8},{14,-2,2,17}};
        System.out.println(sumOfBorder(arr));
    }
    static int sumOfBorder(int[][] arr){
        int sum=0;
        for(int r=0;r<arr.length;r++){
            for(int c=0;c<arr[r].length;c++){
                if(r==0||r==arr.length-1||c==0||c==arr[r].length-1){
                    sum+=arr[r][c];
                }
            }
        }
        return sum;
    }
}
