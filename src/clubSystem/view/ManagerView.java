package clubSystem.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clubSystem.model.Board;

public class ManagerView extends JFrame implements ActionListener{
	 Board aBoard;
	 JTextField inputClubID_;
	 JTextField aID_2;
	 JTextField typeB;
	 JTextField typeA;
	 JTextField people2;
	 JButton LmemberBtn;
	 JButton LrankBtn1;
	 JButton LrankBtn2;
	 JButton allBtn;
	 JButton addBtn;
	 JButton delBtn;
	 JButton updBtn;
	 JButton getAllClubs;
	 JButton getAllActivities;
	 
	 JTextArea clubs;
	    JTextArea Lbottom;
	    JTextArea activities;
	    JTextArea Rbottom;
	 
	    JPanel Lsearch;
	    JPanel Rsearch;
	    
   public ManagerView() { 
	   super("管理员界面");
	   aBoard=new Board();
	   Container container=this.getContentPane();
	   container.setLayout(new GridLayout(1, 2));
	   
	   JPanel leftPanel=new JPanel(new GridLayout(2, 1));
	   JPanel rightPanel=new JPanel(new GridLayout(2, 1));
	   
	   //左社团
	   JPanel Ltop=new JPanel(new GridLayout(1, 2));
	       clubs=new JTextArea(aBoard.displayAllClubsName());//success
	       clubs.setLineWrap(true);//激活换行
	       clubs.setBackground(Color.orange);
	       clubs.setFont(new Font("SansSerif", Font.PLAIN, 35));
	      Lsearch=new JPanel(new GridLayout(2, 1));
	      JPanel p3=new JPanel();//success
	        getAllClubs=new JButton("所有社团");
	        getAllClubs.setFont(new Font("SansSerif", Font.PLAIN, 15));
	        getAllClubs.addActionListener((ActionListener) this);
	        getAllClubs.setBackground(Color.LIGHT_GRAY);
		   JLabel p3_lable=new JLabel("输入社团编号");
		   p3_lable.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       inputClubID_=new JTextField(10);
	       inputClubID_.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       LmemberBtn=new JButton("查看社团成员列表");
	       LmemberBtn.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       LmemberBtn.addActionListener((ActionListener) this);
	       p3.add(getAllClubs);
	       p3.add(p3_lable);
	       p3.add(inputClubID_);
	       p3.add(LmemberBtn);
	       JPanel p4=new JPanel();//success
	       LrankBtn1=new JButton("按照活动次数排序");
	       LrankBtn1.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       LrankBtn1.addActionListener((ActionListener) this);
	       LrankBtn2=new JButton("按照参与人数排序");
	       LrankBtn2.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       LrankBtn2.addActionListener((ActionListener) this);
	       p4.add(LrankBtn1);
	       p4.add(LrankBtn2);
	       
	       Lsearch.add(p3);
	       Lsearch.add(p4);
	       
	   Ltop.add(clubs);
	   Ltop.add(new JScrollPane(clubs)); //TextArea滚动条
	   Ltop.add(Lsearch);
	   Lbottom=new JTextArea();//success
	   Lbottom.setBorder(BorderFactory.createDashedBorder(Color.red));
	   Lbottom.setFont(new Font("SansSerif", Font.PLAIN, 20));
	   
	   leftPanel.add(Ltop);
	   leftPanel.add(Lbottom);
	   leftPanel.add(new JScrollPane(Lbottom));
	   
	   
	   //右边
	   JPanel Rtop=new JPanel(new GridLayout(1, 2));
	       activities=new JTextArea(aBoard.displayAllActivitiesName());//success
	       activities.setLineWrap(true);//激活换行
	       activities.setBackground(Color.orange);
	       activities.setFont(new Font("SansSerif", Font.PLAIN, 20));
	      Rsearch=new JPanel(new GridLayout(6, 1));
	      JPanel panel5=new JPanel();//success
	      getAllActivities=new JButton("所有活动");
          getAllActivities.setFont(new Font("SansSerif", Font.PLAIN, 15));
          getAllActivities.addActionListener((ActionListener) this);
          getAllActivities.setBackground(Color.LIGHT_GRAY);
	       allBtn=new JButton("所有活动信息汇总");
	       allBtn.setFont(new Font("SansSerif", Font.PLAIN, 15));
		   allBtn.addActionListener((ActionListener) this);
		   panel5.add(getAllActivities);
		   panel5.add(allBtn);
		   	     
	       JPanel panel6=new JPanel();
	       JLabel id_2=new JLabel("活动编号");
		   id_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       aID_2=new JTextField(6);
	       aID_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       panel6.add(id_2);
	       panel6.add(aID_2);
	       
	       JPanel panel7=new JPanel();
	       JLabel typeB_2=new JLabel("类型");
	       typeB_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       typeB=new JTextField(6);
	       typeB.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       panel7.add(typeB_2);
	       panel7.add(typeB);
	       
	       JPanel panel8=new JPanel();
	       JLabel typeA_2=new JLabel("改后类型(添加、删除操作可不填)");
	       typeA_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       typeA=new JTextField(6);
	       typeA.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       panel8.add(typeA_2);
	       panel8.add(typeA);
	       
	       JPanel panel9=new JPanel();
	       JLabel people_2=new JLabel("参与人员(删除可不填，用、隔开)");
	       people_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       people2=new JTextField(8);
	       people2.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       panel9.add(people_2);
	       panel9.add(people2);
	       
	       JPanel panel10=new JPanel();
	       addBtn=new JButton("添加补充信息");
	       addBtn.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       addBtn.addActionListener((ActionListener) this);
	       updBtn=new JButton("修改补充信息");
	       updBtn.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       updBtn.addActionListener((ActionListener) this);
	       delBtn=new JButton("删除补充信息");
	       delBtn.setFont(new Font("SansSerif", Font.PLAIN, 15));
	       delBtn.addActionListener((ActionListener) this);
	       panel10.add(addBtn);
	       panel10.add(delBtn);
	       panel10.add(updBtn);
	       Rsearch.add(panel5);
		   Rsearch.add(panel6);
		   Rsearch.add(panel7);
		   Rsearch.add(panel8);
		   Rsearch.add(panel9);
		   Rsearch.add(panel10);
	       
	   Rtop.add(activities);
	   Rtop.add(new JScrollPane(activities)); //TextArea滚动条
	   Rtop.add(Rsearch);
	      Rbottom=new JTextArea();
	      Rbottom.setBorder(BorderFactory.createDashedBorder(Color.blue));
	      Rbottom.setFont(new Font("SansSerif", Font.PLAIN, 20));
	      
	   rightPanel.add(Rtop);
	   rightPanel.add(Rbottom);
	   rightPanel.add(new JScrollPane(Rbottom));
       
       container.add(leftPanel);
       container.add(rightPanel);
       
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setSize(getMaximumSize());
       this.setVisible(true);
	 
	    
}
   public static void main(String[] args) {
	ManagerView aManagerView=new ManagerView();
}
   @Override
   public void actionPerformed(ActionEvent e) {
	   
	   //一键得到所有社团
	   if(e.getSource()==getAllClubs) {
			try {
				clubs.setText(aBoard.displayAllClubsName());
				Lbottom.setText("");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	     }
	   //一键得到所有活动
	   if(e.getSource()==getAllActivities) {
			try {
				activities.setText(aBoard.displayAllActivitiesName());
				Rbottom.setText("");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	     }
	//查看某个社团的成员列表
	if(e.getSource()==LmemberBtn) {
		int clubID=Integer.parseInt(inputClubID_.getText());
		try {
			Lbottom.setText(aBoard.getAllMembersInAClub(clubID));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     }
	//将所有社团按照活动次数排序
	if(e.getSource()==LrankBtn1) {
		try {
			clubs.setText(aBoard.rankClubs("activityTimes"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     }
	//将所有社团按照参与人数排序
	if(e.getSource()==LrankBtn2) {
			try {
				clubs.setText(aBoard.rankClubs("memberNumbers"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	  }
    //所有信息汇总
	if(e.getSource()==allBtn) {
		try {
			Rbottom.setText(aBoard.collectAllActivities());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     }
	//添加
	if(e.getSource()==addBtn) {
		try {
			int inputActivityID=Integer.parseInt(aID_2.getText());
			String inputType=typeB.getText();
			String[] inputParticipatorsArray=people2.getText().split("、");
			
			String str=new String("添加之前：\n"+ aBoard.getDetails(inputActivityID, "activity"));
			aBoard.addANewRemark(inputActivityID, inputType, inputParticipatorsArray);
             str+="\n添加之后： \n"+ aBoard.getDetails(inputActivityID, "activity");
             
             Rbottom.setText(str);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     }
	//修改
	if(e.getSource()==updBtn) {
		try {		
			int inputActivityID=Integer.parseInt(aID_2.getText());
			String inputTypeBefore=typeB.getText();
			String inputTypeAfter=typeA.getText();
			String[] inputParticipatorsArray=people2.getText().split("、");
			
			String str=new String("修改之前：\n"+ aBoard.getDetails(inputActivityID, "activity"));
			aBoard.updateRemark(inputActivityID, inputTypeBefore, inputTypeAfter, inputParticipatorsArray);
             str+="\n修改之后： \n"+ aBoard.getDetails(inputActivityID, "activity");
             
             Rbottom.setText(str);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     }
	//删除
	if(e.getSource()==delBtn) {
		try {			
			int inputActivityID=Integer.parseInt(aID_2.getText());
			String inputType=typeB.getText();
			
			String str=new String("删除之前：\n"+ aBoard.getDetails(inputActivityID, "activity"));
			aBoard.deleteRemark(inputActivityID, inputType);
             str+="\n删除之后： \n"+ aBoard.getDetails(inputActivityID, "activity");
             
             Rbottom.setText(str);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     }
}
}
