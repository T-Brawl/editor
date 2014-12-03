package plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TimeTest {

	protected class WhatTimeIsIt implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(java.util.Calendar.getInstance().getTime());			
		}
		
		
	}	
	
	protected WhatTimeIsIt clock = new WhatTimeIsIt();
	
	public static void main(String[] args) {
		TimeTest main = new TimeTest();
		Timer tictac = new Timer(1000,main.clock);
		tictac.start();
		while(true);
	}

}
