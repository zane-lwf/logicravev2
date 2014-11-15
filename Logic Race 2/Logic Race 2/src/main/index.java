package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import java.awt.Font;

class index extends JFrame {
	private static JLabel pressStart = new JLabel("");
	private static JLabel highScore = new JLabel("");
	private static JLabel credit = new JLabel("");
	private static JLabel back = new JLabel("");
	public static JPanel contentPane;
	private static JLabel BGindex = new JLabel("");
	static int Bug=1;
	
	public index() {
		page();
	}
	static int i = 3;
	private JLabel numPic;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @return
	 */
	private void page() {
		game.setStop();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 806, 629);
		contentPane = new JPanel();
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setTitle("Logic Race II");
		
		rank high = new rank(contentPane);
		high.set();
		
		time.setInGame(1);
		
		final game a= new game(contentPane);
		pause stop = new pause(contentPane);
		
		stop.set();
		
		pause.hide();
		time.setSec(1000000000-time.getSec());
		
		back.setIcon(new ImageIcon("src\\Picture\\Text\\back 1.png"));
		back.setBounds(650,550, 253, 50);
		contentPane.add(back);
		
		time live = new time(contentPane);
		live = new time(contentPane);
		
		credit.setIcon(new ImageIcon("src\\Picture\\Text\\Credit 1.png"));
		credit.setBounds(310, 520, 253, 50);
		contentPane.add(credit);
		
		numPic = new JLabel("");
		numPic.setIcon(new ImageIcon("src\\Picture\\Text\\1.png"));
		numPic.setBounds(329, 200, 135, 169);
		contentPane.add(numPic);
		numPic.setVisible(false);
		
		BGindex.setBackground(new Color(0, 0, 0));
		BGindex.setIcon(new ImageIcon("src\\Picture\\Background\\index.jpg"));
		BGindex.setBounds(0, 0, 850, 600);
		
		contentPane.add(highScore);
		contentPane.add(pressStart);
		contentPane.add(BGindex);
		
		game.setStop();

		pressStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				pressStart.setIcon(new ImageIcon("src\\Picture\\Button\\press02.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pressStart.setIcon(new ImageIcon("src\\Picture\\Button\\press01.png"));
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				i=3;
				hide();
				BGindex.setVisible(true);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				(new Thread(new Runnable() {
					@Override
					public void run() {
						numPic.setVisible(true);
						BGindex.setIcon(new ImageIcon("src\\Picture\\Background\\play.png"));
						while (i > 0) {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									numPic.setIcon(new ImageIcon("src\\Picture\\Text\\" + i + ".png"));
									i--;
								}
							});
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						time.setSec(10000-time.getSec());
						BGindex.setVisible(false);
						numPic.setVisible(false);
						System.out.print(11000-time.getSec());
						game.setCorrectPoint(0);
						end.setTmp("");
						end.setI(4);
						time.show();
						time.setTotalTime(0);
						game.setNumber(0);
						game.setPoint(0);
						game.setCombo(0);
						game.newGame();
						time.setInGame(0);					}
				})).start();
			}
			
		});
		
		pressStart.setIcon(new ImageIcon("src\\Picture\\Button\\press01.png"));
		pressStart.setBounds(260, 380, 300, 60);
		
		back.setVisible(false);
		
		BGindex.setForeground(SystemColor.desktop);
		BGindex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		highScore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				highScore.setIcon(new ImageIcon("src\\Picture\\Text\\High Score 2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				highScore.setIcon(new ImageIcon("src\\Picture\\Text\\High Score 1.png"));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hide();
				game.setStop();
				rank.show();
			}
		});
		
		highScore.setIcon(new ImageIcon("src\\Picture\\Text\\High Score 1.png"));
		highScore.setBounds(275, 455, 253, 50);
	
		credit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				credit.setIcon(new ImageIcon("src\\Picture\\Text\\Credit 2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				credit.setIcon(new ImageIcon("src\\Picture\\Text\\Credit 1.png"));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressStart.setVisible(false);
				highScore.setVisible(false);
				credit.setVisible(false);
				back.setVisible(true);
				BGindex.setIcon(new ImageIcon("src\\Picture\\Background\\BGcredit.png"));
			}
		});
		
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				back.setIcon(new ImageIcon("src\\Picture\\Text\\back 2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				back.setIcon(new ImageIcon("src\\Picture\\Text\\back 1.png"));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pressStart.setVisible(true);
				highScore.setVisible(true);
				credit.setVisible(true);
				back.setVisible(false);
				BGindex.setIcon(new ImageIcon("src\\Picture\\Background\\index.jpg"));
			}
		});
		
		game.start();
		game.superHide();
	}
	
	public static void returnHome(){
		BGindex.setVisible(true);
		BGindex.setIcon(new ImageIcon("src\\Picture\\Background\\index.jpg"));
		pressStart.setVisible(true);
		highScore.setVisible(true);
		credit.setVisible(true);
	}
	
	public void hide(){
		pressStart.setVisible(false);
		highScore.setVisible(false);
		credit.setVisible(false);
		BGindex.setVisible(false);
	}
}
