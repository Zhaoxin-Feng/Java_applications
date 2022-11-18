package JavaApplication;

public class TestStudent{

	
	
	public static void main(String[] args) {

		Student Baby = new Student("201021010200","刘大宝",'男');
		Baby.setAddress("北京师范大学西西楼 215");
		Baby.setSpecialty("教育技术");
		System.out.println(Baby);
	}
	
}