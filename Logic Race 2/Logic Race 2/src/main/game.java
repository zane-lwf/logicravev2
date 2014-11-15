package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class game {

	static JLabel BG= new JLabel("");
	static JButton choice1 = new JButton("");
	static JButton choice2 = new JButton("");
	static JButton choice3 = new JButton("");
	static JButton choice4 = new JButton("");
	static int quest;
	private static String pic[]={"Blank_Map.png","Blunt_Alloy.png","Cafeteria_Meat.png",
								"CriticalGreatsword.png","CriticalSpear.png","Dagger.png",
								"Familiar_Juice.png","Gruel_Stew.png","Hard_Iron.png",
								"Hinoki.png","Kasu_Seed.png","Kuneri_Fang.png",
								"Ponpata_Song.png","Succulent_Meat.png","Wood_Branch.png",
								"Club_D.png","Greatshield.PNG","MarumenkoHelm_SU.png",
								"Tuba.png","flag.png","Mater_Seed.png",
								"Predator_Pumpkin.png","Warhorse_D.png"};

	public static int getPoint() {
		return point;
	}

	public static int getCorrectPoint() {
		return correctPoint;
	}

	public static void setPoint(int point) {
		game.point = point;
	}

	public static void setCorrectPoint(int correctPoint) {
		game.correctPoint = correctPoint;
	}

	public static void setNumber(int number) {
		Number = number;
	}

	public static int getNumber() {
		return Number;
	}

	private static String dirPic = "src\\Picture\\Item\\";
	static JLabel item1 = new JLabel("");
	static JLabel item2 = new JLabel("");
	static JLabel item3 = new JLabel("");
	static JLabel item4 = new JLabel("");
	static JLabel item5 = new JLabel("");
	static JLabel item6 = new JLabel("");
	static JLabel item7 = new JLabel("");
	static JLabel item8 = new JLabel("");
	static JLabel item9 = new JLabel("");
	static JLabel item10 = new JLabel("");
	static JLabel item11 = new JLabel("");
	
	private static JLabel bug = new JLabel("");
	private static int point=0,correctPoint=0,Number=0;
	private static int ans,combo=0,tmp=0;
	public static int getCombo() {
		return combo;
	}

	public static void setCombo(int combo) {
		game.combo = combo;
	}

	private static int objValue1,objValue2,objValue3,objValue4;
	private static int obj1,obj2,obj3,obj4;
	private static JPanel contentPane;
	private static JLabel scale1 = new JLabel("");
	private static JLabel scale2 = new JLabel("");
	private static JLabel scale3 = new JLabel("");
	private static Cal cal= new Cal();
	public static int nItem=pic.length;
	
	static JLabel tfIcon = new JLabel("");
	
	public game(JPanel ContentPane){
		contentPane=ContentPane;
	}
	
	static void start(){

		item1.setVisible(false);
		item2.setVisible(false);
		item3.setVisible(false);
		item4.setVisible(false);
		item5.setVisible(false);
		item6.setVisible(false);
		item7.setVisible(false);
		item8.setVisible(false);
		item9.setVisible(false);
		item10.setVisible(false);
		item11.setVisible(false);
		choice1.setVisible(false);
		choice3.setVisible(false);
		choice2.setVisible(false);
		choice4.setVisible(false);
		scale1.setVisible(false);
		scale2.setVisible(false);
		scale3.setVisible(false);
	
		end endGame = new end(contentPane);
		endGame.set();
		
		time live=new time(contentPane);
		live.set();
		
		tfIcon.setBounds(447, 232, 300, 300);
		tfIcon.setVisible(false);
		contentPane.add(tfIcon);
		contentPane.add(choice2);
		contentPane.add(choice1);
		contentPane.add(choice3);
		contentPane.add(choice4);
		contentPane.add(item2);
		contentPane.add(item1);
		contentPane.add(item3);
		contentPane.add(item4);
		contentPane.add(item5);
		contentPane.add(item6);
		contentPane.add(item7);
		contentPane.add(item8);
		contentPane.add(item9);
		contentPane.add(item10);
		contentPane.add(item11);
	
		contentPane.add(scale1);
		contentPane.add(scale3);
		contentPane.add(scale2);
		contentPane.add(bug);
		
		live.start();
		
		contentPane.add(BG);
		
		item1.setToolTipText("item1");
		item2.setToolTipText("item2");
		item3.setToolTipText("item3");
		item4.setToolTipText("item4");
		item5.setToolTipText("item5");
		item6.setToolTipText("item6");
		item7.setToolTipText("item7");
		item8.setToolTipText("item8");
		item9.setToolTipText("item9");
		item10.setToolTipText("item10");
		item11.setToolTipText("item11");
		
		choice1.setToolTipText("choice1");
		choice2.setToolTipText("choice2");
		choice3.setToolTipText("choice3");
		choice4.setToolTipText("choice4");
		
		addMouseChoice();
		
		BG.setIcon(new ImageIcon("src\\Picture\\Background\\play.png"));
		BG.setBounds(0, 0, 850, 600);
		
		set();
	}
	
	static void set(){
		item1.setVisible(false);
		item2.setVisible(false);
		item3.setVisible(false);
		item4.setVisible(false);
		item5.setVisible(false);
		item6.setVisible(false);
		item7.setVisible(false);
		item8.setVisible(false);
		item9.setVisible(false);
		item10.setVisible(false);
		item11.setVisible(false);
		choice1.setVisible(false);
		choice3.setVisible(false);
		choice2.setVisible(false);
		choice4.setVisible(false);
		scale1.setVisible(false);
		scale2.setVisible(false);
		scale3.setVisible(false);
		
		cal.randomPic();
		cal.randomValue();
		obj1=cal.getObj1();
		obj2=cal.getObj2();
		obj3=cal.getObj3();
		obj4=cal.getObj4();
		objValue1=cal.getValue1();
		objValue2=cal.getValue2();
		objValue3=cal.getValue3();
		objValue4=cal.getValue4();	
		
		ranPattern();
	}
	
	private static void pattern201(){
		ans=cal.max(objValue1, objValue2);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		Position pixel=new Position(201);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0], y[0], 70, 70);
		item2.setBounds(x[1], y[1], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale1.setBounds(x[2],y[2], 275, 63);
		setChoice(2);
		item1.setVisible(true);
		item2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern202(){
		ans=cal.max(objValue1, objValue2);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		Position pixel=new Position(202);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0], y[0], 70, 70);
		item2.setBounds(x[1], y[1], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale1.setBounds(x[2],y[2], 275, 63);
		setChoice(2);
		item1.setVisible(true);
		item2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern203(){
		ans=cal.max(objValue1, objValue2);
		int locked=setAnsItem();
		if(locked==obj1){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(locked==obj2){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		
		Position pixel=new Position(203);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);
		item8.setBounds(x[8],y[8], 70, 70);
		item9.setBounds(x[9],y[9], 70, 70);
		item2.setBounds(x[1],y[1], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale1.setBounds(x[4],y[4], 275, 63);

		setChoice(2);
		item1.setVisible(true);
		item2.setVisible(true);
		item9.setVisible(true);
		item8.setVisible(true);
		scale1.setVisible(true);
	}
	private static void pattern204(){
		ans=cal.max(objValue1, objValue2);
		Position pixel=new Position(204);
		int locked=setAnsItem();
		if(locked==obj1){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(locked==obj2){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);
		item8.setBounds(x[8],y[8], 70, 70);
		item9.setBounds(x[9],y[9], 70, 70);
		item2.setBounds(x[1],y[1], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale1.setBounds(x[4],y[4], 275, 63);
		setChoice(2);
		item1.setVisible(true);
		item2.setVisible(true);
		item9.setVisible(true);
		item8.setVisible(true);
		scale1.setVisible(true);
}
	
	private static void pattern205(){
		ans=cal.max(objValue1, objValue2);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		
		Position pixel=new Position(205);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);
		item2.setBounds(x[1],y[1], 70, 70);
		item3.setBounds(x[2],y[2], 70, 70);
		
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale1.setBounds(x[3],y[3], 275, 63);
		setChoice(2);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		scale1.setVisible(true);
	}

	private static void pattern206(){
		ans=cal.max(objValue1, objValue2);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		
		Position pixel=new Position(206);
		int[] x=pixel.x();
		int[] y=pixel.y();
			
		item1.setBounds(x[0],y[0], 70, 70);
		item2.setBounds(x[1],y[1], 70, 70);
		item3.setBounds(x[2],y[2], 70, 70);
	
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale1.setBounds(x[3],y[3], 275, 63);
		setChoice(2);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		scale1.setVisible(true);
	}

	private static void pattern207(){
		ans=cal.max(objValue1, objValue2);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		Position pixel=new Position(207);
		int[] x=pixel.x();
		int[] y=pixel.y();
		item1.setBounds(x[0],y[0], 70, 70);
		item2.setBounds(x[1],y[1], 70, 70);
		item3.setBounds(x[2],y[2], 70, 70);
		item4.setBounds(x[3],y[3], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale1.setBounds(x[4],y[4], 275, 63);
		setChoice(2);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		scale1.setVisible(true);
	}

	private static void pattern208(){
		ans=cal.max(objValue1, objValue2);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		Position pixel=new Position(208);
		int[] x=pixel.x();
		int[] y=pixel.y();
		item1.setBounds(x[0],y[0], 70, 70);
		item2.setBounds(x[1],y[1], 70, 70);
		item3.setBounds(x[2],y[2], 70, 70);
		item4.setBounds(x[3],y[3], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale1.setBounds(x[4],y[4], 275, 63);
		setChoice(2);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		scale1.setVisible(true);
	}

	private static void pattern209(){
		ans=cal.max(objValue1, objValue2);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		Position pixel=new Position(209	);
		int[] x=pixel.x();
		int[] y=pixel.y();
		item1.setBounds(x[0],y[0], 70, 70);
		item8.setBounds(x[9],y[9], 70, 70);
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item4.setBounds(x[4],y[4], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale3.png"));
		scale1.setBounds(x[5],y[5], 275, 63);
		setChoice(2);
		item1.setVisible(true);
		item8.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		scale1.setVisible(true);
	}

	private static void pattern210(){
		ans=cal.max(objValue1, objValue2);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		Position pixel=new Position(210);
		int[] x=pixel.x();
		int[] y=pixel.y();	
		item1.setBounds(x[0],y[0], 70, 70);
		item8.setBounds(x[9],y[9], 70, 70);
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item4.setBounds(x[4],y[4], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale3.png"));
		scale1.setBounds(x[5],y[5], 275, 63);
		setChoice(2);
		item1.setVisible(true);
		item8.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern301(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));	
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
		}
		
		Position pixel=new Position(301);
		int[] x=pixel.x();
		int[] y=pixel.y();
		item1.setBounds(x[0],y[0], 70, 70);
		item8.setBounds(x[9],y[9], 70, 70);
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale1.setBounds(x[5],y[5], 275, 63);
		scale2.setBounds(x[4],y[4], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item8.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern302(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));	
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
		}
		
		Position pixel=new Position(302);
		int[] x=pixel.x();
		int[] y=pixel.y();
		item1.setBounds(x[0],y[0], 70, 70);
		item8.setBounds(x[9],y[9], 70, 70);
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale1.setBounds(x[5],y[5], 275, 63);
		scale2.setBounds(x[4],y[4], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item8.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern303(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));	
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
		}
		
		Position pixel=new Position(303);
		int[] x=pixel.x();
		int[] y=pixel.y();
		item1.setBounds(x[0],y[0], 70, 70);
		item8.setBounds(x[9],y[9], 70, 70);
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale1.setBounds(x[5],y[5], 275, 63);
		scale2.setBounds(x[4],y[4], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item8.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern304(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));	
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
		}
		
		Position pixel=new Position(304);
		int[] x=pixel.x();
		int[] y=pixel.y();
		item1.setBounds(x[0],y[0], 70, 70);
		item8.setBounds(x[9],y[9], 70, 70);
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale1.setBounds(x[5],y[5], 275, 63);
		scale2.setBounds(x[4],y[4], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item8.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern305(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		
		Position pixel=new Position(305);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);		
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item4.setBounds(x[9],y[9], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale1.setBounds(x[5],y[5], 275, 63);
		scale2.setBounds(x[4],y[4], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	
	private static void pattern306(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		
		Position pixel=new Position(306);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);		
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item4.setBounds(x[9],y[9], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale1.setBounds(x[5],y[5], 275, 63);
		scale2.setBounds(x[4],y[4], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern307(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));	
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
		}
		
		Position pixel=new Position(307);
		int[] x=pixel.x();
		int[] y=pixel.y();
		item1.setBounds(x[0],y[0], 70, 70);
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale3.png"));
		scale1.setBounds(x[4],y[4], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern308(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		
		Position pixel=new Position(308);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);		
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item4.setBounds(x[4],y[4], 70, 70);
		item5.setBounds(x[5],y[5], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale1.setBounds(x[6],y[6], 275, 63);
		scale2.setBounds(x[7],y[7], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		item5.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern309(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		
		Position pixel=new Position(309);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);		
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item4.setBounds(x[4],y[4], 70, 70);
		item5.setBounds(x[5],y[5], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale1.setBounds(x[6],y[6], 275, 63);
		scale2.setBounds(x[7],y[7], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		item5.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern310(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		
		Position pixel=new Position(310);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);		
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item4.setBounds(x[4],y[4], 70, 70);
		item5.setBounds(x[5],y[5], 70, 70);
		item6.setBounds(x[6],y[6], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale1.setBounds(x[7],y[7], 275, 63);
		scale2.setBounds(x[8],y[8], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		item5.setVisible(true);
		item6.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern311(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		
		Position pixel=new Position(311);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);		
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item4.setBounds(x[4],y[4], 70, 70);
		item5.setBounds(x[5],y[5], 70, 70);
		item6.setBounds(x[6],y[6], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale1.setBounds(x[7],y[7], 275, 63);
		scale2.setBounds(x[8],y[8], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		item5.setVisible(true);
		item6.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern312(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		
		Position pixel=new Position(312);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);		
		item2.setBounds(x[4],y[4], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item8.setBounds(x[2],y[2], 70, 70);
		item5.setBounds(x[5],y[5], 70, 70);
		item6.setBounds(x[6],y[6], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale3.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale1.setBounds(x[7],y[7], 275, 63);
		scale2.setBounds(x[8],y[8], 275, 63);
		scale3.setBounds(x[9],y[9], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item8.setVisible(true);
		item5.setVisible(true);
		item6.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
		scale3.setVisible(true);
	}
	
	private static void pattern313(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		
		Position pixel=new Position(313);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);		
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item4.setBounds(x[4],y[4], 70, 70);
		item5.setBounds(x[5],y[5], 70, 70);
		item6.setBounds(x[6],y[6], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale3.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale3.png"));
		scale1.setBounds(x[7],y[7], 275, 63);
		scale2.setBounds(x[8],y[8], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		item5.setVisible(true);
		item6.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern314(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		
		Position pixel=new Position(314);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);		
		item2.setBounds(x[4],y[4], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item4.setBounds(x[5],y[5], 70, 70);
		item8.setBounds(x[2],y[2], 70, 70);
		item5.setBounds(x[10],y[10], 70, 70);
		item6.setBounds(x[6],y[6], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale3.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale1.setBounds(x[7],y[7], 275, 63);
		scale2.setBounds(x[8],y[8], 275, 63);
		scale3.setBounds(x[9],y[9], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		item8.setVisible(true);
		item5.setVisible(true);
		item6.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
		scale3.setVisible(true);
	}
	
	private static void pattern315(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));	
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
		}
		
		Position pixel=new Position(315);
		int[] x=pixel.x();
		int[] y=pixel.y();
		item1.setBounds(x[0],y[0], 70, 70);
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale3.png"));
		scale1.setBounds(x[4],y[4], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern316(){
		ans=cal.max(objValue1,objValue2,objValue3);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		
		Position pixel=new Position(316);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);		
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item4.setBounds(x[4],y[4], 70, 70);
		item5.setBounds(x[5],y[5], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale1.setBounds(x[6],y[6], 275, 63);
		scale2.setBounds(x[7],y[7], 275, 63);
		setChoice(3);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		item5.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern401(){
		ans=cal.max(objValue1,objValue2,objValue3,objValue4);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj4]));
		}
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj4]));
		}
		else if (obj3==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj4]));
		}
		else {
			item2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj2]));	
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj3]));
		}
		Position pixel=new Position(401);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);		
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item5.setBounds(x[4],y[4], 70, 70);
		item6.setBounds(x[5],y[5], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale3.png"));
		scale1.setBounds(x[6],y[6], 275, 63);
		setChoice(4);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item5.setVisible(true);
		item6.setVisible(true);	
		scale1.setVisible(true);
	}
	
	private static void pattern402(){
		ans=cal.max(objValue1,objValue2,objValue3,objValue4);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item7.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item10.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item11.setIcon(new ImageIcon(dirPic+pic[obj4]));
		}
		
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item7.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item10.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item11.setIcon(new ImageIcon(dirPic+pic[obj4]));
		}
		else if(obj3==locked){ 
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item7.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item10.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item11.setIcon(new ImageIcon(dirPic+pic[obj4]));
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item7.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item10.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item11.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		
		Position pixel=new Position(402);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);		
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item4.setBounds(x[4],y[4], 70, 70);
		item5.setBounds(x[5],y[5], 70, 70);
		item6.setBounds(x[6],y[6], 70, 70);
		item7.setBounds(x[10],y[10], 70, 70);
		item10.setBounds(x[7],y[7], 70, 70);
		item11.setBounds(x[8],y[8], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale3.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale3.png"));
		scale1.setBounds(x[9],y[9], 275, 63);
		scale2.setBounds(x[11],y[11], 275, 63);
		setChoice(4);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		item7.setVisible(true);
		item5.setVisible(true);
		item6.setVisible(true);
		item10.setVisible(true);
		item11.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern403(){
		ans=cal.max(objValue1,objValue2,objValue3,objValue4);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj4]));
			
		}
		
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj4]));
		}
		else if(obj3==locked){ 
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj4]));
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		
		Position pixel=new Position(403);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);	
		item8.setBounds(x[2],y[2], 70, 70);
		item2.setBounds(x[3],y[3], 70, 70);
		item3.setBounds(x[4],y[4], 70, 70);
		item4.setBounds(x[5],y[5], 70, 70);
		item5.setBounds(x[6],y[6], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale3.png"));
		scale3.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		scale1.setBounds(x[7],y[7], 275, 63);
		scale2.setBounds(x[8],y[8], 275, 63);
		scale3.setBounds(x[9],y[9], 275, 63);
		setChoice(4);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		item5.setVisible(true);
		item8.setVisible(true);
		scale3.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern404(){
		ans=cal.max(objValue1,objValue2,objValue3,objValue4);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj2]));
			
		}
		
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		else if(obj3==locked){ 
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		
		Position pixel=new Position(404);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);	
		item8.setBounds(x[10],y[10], 70, 70);
		item2.setBounds(x[3],y[3], 70, 70);
		item3.setBounds(x[4],y[4], 70, 70);
		item4.setBounds(x[5],y[5], 70, 70);
		item5.setBounds(x[6],y[6], 70, 70);
		item6.setBounds(x[7],y[7], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale3.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale2.png"));
		
		scale1.setBounds(x[8],y[8], 275, 63);
		scale2.setBounds(x[9],y[9], 275, 63);
		
		setChoice(4);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		item5.setVisible(true);
		item6.setVisible(true);
		item8.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern405(){
		ans=cal.max(objValue1,objValue2,objValue3,objValue4);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item7.setIcon(new ImageIcon(dirPic+pic[obj2]));
			
		}
		
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item7.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		else if(obj3==locked){ 
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item7.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item7.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		
		Position pixel=new Position(405);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);	
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item4.setBounds(x[4],y[4], 70, 70);
		item5.setBounds(x[5],y[5], 70, 70);
		item6.setBounds(x[7],y[7], 70, 70);
		item7.setBounds(x[10],y[10], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale3.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale3.png"));
		
		scale1.setBounds(x[8],y[8], 275, 63);
		scale2.setBounds(x[9],y[9], 275, 63);
		
		setChoice(4);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		item5.setVisible(true);
		item6.setVisible(true);
		item7.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	private static void pattern406(){
		ans=cal.max(objValue1,objValue2,objValue3,objValue4);
		int locked=setAnsItem();
		if(obj1==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item7.setIcon(new ImageIcon(dirPic+pic[obj2]));
			
		}
		
		else if(obj2==locked){
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item7.setIcon(new ImageIcon(dirPic+pic[obj1]));
		}
		else if(obj3==locked){ 
			item2.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item7.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		else{
			item2.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item4.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item5.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item6.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item7.setIcon(new ImageIcon(dirPic+pic[obj2]));
		}
		
		Position pixel=new Position(406);
		int[] x=pixel.x();
		int[] y=pixel.y();
		
		item1.setBounds(x[0],y[0], 70, 70);	
		item7.setBounds(x[10],y[10], 70, 70);
		item2.setBounds(x[2],y[2], 70, 70);
		item3.setBounds(x[3],y[3], 70, 70);
		item4.setBounds(x[4],y[4], 70, 70);
		item5.setBounds(x[5],y[5], 70, 70);
		item6.setBounds(x[7],y[7], 70, 70);
		scale1.setIcon(new ImageIcon("src\\Picture\\Item\\Scale3.png"));
		scale2.setIcon(new ImageIcon("src\\Picture\\Item\\Scale3.png"));
		
		scale1.setBounds(x[8],y[8], 275, 63);
		scale2.setBounds(x[9],y[9], 275, 63);
		
		setChoice(4);
		item1.setVisible(true);
		item2.setVisible(true);
		item3.setVisible(true);
		item4.setVisible(true);
		item5.setVisible(true);
		item6.setVisible(true);
		item7.setVisible(true);
		scale2.setVisible(true);
		scale1.setVisible(true);
	}
	
	
private static int setAnsItem(){
		if(objValue1==ans){
			item1.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item9.setIcon(new ImageIcon(dirPic+pic[obj1]));
			item8.setIcon(new ImageIcon(dirPic+pic[obj1]));
			return obj1;
		}
		else if (objValue2==ans){
			item1.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item9.setIcon(new ImageIcon(dirPic+pic[obj2]));
			item8.setIcon(new ImageIcon(dirPic+pic[obj2]));
			return obj2;
		}
		else if (objValue3==ans){
			item1.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item9.setIcon(new ImageIcon(dirPic+pic[obj3]));
			item8.setIcon(new ImageIcon(dirPic+pic[obj3]));
			return obj3;
		}
		else {
			item1.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item9.setIcon(new ImageIcon(dirPic+pic[obj4]));
			item8.setIcon(new ImageIcon(dirPic+pic[obj4]));
			return obj4;
		}	
	}

	private static void setChoice(int i){
		switch(i){
		case 2: choice1.setBackground(Color.LIGHT_GRAY);
			choice1.setIcon(new ImageIcon(dirPic+pic[obj1]));
			choice1.setBounds(292,510, 70, 70);
			choice2.setBackground(Color.LIGHT_GRAY);
			choice2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			choice2.setBounds(476,510, 70, 70);
			choice1.setVisible(true);
			choice2.setVisible(true);break;
		case 3:choice1.setBackground(Color.LIGHT_GRAY);
			choice1.setIcon(new ImageIcon(dirPic+pic[obj1]));
			choice1.setBounds(260,510, 70, 70);
			choice2.setBackground(Color.LIGHT_GRAY);
			choice2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			choice2.setBounds(380,510, 70, 70);
			choice3.setBackground(Color.LIGHT_GRAY);
			choice3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			choice3.setBounds(490,510, 70, 70);
			choice1.setVisible(true);
			choice2.setVisible(true);
			choice3.setVisible(true);break;	
		case 4:choice1.setBackground(Color.LIGHT_GRAY);
			choice1.setIcon(new ImageIcon(dirPic+pic[obj1]));
			choice1.setBounds(200,510, 70, 70);
			choice2.setBackground(Color.LIGHT_GRAY);
			choice2.setIcon(new ImageIcon(dirPic+pic[obj2]));
			choice2.setBounds(315,510, 70, 70);
			choice3.setBackground(Color.LIGHT_GRAY);
			choice3.setIcon(new ImageIcon(dirPic+pic[obj3]));
			choice3.setBounds(425,510, 70, 70);
			choice4.setBackground(Color.LIGHT_GRAY);
			choice4.setIcon(new ImageIcon(dirPic+pic[obj4]));
			choice4.setBounds(525,510, 70, 70);
			choice1.setVisible(true);
			choice2.setVisible(true);
			choice3.setVisible(true);
			choice4.setVisible(true);break;
		}	
	}
	
	private static void ranPattern(){
		int nQuest;
		if(combo<=3){
			nQuest=10;
			quest=(int) (Math.random()*nQuest);
		}
		else if (combo<=7){
			nQuest=6;
			quest=((int)(Math.random()*nQuest))+100;
		}
		else if(combo<=11) {
			nQuest=9;
			quest=((int)(Math.random()*nQuest))+200;
		}
		else{
			nQuest=6;
			quest=((int)(Math.random()*nQuest))+300;
		}
		//0-99=easy ,100-199=medium ,200-299=hard ,300+=hell 
		//System.out.println("quest "+quest);
		switch(quest){
		case 0:pattern201();break;
		case 1:pattern202();break;
		case 2:pattern203();break;
		case 3:pattern204();break;
		case 4:pattern205();break;
		case 5:pattern206();break;
		case 6:pattern207();break;
		case 7:pattern208();break;
		case 8:pattern209();break;
		case 9:pattern210();break;
		case 100:pattern301();break;
		case 101:pattern302();break;
		case 102:pattern303();break;
		case 103:pattern304();break;
		case 104:pattern305();break;
		case 105:pattern306();break;
		case 106:pattern307();break;
		case 200:pattern308();break;
		case 201:pattern309();break;
		case 202:pattern310();break;
		case 203:pattern311();break;
		case 204:pattern312();break;
		case 205:pattern313();break;
		case 206:pattern314();break;
		case 207:pattern315();break;
		case 208:pattern316();break;
		case 300:pattern401();break;
		case 301:pattern402();break;
		case 302:pattern403();break;
		case 303:pattern404();break;
		case 304:pattern405();break;
		case 305:pattern406();break;
		}	
	}
	
	private static void correct(){
		anime("True");
		point++;
		correctPoint++;
		point+=combo;
		combo++;
		time.setSec(2000);
		set();
	}
	
	private static void wrong(){
		anime("False");
		point-=4;
		combo=0;
		if(time.getSec()<=4000){
			time.setend(0);
		}
		else{
			time.setSec(-4000);
		}
		set();
	}
	
	public static void anime(final String TrueOrFalse){
		int signal=0;
		final Thread tf = (new Thread(new Runnable() {
			@Override
			public void run() {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						tfIcon.setIcon(new ImageIcon("src\\Picture\\Button\\"+TrueOrFalse+".png"));
						tfIcon.setVisible(true);
					}
				});
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tfIcon.setVisible(false);
			}
		}));
		tf.start();
	}
	
	public static void setStop(){
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public static void setContinue(){
		choice1.setVisible(true);
		choice2.setVisible(true);
		if(quest>=100){
			choice3.setVisible(true);
		}
		if(quest>=300){
			choice4.setVisible(true);
		}
	}
	
	public static void addMouseChoice(){
		choice1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Number++;
				if(ans==objValue1){
					correct();

				}
				else{
					 wrong();
				}
			}
		});
		
		choice2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Number++;
				if(ans==objValue2){
					correct();
				}
				else{
					 wrong();
				}
			}
		});		
		
		choice3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Number++;
				if(ans==objValue3){
					correct();
				}
				else{
					 wrong();
				}
			}
		});
		
		choice4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Number++;
				if(ans==objValue4){
					correct();
				}
				else{
					 wrong();

				}
			}
		});
		
	}
	
	public static void newGame(){
		BG.setVisible(true);
		setContinue();
		pause.show();
		set();
	}
	
	public static void end(){
		item1.setVisible(false);
		item2.setVisible(false);
		item3.setVisible(false);
		item4.setVisible(false);
		item5.setVisible(false);
		item6.setVisible(false);
		item7.setVisible(false);
		item8.setVisible(false);
		item9.setVisible(false);
		item10.setVisible(false);
		item11.setVisible(false);
		choice1.setVisible(false);
		choice3.setVisible(false);
		choice2.setVisible(false);
		choice4.setVisible(false);
		scale1.setVisible(false);
		scale2.setVisible(false);
		scale3.setVisible(false);
		BG.setVisible(false);
	}
	
	public static void superHide(){
		choice1.setBounds(100000,100000, 70, 70);
		choice2.setBounds(100000,100000, 70, 70);
		choice3.setBounds(100000,100000, 70, 70);
		choice4.setBounds(100000,100000, 70, 70);
	}
}
