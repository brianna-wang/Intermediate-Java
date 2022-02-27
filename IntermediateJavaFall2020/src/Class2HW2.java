public class Class2HW2 {
    public static void main(String[] args){
        int[][] arr1={{10,0},{-4,5}};
        int[][] arr2={{-6,3},{1,-7}};
        int[][] sumMatrix=sumMatrix(arr1,arr2);
        for(int r=0;r<sumMatrix.length;r++){
            for(int c=0;c<sumMatrix[r].length;c++){
                System.out.print(sumMatrix[r][c]+" ");
            }
            System.out.println();
        }
    }
    static int[][] sumMatrix(int[][] arr1,int[][] arr2){
        int[][] sumMatrix=new int[arr1.length][arr1[0].length];
        for(int r=0;r<arr1.length;r++){
            for(int c=0;c<arr1[r].length;c++){
                sumMatrix[r][c]=arr1[r][c]+arr2[r][c];
            }
        }
        return sumMatrix;
    }
}
