package clubSystem.model;

public class Participator {
	private String name;
	private String institute;
	private String klass;
	private int participatorID;

	public Participator(int participatorID,String name, String institute, String klass) {
		this.setParticipatorID(participatorID);
		this.name = name;
		this.institute = institute;
		this.klass = klass;
	}
    
	public String getDetails() {

		String str="";
		str="编号："+getParticipatorID()
			+" 姓名："+getName()
		    +" 学院："+getInstitute()
		    +" 班级："+getKlass();
		   
		return str;
	}
	//getters and setters
	public int getParticipatorID() {
		return participatorID;
	}

	public void setParticipatorID(int participatorID) {
		this.participatorID = participatorID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getKlass() {
		return klass;
	}

	public void setKlass(String klass) {
		this.klass = klass;
	}

	
}
