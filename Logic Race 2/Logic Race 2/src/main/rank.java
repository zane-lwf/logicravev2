package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class rank {
	private static JPanel Page;
	private static JEditorPane textRank = new JEditorPane();
	private static JLabel BGrank = new JLabel("");
	private static JLabel pressStart = new JLabel("");
	private static String tmp="";
	private static int point[]={0,0,0,0,0,0,0,0,0},indextmp=6;
	private static String name[]={"1","2","3","4","5","6","7","8"};
	private static File file = new File("file.txt");
	private static BufferedReader reader = null;
	private static JTextField textField = new JTextField();
	private static JButton btnSubmit = new JButton("submit");
	
	public rank(JPanel page){
		Page=page;
	}
	
	public void set(){
		hide();
		
		textField.setBounds(270, 430, 150, 20);
		Page.add(textField);
		textField.setColumns(10);
		
		textField.setText("Enter Your Name");
		
		btnSubmit.setBounds(439, 429, 90, 23);
		Page.add(btnSubmit);
		
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {	
				String player="";
				player = textField.getText();
				if(player.length()>7){
					textField.setText("only 1-7 character");
				}
				else{
					tmp="";
					name[indextmp]=player;
					for(int i =0;i<5;i++){
						tmp+=name[i]+"\t\t";
						tmp+=point[i]+"\n";
					}
					textRank.setText(tmp);
					try {
				        BufferedWriter out = new BufferedWriter(new FileWriter("file.txt"));
				            for (int i = 0; i < 5; i++) {
				                out.write(point[i]+"");
				                out.newLine();
				                out.write(name[i]);
				                out.newLine();
				            }
				            out.close();
				        } catch (IOException e) {}
				}
				
			}
		});
		
		
		pressStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				pressStart.setIcon(new ImageIcon("src\\Picture\\Text\\continue 2.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pressStart.setIcon(new ImageIcon("src\\Picture\\Text\\continue 1.png"));
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {	
				hide();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				index.returnHome();
			}
		});
		
		pressStart.setIcon(new ImageIcon("src\\Picture\\Text\\continue 1.png"));
		pressStart.setBounds(290, 530, 300, 60);
		Page.add(pressStart);

		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;
		    int i=0;
		    while (i<5) {
		    	text = reader.readLine();
		        tmp+=text+"\t";
		        text = reader.readLine();
		        tmp+=text+"\n";
		        i++;
		    }
		} catch (FileNotFoundException e) {
			try {
				File file = new File("file.txt");
				if (file.createNewFile()){
				System.out.println("File is created!");
				}else{
				System.out.println("File already exists.");
				}
				} catch (IOException err) {
				e.printStackTrace();
				}
			try {
		        BufferedWriter out = new BufferedWriter(new FileWriter("file.txt"));
		            for (int i = 0; i < 5; i++) {
		                out.write(point[i]+"");
		                out.newLine();
		                out.write(name[i]);
		                out.newLine();
		            }
		            out.close();
		        } catch (IOException errrr) {}
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}
		textRank.setText(tmp);
		textRank.setBounds(190, 220, 415, 170);
		textRank.setEditable(false);
		textRank.setBackground(Color.white);
		textRank.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Page.add(textRank);
		BGrank.setBackground(new Color(0, 0, 0));
		BGrank.setIcon(new ImageIcon("src\\Picture\\Background\\ranking.png"));
		BGrank.setBounds(0, 0, 850, 600);
		Page.add(BGrank);
	}
	
	public static void show (){
		BGrank.setVisible(true);
		textRank.setVisible(true);
		pressStart.setVisible(true);
	}
	public static void hide (){
		textRank.setVisible(false);
		BGrank.setVisible(false);
		pressStart.setVisible(false);
		btnSubmit.setVisible(false);
		textField.setVisible(false);
	}
	
	public static void setNew(int s){
		int n = 5;
		int signal=0;
		tmp="";
		try {
			reader = new BufferedReader(new FileReader(file));
		    String text = null;
		    for (int i = 0; i<n ; i++) {
		    	try{
			    	text = reader.readLine();
			    	System.out.print(text);
			        if(Integer.parseInt(text)<=s){
			        	point[i]=s;
			        	indextmp=i;
			        	signal=1;
			        	s=-9999;
			        	i++;
			        }
			        point[i]=Integer.parseInt(text);
			        
			    	text = reader.readLine();
			        if(signal==1){
			        	i--;
			        	name[i]="***********";
			        	signal=2;
			        	i++;
			        }
			        name[i]=text;
		    }catch(Exception er){
		    }
		    }
		    
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();   
		        }
		    } catch (IOException e) {
		    }
		}
		for(int i=0;i<5;i++){
			tmp+=name[i]+"\t\t";
			tmp+=point[i]+"\n";
		}
		textRank.setText(tmp);
		if(signal==2){
			btnSubmit.setVisible(true);
			textField.setVisible(true);
		}

	}
}
