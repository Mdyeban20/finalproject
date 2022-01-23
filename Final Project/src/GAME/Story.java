package GAME;


import javax.swing.ImageIcon;

import Monsters.Boss_Kumakatok;
import Monsters.Monster_Aswang;
import Monsters.Monster_Engkanto;
import Monsters.Monster_Maranhig;
import Monsters.Monster_Pixie;
import Monsters.Monster_Wolf;
import Monsters.superMonster;
import Weapons.Weapon_Knife;
import Weapons.Weapon_KrusBow;
import Weapons.Weapon_Sinag;

public class Story {
	
	Game game;
	UI ui;
	ImageIcon background;
	VisibilityManager vm;
	Player player = new Player();
	superMonster monster;
	int dialogcounter = 0, quest1 = 0, quest2 = 0, quest3 = 0, potion = 0, holywater = 0, gem = 0, wood = 0;
	String recent = "Master", blessedWeapon;
	
	public Story(Game g, UI userInterface, VisibilityManager vManager) {
		
		game = g;
		ui = userInterface;
		vm = vManager;
	}
	
	
	public void defaultSetup() {
		player.hp = 15;
		player.gold = 6;
		potion = 1;
		ui.hpNumberLabel.setText("" + player.hp);
		
		player.currentWeapon = new Weapon_Knife();
		ui.weaponNameLabel.setText(player.currentWeapon.name);
	}
	public void nextSetup() {
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
	}
	public void selectPosition(String nextPosition) {
		ui.repaint();
		switch(nextPosition) {
		case "Intro": Intro();break;
		case "Master": Master(); break;
		case "fight" : fight();vm.titletoTown();break;
		case "monsterAttack" : monsterAttack();break;
		case "run" : run();break;
		case "attack": playerAttack();break;
		case "win": win();break;
		case "butcher": butcher();break;
		case "richperson": richperson();break;
		case "priest": priest(); break;
		case "town":town(); recent = "town"; break;
		case "leaveplaza":leavePlaza();break;
		case "church":church();break;
		case "shop":shop(); recent = "shop";break;
		case "forest":forest();break;
		case "exitForest":exitForest();dialogcounter = 0;break;
		case "rest":rest();;break;
		case "Nun":nun();break;
		case "cemetery":cemetery();break;
		case "cemeteryExit":cemeteryExit();break;
		case "buypot" : buyPotion();break;
		case "buysinag" : buySinag();break;
		case "lose": lose(); break;
		case "grove":  grove();break;
		case "farm": farm();break;
		case "heal":healPotion();break;
		case "toTitle": toTitle();break;
		case "waterfall": waterfall(); break;
		case "itemsneeded": neededItems();break;
		case "exchange": exchange();break;
		case "talkfairies" : talkFairies();break;
		case "finalboss": FinalBoss();break;
		case "KEK":break;
		}
		
	}
	public void Intro() {
		if (dialogcounter < 1) {
			ui.mainTextArea.setText("Juan: Tell me something interesting before we met");
			game.nextPosition1 = "Intro";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("Francisco: Alright! Alright. I'll tell you a mini adventure I had. It started on a sunset and I was ambushed by a");
			background = new ImageIcon(getClass().getClassLoader().getResource("sunset.png"));
			ui.setImage(background);
			game.nextPosition1 = "fight";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
			dialogcounter = 0;
			
		}
		
		dialogcounter = dialogcounter + 1;
		monster = new Monster_Wolf();
		nextSetup();

	}


	public void Master() {
		dialogcounter = dialogcounter + 1;
		nextSetup();
		switch(dialogcounter) {
		case 1:
			ui.mainTextArea.setText("Master Goyo: Where have you been Francisco?!! No matter. I want you to solve the current problems in town ");
			game.nextPosition1 = "Master";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
			
			break;
		case 2:
			ui.mainTextArea.setText("Francisco: I'm sorry I'm late master... But may I ask what the problems are?");
			game.nextPosition1 = "Master";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
			
			break;
		case 3:
			ui.mainTextArea.setText("Master Goyo: Go around town and ask the people. Only return once you solved the mysterious problems ");
			game.nextPosition1 = "Master";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
			
			break;
		case 4:
			ui.mainTextArea.setText("Yes Master!!");
			game.nextPosition1 = "town";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
			
			break;
		}
	}
	
