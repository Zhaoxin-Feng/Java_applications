import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // input from the keyboard
        int n;
        System.out.print("Please enter a number:");
        n = scan.nextInt();
        generateFactorial(n);
        //?
        scan.close();
    }
    //static?
    public static void generateFactorial(int n){
        int result=1;
        for(int i=1;i<=n;i++)
        {
            result=result*i;
        }
        System.out.println("The factorial of "+n+" is "+result);
    }
}
