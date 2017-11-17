package clubSystem.model;

import java.awt.Checkbox;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import javax.sound.midi.Patch;


public class Board {
	private ArrayList<String[]> clubs_initData;
	private ArrayList<String[]> activities_initData;
	private ArrayList<String[]> participators_initData;
	private ArrayList<File> pictures;
	static ArrayList<Participator> participators=new ArrayList<>();//成员列表
	static ArrayList<Activity> activities=new ArrayList<>();//活动列表
	static ArrayList<Club> clubs=new ArrayList<>();//社团列表
	
//得到三张表里初始化数据
	public Board() {
		this.clubs_initData=new ArrayList<>();
		this.activities_initData=new ArrayList<>();
		this.participators_initData=new ArrayList<>();
		int participatorID=1;
		int activityID=1;
		int clubID=1;
	
		File fileFolder=new File("./src/pic");
		pictures=new ArrayList<>();
		//将图片路径存入数组
		if(fileFolder.isDirectory()) {
			for(File a:fileFolder.listFiles()) {
				pictures.add(a);
			}			
		}
		
		//读csv文件
		ReadCSV datas_init=new ReadCSV();
		//得到用户表初始的表格数据存入成员列表
		this.participators_initData=datas_init.getDataFromCSV("./src/csv/用户表.csv");
	    
		for(String[] aPersonData:participators_initData) {
			Participator aParticipator=new Participator(participatorID,aPersonData[0],aPersonData[1], aPersonData[2]);
//			System.out.println(aParticipator.getDetails());   用户列表测试通过
			participators.add(aParticipator);
			participatorID++;
		}
		
		
		//得到活动表初始的表格数据存入活动列表
		this.activities_initData=datas_init.getDataFromCSV("./src/csv/活动表.csv");
		
		for(String[] anActivityData:activities_initData) {	
			Activity anActivity=new Activity(activityID,anActivityData[0], anActivityData[1], anActivityData[2], anActivityData[4]);
			
			//如果有备注，则创建动态数组用来存备注内容
			if(anActivityData.length>5) {
				HashMap<String, ArrayList<Participator>> aRemark=new HashMap<>();
				ArrayList<Participator> participatorsInRemark=new ArrayList<>();
				for(String name:anActivityData[5].split("：")[1].split("、")) {
					if(check(name)!=null) 
						participatorsInRemark.add(check(name));
					else participatorsInRemark.add(new Participator(participatorID,name, "", ""));
					/*如果活动的备注中的人不在成员列表
					（但初始化时都在，这个基本用不上）*/
				}
				aRemark.put(anActivityData[5].split("：")[0], participatorsInRemark);
				anActivity.setRemark(aRemark);		
			}			
			//创建初始化活动表时的“主办社团”
			ArrayList<Club> theClubs=new ArrayList<>();
			for(String clubName:anActivityData[3].split("、")) {
				if(checkC(clubName)!=null) {
					theClubs.add(checkC(clubName));
				}
				else {
					theClubs.add(new Club(clubID,clubName, "", null, "", "", "", null));
				}
			}
			anActivity.setClubs(theClubs);
//			System.out.println(anActivity.getActivityDetails());   活动列表测试通过
			
			activities.add(anActivity);	
			activityID++;
		}
		
		
		//得到社团表初始的表格数据，动态数组里面每一个元素也是一个数组（一行数据）
		this.clubs_initData=datas_init.getDataFromCSV("./src/csv/社团表.csv");
       
		for(String[] aClubData:clubs_initData) {
			Participator aLeader=null;
			//先得到Leader
			if(check(aClubData[2])!=null) {
				aLeader=check(aClubData[2]);
			}
			else {
				aLeader=new Participator(participatorID,aClubData[2], "", "");
			}
			//从CSV表格中得到数据后，对每一个社团（一行），建立初始成员数组
			ArrayList<Participator> theClubMembers=new ArrayList<>();
			for(String memberName:aClubData[5].split("、")) {
				if(check(memberName)!=null) {
					theClubMembers.add(check(memberName));
				}
				else {
					theClubMembers.add(new Participator(participatorID,memberName, "", ""));
				}
			}
			//从CSV表格中得到数据后，对每一个社团（一行），建立初始活动数组
			ArrayList<Activity> theClubActivity=new ArrayList<>();
			for(String activityName:aClubData[6].split("、")) {
				if(checkA(activityName)!=null) {
					theClubActivity.add(checkA(activityName));
				}
				else {
					theClubActivity.add(new Activity(activityID,activityName, "", "", ""));
				}
			}
			//建立初始化社团
			Club aClub=new Club(clubID,aClubData[0],aClubData[1],aLeader,aClubData[3], aClubData[4], aClubData[7],theClubActivity);
			aClub.setMembers(theClubMembers);
//			System.out.println(aClub.getClubDetails());  社团列表测试通过
			clubs.add(aClub);
			clubID++;
		}
		
	}
	//判断各个数组是否已经包含
	//暂且认为社团成员、活动、社团不同名
	public static Participator check(String name) {
		for(Participator p:participators) {
				if(p.getName().equals(name)) return p;		
		}
	    return null;		
	}
	
