package SAP;

public class course {

	public String name;
	public int hours;
	public String grade;
	
	public course(String string) {
		name = string;
	}

	public void setHours(int i) {
		hours = i;
		
	}

	public void setGrade(String string) {
		grade = string;
		
	}

	/**
	 * 
	 * @return name of course
	 */
	public String getName() {
		return name;
	}

}
