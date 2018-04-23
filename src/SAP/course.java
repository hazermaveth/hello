package SAP;

public class course {

public String name, grade, group;
	public int hours, courseNameNum, courseIDNum, gradeValue;

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
		case "ANTH": courseNameNum = 0; break;
		case "CS": courseNameNum = 1; break;
		case "EET": courseNameNum = 2; break;
		case "ENG": courseNameNum = 3; break;
		case "IS": courseNameNum = 4; break;
		case "MATH": courseNameNum = 5; break;
		default: courseNameNum = 6;
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
	
	public int getGradeValue() {
		return gradeValue;
	}

	public String getGrade() {
		return grade;
	}
	
	public int getNameNum() {
		return courseNameNum;
	}
	
	public int getIDNum() {
		return courseIDNum;
	}

}
