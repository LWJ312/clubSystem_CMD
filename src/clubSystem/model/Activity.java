package clubSystem.model;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Activity {
	// 属性变量
	private String activityName;
	private String heldTime;
	private String heldPlace;
	private String description;
	
	private int activityID;
	// 活动备注
	private HashMap<String, ArrayList<Participator>> remark;
	// 引用变量
	private ArrayList<Club> clubs;

	public Activity(int activityID, String activityName, String heldTime, String heldPlace, String description) {
		this.activityID=activityID;
		this.activityName = activityName;
		this.heldTime = heldTime;
		this.heldPlace = heldPlace;
		this.description = description;
		
		remark=new HashMap<>();
//		this.remark = remark;
//		this.clubs = clubs;
	}
	//获得活动详情
	public String getActivityDetails() {

		String str="";
		str="活动详情如下："
			+"\n活动编号"+getActivityID()
			+"\n活动名称："+getActivityName()
		    +"\n开始时间："+getHeldTime()
		    +"\n地点："+getHeldPlace()
		    +"\n主办社团："+getClubsName()
		    +"\n宣传标语："+getDescription()
		    +"\n备注："+getRemarkName();
		
		return str;
	}
	//根据活动的具体类型添加新的信息……
	public void addANewRemark(String str, ArrayList<Participator> p) {
		this.remark.put(str, p);
	}
	//修改备注（先删除再添加）
	public void changeOldRemark(String index,String str, ArrayList<Participator> p) {
		remark.remove(index);
		addANewRemark(str,p);
	}
	
    //getters and setters

	public int getActivityID() {
		return activityID;
	}
	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}
	
	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getHeldTime() {
		return heldTime;
	}

	public void setHeldTime(String heldTime) {
		this.heldTime = heldTime;
	}

	public String getHeldPlace() {
		return heldPlace;
	}

	public void setHeldPlace(String heldPlace) {
		this.heldPlace = heldPlace;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HashMap<String, ArrayList<Participator>> getRemark() {
		return remark;
	}
	public String getRemarkName() {
		if(getRemark().size()==0) return "暂无";
		else {
			String str="";
			//遍历map
		   HashMap<String, ArrayList<Participator>> map=getRemark();
           Set<String> keySet=map.keySet();
           for(Iterator<String> iterator = keySet.iterator();iterator.hasNext();){  
               String key = iterator.next();    
               String value="";
               for(Participator p:map.get(key)) {
            	   value+=p.getName()+" ";
               }
                
               str +=key+":"+value;    
           }  
		return str;
		}
		
	}
	public void setRemark(HashMap<String, ArrayList<Participator>> remark) {
		this.remark = remark;
	}

	public ArrayList<Club> getClubs() {
		return clubs;
	}
	
	public String getClubsName() {
		String str="";
		if(getClubs()==null) return "暂无";
		else {
			for(Club c:getClubs()) {
				str+=c.getClubName()+" ";
			}
		}  
		return str;	
	}
	public void setClubs(ArrayList<Club> clubs) {
		this.clubs = clubs;
	}

}
