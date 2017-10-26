package com.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.SwingWorker;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MainFrameBackup extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	// Ship drag identifier
	private static boolean isPlacing = false;
	private static boolean isHitting = false;
	private static int shipModel = 0;
	
	// Related arrays
	private static Area compAreaArray[][] = new Area[8][8];
	private static Area userAreaArray[][] = new Area[8][8];
	
	private static Random random = new Random();
	
	// Ship models
	private static ShipModel[] shipModelArray = new ShipModel[10];
	private static ArrayList<Integer> compUsedModels = new ArrayList<>();
	
	// Labels
	private static JLabel infoLabel;
	
	// Panels
	private JPanel contentPane;
	
	// Buttons
	private static JButton debugRevealer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameBackup frame = new MainFrameBackup();
					frame.setVisible(true);
					
					// Fill area arrays' types
					for (int p = 0; p < 8; p++){
						for (int q = 0; q < 8; q++){
							userAreaArray[p][q].setType(AreaType.BLANK);
							compAreaArray[p][q].setType(AreaType.BLANK);
						}
					}
					
					// Inform player
					infoLabel.setText("Computer has placed their ships, you're placing now!");
					
					// Disable computer buttons
					adjustButtons(compAreaArray, "disable");
					
					// Computer places ship
					while (countType(compAreaArray, AreaType.SHIP) != 14){
						
						// Choose ship model
						int sm = random.nextInt(compAreaArray.length) + 2;
						if (sm < 6){ // For horizontal ships
							if (checkShipModel(sm)){
								// Restart if ship type is already placed
								continue;
							}
						} else { // For vertical ships
							if (checkShipModel((sm - 4))){
								// Restart if ship type is already placed
								continue;
							}
						}
						
						// Choose random coordinates
						int rx, ry;
						if (sm < 6){
							rx = random.nextInt((compAreaArray.length + 1) - sm);
							ry = random.nextInt(compAreaArray.length);
						} else {
							rx = random.nextInt(compAreaArray.length);
							ry = random.nextInt((compAreaArray.length + 1) - (sm - 4));
						}
						
						// Are choosen coordinates not out of bounds or occupied ?
						if (isSafeToPlace(compAreaArray, compAreaArray[ry][rx], sm)){
							if (sm < 6) {
								for (int p = 0; p < sm; p++){
									compAreaArray[ry][rx + p].setType(AreaType.SHIP);
								}
							} else {
								for (int p = 0; p < (sm - 4); p++){
									compAreaArray[ry + p][rx].setType(AreaType.SHIP);
								}
							}
							compUsedModels.add(sm);
						}
						// Debug
						// System.out.println("RY: " + ry + ", RX: " + rx + ", SM: " + sm + ", Count: " + countType(compAreaArray, AreaType.SHIP));
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public MainFrameBackup() {
		
		// Adjust how the frame looks
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch ( Exception e) {
			e.printStackTrace();}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 928);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// Label for computer
		try {
			JLabel labelComputer = new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("/labelComputer.png"))));
			labelComputer.setBounds(747, 7, 256, 32);
			contentPane.add(labelComputer);
		} catch (Exception e) {e.printStackTrace();}
		
		// Label for user
		try {
			JLabel labelUser = new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("/labelUser.png"))));
			labelUser.setBounds(175, 7, 256, 32);
			contentPane.add(labelUser);
		} catch (Exception e) {e.printStackTrace();}
		
		// #Debug JButton for revealing computer's ship placement
		debugRevealer = new JButton("Reveal");
		debugRevealer.setEnabled(false);
		debugRevealer.setBounds(1060, 800, 80,20);
		debugRevealer.addActionListener(new ActionListener(){ // Add ActionListener
			public void actionPerformed(ActionEvent arg0) {
				revealShips(compAreaArray);
			}
			
		});
		contentPane.add(debugRevealer);
		
		
		// A label that displays information related to the state of the game
		infoLabel = new JLabel("Information Label", SwingConstants.CENTER);
		infoLabel.setFont(new Font("Verdana", Font.BOLD, 32));
		infoLabel.setToolTipText("Status of the game will be displayed here");
		infoLabel.setBounds(90, 580, 1000, 48);
		contentPane.add(infoLabel);
		
		// Build shipModelArray
		for (int p = 1; p < 10; p++){
			ShipModel sm = new ShipModel();
			try { // try-catch model for IO exceptions
				
				// Add MouseListeners
				if (p == 1){
					sm.addMouseListener(new MouseAdapter(){
						@Override
						public void mousePressed(MouseEvent arg0){
							if (sm.isEnabled()){
								isPlacing = true;
								shipModel = 2;
							}
						}
					});
				} else if (p == 2){
					sm.addMouseListener(new MouseAdapter(){
						@Override
						public void mousePressed(MouseEvent arg0){
							if (sm.isEnabled()){
								isPlacing = true;
								shipModel = 3;
							}
						}
					});
				} else if (p == 3){
					sm.addMouseListener(new MouseAdapter(){
						@Override
						public void mousePressed(MouseEvent arg0){
							if (sm.isEnabled()){
								isPlacing = true;
								shipModel = 4;
							}
						}
					});
				} else if (p == 4){
					sm.addMouseListener(new MouseAdapter(){
						@Override
						public void mousePressed(MouseEvent arg0){
							if (sm.isEnabled()){
								isPlacing = true;
								shipModel = 5;
							}
						}
					});
				} else if (p == 5){
					sm.addMouseListener(new MouseAdapter(){
						@Override
						public void mousePressed(MouseEvent arg0){
							if (sm.isEnabled()){
								isPlacing = true;
								shipModel = 6;
							}
						}
					});
				} else if (p == 6){
					sm.addMouseListener(new MouseAdapter(){
						@Override
						public void mousePressed(MouseEvent arg0){
							if (sm.isEnabled()){
								isPlacing = true;
								shipModel = 7;
							}
						}
					});
				} else if (p == 7){
					sm.addMouseListener(new MouseAdapter(){
						@Override
						public void mousePressed(MouseEvent arg0){
							if (sm.isEnabled()){
								isPlacing = true;
								shipModel = 8;
							}
						}
					});
				} else if (p == 8){
					sm.addMouseListener(new MouseAdapter(){
						@Override
						public void mousePressed(MouseEvent arg0){
							if (sm.isEnabled()){
								isPlacing = true;
								shipModel = 9;
							}
						}
					});
				} 
				
				// First model types only should be initially visible
				if (!((p == 1) || (p == 5))){
					sm.setVisible(false);
				}
				
				// Determine shipModel bounds
				if (p < 5){
					sm.setBounds((2 + (p * 45)), 635, (32 + (p * 32)), 32);
				} else if (p != 9) {
					sm.setBounds((2 + ((p - 4) * 45)), 679, 32, (32 + ((p - 4) * 32)));}
				
				// Assign shipModel icon
				if (p != 9){
					sm.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/shipModel" + (p + 1) + ".png"))));
				}
			} catch (Exception e) {}
			
			shipModelArray[p] = sm;
			contentPane.add(sm);
		}
		
		// Initialise user button array
		for (int a = 0; a < 8; a++){
			for (int b = 0; b < 8; b++){
				Area area = new Area("");
				area.setLocation((((64 * b) + 47)), ((64 * a) + 48));
				
				// Assign an image to the JButton
				try {area.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/blank.png"))));
				} catch (Exception ex) {System.out.println(ex);}
				
				// Add listeners
				area.addMouseListener(new MouseAdapter(){
					@Override
					public void mouseEntered(MouseEvent arg0){
						
						// Define and build icons, try catch required because of ImageIO
						ImageIcon IMG_XCENTER = null;
						ImageIcon IMG_YCENTER = null;
						ImageIcon IMG_DOWN = null;
						ImageIcon IMG_RIGHT = null;
						ImageIcon IMG_LEFT = null;
						ImageIcon IMG_UP = null;
						try{
							IMG_XCENTER = new ImageIcon(ImageIO.read(getClass().getResource("/shipcenterx.png")));
							IMG_YCENTER = new ImageIcon(ImageIO.read(getClass().getResource("/shipcentery.png")));
							IMG_DOWN = new ImageIcon(ImageIO.read(getClass().getResource("/shipdown.png")));
							IMG_RIGHT = new ImageIcon(ImageIO.read(getClass().getResource("/shipright.png")));
							IMG_LEFT = new ImageIcon(ImageIO.read(getClass().getResource("/shipleft.png")));
							IMG_UP = new ImageIcon(ImageIO.read(getClass().getResource("/shipup.png")));
						} catch (Exception ex) {System.out.println(ex);}
						
						// Get area indexes
						int ax = (int) ((area.getBounds().getCenterX() - 47) / 64);
						int ay = (int) ((area.getBounds().getCenterY() - 48) / 64);
						
						// Render the guideline for ship placement
						if (isPlacing && isSafeToPlace(userAreaArray, area, shipModel)){
							if (shipModel < 6){
								for (int p = 0; p < shipModel; p++){
									// Determine the type of current ship piece
									if (p == 0){
										userAreaArray[ay][ax + p].setIcon(IMG_LEFT);
									} else if (p == (shipModel - 1)) {
										userAreaArray[ay][ax + p].setIcon(IMG_RIGHT);
									} else {
										userAreaArray[ay][ax + p].setIcon(IMG_XCENTER);
									}
								}
							}
							else {
								for (int p = 0; p < (shipModel - 4); p++){
									// Determine the type of current ship piece
									if (p == 0){
											userAreaArray[ay + p][ax].setIcon(IMG_UP);
										} else if (p == (shipModel - 5)) {
											userAreaArray[ay + p][ax].setIcon(IMG_DOWN);
										} else {
											userAreaArray[ay + p][ax].setIcon(IMG_YCENTER);
										}
								}
							}
						}
					
					}
					
					@Override
					public void mouseExited(MouseEvent arg0) {

						// Get area indexes
						int ax = (int) ((area.getBounds().getCenterX() - 47) / 64);
						int ay = (int) ((area.getBounds().getCenterY() - 48) / 64);

						// Erase the guideline
						if (isPlacing){
							if (isSafeToPlace(userAreaArray, area, shipModel)){
								if (shipModel < 6){
									for (int p = 0; p < shipModel; p++){
										userAreaArray[ay][ax + p].changeIcon(AreaType.BLANK);
									}
								}
								else {
									for (int p = 0; p < (shipModel - 4); p++){
										userAreaArray[ay + p][ax].changeIcon(AreaType.BLANK);
									}
								}
							}
						}
					}
					
					@Override
					public void mousePressed(MouseEvent arg0){
						
						// Get area indexes
						int ax = (int) ((area.getBounds().getCenterX() - 47) / 64);
						int ay = (int) ((area.getBounds().getCenterY() - 48) / 64);
						
						// If ship placement is successful, register AreaType
						if (isPlacing){
							if (isSafeToPlace(userAreaArray, area, shipModel)){
								isPlacing = false;
								if (shipModel < 6){
									for (int p = 0; p < shipModel; p++){
										userAreaArray[ay][ax + p].setType(AreaType.SHIP);
									}
								}
								else {
									for (int p = 0; p < (shipModel - 4); p++){
										userAreaArray[ay + p][ax].setType(AreaType.SHIP);
									}
								}
								
								// Disable picked option, enable next ship models to be placed
								// Debug: System.out.println(shipModel);
								if (shipModel < 6){
									shipModelArray[shipModel - 1].setVisible(false);
									shipModelArray[shipModel + 3].setVisible(false);
									if (shipModel != 5){ // Condition so that the previous models won't re-appear
										shipModelArray[shipModel].setVisible(true);
									}
									shipModelArray[shipModel + 4].setVisible(true);
								} else {
									shipModelArray[shipModel - 1].setVisible(false);
									shipModelArray[shipModel - 5].setVisible(false);
									shipModelArray[shipModel].setVisible(true);
									if (shipModel != 9){ // Condition so that the previous models won't re-appear
										shipModelArray[shipModel - 4].setVisible(true);
									}
								}
								
								// If it's the last ship to be placed, initiate computer
								if (shipModel == 9 || shipModel == 5){
									hit();
								}
							} else {
								if (isPlacing){
									infoLabel.setText("You've already placen a ship there!");
								}
							}
						}
					}
				});
				area.addActionListener(this);
				
				// Add to array and frame
				userAreaArray[a][b] = area;
				contentPane.add(area);
				
			}
		}
		
		// Initialise computer button array
		for (int a = 0; a < 8; a++){
			for (int b = 0; b < 8; b++){
				Area area = new Area("");
				area.setLocation((1114 - ((64 * b) + 47)), ((64 * a) + 48));
				
				// Assign an image to the JButton
				area.changeIcon(AreaType.BLANK);
				
				// Add action listener
				area.addActionListener(this);
				
				// Add to array and frame
				compAreaArray[a][b] = area;
				contentPane.add(area);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (isHitting){
			
			// Go through button array and check source and state then act accordingly
			for (int p = 0; p < userAreaArray.length; p++){
				for (int q = 0; q < userAreaArray.length; q++){
					if (arg0.getSource() == compAreaArray[p][q]) {
						
						// If button is a hit or a miss
						if (compAreaArray[p][q].getType() == AreaType.MISS || compAreaArray[p][q].getType() == AreaType.HIT){
							infoLabel.setText("You've hit that area already!");
						}
						
						// If button is a blank
						else if (compAreaArray[p][q].getType() == AreaType.BLANK) {
							infoLabel.setText("You missed!");
							compAreaArray[p][q].changeIcon(AreaType.MISS);
							compAreaArray[p][q].setType(AreaType.MISS);
							isHitting = false;
							hit(); // Trigger SwingWorker
						}
						
						// If button is a ship
						else if (compAreaArray[p][q].getType() == AreaType.SHIP){
							infoLabel.setText("You've hit a ship!");
							compAreaArray[p][q].changeIcon(AreaType.HIT);
							compAreaArray[p][q].setType(AreaType.HIT);
							isHitting = false;
							hit(); // Trigger SwingWorker
						}
					}
				}
			}
		}
	}
	
	public static void hit(){
		SwingWorker<Void, Void> sw = new SwingWorker<Void, Void>(){

			@Override
			protected Void doInBackground() throws Exception {
				
				// Winning condition
				if (countType(userAreaArray, AreaType.HIT) == 14){
					JOptionPane.showMessageDialog(null, "Computer wins!");
					infoLabel.setText("Computer won!");
					adjustButtons(compAreaArray, "disable");
					adjustButtons(userAreaArray, "disable");
					isHitting = true;
				} else if (countType(compAreaArray, AreaType.HIT) == 14){
					JOptionPane.showMessageDialog(null, "User wins!");
					infoLabel.setText("User won!");
					adjustButtons(compAreaArray, "disable");
					adjustButtons(userAreaArray, "disable");
					isHitting = true;}
				
				if (!isHitting){
					Thread.sleep(1000);
					adjustButtons(compAreaArray, "disable");
					Thread.sleep(500);infoLabel.setText("Computer is deciding");
					Thread.sleep(500);infoLabel.setText("Computer is deciding.");
					Thread.sleep(500);infoLabel.setText("Computer is deciding..");
					Thread.sleep(500);infoLabel.setText("Computer is deciding...");
					int rx = random.nextInt(8);
					int ry = random.nextInt(8);
					
					// This code segment makes it so that the computer won't hit an already hit spot.
					while (userAreaArray[rx][ry].getType() == AreaType.MISS || userAreaArray[rx][ry].getType() == AreaType.HIT){
						rx = random.nextInt(8);
						ry = random.nextInt(8);}
					
					// Computer missed
					if (userAreaArray[rx][ry].getType() == AreaType.BLANK){
						userAreaArray[rx][ry].changeIcon(AreaType.MISS);
						userAreaArray[rx][ry].setType(AreaType.MISS);
						infoLabel.setText("Computer missed!");
						isHitting = true;}
					
					// Computer hit a ship
					if (userAreaArray[rx][ry].getType() == AreaType.SHIP){
						userAreaArray[rx][ry].changeIcon(AreaType.HIT);
						infoLabel.setText("Computer hit one of your ships!");
						userAreaArray[rx][ry].setType(AreaType.HIT);
						isHitting = true;}
					Thread.sleep(500);adjustButtons(compAreaArray, "enable");
				}
				return null;
			}
		};
		
		// Start the SwingWorker
		sw.execute();
		
	}

	public static void adjustButtons(JButton[][] array, String statement){
		// Disables or enables buttons in an array
		if (statement.equals("disable")){
			for (int p = 0; p < array.length; p++){
				for (int q = 0; q < array.length; q++){
					array[p][q].setEnabled(false);
				}
			}
		}
		else {
			for (int p = 0; p < array.length; p++){
				for (int q = 0; q < array.length; q++){
					array[p][q].setEnabled(true);
				}
			}
		}
	}

	public static int countType(Area[][] array, AreaType type){
		// Counts the amount of specified AreaTypes in an Area array
		int count = 0;
		for (int p = 0; p < array.length; p++){
			for (int q = 0; q < array.length; q++){
				if (array[p][q].getType() == type){
					count++;
				}
			}
		}
		return count;
	}

	public static boolean isSafeToPlace(Area[][] array, Area area, int shipModel){
		// Checks collision and out-of-bounds possibilites
		boolean result = true;
		int ax;
		if (array == userAreaArray) {	
			ax = (int) (((area.getBounds().getCenterX() - 47) / 64));
		} else {
			ax = (int) (Math.abs((area.getBounds().getCenterX() - 1131) / 64));
		}
		int ay = (int) ((area.getBounds().getCenterY() - 48) / 64);
		if (shipModel < 6){
			for (int p = 0; p < shipModel; p++){
				if ((ax + p > 7) || array[ay][ax + p].getType() == AreaType.SHIP){
					result = false;
				}
			}
		} else {
			for (int p = 0; p < (shipModel - 4); p++){
				if ((ay + p > 7) || array[ay + p][ax].getType() == AreaType.SHIP){
					result = false;
				}
			}
		}
		return result;
	}
	
	public static void revealShips(Area[][] array){
		for (int p = 0; p < array.length; p++){
			for (int q = 0; q < array.length; q++){
				if (array[p][q].getType() == AreaType.SHIP){
					System.out.println(p + ", " + q);
					array[p][q].changeIcon(AreaType.HIT);
				}
			}
		}
	}

	public static boolean checkShipModel(int shipModel){
		boolean result = false;
		for (int p : compUsedModels) {
			if ((shipModel == p) || (shipModel == (p - 4))){
				result = true;
			}
		}
		return result;
	}
}

