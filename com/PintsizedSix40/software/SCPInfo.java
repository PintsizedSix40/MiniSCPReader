package com.PintsizedSix40.software;

public class SCPInfo {

	private String item;
	private String oc;
	private String SCP;
	private String desc;
	
	SCPInfo(String a, String b, String c, String d){
		item = a;
		oc = b;
		SCP = c;
		desc = d;
	}
	
	public String constructSSML() {
		String template = "Item Number {itemnum}<br> Object Class {objclass}<br> Special Containment Procedures<br> {specon}<br> Description<br> {desc}<br>";
		template = template.replace("{itemnum}", item).replace("{objclass}", oc).replace("{specon}", SCP).replace("{desc}", desc);
		return template;
	}
	
}
