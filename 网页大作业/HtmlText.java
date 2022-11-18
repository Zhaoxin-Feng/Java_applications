package html;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

//最后在存放程序的文件夹里会生成before和after两个txt文件，before里面是网页中的所有信息，after里面是纯文本信息
public class HtmlText {

	public static String SRC = "FirstPage.html";

	public static void main(String[] args) throws IOException {

		// 爬取网页，把网址复制到字符串中
		InputStream is2 = UrlCrawBoke.doGet("https://baijiahao.baidu.com/s?id=1718812107504330775&wfr=spider&for=pc");
		//讲输入流转成字符串，并且转成UTF-8格式，不出现乱码
		String pageStr = UrlCrawBoke.inputStreamToString(is2, "UTF-8");
		is2.close();
		//获取网页中的所有信息，储存在before中
		FileWriter is1 = new FileWriter("before.txt");
		is1.write(pageStr); 
		is1.close();
		// 建立after文档，用于存放纯文本版的网页
		String after = Html2Text(pageStr.toString());
		FileWriter is = new FileWriter("after.txt");
		is.write(after); 
		is.close();
		System.out.println(after);
	}

	// 从html中提取纯文本
	public static String Html2Text(String inputString) {
		//html标签的字符串
		String htmlStr = inputString;
		//空格
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;
		//过滤非文本部分
		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签
			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签
			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签
			textStr = htmlStr;
		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}
		// 剔除空格行、数字和各种符号
		textStr = textStr.replaceAll("[ ]+", "");
		textStr = textStr.replaceAll("1", "").replaceAll("2", "").replaceAll("3", "").replaceAll("4", "")
				.replaceAll("5", "").replaceAll("6", "").replaceAll("7", "").replaceAll("8", "").replaceAll("9", "")
				.replaceAll("0", "");
		textStr = textStr.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");
		textStr = textStr.replaceAll("\t", "");
		textStr = textStr.replaceAll("&nbsp;", "").replace("&gt;", "").replace("&mdash;", "");
		textStr = textStr.replaceAll("\\\\", "");// 正则表达式中匹配一个反斜杠要用四个反斜杠
		textStr = textStr.replaceAll("\r\n", "");
		textStr = textStr.replaceAll("\n", "");
		//最后返回纯文本字符串
		return textStr;
	}
}

//获取网页信息的方式
class UrlCrawBoke {
	public static InputStream doGet(String urlstr) throws IOException {
		URL url = new URL(urlstr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
		InputStream inputStream = conn.getInputStream();
		return inputStream;
	}

	public static String inputStreamToString(InputStream is, String charset) throws IOException {
		byte[] bytes = new byte[1024];
		int byteLength = 0;
		StringBuffer sb = new StringBuffer();
		while ((byteLength = is.read(bytes)) != -1) {
			sb.append(new String(bytes, 0, byteLength, charset));
		}
		return sb.toString();
	}
}