	public static Activity checkA(String activityName) {
		for(Activity a:activities) {
			if(a.getActivityName().equals(activityName)) return a;		
	    }
        return null;	
	}
	
	public static Club checkC(String clubName) {
		for(Club c:clubs) {
			if(c.getActivitiesName().equals(clubName)) return c;
		}
		return null;
	}
//图片轮播	
	public void picturesPlay() {
		for(File p:pictures) {
			System.out.println(p);
		}
	}
/*用户角度*/
//显示所有社团
	public String displayAllClubsName() {
		String allClubsName="所有社团ALL CLUBS:\n";
		for(Club c:clubs) {
			allClubsName+="编号: "+c.getClubID()+" "+c.getClubName()+"\n";
		}
//		System.out.println(allClubsName); 测试通过
		return allClubsName;
	}
//显示所有活动
	public String displayAllActivitiesName() {
		String allActivitiesName="所有活动ALL ACTIVITIES:\n";
		for(Activity a:activities) {
			allActivitiesName+="编号: "+a.getActivityID()+" "+a.getActivityName()+"\n";
		}
//		System.out.println(allActivitiesName);测试通过
		return allActivitiesName;
	}
//查找社团
	public Club searchClubByName(String clubName) throws Exception {
		for(Club c:clubs) {
			if(c.getClubName().equals(clubName)) 
				return c;
		}
		Exception e=new Exception("输入的社团不存在!!!");
		throw e;
	}
//查找活动（通过活动名，活动时间，活动社团）
	public Activity searchActivityByName(String activityName) throws Exception {
		for(Activity a:activities) {
			if(a.getActivityName().equals(activityName)) 
				return a;
		}
		Exception e=new Exception("输入的活动不存在!!!");
		throw e;
	}
	
