// #define SLOW = 1
public class Fan
{
    static int SLOW = 1;
    static int MEDIUM = 2;
    static int FAST = 3;
    int speed =SLOW;
    boolean on = false;
    double radius = 5.0;
    String color = "blue"; 

    public Fan(){
    
    }

    public Fan(int speed,double radius,String color,boolean on){
        this.color=color;
        this.speed=speed;
        this.radius=radius;
        this.on=on;
    }

    public String toStrings(Fan Blower){
        String Description;
        if(Blower.on){
            Description = new String("This fan:"+"speed "+Blower.speed +" color "+Blower.color+" radius "+Blower.radius);
        }
        else{
            Description = new String("This fan is off"+" color "+Blower.color+" radius "+Blower.radius);
        }
        return Description;
    }

    public static void main(String[] args) {
        Fan YellowFan = new Fan(Fan.FAST,10,"yellow",true);
        Fan BlueFan = new Fan(Fan.FAST,5,"blue",false);
        System.out.println(YellowFan.toStrings(YellowFan));
        System.out.println(BlueFan.toStrings(BlueFan));
    }
}
