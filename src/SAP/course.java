public class course {

	public String name, grade, group, preReq, semester, year;
	public int hours, courseGroupNum, courseIDNum, gradeValue, orAnd;
	public boolean hasPreReq, complete;

	public course(String string) {
		name = string;
		char labCom = name.charAt(name.length()-1);
		if (labCom == 'L'){
			group = name.substring(0, name.length()-5);
			String numberPart = name.substring(name.length() - 4 , name.length()-1);
			courseIDNum = Integer.parseInt(numberPart);
		} else {
			group = name.substring(0, name.length()-4);
			String numberPart = name.substring(name.length() - 3 , name.length());
			courseIDNum = Integer.parseInt(numberPart);
		}
		
	}

	public void setHours(int i) {
		hours = i;
	}
	
	public void setOrAnd(int i){
		orAnd = i;
	}
	
	public void setPreReq(String s){
		if (s.isEmpty()){
			hasPreReq = false;
			
		} else {
			hasPreReq = true;
			preReq = s;
		}
		
	}

	public void setGrade(String string) {
		grade = string;
		switch (grade){
		case "A": gradeValue = 4; break;
		case "B": gradeValue = 3; break;
		case "C": gradeValue = 2; break;
		case "D": gradeValue = 1; break;
		default: gradeValue = 0;
		}

	}

	/**
	 * name of course
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Value of grade
	 * @return gradeValue
	 */
	public int getGradeValue() {
		return gradeValue;
	}

	/**
	 * 
	 * @return grade
	 */
	public String getGrade() {
		return grade;
	}
	
	/**
	 * number value of the group the course is in
	 * @return courseGroupNum
	 */
	public int getNameNum() {
		return courseGroupNum;
	}
	
	/**
	 * Number part of the course ID
	 * @return courseIDNum
	 */
	public int getIDNum() {
		return courseIDNum;
	}
	
	/**
	 * Int based on if something is required
	 * @return orAnd
	 */
	public int getOrAnd(){
		return orAnd;
	}

	/**
	 * Credit hours of the course
	 * @return hours
	 */
	public int getCreditHours() {
		return hours;
	}
	
	public String getPreReq(){
		return preReq;
	}
	
	public boolean hasPreReq(){
		return hasPreReq;
	}

	public void completed() {
		complete = true;
	}
	
	public void resetComplete(){
		complete = false;	
	}
	
	public boolean isCompleted() {
		return complete;
	}

	public void setYearOffered(String s) {
		year = s;
		
	}

	public void setSemesterOffered(String s) {
		semester = s;
		
	}

	public String getSemester() {
		return semester;
	}

	public String getYear() {
		return year;
	}

}
