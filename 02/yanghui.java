public class yanghui {
    public static void main(String[] args) {
        int[][] YH = new int [10][];
        System.out.println("YH:");

        for(int i=0;i<YH.length;i++)
        {
            YH[i]=new int[i+1];
            for(int j=0;j<=i;j++)
            {
                if(j==0||j==i)
                    YH[i][j]=1;
                else
                    YH[i][j]=YH[i-1][j-1]+YH[i-1][j];
                System.out.print(YH[i][j]+" ");
            }
            System.out.println();
        }
    }
}
