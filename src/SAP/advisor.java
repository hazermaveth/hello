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
		//printCourses();
		//printGrades();
		//printCreditHours();
		reqComplete();
		//printReq();
	}



	public advisor(String newID) {
		studentID = newID;
		setMajor("CS");
	}

	public void setMajor(String string) {
		major = string;	
	}

	public void sortCourses() {
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

	public void majorProgress() {
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

	public void reqSetUpGen() {
		List<String> requirmentsList = Arrays.asList("UNIV 101 Freshman Seminar, 3, UNIV 101, D, 3", "Communicating Effectively (ENG 102), 3, ENG 102, C, 3", "Communicating Effectively (ENG 104), 3, ENG 104, C, 3",
				"Communicating Effectively (COMM), 3, COMM 101, D, 3", "Communicating Effectively (COMM), 3, COMM 102, D, 3", "Communicating Effectively (COMM), 3, COMM 104, D, 3",
				"Understanding and Applying Mathematical Principles, 3, MATH 113, D, 3", "Understanding and Applying Mathematical Principles, 3, MATH 119, D, 3",
				"Understanding and Applying Mathematical Principles, 3, MATH 120, D, 3", "Understanding and Applying Mathematical Principles, 3, MATH 124, D, 3", 
				"Understanding and Applying Mathematical Principles, 3, MATH 213, D, 3");

		String credit = "";
		String reqCourse = "";
		int creditHours = 0;
		String requirmentOne = requirmentsList.get(0);

		String nameOne = requirmentOne.substring(0, requirmentOne.indexOf(",")); requirmentOne = requirmentOne.substring(requirmentOne.indexOf(",") + 2, requirmentOne.length());
		String creditNeed = requirmentOne.substring(0, requirmentOne.indexOf(",")); requirmentOne = requirmentOne.substring(requirmentOne.indexOf(",") + 2, requirmentOne.length());
		String courseName = requirmentOne.substring(0, requirmentOne.indexOf(",")); requirmentOne = requirmentOne.substring(requirmentOne.indexOf(",") + 2, requirmentOne.length());
		String grade = requirmentOne.substring(0, requirmentOne.indexOf(",")); requirmentOne = requirmentOne.substring(requirmentOne.indexOf(",") + 2, requirmentOne.length());

		int creditHoursNeed = Integer.parseInt(creditNeed);

		if(requirmentOne.length() > 1){
			credit = requirmentOne.substring(0, requirmentOne.indexOf(","));
			creditHours = Integer.parseInt(credit);
			reqCourse = requirmentOne.substring(requirmentOne.indexOf(",") + 2, requirmentOne.length());
		} else {
			credit = requirmentOne.substring(0, requirmentOne.length());
			creditHours = Integer.parseInt(credit);
		}

		requirements first = new requirements(nameOne);
		first.setNeededCredit(creditHoursNeed);

		course temp1 = new course(courseName);
		temp1.setGrade(grade);
		temp1.setPreReq(reqCourse);
		temp1.setHours(creditHours);

		first.add(temp1);
		req.add(first);

		for (int i = 1; i < requirmentsList.size(); i++){

			credit = "";
			reqCourse = "";
			creditHours = 0;
			requirmentOne = requirmentsList.get(i);

			nameOne = requirmentOne.substring(0, requirmentOne.indexOf(",")); requirmentOne = requirmentOne.substring(requirmentOne.indexOf(",") + 2, requirmentOne.length());
			creditNeed = requirmentOne.substring(0, requirmentOne.indexOf(",")); requirmentOne = requirmentOne.substring(requirmentOne.indexOf(",") + 2, requirmentOne.length());
			courseName = requirmentOne.substring(0, requirmentOne.indexOf(",")); requirmentOne = requirmentOne.substring(requirmentOne.indexOf(",") + 2, requirmentOne.length());
			grade = requirmentOne.substring(0, requirmentOne.indexOf(",")); requirmentOne = requirmentOne.substring(requirmentOne.indexOf(",") + 2, requirmentOne.length());
			creditHoursNeed = Integer.parseInt(creditNeed);

			if(requirmentOne.length() > 1){
				credit = requirmentOne.substring(0, requirmentOne.indexOf(","));
				creditHours = Integer.parseInt(credit);
				reqCourse = requirmentOne.substring(requirmentOne.indexOf(",") + 2, requirmentOne.length());
			} else {
				credit = requirmentOne.substring(0, requirmentOne.length());
				creditHours = Integer.parseInt(credit);
			}

			if(nameOne.equals((req.get(req.size()-1).getDesc()))){
				course temp2 = new course(courseName);
				temp2.setGrade(grade);
				temp2.setPreReq(reqCourse);
				temp2.setHours(creditHours);

				(req.get(req.size()-1)).add(temp2);
				
			} else {
				requirements next = new requirements(nameOne);
				next.setNeededCredit(creditHoursNeed);

				course temp2 = new course(courseName);
				temp2.setGrade(grade);
				temp2.setPreReq(reqCourse);
				temp2.setHours(creditHours);

				next.add(temp2);
				req.add(next);
			}

		}
	}

	public void reqComplete() {
		for(int i = 0; i < req.size(); i++){
			(req.get(i)).check(courses);	
		}

		int i = 0;
		while (i < req.size()){
			if ((req.get(i)).getComplete()){
				req.remove(i);
			} else {
				i++;
			}
		}

	}

	public void printReq() {
		for(int i = 0; i < req.size(); i++){
			System.out.println((req.get(i)).getDesc());
			System.out.println("\t" + ((req.get(i)).getCourse(0)).getName());
			for(int j = 1; j < (req.get(i)).size(); j++){
				System.out.println("\tor " + ((req.get(i)).getCourse(j)).getName());
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

	public void printGrades() {
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

	public void printCreditHours() {
		System.out.print("[");
		for(int i = 0; i < courses.size() - 1; i++){
			System.out.print((courses.get(i)).getCreditHours() + ", ");
		}
		System.out.print((courses.get(courses.size()-1)).getCreditHours());
		System.out.println("] - Credit Hours");


	}


}
