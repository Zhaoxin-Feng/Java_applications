package lottery2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LotteryFrame extends JFrame {
	int randomId = 0;
	int flag = 0;
	JPanel otherPanel;
	JLabel myImage;
	JButton randomButton;
	JLabel birthLabel;
	JLabel nameLabel;
	JLabel formerBirthLabel;
	JLabel formerNameLabel;
	Timer timer;
	ArrayList<Person> stuInfo = new ArrayList<Person>();
	ImageIcon[] imgs;

//构造方法
	LotteryFrame(ArrayList<Person> stuInfo, ImageIcon[] imgs) {
		this.imgs = imgs;
		this.stuInfo = stuInfo;
		myImage = new JLabel(imgs[0]);
		otherPanel = new JPanel();

//用于调整布局的两个虚无button
		JButton c = new JButton("                                                     ");
		JButton d = new JButton("                                                     ");
		c.setContentAreaFilled(false);
		c.setBorderPainted(false);
		c.setEnabled(false);
		d.setContentAreaFilled(false);
		d.setBorderPainted(false);
		d.setEnabled(false);
//设置label和button样式
		formerBirthLabel = new JLabel("学号：");
		birthLabel = new JLabel("王嘉尔");
		nameLabel = new JLabel("19940328");
		formerNameLabel = new JLabel("姓名：");
		birthLabel.setFont(new Font("隶书", Font.PLAIN, 36));
		birthLabel.setForeground(Color.RED);
		nameLabel.setFont(new Font("隶书", Font.PLAIN, 36));
		nameLabel.setForeground(Color.RED);
		randomButton = new JButton("随机选择");
		randomButton.setFont(new Font("隶书", Font.PLAIN, 36));
		formerBirthLabel.setFont(new Font("隶书", Font.PLAIN, 36));
		formerNameLabel.setFont(new Font("隶书", Font.PLAIN, 36));
//添加组件
		otherPanel.add(formerNameLabel);
		otherPanel.add(nameLabel);
		otherPanel.add(d);
		otherPanel.add(randomButton);
		otherPanel.add(c);
		otherPanel.add(formerBirthLabel);
		otherPanel.add(birthLabel);
//关于Frame的一些设置
		this.getContentPane().add(myImage, BorderLayout.CENTER);
		this.getContentPane().add(otherPanel, BorderLayout.SOUTH);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
//设置 timer
		timer = new Timer(150, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				randomId = (int) (Math.random() * stuInfo.size());
				myImage.setIcon(imgs[randomId]);
				Person temPerson = stuInfo.get(randomId);
				birthLabel.setText(temPerson.getBirthday());
				nameLabel.setText(temPerson.getName());
			}
		});

//按钮点击事件
		randomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (flag == 0) {
					timer.start();
					flag = 1;
				} else {
					timer.stop();
//					Person temPerson = stuInfo.get(randomId);
//					birthLabel.setText(temPerson.getBirthday());
//					nameLabel.setText(temPerson.getName());
					flag = 0;
				}
			}
		});
	}
}
