package clubSystem.view;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class PlayPictureView extends JFrame implements MouseListener{
    ArrayList<ImageIcon> pictures;
    int index;
    MyJpanel myJpanel;
    Timer timer;
    JLabel tips=new JLabel("进入用户界面请按“u”,进入管理员界面请按“m”");
    Container container;
	
    public PlayPictureView() {
    	File fileFolder=new File("./src/pic");
		pictures=new ArrayList<>();
		//遍历图片文件夹将图片路径转换成图片存入数组
		if(fileFolder.isDirectory()) {
			for(File a:fileFolder.listFiles()) {
				ImageIcon image=new ImageIcon(a.getPath());
				pictures.add(image);
			}			
		}
      	container=this.getContentPane();
    	myJpanel=new MyJpanel();
    	container.add(myJpanel);
    	addMouseListener(this);
    	
    	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setTitle("图片轮播");
    	this.setSize(getMaximumSize());
    	this.setVisible(true);
    	
    	timer=new Timer(1000, new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				myJpanel.repaint();
				// TODO Auto-generated method stub
				
			}
		});
    	
    	timer.start();	
    	
    }
    
    class MyJpanel extends JPanel{
    	   @Override
    	    public void paint(Graphics g) {
    		// TODO Auto-generated method stub
    		super.paint(g);
    		g.drawImage(pictures.get(index%pictures.size()).getImage(), 0, 0, this);
            index++;  	
    	   }
    	  
     }
    
    @Override
	public void mouseClicked(MouseEvent e) {
		timer.stop();
		this.dispose();	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}


