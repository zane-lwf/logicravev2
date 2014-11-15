package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class end {
	private static JLabel BGend = new JLabel("");
	private static JEditorPane result = new JEditorPane();
	private static JPanel page;
	private static int i=4;
	private static String tmp="";
	static JLabel pressStart = new JLabel("");
	
	public end(JPanel p){
		page=p;
	}
	
	public void set(){
		hide();
		tmp="";
		BGend.setIcon(new ImageIcon("src\\Picture\\Background\\ranking.png"));
		BGend.setBounds(0, 0, 850, 600);
		BGend.setVisible(false);
		result.setEnabled(true);
		result.setEditable(false);
		result.setBounds(200, 200, 380, 130);
		result.setText("");
		result.setFont(new Font("Tahoma", Font.PLAIN, 24));
		result.setForeground(Color.gray);
		i=4;
		pressStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				pressStart.setIcon(new ImageIcon("src\\Picture\\text\\continue 2.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pressStart.setIcon(new ImageIcon("src\\Picture\\text\\continue 1.png"));
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressStart.setVisible(false);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				hide();
				rank.setNew(game.getPoint());
				rank.show();
			}
		});
		
		pressStart.setIcon(new ImageIcon("src\\Picture\\text\\continue 1.png"));
		pressStart.setBounds(290, 530, 300, 60);
		page.add(pressStart);
		page.add(result);
		page.add(BGend);
	}
	
	public static String getTmp() {
		return tmp;
	}

	public static void setTmp(String tmp) {
		end.tmp = tmp;
	}

	public static void setI(int i) {
		end.i = i;
	}

	public static void show(){
		BGend.setVisible(true);
		result.setVisible(true);
		pressStart.setVisible(true);
		Thread display = (new Thread(new Runnable() {
			@Override
			public void run() {
				while (i > 0) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							if(i==1){
								result.setText(tmp+"Time\t\t"+(time.getTotalTime()-1)+"\n");
								i--;
								tmp=tmp+"Time\t\t"+(time.getTotalTime()-1)+"\n";
							}
							else if(i==2){
								result.setText(tmp+"Score\t\t"+game.getPoint()+"\n");
								i--;
								tmp=tmp+"Score\t\t"+game.getPoint()+"\n";
							}
							else if(i==3){
								result.setText(tmp+"Total Question\t\t"+game.getNumber()+"\n");
								i--;
								tmp=tmp+"Total Question\t\t"+game.getNumber()+"\n";
							}
							else if(i==4){
								result.setText(tmp+"Correct\t\t"+game.getCorrectPoint()+"\n");
								i--;
								tmp=tmp+"Correct\t\t"+game.getCorrectPoint()+"\n";
							}
						}
					});
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}));
		display.start();
	}
	
	public static void hide(){
		BGend.setVisible(false);
		result.setVisible(false);
		pressStart.setVisible(false);
	}
}
