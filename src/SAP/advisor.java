package SAP;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class advisor{
	String studentID;
	ArrayList<course> courses = new ArrayList<course>();
	ArrayList<requirements> req = new ArrayList<requirements>();
	String major;

	/***
	 * 
	 */
	public void start() {
		majorProgress();
		sortCourses();
		reqSetUpGen();
		//reqSetUpMajor();
		printCourses();
		printGrades();
		printCreditHours();
	}




	public advisor(String newID) {
		studentID = newID;
		setMajor("CS");
	}

	public void setMajor(String string) {
		major = string;	
	}

	private void sortCourses() {
		for(int i = 0; i < courses.size(); i++){
			for(int j = 0; j < courses.size()-1; j++){
				if((courses.get(j)).getIDNum() > (courses.get(j+1)).getIDNum()){
					course class1 = courses.get(j+1);
					courses.set(j+1, courses.get(j));
					courses.set(j, class1);
				}
			}
		}

		for(int i = 0; i < courses.size(); i++){
			for(int j = 0; j < courses.size()-1; j++){
				if((courses.get(j)).getNameNum() > (courses.get(j+1)).getNameNum()){
					course class1 = courses.get(j+1);
					courses.set(j+1, courses.get(j));
					courses.set(j, class1);
				}
			}
		}
	}

	private void majorProgress() {
		List<String> classesTaken = Arrays.asList("MATH 124 C 4.0", "IS 301 B 3.0", "IS 281 A 3.0", "ENG 305 B 3.0", "EET 340 B 3.0"
				, "CS 102 A 1.0", "IS 315 A 3.0", "CS 451 A 3.0", "CS 234 A 4.0", "ANTH 310 B 3.0", "MATH 132 D 4.0", "MATH 132 B 4.0",
				"IS 343 A 3.0", "IS 316 A 3.0", "CS 360 A 3.0", "CS 357 A 3.0", "CS 301 B 3.0", "CS 472 A 3.0", "CS 461 A 3.0");

		for(int i = 0; i < classesTaken.size(); i++){
			String current = classesTaken.get(i);
			String className = current.substring(0, current.length()-6);
			String classGrade = current.substring(current.length()-5, current.length()-4);
			String currentCHours = current.substring(current.length()-3, current.length()-2);
			int classCH = Integer.parseInt(currentCHours);
			/*System.out.println(className);
			System.out.println(classGrade);
			System.out.println(classCH);*/	

			course class1 = new course(className);
			class1.setGrade(classGrade);
			class1.setHours(classCH);

			//I do not think we need this, in fact I think this would cause problems.
			/*
			for(int j = 0; j < courses.size(); j++){
				if (className.equals((courses.get(j).getName()))){
					if(class1.getGradeValue() >= (courses.get(j).getGradeValue())){
						courses.remove(j);
					}
				} 
			}
			 */
			courses.add(class1);	
		}
	}

	private void reqSetUpGen() {
		List<String> requirmentsList = Arrays.asList("UNIV 101 Freshman Seminar, 3, 1, UNIV 101 D 3", "Communicating Effectively, 9, 1, ENG 102 C 3", "Communicating Effectively, 9, 2, ENG 104 C 3",
				"Communicating Effectively, 9, 3, COMM 101 D 3", "Communicating Effectively, 9, 3, COMM 102 D 3", "Communicating Effectively, 9, COMM 102 D 3",
				"Understanding and Applying Mathematical Principles, 3, MATH 113 D 3", "Understanding and Applying Mathematical Principles, 3, MATH 119 D 3",
				"Understanding and Applying Mathematical Principles, 3, MATH 120 D 3", "Understanding and Applying Mathematical Principles, 3, MATH 124 D 3", 
				"Understanding and Applying Mathematical Principles, 3, MATH 213 D 3");

		String requirmentOne = requirmentsList.get(0);
		String r1 = requirmentOne.substring(0, requirmentOne.indexOf(",")); String requirmentOne = requirmentOne.substring(requirmentOne.indexOf(",") + 2, requirmentOne.length());
		System.out.println(r1);
		System.out.println(requirmentOne);

		for (int i = 1; i < requirmentsList.size(); i++){
			String tempReq = requirmentsList.get(i);
			String r2 = tempReq.substring(0, tempReq.indexOf(",")); tempReq = tempReq.substring(tempReq.indexOf(",") + 2, tempReq.length());

			String sameReq = requirmentsList.get(i-1);
			String s2 = sameReq.substring(0, sameReq.indexOf(","));
			if(r2.equals(s2)){
				System.out.println(tempReq);
			} else {
				System.out.println(r2);
				System.out.println(tempReq);
			}
		}

	}

	public void printCourses() {

		System.out.print("[");
		for(int i = 0; i < courses.size() - 1; i++){
			System.out.print((courses.get(i)).getName() + ", ");
		}
		System.out.print((courses.get(courses.size()-1)).getName());
		System.out.println("]");

	}

	private void printGrades() {
		System.out.print("[");
		for(int i = 0; i < courses.size() - 1; i++){
			System.out.print((courses.get(i)).getGrade() + ", ");
		}
		System.out.print((courses.get(courses.size()-1)).getGrade());
		System.out.println("] - Grades");


		System.out.print("[");
		for(int i = 0; i < courses.size() - 1; i++){
			System.out.print((courses.get(i)).getGradeValue() + ", ");
		}
		System.out.print((courses.get(courses.size()-1)).getGradeValue());
		System.out.println("] - Value of the Grades");

	}
	
	private void printCreditHours() {
		System.out.print("[");
		for(int i = 0; i < courses.size() - 1; i++){
			System.out.print((courses.get(i)).getCreditHours() + ", ");
		}
		System.out.print((courses.get(courses.size()-1)).getCreditHours());
		System.out.println("] - Credit Hours");


	}


}
