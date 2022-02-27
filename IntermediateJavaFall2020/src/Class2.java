public class Class2 {
    static boolean contains(int[][] m,int n){
        for(int r=0;r<m.length;r++){
            for(int c=0;c<m[r].length;c++){
                if(m[r][c]==n){
                    return true;
                }
            }
        }
        return false;
    }

    static int[] getRowSum(int[][]abc){
        int[] rowSum= new int[abc.length];
        for(int r=0;r<abc.length;r++){
            int sum=0;
            for(int c=0;c<abc[r].length;c++){
                sum+=abc[r][c];
            }
            rowSum[r]=sum;
        }
        return rowSum;
    }

    static int[] getColumnSum(int[][]abc){
        int[] columnSum=new int[abc[0].length];
        for(int c=0;c<abc[0].length;c++){
            int sum=0;
            for(int r=0;r<abc.length;r++){
                sum+=abc[r][c];
            }
            columnSum[c]=sum;
        }
        return columnSum;
    }

    static int[][] stringLength(String[][]m){
        int[][] stringLength=new int[m.length][m[0].length];
        for(int r=0;r<m.length;r++){
            for(int c=0;c<m[0].length;c++){
                stringLength[r][c]=m[r][c].length();
            }
        }
        return stringLength;
    }

    public static void main (String [] args){
        //int [][]m=new int[3][4];
        int [][]m={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        boolean b1=contains(m,3);
        System.out.println(b1);
        boolean b2=contains(m,20);
        System.out.println(b2);
        int [][]m1={{3,4},{5,5}};
        System.out.println(contains(m1,6));
        int[] m_rowSum=getRowSum(m);
        //System.out.println(m[0][1]);
        for(int r=0;r<m.length;r++){
            for(int c=0;c<m[r].length;c++){
                m[r][c]++;
                if(m[r][c]<10) {
                    System.out.print(m[r][c] + "  ");
                }
                else{
                    System.out.print(m[r][c]+" ");
                }
            }
            System.out.println();
        }
        int sum=0;
        for(int r=0;r<m.length;r++){
            for(int c=0;c<m[r].length;c++){
                sum+=m[r][c];
            }
        }
        System.out.println("sum="+sum);
    }
}
