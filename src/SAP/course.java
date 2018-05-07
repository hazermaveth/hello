package SAP;

public class course {

	public String name, grade, group, preReq, semester, year;
	public int hours, courseGroupNum, courseIDNum, gradeValue, orAnd;
	public boolean hasPreReq, complete;

	/**
	 * Sets the name of the course name and course ID
	 * @param s
	 */
	public course(String s) {
		name = s;
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

	/**
	 * Sets the credit hours that the courses has
	 * @param i
	 */
	public void setHours(int i) {
		hours = i;
	}
	
	/**
	 * Sets the preReq that the courses has
	 * also sets the hasPreReq true or false
	 * based on the string
	 * @param s
	 */
	public void setPreReq(String s){
		if (s.isEmpty()){
			hasPreReq = false;
			
		} else {
			hasPreReq = true;
			preReq = s;
		}
		
	}

	/**
	 * Sets the grade of the course either needed or taken
	 * also sets the grade value
	 * @param s
	 */
	public void setGrade(String s) {
		grade = s;
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
	 * This is used to make sure the course the student took meet
	 * the requirement 
	 * Value of grade
	 * @return gradeValue
	 */
	public int getGradeValue() {
		return gradeValue;
	}

	/**
	 * Used for error checking
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
	 * Credit hours of the course
	 * @return hours
	 */
	public int getCreditHours() {
		return hours;
	}
	
	/**
	 * The prerequisites that the course has
	 * @return preReq
	 */
	public String getPreReq(){
		return preReq;
	}
	
	/**
	 * Returns true if the course have a prerequisites
	 * Returns false if the course does not have a prerequisites
	 * @return hasPreReq
	 */
	public boolean hasPreReq(){
		return hasPreReq;
	}

	/**
	 * Sets complete to be true so that it can be cleared or saved
	 */
	public void completed() {
		complete = true;
	}
	
	/**
	 * Sets complete to false so that it can be cleared or saved
	 */
	public void resetComplete(){
		complete = false;	
	}
	
	/**
	 * used for 
	 * @return complete
	 */
	public boolean isCompleted() {
		return complete;
	}

	/**
	 * sets the year that a course is offered
	 * E for even years
	 * O for odd years
	 * A for every year
	 * @param s
	 */
	public void setYearOffered(String s) {
		year = s;
		
	}

	/**
	 * sets the semester that a course is offered
	 * F for fall
	 * S for spring
	 * B for both
	 * @param s
	 */
	public void setSemesterOffered(String s) {
		semester = s;
		
	}

	/**
	 * returns the type of semester a course is offered
	 * F for fall
	 * S for spring
	 * B for both
	 * @return semester
	 */
	public String getSemester() {
		return semester;
	}

	/**
	 * returns the type of year a course is offered
	 * E for even years
	 * O for odd years
	 * A for every year
	 * @return year
	 */
	public String getYear() {
		return year;
	}

}