	public void town() {
		
		background = new ImageIcon(getClass().getClassLoader().getResource("town.png"));
		ui.setImage(background);
		if (player.currentWeapon.name == "KrusBow") {
			ui.mainTextArea.setText("You hear knocking out in town and people screaming and scrambling about");
			
			ui.choice1.setText("Check it out");
			ui.choice2.setText("Visit Church first");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "finalboss";
			game.nextPosition2 = "church";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("You see three people in town. A bucther, a priest, and a rich person talking to his maid. What do you want to do?");
			
			game.nextPosition1 = "butcher";
			game.nextPosition2 = "richperson";
			game.nextPosition3 = "priest";
			game.nextPosition4 = "leaveplaza";
			
			ui.choice1.setText("Talk to butcher");
			ui.choice2.setText("Talk to rich person");
			ui.choice3.setText("Talk to priest");
			ui.choice4.setText("Leave Plaza");
		}
	}
	
	public void butcher() {
		if (quest1 <= 1) {
			ui.mainTextArea.setText("Well kid, there have been some big mystery back in teh animal farm 'cause animals disappear every now and then");
			quest1 = 1;
		}
		else {
			ui.mainTextArea.setText("Looks like there was something sinister that pretended to be a farm animal");
		}
		game.nextPosition1 = "town";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
		nextSetup();
	}
	
