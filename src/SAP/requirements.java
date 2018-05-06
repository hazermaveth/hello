package SAP;



import java.util.ArrayList;

public class requirements {

	public ArrayList<course> fulfill = new ArrayList<course>();
	public String desc;
	public int creditHours, completeHours;
	public boolean done = false, preReqMet = false;
	public ArrayList<course> takeable = new ArrayList<course>();


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



	public boolean getComplete() {
		return done;
	}

	public void upperDivCheck() {
		for (int i = 0; i < fulfill.size(); i++){
			if((fulfill.get(i)).getIDNum() > 300){
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

	public void checkYear(int year) {
		
		for (int i = 0; i < fulfill.size(); i++){
			if ((fulfill.get(i)).getYear().equals("O")){
				if (year%2 == 1){
					(fulfill.get(i)).completed();
					System.out.println(fulfill.get(i).getName());
				}
			} else if ((fulfill.get(i)).getYear().equals("E")){
				if (year%2 == 0){
					(fulfill.get(i)).completed();
					System.out.println(fulfill.get(i).getName());
				}
			} else if ((fulfill.get(i)).getYear().equals("A")){
				(fulfill.get(i)).completed();
			}


		}
		
		for (int i = 0;i < fulfill.size(); i++){
			if ((fulfill.get(i)).isCompleted()){
				takeable.add(fulfill.get(i));
				System.out.println(fulfill.get(i).getName());
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

}
