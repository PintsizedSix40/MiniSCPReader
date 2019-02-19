package com.PintsizedSix40.software;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

	public static String redact(String in) {
		return in.replaceAll("█+", "REDACTED");
	}
	
	public static String[] getSCP(String in) {
		Matcher mat = Pattern.compile("(SCP)(-)(.*)( )(-)( )(.*)").matcher(in);
		if(mat.find()) {
			String[] info = new String[2];
			info[0] = mat.group(3);
			info[1] = mat.group(7);
			return info;
		}
		return null;
	}
	
	public static Matcher getSCPInfo(String in) {
		Matcher mat = Pattern.compile("Item #: (.*)Object Class: (.*)Special Containment Procedures: (.*)Description: (.*)«.*").matcher(in);
	if(mat.find()) {
		return mat;
	}
	return null;
	}
	
}
