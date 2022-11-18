public class closeNumber {
    public static void main(String[] args) {
        int a,b;
        for(a=2;a<5000;a++)
        {
            b = close_number(a);
            if (close_number(b) == a && a < b)   
			System.out.println(a+" & "+b);
        }
    }
    public static int close_number(int n) {
        int i, sum = 0;
        for (i = 1; i < n; i++)
        {
            if (n % i == 0)
                sum += i;
        }
        return sum;
    }
}
