package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class time extends Thread {

	private static JPanel Content;
	private static int sec=1000000000,totalTime=0;
	private static JLabel showTime = new JLabel("Time lef90t : "+sec/1000);
	private static JLabel BGindex = new JLabel("");
	private static int sign=0,inGame=0;
	
	public time(JPanel content){
		Content=content;
		showTime.setBounds(300, 300, 100, 100);
		Content.add(showTime);
	}
	
	public time(){
	}
	
	
	public static void setTotalTime(int totalTime) {
		time.totalTime = totalTime;
	}



	public void set(){
		showTime.setBounds(650, 20, 200,100);
		sec=10000;
		showTime.setFont(new Font("Tahoma", Font.PLAIN, 24));
		showTime.setForeground(Color.WHITE);
		Content.add(showTime);
	}
	
	public void run(){
		while (true) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							if((pause.getSignal()==0 && sign==0)&&inGame==0){
								sec-=1000;
								if(sec<10000){
									totalTime++;
								}
								System.out.println(sec);
							}
							
							showTime.setText("Time left : "+sec/1000);
							
							if(sec<0){
								sign=1;
								sec=10000;
							}
							
							if(sign==1){
								System.out.println("-------------------End-------------------");
								BGindex.setVisible(true);
								pause.hide();
								game.end();
								end.show();
								time.hide();
								inGame=1;
								sign=0;
							}
						}
					});
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
	}

	public static void setSec(int sec) {
		time.sec += sec;
	}

	public static int getSec() {
		return sec;
	}

	public static int getTotalTime() {
		return totalTime;
	}
	
	public static void setend(int sec) {
		time.sec = sec;
	}
	
	public static void hide(){
		showTime.setVisible(false);
		
	}
	
	public static void show(){
		showTime.setVisible(true);
	}

	public static void setInGame(int inGame) {
		time.inGame = inGame;
	}
	
	
}