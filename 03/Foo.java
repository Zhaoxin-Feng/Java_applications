public class Foo {
    public Foo(){

    }

    public void test(){
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a, b);
        System.out.println(a+","+b);
    }
    public void operate(StringBuffer x, StringBuffer y){
        x.append(y);     //strcat
        y = x;
    }
     public static void main(String sgf[]) {
        Foo foo = new Foo();
        foo.test();
    }
}
//记住对象之间的赋值是管理权限的交付即可理解