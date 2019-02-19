package com.PintsizedSix40.software;

import java.util.ArrayList;

public class SCPContainerArray {

	private ArrayList<SCPContainer> scps = new ArrayList<SCPContainer>();
	
	SCPContainerArray(){
		
	}
	public void addContainer(SCPContainer cont) {
		scps.add(cont);
	}
	public ArrayList<SCPContainer> getContainers(){
		return scps;
	}
}
