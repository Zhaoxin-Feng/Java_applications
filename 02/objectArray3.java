public class objectArray3 {
    public static void main(String[] args) {
        int m1,m2;
        int a[][];
        m1=5;
        m2=8;
        a=new int[m1][m2];
            for(int i=0;i<5;i++)
        {
            for(int j=0;j<8;j++)
            {
               a[i][j]=i*j; 
            }
        }
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<8;j++)
            {
               System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
    
}
