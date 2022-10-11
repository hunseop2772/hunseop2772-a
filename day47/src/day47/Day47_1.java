package day47;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class Day47_1 extends JFrame {
	void AddFrame(){_
	setTitle("JFrame");
	setSize(300,300);
	
	//컴포넌트 만들기
	JButton bytton = new JButton("button");
	JCheckBox b0x = new JCheckBox("checkbox");
	JSlider = slider = new JSlider();
	JTextField tf = new JTextField("text 입력",20);
	this.setLayout(new FlowerLayout());
	
	this.add(button);
	this.add(box);
	this.add(slide);
	this.add(tf);
	
	
	
	setVisible(true);
	//내 프로그램 닫는 기능을 닫기버튼으로 설정
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	public static void main(String[] args) {
		new AddFrame();
	}
		
	}

}
