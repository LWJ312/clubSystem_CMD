package clubSystem.view;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class BoardView extends JFrame implements ActionListener{
	 static BoardView aBoardView;
	 static PlayPictureView aPictureView;
	 JButton user;
	 JButton manager;
	 
	public BoardView() {
		super("请选择");
		Container container=this.getContentPane();
		container.setLayout(new GridLayout(1, 2));
		user=new JButton("用户请点击");
		user.setFont(new Font("SansSerif", Font.PLAIN, 40));
		user.addActionListener(this);
		manager=new JButton("管理员请点击");
		manager.setFont(new Font("SansSerif", Font.PLAIN, 40));
		manager.addActionListener(this);
		
		container.add(user);
		container.add(manager);
		  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(getMaximumSize());
	    this.setVisible(true);
		
	}
	public static void main(String[] args) {
		 aBoardView=new BoardView();
		 aPictureView=new PlayPictureView();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==user) {
			UserView aUserView =new UserView();		
		}
		if(e.getSource()==manager) {
			ManagerView aManagerView=new ManagerView();
		}
	}
}
