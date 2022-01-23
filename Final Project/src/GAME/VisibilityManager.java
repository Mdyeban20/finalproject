package GAME;

import javax.swing.ImageIcon;

public class VisibilityManager {
	
	UI ui;
	ImageIcon bg;
	
	public VisibilityManager(UI userInterface) {
		ui = userInterface;
	}
	
	public void showTitleScreen() {
		
		bg = new ImageIcon(getClass().getClassLoader().getResource("forest.png"));
		ui.setImage(bg);
		
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		ui.backgroundimgPanel.setVisible(true);
		
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
		
	}
	
	public void Intro() {
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.backgroundimgPanel.setVisible(true);
		
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.playerPanel.setVisible(false);
	}
	
	public void titletoTown() {

		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.playerPanel.setVisible(true);
		
		ui.backgroundimgPanel.setVisible(true);
	}
}