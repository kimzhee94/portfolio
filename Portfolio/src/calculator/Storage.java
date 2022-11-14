package calculator;

import java.util.*;

public class Storage {

	List<String> savedList = new ArrayList<>();
	
	public void putSavedList(int value) {
		//value = "[" + (this.savedList.size() + 1) + "] " + value;
		savedList.add(String.valueOf(value));
	}
	
	public List<String> getSavedList() {
		return this.savedList;
	}
	
	public String getLastResult() {
		if(savedList.size() > 0) {
			return savedList.get(savedList.size()-1);
		} else {
			return null;
		}
	}
	
}
