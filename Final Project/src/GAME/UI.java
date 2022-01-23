package GAME;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.InputStream;
import java.io.IOException;

import javax.swing.*;

import GAME.Game.ChoiceHandler;


public class UI {
	
	JFrame window;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, backgroundimgPanel;
	JLabel titleNameLabel, hpLabel, hpNumberLabel, weaponNameLabel, weaponLabel, backgroundimgLabel;
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	Font PixelFont;
	Font titleFont = new Font("PixelMplus10", Font.TRUETYPE_FONT, 90);
	Font normalFont = new Font("PixelMplus10", Font.TRUETYPE_FONT, 28);
	
	
	public void setImage(ImageIcon icon) {
		window.remove(backgroundimgPanel);
		window.add(backgroundimgPanel);
		backgroundimgLabel.setIcon(icon);
	}
	
	public void createUI(ChoiceHandler cHandler) {
		try {
			InputStream is = getClass().getResourceAsStream("/Fonts/PixelMplus10-Regular.ttf");
			PixelFont = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		backgroundimgPanel = new JPanel();
		backgroundimgPanel.setBounds(-5,50,800,600);
		
		backgroundimgLabel = new JLabel();
		backgroundimgPanel.setOpaque(false);
		backgroundimgPanel.add(backgroundimgLabel);
		
		
		//Title
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Francisco");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.setOpaque(false);
		titleNamePanel.add(titleNameLabel);
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setFont(normalFont);
		startButton.setForeground(Color.white);
		startButton.setFocusPainted(false);
		startButton.setBorder(null);
		startButton.addActionListener(cHandler);
		startButton.setActionCommand("start");
		startButtonPanel.setOpaque(false);
		startButtonPanel.add(startButton);
		
	
		window.add(titleNamePanel);
		window.add(startButtonPanel);
		
		//Game Screen
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(95, 100, 600, 250);
		mainTextPanel.setBackground(new Color(0,0,0,80));
		window.add(mainTextPanel);
		
		mainTextArea = new JTextArea("");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(new Color(0,0,0,0));
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setLineWrap(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setOpaque(false);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		window.add(choiceButtonPanel);
		
		//4 Choices
		
		choice1 = new JButton("choice1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("choice2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("choice3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(cHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("choice4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(cHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(new Color(0,0,0,80));
		playerPanel.setOpaque(false);
		playerPanel.setLayout(new GridLayout(1,4));
		window.add(playerPanel);
		
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpNumberLabel = new JLabel("10");
		hpNumberLabel.setFont(normalFont);
		hpNumberLabel.setForeground(Color.white);
		playerPanel.add(hpNumberLabel);
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		weaponNameLabel = new JLabel("empty");
		weaponNameLabel.setFont(normalFont);
		weaponNameLabel.setForeground(Color.white);
		playerPanel.add(weaponNameLabel);
		
		window.setVisible(true);
	}
	public void repaint() {
		window.repaint();
	}


}
