package SAP;

public class course {

	public String name, grade, group;
	public int hours, courseGroupNum, courseIDNum, gradeValue;

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

		switch (group){
		case "ANTH": courseGroupNum = 0; break;
		case "CS": courseGroupNum = 1; break;
		case "EET": courseGroupNum = 2; break;
		case "ENG": courseGroupNum = 3; break;
		case "IS": courseGroupNum = 4; break;
		case "MATH": courseGroupNum = 5; break;
		default: courseGroupNum = 6;
		}


	}

	public void setHours(int i) {
		hours = i;

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
	 * 
	 * @return name of course
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return Value of grade
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
	 * 
	 * @return number value of the group the course is in
	 */
	public int getNameNum() {
		return courseGroupNum;
	}
	
	/**
	 * 
	 * @return Number part of the course ID
	 */
	public int getIDNum() {
		return courseIDNum;
	}

	/**
	 * 
	 * @return Credit hours of the course
	 */
	public int getCreditHours() {
		return hours;
	}

}
