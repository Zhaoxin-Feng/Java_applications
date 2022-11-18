package clock;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Clock1 extends JComponent {

	private static int hour = 0;
	private static int min = 0;
	private static int sec = 0;
	private static int total = 0;
	private final double PI = Math.PI;
	private Graphics2D g;
	private static Date current = new Date();

	private JButton currentButton = new JButton("当前时间");
	private JButton customizeButton = new JButton("自定义时间");

	private JLabel display = new JLabel("00:00:00");
	private String timeString = "00:00:00";

	private JLabel hourJLabel = new JLabel("时");
	private JLabel minJLabel = new JLabel("分");
	private JLabel secJLabel = new JLabel("秒");

	private JTextField hourField = new JTextField(0);
	private JTextField minField = new JTextField(0);
	private JTextField secField = new JTextField(0);

	public Clock1() {

		hour = current.getHours();
		min = current.getMinutes();
		sec = current.getSeconds();
		total = hour * 3600 + min * 60 + sec;

		add(currentButton);
		currentButton.setBounds(100, 510, 120, 30);
		currentButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		add(display);
		display.setBounds(250, 510, 120, 30);
		display.setFont(new Font("微软雅黑", Font.BOLD, 18));
		add(customizeButton);
		customizeButton.setBounds(50, 560, 150, 30);
		customizeButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));

		add(hourField);
		hourField.setBounds(220, 560, 30, 30);
		add(hourJLabel);
		hourJLabel.setBounds(260, 560, 30, 30);

		add(minField);
		minField.setBounds(280, 560, 30, 30);
		add(minJLabel);
		minJLabel.setBounds(320, 560, 30, 30);

		add(secField);
		secField.setBounds(340, 560, 30, 30);
		add(secJLabel);
		secJLabel.setBounds(380, 560, 30, 30);

		currentButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				hour = current.getHours();
				min = current.getMinutes();
				sec = current.getSeconds();
				total = hour * 3600 + min * 60 + sec;
				if (myThread.isAlive()) {

				} else {
					myThread.start();
				}
			}
		});

		customizeButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				hour = Integer.parseInt(hourField.getText());
				min = Integer.parseInt(minField.getText());
				sec = Integer.parseInt(secField.getText());
				total = hour * 3600 + min * 60 + sec;
				if (myThread.isAlive()) {

				} else {
					myThread.start();
				}
			}
		});

	}

	public void hourPointer(int second, Graphics2D g) {
		double x, y, speed;
		speed = second * PI / 21600;
		x = 250 + 100 * Math.sin(speed);
		y = 233 - 100 * Math.cos(speed);
		g.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
		g.drawLine(250, 233, (int) x, (int) y);
	}

	public void minutePointer(int second, Graphics2D g) {
		double x, y, speed;
		speed = second * PI / 1800;
		x = 250 + 130 * Math.sin(speed);
		y = 233 - 130 * Math.cos(speed);
		g.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
		g.drawLine(250, 233, (int) x, (int) y);
	}

	public void secondPointer(int second, Graphics2D g) {
		double x, y, x1, y1, speed;
		speed = second * PI / 30;
		x = 250 + 170 * Math.sin(speed);
		y = 233 - 170 * Math.cos(speed);
		g.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
		g.drawLine(250, 233, (int) x, (int) y);
	}

	@SuppressWarnings("deprecation")
	public void paintComponent(Graphics g1) {
		super.paintComponent(g1);
		g = (Graphics2D) g1;

		int x = 0, y = 0;
		ImageIcon icon = new ImageIcon("E:\\sophomore\\Java\\Java上机\\第四次作业\\clock\\clock01.jpg");
//		g.drawImage(icon.getImage(), x, y, getSize().width, getSize().height, this);// 图片会自动缩放
		g.drawImage(icon.getImage(), x, y, this);// 图片不会自动缩放

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));

		hourPointer(total, g);
		minutePointer(total % 3600, g);
		secondPointer(total % 60, g);
	}

	@SuppressWarnings("deprecation")
	private Thread myThread = new Thread() {

		public void run() {
			while (true) {
				total++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				repaint();
				showTime();
			}
		}
	};

	@SuppressWarnings("deprecation")
	private void showTime() {
		sec += 1;
		if (sec >= 60) {
			sec = 0;
			min += 1;
		}
		if (min >= 60) {
			min = 0;
			hour += 1;
		}
		if (hour < 10) {
			timeString = "0" + hour + ":";
		} else {
			timeString = "" + hour + ":";
		}
		if (min < 10) {
			timeString = timeString + "0" + min + ":";
		} else {
			timeString = timeString + "" + min + ":";
		}
		if (sec < 10) {
			timeString = timeString + "0" + sec;
		} else {
			timeString = timeString + "" + sec;
		}

		timeString = "  " + timeString;
		display.setText(timeString);
	}

	public static void main(String[] args) {

		JFrame myFrame = new JFrame("myClock");
		Clock1 myClock1 = new Clock1();
		myFrame.add(myClock1);
		myClock1.setBounds(0, 0, 500, 500);
		myFrame.setBounds(500, 200, 500, 650);

		myFrame.setVisible(true);

		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
