package clubSystem.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;;

public class Club{
	// 声明属性变量
	private String clubName;
	private String foundedTime;
	private Participator leader;
	private String phoneNumber;
	private String email;
	private String description;
	private int clubID;

	// 声明引用变量——社团成员&活动
	private ArrayList<Participator> members;
	private ArrayList<Activity> activities;

	public Club(int clubID,String clubName, String foundedTime, Participator leader, String phoneNumber, String email,
			String description, ArrayList<Activity> activities) {
		this.clubID=clubID;
		this.clubName = clubName;
		this.foundedTime = foundedTime;
		this.leader = leader;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.description = description;
		this.activities = activities;

		// 默认社团初始化时成员表只有负责人
		members = new ArrayList<>(1);
		members.add(leader);
	}
	//获取社团详细信息
	public String getClubDetails() {
		String str="";
		str="社团详细信息如下："
			+"\n社团编号："+getClubID()
		    +"\n社团名："+getClubName()
		    +"\n创建时间："+getFoundedTime()
		    +"\n负责人："+getLeader().getName()
		    +"\n联系电话："+getPhoneNumber()
		    +"\n邮箱："+getEmail()
			+"\n社团成员："+getMembersName()
			+"\n举办的活动："+getActivitiesName()
			+"\n简介："+getDescription();
		
		return str;
	}
	
    //getters and setters
	public int getClubID() {
		return clubID;
	}
	public void setClubID(int clubID) {
		this.clubID = clubID;
	}
	
	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getFoundedTime() {
		return foundedTime;
	}

	public void setFoundedTime(String foundedTime) {
		this.foundedTime = foundedTime;
	}

	public Participator getLeader() {
		return leader;
	}

	public void setLeader(Participator leader) {
		this.leader = leader;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Participator> getMembers() {
		return members;
	}
	//只输入成员的名字，而不是成员对象
    public String getMembersName() {
		String str="";
		for(int i=0;i<getMembers().size();i++) {
			str+=getMembers().get(i).getName()+" ";
		}
		return str;
	}
    
	public void setMembers(ArrayList<Participator> members) {
		this.members = members;
	}

	public ArrayList<Activity> getActivities() {
		return activities;
	}
	//只输入活动的名字，而不是活动对象
	public String getActivitiesName() {
		String str="";
		for(int i=0;i<getActivities().size();i++) {
			str+=getActivities().get(i).getActivityName()+" ";
		}
		return str;
	}

	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}
	
}

/*实现排序(若用comparable则根据排序规则修改compareTo(),
 * 选用comparator更自由,根据排序规则定义不同的类来实现comparator接口)
 */

//根据活动次数排序（从大到小）
class CompareActivityTimes implements Comparator<Club>{
	@Override
	public int compare(Club o1, Club o2) {
		// TODO Auto-generated method stub
		return -(o1.getActivities().size()-o2.getActivities().size());
	}
}
//根据活动规模(参与人数————暂且认为社团人数）排序（从多到少）
class CompareMemberNumbers implements Comparator<Club>{
	@Override
	public int compare(Club o1, Club o2) {
		// TODO Auto-generated method stub
		return -(o1.getMembers().size()-o2.getMembers().size());
	}
}
