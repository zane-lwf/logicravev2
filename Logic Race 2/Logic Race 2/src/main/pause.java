package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class pause  {
	private static JPanel page;
	private static JLabel btnPause = new JLabel("");
	private static JLabel BGpause = new JLabel("");
	private static int signal=0;
	static time stop = new time();
	
	public static int getSignal() {
		return signal;
	}

	public pause(JPanel p){
		page=p;		
	}
	
	public void set(){
		btnPause.setVisible(true);
		btnPause.setIcon(new ImageIcon("src\\Picture\\Text\\pause1.png"));
		btnPause.setBounds(650,550, 134, 46);
		page.add(btnPause);
		signal=0;
		btnPause.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent arg0) {
			if(signal==0){
				btnPause.setIcon(new ImageIcon("src\\Picture\\Text\\pause2.png"));
			}
			else{
				btnPause.setIcon(new ImageIcon("src\\Picture\\Text\\resume2.png"));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(signal==0){
				btnPause.setIcon(new ImageIcon("src\\Picture\\Text\\pause1.png"));
			}
			else{
				btnPause.setIcon(new ImageIcon("src\\Picture\\Text\\resume1.png"));
			}
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			System.out.print(signal+" ");
			if(signal==0){
				game.setStop();
				btnPause.setBounds(280, 400, 258, 79);
				btnPause.setIcon(new ImageIcon("src\\Picture\\Text\\resume1.png"));
				BGpause.setVisible(true);
				signal=1;
			}
			else{
				game.setContinue();
				BGpause.setVisible(false);
				btnPause.setBounds(650,550, 134, 46);
				btnPause.setIcon(new ImageIcon("src\\Picture\\Text\\pause1.png"));
				signal=0;
			}
		}
	});
	BGpause.setVisible(false);
	BGpause.setIcon(new ImageIcon("src\\Picture\\Background\\BGpause.png"));
	BGpause.setBounds(0, 0, 850, 600);
	page.add(BGpause);	
	}
	
	public static void hide(){
		btnPause.setVisible(false);
		BGpause.setVisible(false);
	}
	
	public static void show(){
		btnPause.setVisible(true);
	}
}
