/**
 * @author Feng Zhaoxin
 */
public class Animal{
    String color;
    String age;
    public void setColor(String c) {
        color = c;
    }
    public void setAge(String a) {
        age = a;   
    }
    public static void main(String[] args) {
        Animal MyAnimal = new Animal();
        MyAnimal.setColor("blue");
        MyAnimal.setAge("18");
        System.out.println("color is "+MyAnimal.color+" age is "+MyAnimal.age);
    }
}


