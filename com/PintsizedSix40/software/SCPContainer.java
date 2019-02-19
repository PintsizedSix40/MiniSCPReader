package com.PintsizedSix40.software;

import java.util.ArrayList;
import java.util.HashMap;

public class SCPContainer {

	ArrayList<String> a;
	ArrayList<String> c;
	SCPContainer(ArrayList<String> ids, ArrayList<String> titles){
		a = ids;
		c = titles;
	}
	
	public ArrayList<String> getIds() {
		return a;
	}
	public ArrayList<String> getTitles() {
		return c;
	}
	
	
}