	public ArrayList<Activity> chooseActivityByTime(String date,String type) {
		ArrayList<Activity> resultBeforeInputDate=new ArrayList<>();
		ArrayList<Activity> resultAfterInputDate=new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
		try {
			Date inputDate=sdf.parse(date);
			for(Activity a:activities) {
				Date existedDate=sdf.parse(a.getHeldTime());
				if(existedDate.before(inputDate)) 
					resultBeforeInputDate.add(a);
				else 
					resultAfterInputDate.add(a);
			}
					
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(type.equals("before")){
//			System.out.println(resultBeforeInputDate.size());  由日期筛选活动通过
			return resultBeforeInputDate;
			}
		else
			return resultAfterInputDate;
		
	}
	
	public ArrayList<Activity> chooseActivityByClub(String clubName) throws Exception{
		ArrayList<Activity> result=new ArrayList<>();
		for(Activity a:activities) {
			for(Club c:a.getClubs()) {
				if(c.getClubName().equals(clubName)) {
					result.add(a);
				}
			}
		}
		if(result.size()==0) {
			Exception e=new Exception("输入的社团不存在!!!");
			throw e;
		}
//		System.out.println(result.get(1).getActivityName());  由社团筛选活动通过
		return result;
	}
//查看详情
	public String getDetails(int id,String type) {
		String str = "";
		switch (type) {
		case "club":{
			for(Club c:clubs) {
				if(c.getClubID()==id)
					str=c.getClubDetails();
			}
		}
			break;
        case "activity":{
        	for(Activity a:activities) {
        		if(a.getActivityID()==id)
        			str=a.getActivityDetails();
        	}
        }  break;
		default:
			System.out.println("输入错误!");
			break;
		}
//		System.out.println(str);  查询详情通过
		return str;
	}

/*后台管理者角度*/
//查看每个社团的所有成员列表
	    public String getAllMembersInAClub(int clubID) {
			String str="";
			for(Club c:clubs) {
				if(c.getClubID()==clubID) {
					str=c.getClubName()+"的所有成员列表: \n";
					for(Participator p:c.getMembers()) {
						str+=p.getDetails()+"\n";
					}
				}
			}
//			System.out.println(str);
			return "输入的社团不存在呢,再看看其他的？";
		}
//对社团进行排序
	    public String rankClubs(String rule) { 
	    	String str="";
			switch (rule) {
			case "activityTimes":
			{
				str="所有社团按照开展活动次数（多——>少）排序: \n";
				Collections.sort(clubs, new CompareActivityTimes());
				
			}
				break;
			case "memberNumbers":
			{
				str="所有社团按照活动规模（人数）（多——>少）排序: \n";
				Collections.sort(clubs, new CompareMemberNumbers());		
			}
				break;
			default:
				break;
			}
//			System.out.println(str+displayAllClubsName()); 将社团按照排序规则排序通过
			return str+displayAllClubsName();
		}
//对所有活动进行信息汇总
	    public String collectAllActivities() {
			String str="";
			for(Activity a:activities){
				str+=a.getActivityDetails()+"\n";
			}
//			System.out.println(str); 测试通过
			return str;
		}
//对活动添加补充信息
	    //在有内容/无内容的备注里面添加新的内容
	    public void addANewRemark(int activityID,String string, String[] participatorsName)throws Exception {
	    	
	    	ArrayList<Participator> newParticipators=new ArrayList<>();
	    	for(Activity a:activities) {
				if(a.getActivityID()==activityID) {		
					for(String s:participatorsName) {
						for(Participator p:participators) {
							if(p.getName().equals(s)) {
								newParticipators.add(p);
							}
						}
					}	
					
					a.getRemark().put(string, newParticipators);
				}
			}
	    
			if(newParticipators.size()!=participatorsName.length) {
				Exception e=new Exception("输入的参与者具体信息不存在");
				throw e;
			}
//			System.out.println(collectAllActivities());加入一条新的备注测试通过
		}
	    //删除已有（!!!）备注，已有!!!故没有考虑异常;
	    public void deleteRemark(int activityID,String string) {
	    	for(Activity a:activities) {
	    		if(a.getActivityID()==activityID) {
	    			a.getRemark().remove(string);
//	    			System.out.println(collectAllActivities()); 删除一条备注测试通过
	    		}
	    	}
	    }
	    //修改备注
	    public void updateRemark(int activityID,String stringBefore,String stringAfter,String[] participatorsName) throws Exception {
			deleteRemark(activityID, stringBefore);
			addANewRemark(activityID, stringAfter, participatorsName);
//			System.out.println(collectAllActivities()); 修改备注测试通过
		}
		public static ArrayList<Participator> getParticipators() {
			return participators;
		}
		public static void setParticipators(ArrayList<Participator> participators) {
			Board.participators = participators;
		}
		public static ArrayList<Activity> getActivities() {
			return activities;
		}
		public static void setActivities(ArrayList<Activity> activities) {
			Board.activities = activities;
		}
		public ArrayList<Club> getClubs() {
			return clubs;
		}
		public static void setClubs(ArrayList<Club> clubs) {
			Board.clubs = clubs;
		}
	    
	    
	    
	    //未完成?????后台编辑了之后再重新写入文件???
	    //有一个问题：排序之后的列表还能还原嘛，不能的话用编号再排列一次？？
	    public static void main(String[] Sargs) throws Exception {
			Board aBoard=new Board();
			aBoard.displayAllClubsName();
			aBoard.displayAllActivitiesName();
			aBoard.searchActivityByName("爱心捐款");
			aBoard.searchClubByName("话剧社");
			aBoard.chooseActivityByTime("2016.1.30", "before");
			aBoard.chooseActivityByClub("话剧社");
			aBoard.getDetails(2, "club");
			
			aBoard.getAllMembersInAClub(2);
			aBoard.rankClubs("activityTimes");
			aBoard.rankClubs("memberNumbers");
			aBoard.collectAllActivities();
			String[] str= {"123","456"};
			String[] str1= {"陈刚","李铁"};
			aBoard.addANewRemark(12, "导演", str1);//String[]先提前写好
			aBoard.deleteRemark(1, "参演者");
			aBoard.updateRemark(2, "参演者","演员",str1);
			
			
		}
}
