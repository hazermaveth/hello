package SAP;

import java.util.ArrayList;

public class requirements {
	public ArrayList<course> fulfill = new ArrayList<course>();
	public String desc;
	public int creditHours;
	
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
	
	
}
