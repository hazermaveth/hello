package SAP;

import java.util.ArrayList;

public class requirements {

	public ArrayList<course> fulfill = new ArrayList<course>();
	public String desc;
	public int creditHours, completeHours;
	public boolean done = false;
	public ArrayList<Integer> miniReq = new ArrayList<Integer>();

	public requirements(String s) {
		desc = s;
	}

	public void setNeededCredit(int i) {
		creditHours = i;
	}

	public void add(course temp) {
		fulfill.add(temp);
	}

	public String getDesc() {
		return desc;
	}

	public int size() {
		return fulfill.size();
	}

	public course getCourse(int i) {
		return fulfill.get(i);
	}

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
		if (creditHours <= completeHours){
			done = true;
		}
		
		for (int i = 0; i < fulfill.size(); i++){
			if ((fulfill.get(i)).isCompleted()){
				fulfill.remove(i);
			}
		}
	}
	
	

	public boolean getComplete() {
		return done;
	}

	public void removeUpperDiv() {
		// any > 300 remove
		// if size == 0 mark complete
		
	}
}
