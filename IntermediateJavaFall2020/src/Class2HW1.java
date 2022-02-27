public class Class2HW1 {
    public static void main(String[] args){
        int[][] arr={{2,-10,12,3},{0,1,-9,8},{14,-2,2,17}};
        System.out.println(largestSumColumn(arr));
    }
    static int largestSumColumn(int[][] arr){
        int largestSum=0;
        int column=0;
        for(int c=0;c<arr[0].length;c++){
            int sum=0;
            for(int r=0;r<arr.length;r++){
                sum+=arr[r][c];
            }
            if(sum>largestSum){
                largestSum=sum;
                column=c;
            }
        }
        return column;
    }
}