	public void richperson() {
		if (quest2 <= 1) {
			ui.mainTextArea.setText("Where are my precious gems?!?! Did you take them?! My apologies lad, I am talking to my maid");
			quest2 = 1;
		}
		else if (quest2 >= 2) {
			ui.mainTextArea.setText("Thank you for returning my possesions. Take this mysterious gem as payment");
			gem = 1;
			quest2 = quest2 + 1;
			
		}
		game.nextPosition1 = "town";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
		nextSetup();
	}
	public void priest() {
		if (quest3 <= 1) {
			ui.mainTextArea.setText("There have been a lot of vistors in the cemetery lately. Although, its a bit weird that they only visit at night.");
			quest3 = 1;
		}
		else {
			ui.mainTextArea.setText("There is a weapon the shop can forge. Its great against the mysterious creatures. However, certain items are needed");
		}
		game.nextPosition1 = "town";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
		nextSetup();
	}
	public void leavePlaza() {
		
		if (quest1 >= 1 && quest2 >= 1 && quest3 >=1) {
			ui.mainTextArea.setText("Where do you wanna go?");
			
			ui.choice1.setText(" To Forest");
			ui.choice2.setText(" To Church");
			ui.choice3.setText(" To Shop");
			ui.choice4.setText(" Stay");
			
			game.nextPosition1 = "forest";
			game.nextPosition2 = "church";
			game.nextPosition3 = "shop";
			game.nextPosition4 = "town";
		}
		else if (quest1 == 0 && quest2 == 0 && quest3 == 0){
			ui.mainTextArea.setText("Maybe I should talk to the townspeople first");
			nextSetup();
			game.nextPosition1 = recent;
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
	}
	
	public void forest() {
		
		recent = "town";
		background = new ImageIcon(getClass().getClassLoader().getResource("forest.png"));
		ui.setImage(background);
		int encounterChance = new java.util.Random().nextInt(10)+1;
		
		if (encounterChance < 5) {
			monster = new Monster_Wolf();
		}
		else if (encounterChance > 5 && encounterChance < 9) {
			monster = new Monster_Maranhig();
		}
		else {
			monster = new Monster_Engkanto();
		}
		
		ui.mainTextArea.setText("As you were entering the forest you were suddenly attacked by "+monster.name+"!");
		nextSetup();
		
		game.nextPosition1 = "fight";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
		
	}
	
	public void exitForest() {
		recent = "exitForest";
		
		background = new ImageIcon(getClass().getClassLoader().getResource("forest.png"));
		ui.setImage(background);
		ui.mainTextArea.setText("Where do you go now?");
		
		ui.choice1.setText("Back to Town");
		ui.choice2.setText("Fairies' Grove");
		ui.choice3.setText("Farm");
		ui.choice4.setText("Waterfall");
		
		game.nextPosition1 = "town";
		game.nextPosition2 = "grove";
		game.nextPosition3 = "farm";
		game.nextPosition4 = "waterfall";
	}
	
	public void church() {
		recent = "town";
		background = new ImageIcon(getClass().getClassLoader().getResource("church.png"));
		ui.mainTextArea.setText("Nun: Welcome child!!\n\nWhat do you want to do?");
		ui.setImage(background);
		
		ui.choice1.setText(" Rest (+7 hp)");
		ui.choice2.setText(" Talk to Nun");
		ui.choice3.setText(" Go to Cemetery");
		ui.choice4.setText(" Go back to Plaza");
		
		game.nextPosition1 = "rest";
		game.nextPosition2 = "Nun";
		game.nextPosition3 = "cemetery";
		game.nextPosition4 = recent;
		
		recent = "church";
	}
	
	
	public void rest() {
		ui.mainTextArea.setText("You decided to take a rest and you healed 7 hp.");
		player.hp = player.hp + 7;
		ui.hpNumberLabel.setText("" + player.hp);
		
		nextSetup();
		
		game.nextPosition1 = recent;
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void nun() {
		recent = "church";
		if (holywater == 0) {
			ui.mainTextArea.setText("Nun: May god bless you. Take this holy water with you as well\n You can feel the blessing on your weapon");
			holywater = 1;
			quest3 = quest3 + 1;
			
			player.currentWeapon.damage = (int) (player.currentWeapon.damage * 1.75);
			player.currentWeapon.minDamage = (int) (player.currentWeapon.minDamage * 1.75);
			
			blessedWeapon = player.currentWeapon.name;
			
			nextSetup();
			game.nextPosition1 = recent;
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else if(player.currentWeapon.name != blessedWeapon){
			ui.mainTextArea.setText("Nun: May god bless you. \n You can feel the blessing on your weapon");
			
			player.currentWeapon.damage = (int) (player.currentWeapon.damage * 1.75);
			player.currentWeapon.minDamage = (int) (player.currentWeapon.minDamage * 1.75);
			
			blessedWeapon = player.currentWeapon.name;
			
			nextSetup();
			
			game.nextPosition1 = recent;
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		
		}
		else {
			ui.mainTextArea.setText("Nun: May god bless you.");
			
			nextSetup();
			
			game.nextPosition1 = recent;
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
	}
	
	public void cemetery() {
		recent = "church";
		background = new ImageIcon(getClass().getClassLoader().getResource("cemetery.png"));
		ui.setImage(background);
		if (quest3 <= 2) {
			ui.mainTextArea.setText("You see an undead and it started to attack you!");
			
			monster = new Monster_Maranhig();
			
			nextSetup();
			
			game.nextPosition1 = "fight";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("There is nothing to do in the area");
			nextSetup();
			
			game.nextPosition1 = recent;
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}

		
	}
	
	public void cemeteryExit() {
		ui.mainTextArea.setText("There is nothing to do here anymore\n What do you do?");
		
		ui.choice1.setText("Return to church");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "church";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
	}
	public void shop() {
		background = new ImageIcon(getClass().getClassLoader().getResource("shop.png"));
		ui.mainTextArea.setText("Welcome to my shop!!! What do you want to do child?\n"+"You currently have "+player.gold+" gold.");
		ui.setImage(background);
		
		ui.choice1.setText("Buy potion(-3G)");
		ui.choice4.setText("Leave");
		if (player.currentWeapon.name != "Silver Sinag") {
			ui.choice2.setText("Buy Silver Sinag(-15G");
			game.nextPosition2 = "buysinag";
		}
		else {
			ui.choice2.setText("Already equipped");
			game.nextPosition3 = "";
		}
		if (quest1 >= 3 && quest2 >= 3 & quest3 >=3 && wood ==1 &&gem == 1 && holywater==1 ) {
			ui.choice3.setText("Forge Krus Bow");
			game.nextPosition3 = "forgebow";
		}
		else {
			ui.choice3.setText("3 items needed");
			game.nextPosition3 = "itemsneeded";
		}
		
		
		game.nextPosition1 = "buypot";
		game.nextPosition4 = "town";
		
	}
	
	public void forgeBow() {
		ui.mainTextArea.setText("Clank1 Clank! Clank! The Great KrusBow has been forged. Ready for you to use");
		player.currentWeapon = new Weapon_KrusBow();
		
		nextSetup();
		
		game.nextPosition1 = "shop";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void neededItems() {
		ui.mainTextArea.setText("You need a magical piece of wood, a mystrious gem and holy water");
		
		nextSetup();
		
		game.nextPosition1 = "shop";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void buyPotion() {
		if (player.gold >= 3) {
			potion = potion +1 ;
			player.gold = player.gold - 3;
			ui.mainTextArea.setText("You have bough an hp potion\n You currenly have "+ potion +" on you.\n");
		}
		else {
			ui.mainTextArea.setText("You don't have enough gold to purchase.");
		}
		nextSetup();
		
		game.nextPosition1 = "shop";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	public void buySinag() {
		if (player.gold >= 15) {
			player.currentWeapon = new Weapon_Sinag();
			player.gold = player.gold - 15;
			ui.mainTextArea.setText("You have bought the Silver Sinag for 15 gold");
			ui.weaponNameLabel.setText(player.currentWeapon.name);
		}
		else {
			ui.mainTextArea.setText("You don't have enough gold to purchase.");
		}
		nextSetup();
		
		game.nextPosition1 = "shop";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void grove() {
		background = new ImageIcon(getClass().getClassLoader().getResource("grove.png"));
		ui.setImage(background);
		if (quest2 == 1 ) {
			ui.mainTextArea.setText("Three Fairies: What are you doing here Human?\n\n You see stolen possesions around. What do you do?");
			
			monster = new Monster_Pixie();
			dialogcounter = dialogcounter + 1;
			
			ui.choice1.setText("Attack them"); 
			ui.choice2.setText("Pay gold(-50G)");
			ui.choice3.setText("Talk");
			ui.choice4.setText("Leave");
		
			game.nextPosition1 = "fight";
			game.nextPosition2 = "exchange";
			game.nextPosition3 = "talkfairies";
			game.nextPosition4 = "forest";

		}
		else {
			ui.mainTextArea.setText("Fairies: Hello human!\n\n What do you do?");
			
			ui.choice1.setText("Leave"); 
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
		
			game.nextPosition1 = "forest";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void exchange() {
		if (player.gold >= 50) {
			ui.mainTextArea.setText("Fairies: Great having business with you!");
			
			nextSetup();
			
			quest2 = quest2 + 1;
			
			game.nextPosition1 = "exitForest";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("I'm sorry but looks like youdon't have enough to pay!");
			
			nextSetup();
			game.nextPosition1 = "grove";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}

	}
	
	public void talkFairies() {
		ui.mainTextArea.setText("Fairies: We apologize! We promise to not steal again!");
		
		quest2 = quest2 + 1;
		
		nextSetup();
		
		game.nextPosition1 = "exitForest";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void farm() {
		background = new ImageIcon(getClass().getClassLoader().getResource("farm.png"));
		ui.mainTextArea.setText("There is an oddly bigger and black-colored dog in the farm. It suddenly trnasformed and attacked you!");
		ui.setImage(background);
		monster = new Monster_Aswang();
		
		nextSetup();
		
		game.nextPosition1 = "fight";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
		if (quest1  <=2 ) {
			quest2 = quest2 + 1;
		}
	}
	
	public void waterfall() {
		background = new ImageIcon(getClass().getClassLoader().getResource("waterfall.png"));
		ui.setImage(background);
		ui.mainTextArea.setText("Diwata: Hello child! I hope you are doing fine. Drink some water and rest");
		
		ui.choice1.setText("Drink and Rest"); 
		ui.choice2.setText("Leave");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "rest";
		game.nextPosition2 = "exitForest";
		game.nextPosition3 = "";
		game.nextPosition4 = "";	
	}
	
	public void FinalBoss() {
		monster = new Boss_Kumakatok();
		ui.mainTextArea.setText("An unbelievable monster is threatening the town\nYou have no choice but to fight");
		ui.choice1.setText("Fight"); 
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "fight";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void fight() {
			
		ui.mainTextArea.setText(monster.name + ":" + monster.hp + "\n\nWhat do you do?");
		
		ui.choice1.setText("Attack"); 
		ui.choice2.setText("Hp Potion x" + potion);
		ui.choice3.setText("Run");
		ui.choice4.setText("");
		
		game.nextPosition1 = "attack";
		game.nextPosition2 = "heal";
		game.nextPosition3 = "run";
		game.nextPosition4 = "";	
		
	}
	
	public void healPotion() {
		int healing = new java.util.Random().nextInt(15)+7;
		ui.mainTextArea.setText("You used a potion. You healed " + healing+ "hp");;
		potion = potion - 1;
		player.hp = player.hp + healing;
		ui.hpNumberLabel.setText("" + player.hp);
		
		nextSetup();
		game.nextPosition1 = "monsterAttack";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	public void playerAttack() {
		int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage - player.currentWeapon.minDamage)+player.currentWeapon.minDamage;
		int critAttack = new java.util.Random().nextInt(10)+1;
		if (critAttack == 1) {
			playerDamage = (int) (playerDamage * 1.5);
			ui.mainTextArea.setText("CRIT!\nYou attacked the " + monster.name + " and gave " + playerDamage + " damage");
		}
		else {
			ui.mainTextArea.setText("You attacked the " + monster.name + " and gave " + playerDamage + " damage");
		}
		
		
		monster.hp = monster.hp - playerDamage;
		nextSetup();
		
		if (monster.hp>0) {
			game.nextPosition1 = "monsterAttack";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else if(monster.hp<1) {
			game.nextPosition1 = "win";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
	}
	public void monsterAttack() {
		int monsterDamage = new java.util.Random().nextInt(monster.attack - monster.minattack)+ monster.minattack;
		if (monsterDamage == 0) {
			ui.mainTextArea.setText("You completely blocked the attack!\nYou have received " + monsterDamage +" damage!");
		}
		else {
			ui.mainTextArea.setText("You have received " + monsterDamage +" damage!");
		}
		
		player.hp = player.hp - monsterDamage;
		ui.hpNumberLabel.setText("" + player.hp);
		
		nextSetup();
		
		if(player.hp>0) {
			game.nextPosition1 = "fight";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		if(player.hp<1) {
			game.nextPosition1 = "lose";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
	}
	public void win() {
		int receivedGold = new java.util.Random().nextInt(monster.maxgoldReceived-monster.mingoldReceived) + monster.mingoldReceived;
		player.gold = player.gold + receivedGold;
		ui.mainTextArea.setText("You have defeated " + monster.name + "\nYou have obtained " + receivedGold + " gold!");
		if (monster.drop == "Magical Narra" && quest1 <= 2) {
			ui.mainTextArea.setText(ui.mainTextArea.getText() + "\n You also obtained a magical piece of wood!");
			wood = 1;
			quest1 = quest1 + 1;
		}
		nextSetup();
		if (recent == "town") {
			game.nextPosition1 = "exitForest";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else if (recent == "church") {
			quest3 = quest3 + 1;
			game.nextPosition1 = recent;
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else {
			game.nextPosition1 = recent;
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
		if (monster.name == "Pixie" && dialogcounter < 3) {
			monster = new Monster_Pixie();
			
			dialogcounter = dialogcounter + 1;
			
			if (dialogcounter == 2) {
				quest2 = quest2 + 1;
			}
			
			game.nextPosition1 = "fight";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
		if (monster.name == "Kumakatok") {
			ui.mainTextArea.setText("Townspeople : Hurrahhhhh! Yaaay! We are safe\n\n You have saved the town");
			
			ui.choice1.setText("Go Home"); 
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			game.nextPosition1 = "ending";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
			
		}
	}
	public void lose() {
		ui.mainTextArea.setText("You have lost\n\nGAME OVER");
		
		ui.choice1.setText("To the title screen"); 
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "toTitle";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
	}
	public void run() {
		int getawayChance = new java.util.Random().nextInt(10) + 1;
		if (getawayChance > 8) {
			ui.mainTextArea.setText("You have ran away succesfully");
			
			nextSetup();
			
			game.nextPosition1 = recent;
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else if (getawayChance > 1 && getawayChance < 8) {
			ui.mainTextArea.setText("You have ran away succesfully");
			
			nextSetup();
			
			game.nextPosition1 = recent;
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("You are unable to runaway from the battle");		
			
			nextSetup();
			
			game.nextPosition1 = "monsterAttack";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
	}
	public void ending() {
		background = new ImageIcon(getClass().getClassLoader().getResource("sunrise.png"));
		ui.setImage(background);
		ui.mainTextArea.setText("Francisco: And that was the moment before I found out my master disappeared which lead to the party\n\n"+"..."+"\nCongratulations for finishing the game!");
		
		ui.choice1.setText("To the title screen"); 
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "toTitle";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	public void toTitle() {
		
		defaultSetup();
 		vm.showTitleScreen();
		
	}
}
