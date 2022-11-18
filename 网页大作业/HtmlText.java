package html;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

//����ڴ�ų�����ļ����������before��after����txt�ļ���before��������ҳ�е�������Ϣ��after�����Ǵ��ı���Ϣ
public class HtmlText {

	public static String SRC = "FirstPage.html";

	public static void main(String[] args) throws IOException {

		// ��ȡ��ҳ������ַ���Ƶ��ַ�����
		InputStream is2 = UrlCrawBoke.doGet("https://baijiahao.baidu.com/s?id=1718812107504330775&wfr=spider&for=pc");
		//��������ת���ַ���������ת��UTF-8��ʽ������������
		String pageStr = UrlCrawBoke.inputStreamToString(is2, "UTF-8");
		is2.close();
		//��ȡ��ҳ�е�������Ϣ��������before��
		FileWriter is1 = new FileWriter("before.txt");
		is1.write(pageStr); 
		is1.close();
		// ����after�ĵ������ڴ�Ŵ��ı������ҳ
		String after = Html2Text(pageStr.toString());
		FileWriter is = new FileWriter("after.txt");
		is.write(after); 
		is.close();
		System.out.println(after);
	}

	// ��html����ȡ���ı�
	public static String Html2Text(String inputString) {
		//html��ǩ���ַ���
		String htmlStr = inputString;
		//�ո�
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;
		//���˷��ı�����
		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // ����script��������ʽ{��<script[^>]*?>[\\s\\S]*?<\\/script>
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // ����style��������ʽ{��<style[^>]*?>[\\s\\S]*?<\\/style>
			String regEx_html = "<[^>]+>"; // ����HTML��ǩ��������ʽ
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // ����script��ǩ
			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // ����style��ǩ
			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // ����html��ǩ
			textStr = htmlStr;
		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}
		// �޳��ո��С����ֺ͸��ַ���
		textStr = textStr.replaceAll("[ ]+", "");
		textStr = textStr.replaceAll("1", "").replaceAll("2", "").replaceAll("3", "").replaceAll("4", "")
				.replaceAll("5", "").replaceAll("6", "").replaceAll("7", "").replaceAll("8", "").replaceAll("9", "")
				.replaceAll("0", "");
		textStr = textStr.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");
		textStr = textStr.replaceAll("\t", "");
		textStr = textStr.replaceAll("&nbsp;", "").replace("&gt;", "").replace("&mdash;", "");
		textStr = textStr.replaceAll("\\\\", "");// ������ʽ��ƥ��һ����б��Ҫ���ĸ���б��
		textStr = textStr.replaceAll("\r\n", "");
		textStr = textStr.replaceAll("\n", "");
		//��󷵻ش��ı��ַ���
		return textStr;
	}
}

//��ȡ��ҳ��Ϣ�ķ�ʽ
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

