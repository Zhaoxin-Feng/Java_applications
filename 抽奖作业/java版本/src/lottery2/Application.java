package lottery2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Application {

	public static void main(String[] args) {
		int index = 0;
		ArrayList<Person> stuInfo = new ArrayList<Person>();
		String lineTxt = null;
		String[] tempString = null;
		Person tempPerson = null;
//		读取学生信息
		try {
			File myFile = new File("src/information/stu2.txt");

			if (myFile.isFile() && myFile.exists()) {
				InputStreamReader Reader = new InputStreamReader(new FileInputStream(myFile), "UTF-8");
				// 考虑到编码格式，new FileInputStream(myFile)文件字节输入流，以字节为单位对文件中的数据进行读取
				// new InputStreamReader(FileInputStream a, "编码类型")
				// 将文件字节输入流转换为文件字符输入流并给定编码格式

				BufferedReader bufferedReader = new BufferedReader(Reader);
				// BufferedReader从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
				// 通过BuffereReader包装实现高效读取

				while ((lineTxt = bufferedReader.readLine()) != null) {
					// buffereReader.readLine()按行读取写成字符串
					stuInfo.add(new Person());
					tempString = lineTxt.split("\t");
					tempPerson = stuInfo.get(index);
					tempPerson.setName(tempString[0]);
					tempPerson.setBirthday(tempString[1]);
					index++;
				}
				Reader.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			// TODO: handle exception

		}

//		读取学生照片
		File file = new File("src/images/");
		File[] files = file.listFiles();
		ImageIcon[] imgs = new ImageIcon[files.length];
		for (int n = 0; n < files.length; n++) {
			String str = files[n].getPath();
			imgs[n] = new ImageIcon(str);
		}

//		创建GUI，并传入学生信息的ArrayList
		new LotteryFrame(stuInfo, imgs);
	}
}
