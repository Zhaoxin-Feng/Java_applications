package JavaApplication;

public class Student {
    private String number;
    private String name;
    private char sex;
    private String speciality;
    private String address;

    public Student(String number, String name, char sex){
        this.number = number;
        this.name = name;
        this.sex = sex;
    }

    public String getName(){
        return name;
    }

    public void setNumber(String num){
        number = num;
    }

    public void setSpecialty(String sep){
        speciality = sep;
    }

    public void setAddress(String add){
        address = add;
    }

    @Override
    public String toString(){
        return "information:" + name + "," + sex + "," + number + "," + speciality
        + "," + address;
    }
}
