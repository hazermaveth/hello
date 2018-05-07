package SAP;

import java.util.ArrayList;

public class requirements {

	public ArrayList<course> fulfill = new ArrayList<course>();
	public String desc;
	public int creditHours, completeHours, priority = 1, upperDivClass = 300;
	public boolean done = false, preReqMet = false;
	public ArrayList<course> takeable = new ArrayList<course>();

	/**
	 * Constructor sets the description of the requirement
	 * @param s
	 */
	public requirements(String s) {
		desc = s;
	}
	
	/**
	 * sets the needed credit hours to complete the
	 * requirement
	 * @param i
	 */
	public void setNeededCredit(int i) {
		creditHours = i;
	}
	
	/**
	 * adds course to array fulfill
	 * @param temp
	 */
	public void add(course temp) {
		fulfill.add(temp);
	}

	/**
	 * Sets the priority of a course
	 * @param i
	 */
	public void setPriority(int i){
		priority = i;
	}

	/**
	 * returns the description of the requirement
	 * @return desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * returns the size of the array fulfill
	 * @return fulfill.size()
	 */
	public int size() {
		return fulfill.size();
	}
	
	/**
	 * gets the course at i in the array fulfill
	 * @param i
	 * @return fulfill.get(i)
	 */
	public course getCourse(int i) {
		return fulfill.get(i);
	}

	/**
	 * checks if the student has taken the course
	 * clears sets done to true if credithours ==
	 * completehours or if nothing else is available
	 * @param list
	 */
	public void check(ArrayList<course> list) {
		for (int k = 0; k < fulfill.size(); k++){
			for (int i = 0; i < list.size(); i++){
				if (((fulfill.get(k)).getName()).equals((list.get(i)).getName())){
					if((fulfill.get(k)).getGradeValue() < (list.get(i)).getGradeValue()){
						completeHours += (list.get(i)).getCreditHours();
						(fulfill.get(k)).completed();
					}

				}

			}
		}

		for (int i = 0;i < fulfill.size(); i++){
			if (!(fulfill.get(i)).isCompleted()){
				takeable.add(fulfill.get(i));
			}
		}
		fulfill.clear();
		for (int i = 0;i < takeable.size(); i++){
			(takeable.get(i)).resetComplete();
			fulfill.add(takeable.get(i));
		}
		takeable.clear();

		if (creditHours <= completeHours || fulfill.size() == 0){
			done = true;
		}

	}
	
	/**
	 * used to remove the requirement if it is done or
	 * not available
	 * @return done
	 */
	public boolean getComplete() {
		return done;
	}

	/**
	 * If the student is not able to take upper div
	 */
	public void upperDivCheck() {
		for (int i = 0; i < fulfill.size(); i++){
			if((fulfill.get(i)).getIDNum() > upperDivClass){
				(fulfill.get(i)).completed();
			}


		}

		for (int i = 0;i < fulfill.size(); i++){
			if (!(fulfill.get(i)).isCompleted()){
				takeable.add(fulfill.get(i));
			} 
		}
		fulfill.clear();
		for (int i = 0;i < takeable.size(); i++){
			(takeable.get(i)).resetComplete();
			fulfill.add(takeable.get(i));
		}
		takeable.clear();

		if(fulfill.size() == 0){
			done = true;
		}

	}

	/**
	 * Checks if the student has taken the prerequisite
	 * removes it if not taken and sets the requirement
	 * to done if no courses a available
	 * @param list
	 */
	public void preReqCheck(ArrayList<course> list) {
		for (int i = 0; i < fulfill.size(); i++){
			for (int k = 0; k < list.size(); k++){
				if((fulfill.get(i)).hasPreReq()){
					if(((fulfill.get(i)).getPreReq()).equals((list.get(k)).getName())){
						(fulfill.get(i)).completed(); break;
					} 
				} else {
					(fulfill.get(i)).completed();
				}
			}
		}

		for (int i = 0;i < fulfill.size(); i++){
			if ((fulfill.get(i)).isCompleted()){
				takeable.add(fulfill.get(i));
			} 
		}

		fulfill.clear();
		for (int i = 0;i < takeable.size(); i++){
			(takeable.get(i)).resetComplete();
			fulfill.add(takeable.get(i));
		}
		takeable.clear();

		if(fulfill.size() == 0){
			done = true;
		}
	}
	
	/**
	 * removes all the course that are not available that year
	 * and sets the requirement to done if no courses a available
	 * @param year
	 */
	public void checkYear(int year) {

		for (int i = 0; i < fulfill.size(); i++){
			if ((fulfill.get(i)).getYear().equals("O") && year%2 == 1){
				priority++;
				(fulfill.get(i)).completed();
			} else if ((fulfill.get(i)).getYear().equals("E") && year%2 == 0){
				priority++;
				(fulfill.get(i)).completed();
			} else if ((fulfill.get(i)).getYear().equals("A")){
				(fulfill.get(i)).completed();
			}


		}

		for (int i = 0;i < fulfill.size(); i++){
			if ((fulfill.get(i)).isCompleted()){
				takeable.add(fulfill.get(i));

			} 
		}

		fulfill.clear();
		for (int i = 0;i < takeable.size(); i++){
			(takeable.get(i)).resetComplete();
			fulfill.add(takeable.get(i));

		}
		takeable.clear();

		if(fulfill.size() == 0){
			done = true;
		}
	}

	/**
	 * c is the semester that the student is checking
	 * removes all the course that are not available that semester
	 * and sets the requirement to done if no courses a available
	 * @param c
	 */
	public void checkSemester(char c) {
		for (int i = 0; i < fulfill.size(); i++){
			if ((fulfill.get(i)).getSemester().charAt(0) == c){
				priority++;
				(fulfill.get(i)).completed();
			} else if((fulfill.get(i)).getSemester().charAt(0) == 'B'){
				(fulfill.get(i)).completed();
			}

		}

		for (int i = 0;i < fulfill.size(); i++){
			if ((fulfill.get(i)).isCompleted()){
				takeable.add(fulfill.get(i));

			} 
		}

		fulfill.clear();
		for (int i = 0;i < takeable.size(); i++){
			(takeable.get(i)).resetComplete();
			fulfill.add(takeable.get(i));

		}
		takeable.clear();

		if(fulfill.size() == 0){
			done = true;
		}

	}

	/**
	 * Priority is used to show which requirements based
	 * @return priority
	 */
	public int getpriority() {
		if (fulfill.size()>1 && fulfill.size() < 5){
			priority = 1;
		} else if (fulfill.size()>5){
			priority = 0;
		}
		return priority;
	}

}
