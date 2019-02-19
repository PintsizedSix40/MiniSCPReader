package com.PintsizedSix40.software;

import com.harium.hci.espeak.Espeak;
import com.harium.hci.espeak.Voice;

public class main {

	static Espeak espeak;
	static Voice manVoice;
	public static GUI gui;
	public static int maxSCP;
	public static SCPContainerArray scparr;
	public static void main(String[] args) {
		scparr = new SCPContainerArray();
		manVoice = new Voice();
		manVoice.setName("en-us");
		manVoice.setAmplitude(200);
		manVoice.setPitch(70);
		manVoice.setSpeed(120);
		manVoice.setVariant(true, 7);
		espeak = new Espeak(manVoice);
		maxSCP = 5;
		//scrape
		for(int x = 0; x < maxSCP; x++) {
			scparr.addContainer(Scraper.scrapeList(Integer.toString(x+1)));
		}
		gui = new GUI();
	}
	
	public static void speak(String in) {
		espeak.speak(in);
	}
	
}
