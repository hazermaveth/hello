package SAP;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class advisor{
	String studentID;
	ArrayList<course> courses = new ArrayList<course>();
	
	public advisor(String newID) {
		studentID = newID;
		majorProgress();
	}


	private void majorProgress() {
		
		List<String> classesTaken = Arrays.asList("MATH 124 C 4.0", "IS 301 B 3.0", "IS 281 A 3.0", "ENG 305 B 3.0", "EET 340 B 3.0"
				, "CS 102 A 1.0", "IS 315 A 3.0", "CS 451 A 3.0", "CS 234 A 4.0", "ANTH 310 B 3.0", "MATH 132 D 4.0", "MATH 132 B 4.0",
				"IS 343 A 3.0", "IS 316 A 3.0", "CS 360 A 3.0", "CS 357 A 3.0", "CS 301 B 3.0", "CS 472 A 3.0", "CS 461 A 3.0");
		
		for(int i = 0; i <= classesTaken.size()-1; i++){
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
			courses.add(class1);
		}
		
	printCourses();	
		
	}

	
	private void printCourses() {
		
		System.out.print("[");
		for(int i = 0; i < courses.size() - 1; i++){
			System.out.print((courses.get(i)).getName() + ", ");
		}
		System.out.print((courses.get(courses.size()-1)).getName());
		System.out.println("]");
	}
	
	
	

}
