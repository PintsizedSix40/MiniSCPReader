package com.PintsizedSix40.software;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GUI extends JFrame{

	final public JButton b;
	final public JTextArea tb;
	final public JTextArea snum;
	final public JLabel stitle;
	GUI(){
		b=new JButton("Search");
		tb = new JTextArea();
		JLabel s = new JLabel("SCP-");
		JLabel t = new JLabel("Title-");
		snum = new JTextArea();
		stitle = new JLabel("");
		JButton read = new JButton("Read");
		JButton stop = new JButton("Stop");
		
		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(Scraper.scrapeList("0").getTitles().get(0));
				//System.out.println(Collections.binarySearch(Scraper.scrapeList("0").getTitles(), tb.getText()));
				Runnable run = new Runnable() {
					public void run() {
						
						if(!tb.getText().equalsIgnoreCase("")) {
							for(int x = 0; x < main.maxSCP; x++) {
				SCPContainer scps = main.scparr.getContainers().get(x);
				for(int i = 0; i < scps.getTitles().size(); i++) {
					
					
					if(scps.getTitles().get(i).toLowerCase().contains(tb.getText().toLowerCase())) {
						stitle.setText(scps.getTitles().get(i));
						snum.setText(scps.getIds().get(i));
						return;
				}
				}
				}
				}
				}
				};
				Thread object = new Thread(run);
				object.start();
			}
			
		});
		
		read.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(!snum.getText().equals("")) {
					String text = snum.getText().replaceFirst("^0+(?!$)", "");
					stitle.setText("");
					/*for(int x = 0; x < main.maxSCP; x++) {
						SCPContainer scps = main.scparr.getContainers().get(x);
						if(Integer.parseInt(text)-1 < (x+1)*1000 && Integer.parseInt(text)-1 > x*1000) {
							stitle.setText(scps.getTitles().get(Integer.parseInt(text)-1));
						}
					}*/
					if(text.length() == 1) {
						text = "00"+text;
					} else if(text.length() == 2) {
						text = "0"+text;
					}
					main.speak(Scraper.getPage(text).constructSSML());
				}
					
				
			}
			
		});
		stop.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				main.espeak.kill();
			}
			
		});
		s.setBounds(0, 40, 28, 10);
		snum.setBounds(30, 38, 35, 16);
		tb.setEditable(true);
		b.setBounds(0,10,80,20);// setting button position  
		tb.setBounds(90, 10, 120, 20);
		t.setBounds(75, 40, 28, 10);
		stitle.setBounds(106, 35, 200, 20);
		read.setBounds(0, 70, 68, 20);
		stop.setBounds(70, 70, 68, 20);
		tb.setBorder(BorderFactory.createLineBorder(Color.black));
		snum.setBorder(BorderFactory.createLineBorder(Color.black));
		add(b);//adding button into frame  
		add(tb);
		add(s);
		add(snum);
		add(t);
		add(stitle);
		add(read);
		add(stop);
		setSize(300,300);//frame size 300 width and 300 height  
		setLayout(null);//no layout manager  
		setVisible(true);//now frame will be visible, by default not visible 
		
	}
}
