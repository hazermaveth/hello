package SAP;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class advisor{
	String studentID;
	ArrayList<course> courses = new ArrayList<course>();
	String major;

	public void start() {
		majorProgress();
		sortCourses();
		printCourses();
		printGrades();
	}

	public advisor(String newID) {
		studentID = newID;	
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

	public void sameMajor(){

		major = "CS";
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

			for(int j = 0; j < courses.size(); j++){
				if (className.equals((courses.get(j).getName()))){
					if(class1.getGradeValue() >= (courses.get(j).getGradeValue())){
						courses.remove(j);
					}
				} 
			}
			courses.add(class1);	
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
		System.out.println("]");
		
		System.out.print("[");
		for(int i = 0; i < courses.size() - 1; i++){
			System.out.print((courses.get(i)).getGradeValue() + ", ");
		}
		System.out.print((courses.get(courses.size()-1)).getGradeValue());
		System.out.println("]");

	}	
}
