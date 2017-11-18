package clubSystem.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListDataListener;

import clubSystem.model.*;

public class UserView extends JFrame implements ActionListener{	
	Board aBoard;
	JButton getAllClubs;
	JButton getAllActivities;
	JButton LsearchBtn;
	JButton LdetailBtn;
	JButton RsearchBtn;
	JButton RdetailBtn;
	JButton RtimeBeforeBtn;
	JButton RtimeAfterBtn;
	JButton clubBtn;
	JTextArea clubs;
    JTextArea Lbottom;
    JTextArea activities;
    JTextArea Rbottom;
    JTextField inputSearchClub;
    JTextField inputClubID;
    JTextField inputSearchActivityName;
    JTextField inputActivityID;
    JTextField inputTime;
    JTextField inputClubName;
    
    JPanel Lsearch;
    JPanel Rsearch;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    
   public UserView() {
	   super("用户主界面");
	   aBoard=new Board();
	   Container container=this.getContentPane();
	   container.setLayout(new GridLayout(1, 2));
	         
	   JPanel leftPanel=new JPanel(new GridLayout(2, 1));
	   JPanel rightPanel=new JPanel(new GridLayout(2, 1));
	   //左社团
	   JPanel Ltop=new JPanel(new GridLayout(1, 2));
	       clubs=new JTextArea(aBoard.displayAllClubsName());//success
	       clubs.setLineWrap(true);//激活换行
	       clubs.setBackground(Color.pink);
	       clubs.setFont(new Font("SansSerif", Font.PLAIN, 35));
	      Lsearch=new JPanel(new GridLayout(2, 1));
	       JPanel p1=new JPanel();//success
	        getAllClubs=new JButton("所有社团");
	        getAllClubs.setFont(new Font("SansSerif", Font.PLAIN, 15));
	        getAllClubs.addActionListener((ActionListener) this);
	        getAllClubs.setBackground(Color.LIGHT_GRAY);
	        JLabel p1_lable=new JLabel("输入社团名");
	        p1_lable.setFont(new Font("SansSerif", Font.PLAIN, 15));
	        inputSearchClub=new JTextField(10);
	        inputSearchClub.setFont(new Font("SansSerif", Font.PLAIN, 15));
	        LsearchBtn=new JButton("搜索社团");
	        LsearchBtn.setFont(new Font("SansSerif", Font.PLAIN, 15));
	        LsearchBtn.addActionListener((ActionListener) this);
	        p1.add(getAllClubs);
	        p1.add(p1_lable);
	        p1.add(inputSearchClub);
	        p1.add(LsearchBtn);
	       JPanel p2=new JPanel();//success
	        JLabel p2_lable=new JLabel("输入社团编号");
	        p2_lable.setFont(new Font("SansSerif", Font.PLAIN, 15));
	        inputClubID=new JTextField(10);
	        inputClubID.setFont(new Font("SansSerif", Font.PLAIN, 15));
	        LdetailBtn=new JButton("查看社团详情");
	        LdetailBtn.setFont(new Font("SansSerif", Font.PLAIN, 15));
	        LdetailBtn.addActionListener((ActionListener) this);
	        p2.add(p2_lable);
	        p2.add(inputClubID);
	        p2.add(LdetailBtn);
	      Lsearch.add(p1);
	      Lsearch.add(p2);
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
	       activities.setBackground(Color.pink);
	       activities.setFont(new Font("SansSerif", Font.PLAIN, 20));
	      Rsearch=new JPanel(new GridLayout(6, 1));
	        panel1=new JPanel();//success
	          getAllActivities=new JButton("所有活动");
	          getAllActivities.setFont(new Font("SansSerif", Font.PLAIN, 15));
	          getAllActivities.addActionListener((ActionListener) this);
	          getAllActivities.setBackground(Color.LIGHT_GRAY);
	          JLabel panel1_lable=new JLabel("输入活动名");
	          panel1_lable.setFont(new Font("SansSerif", Font.PLAIN, 15));
	          inputSearchActivityName=new JTextField(10);
	          inputSearchActivityName.setFont(new Font("SansSerif", Font.PLAIN, 15));
	          RsearchBtn=new JButton("搜索活动");
	          RsearchBtn.setFont(new Font("SansSerif", Font.PLAIN, 15));
		      RsearchBtn.addActionListener((ActionListener) this);
		      panel1.add(getAllActivities);
		      panel1.add(panel1_lable);
	          panel1.add(inputSearchActivityName);
	          panel1.add(RsearchBtn);
	        panel2=new JPanel();//success
	          JLabel panel2_lable=new JLabel("输入活动编号");
	          panel2_lable.setFont(new Font("SansSerif", Font.PLAIN, 15));
	          inputActivityID=new JTextField(10);
	          inputActivityID.setFont(new Font("SansSerif", Font.PLAIN, 15));
	          RdetailBtn=new JButton("查看活动详情");
	          RdetailBtn.setFont(new Font("SansSerif", Font.PLAIN, 15));
		      RdetailBtn.addActionListener((ActionListener) this);
		      panel2.add(panel2_lable);
	          panel2.add(inputActivityID);
	          panel2.add(RdetailBtn);
	        panel3=new JPanel();//success
	          JLabel panel3_lable=new JLabel("输入时间(格式为yyyy.MM.dd)");
	          panel3_lable.setFont(new Font("SansSerif", Font.PLAIN, 15));
	          inputTime=new JTextField(10);
	          inputTime.setFont(new Font("SansSerif", Font.PLAIN, 15));
	          RtimeBeforeBtn=new JButton("按时间筛选（前）");
	          RtimeBeforeBtn.setFont(new Font("SansSerif", Font.PLAIN, 15));
	          RtimeBeforeBtn.addActionListener((ActionListener) this);
	          RtimeAfterBtn=new JButton("按时间筛选（后）");
	          RtimeAfterBtn.setFont(new Font("SansSerif", Font.PLAIN, 15));
	          RtimeAfterBtn.addActionListener((ActionListener) this);
	          panel3.add(panel3_lable);
	          panel3.add(inputTime);
	          panel3.add(RtimeBeforeBtn);
	          panel3.add(RtimeAfterBtn);
	         panel4=new JPanel();//success
	          JLabel panel4_lable=new JLabel("输入社团名");
	          panel4_lable.setFont(new Font("SansSerif", Font.PLAIN, 15));
	          inputClubName=new JTextField(10);
	          inputClubName.setFont(new Font("SansSerif", Font.PLAIN, 15));
	          clubBtn=new JButton("按社团筛选");
	          clubBtn.setFont(new Font("SansSerif", Font.PLAIN, 15));
		      clubBtn.addActionListener((ActionListener) this);
		      panel4.add(panel4_lable);
	          panel4.add(inputClubName);
	          panel4.add(clubBtn);
	          
	        Rsearch.add(panel1);
	        Rsearch.add(panel2);
	        Rsearch.add(panel3);
	        Rsearch.add(panel4);
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
	UserView aUserView =new UserView();
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
	  //搜索社团
	if(e.getSource()==LsearchBtn) {
		String inputClubName=inputSearchClub.getText();
		try {
			clubs.setText("编号: "+aBoard.searchClubByName(inputClubName).getClubID()+aBoard.searchClubByName(inputClubName).getClubName());
			Lbottom.setText(aBoard.searchClubByName(inputClubName).getClubDetails());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     }
	//查看社团详情
	if(e.getSource()==LdetailBtn) {
		int clubID=Integer.parseInt(inputClubID.getText());
		try {
			clubs.setText(aBoard.displayAllClubsName());
			Lbottom.setText(aBoard.getDetails(clubID, "club"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     }
	//搜索活动
	if(e.getSource()==RsearchBtn) {
		String inputActivityName=inputSearchActivityName.getText();
		try {
			activities.setText("编号: "+aBoard.searchActivityByName(inputActivityName).getActivityID()+aBoard.searchActivityByName(inputActivityName).getActivityName());
			Rbottom.setText(aBoard.searchActivityByName(inputActivityName).getActivityDetails());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     }
	//查看活动详情
	if(e.getSource()==RdetailBtn) {
		int activityID=Integer.parseInt(inputActivityID.getText());
		try {
			activities.setText(aBoard.displayAllActivitiesName());
			Rbottom.setText(aBoard.getDetails(activityID, "activity"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     }
	//根据时间筛选活动
	if(e.getSource()==RtimeBeforeBtn) {
		String time=inputTime.getText();
		try {
			String findResult="";
			for(Activity a:aBoard.chooseActivityByTime(time, "before")) {
				findResult+=a.getActivityDetails()+"\n\n";
			}
			activities.setText(findResult);
			Rbottom.setText("");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     }
	 if(e.getSource()==RtimeAfterBtn) {
		String time=inputTime.getText();
		try {
			String findResult="";
			for(Activity a:aBoard.chooseActivityByTime(time, "after")) {
				findResult+=a.getActivityDetails()+"\n\n";
			}
			activities.setText(findResult);
			Rbottom.setText("");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     }
	 //根据社团筛选活动
	 if(e.getSource()==clubBtn) {
			String clubName=inputClubName.getText();
			try {
				String findResult="";
				for(Activity a:aBoard.chooseActivityByClub(clubName)) {
					findResult+=a.getActivityDetails()+"\n\n";
				}
				activities.setText(findResult);
				Rbottom.setText("");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	     }
  }
}
