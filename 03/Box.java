public class Box {
    static int length = 0;
    static int width = 0;
    static int height = 0;
    public Box(int l, int w, int h){
        length = l;
        width = w;
        height = h;
    }
    public static int getVolume(){
        return length*height*width;
    }
    public static int getArea(){
        return 3*(length*width+height*width+height*length);
    }
    //in a non-static method, we cannot use static method
    public String returnData(){
        String init = new String("Size:"+length+" "+width+" "+height);
        // String Area = (String)Box.getVolume();   it's fail!
        String Volume = String.valueOf(Box.getVolume());
        String Area = String.valueOf(Box.getArea());
        return init+" "+Volume+" "+Area;
    }
    public static void main(String[] args) {
        Box myBox = new Box(1,2,3);
        System.out.println("Volume = "+Box.getVolume());
        System.out.println("Volume = "+Box.getArea());
        System.out.println("myBox"+myBox.returnData());
    }

}
