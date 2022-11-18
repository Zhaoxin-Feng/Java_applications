public class ArrayTest{
    public static void main(String[] args) {
        int A[] = new int[10];
        for(int i=0;i<9;i++)
        {
            A[i] = (int)(Math.random()*100);
        }
        double average = generateAverage(A, 10);
        System.out.println("Average is "+ average);
        generateMax(A, 10);
        generateMin(A, 10);
        printLevel(average);
    }
    public static double generateAverage(int A[],int n){
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+A[i];
        }
        return sum/n;
    }
    public static void generateMax(int A[],int n){
        int max=A[0];
        int index=0;
        for(int i=1;i<n;i++)
        {
            if(A[i]>max){
                max=A[i];
                index=i;
            }
        }
        System.out.println("Max "+"= "+"A"+index+" = "+max);
    }
    public static void generateMin(int A[],int n){
        int min=A[0];
        int index=0;
        for(int i=1;i<n;i++)
        {
            if(A[i]<min){
                min=A[i];
                index=i;
            }
        }
        System.out.println("Min "+"= "+"A"+index+" = "+min);
    }
    public static void printLevel(double num){
        System.out.print("The level of average is ");
        if(num >= 90)
        {
            System.out.println("A");
        }
        else if(num >= 80){
            System.out.println("B");
        }
        else if(num >= 70){
            System.out.println("C");
        }
        else if(num >= 60){
            System.out.println("D");
        }
        else{
            System.out.println("E");
        }
    }

}