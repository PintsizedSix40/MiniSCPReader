package com.PintsizedSix40.software;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.regex.Matcher;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Scraper {

	
	public static SCPContainer scrapeList(String thousand) {
		String suffix = "";
		if(!thousand.equals("1")) {
			suffix = "-"+thousand;
		}
		String url = "http://www.scp-wiki.net/scp-series"+suffix;
		WebClient client = new WebClient();  
		client.getOptions().setCssEnabled(false);  
		client.getOptions().setJavaScriptEnabled(false);  
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> c = new ArrayList<String>();
		try {  
		  String searchUrl = url;
		  HtmlPage page = client.getPage(searchUrl);
		  for(int m = 2; m < 12; m++) {
		  DomElement SCPs = page.getElementById("toc"+m).getNextElementSibling();
		  BufferedReader bufReader = new BufferedReader(new StringReader(SCPs.asText()));
		  String line=null;
		  
		  while( (line=bufReader.readLine()) != null )
		  {
			  String[] SCP = Util.getSCP(line);
			  if(SCP != null) {
a.add(SCP[0]);
c.add(SCP[1]);
			  }
		  }
		  }
		  SCPContainer cont = new SCPContainer(a, c);
		  return cont;
		  
		  
		}catch(Exception e){
		  e.printStackTrace();
		}
		return null;
		}
	
	public static SCPInfo getPage(String id) {
		String url = "http://www.scp-wiki.net/scp-"+id;
		WebClient client = new WebClient();  
		client.getOptions().setCssEnabled(false);  
		client.getOptions().setJavaScriptEnabled(false);  
		try {  
		  String searchUrl = url;
		  HtmlPage page = client.getPage(searchUrl);
		  
		  DomElement SCPs = page.getElementById("page-content");
		  BufferedReader bufReader = new BufferedReader(new StringReader(SCPs.asText()));
		  String line=null;
		  String full = "";
		  while( (line=bufReader.readLine()) != null )
		  {
			  full += line;
		  }
		  
		  full = full.replace("\n", "").replace("\r", "").replace(".", "<br>");
		  Matcher mat = Util.getSCPInfo(full);
		  return new SCPInfo(mat.group(1), mat.group(2), mat.group(3), mat.group(4));
		  
		}catch(Exception e){
			  e.printStackTrace();
			}
		return null;
	}
	
}
