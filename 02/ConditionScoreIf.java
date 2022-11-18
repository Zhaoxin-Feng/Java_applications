public class ConditionScoreIf{
    public static void main(String[] args)
    {
        int num = Integer.parseInt(args[0]);
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