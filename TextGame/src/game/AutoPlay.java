package game;

import java.util.Random;

public class AutoPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		Random rand = new Random();
		int cmd;
		while (game.getGameOver() == false) {
			System.out.println("Please enter a command");
			cmd = rand.nextInt(4);
			if(cmd == 0) {
				System.out.println("north");
				game.playGame("north");
			}
			else if(+cmd == 1) {
				System.out.println("south");
				game.playGame("south");
			}
			else if(cmd == 2) {
				System.out.println("east");
				game.playGame("east");
			}
			else {
				System.out.println("west");
				game.playGame("west");
			}
			//print player current position
			System.out.println(game.getPlayer().getPosition()[0] +
					", " + game.getPlayer().getPosition()[1]);
			for(Item i:game.getPlayer().getInventory()) {
				System.out.println(i.getName());
			}
			if(game.getPlayer().getWeapon() != null) {
				System.out.println("Your weapon is:");
				System.out.println(game.getPlayer().getWeapon().getName());
			}
			if(game.getPlayer().getShield() != null) {
				System.out.println("Your shield is:");
				System.out.println(game.getPlayer().getShield().getName());
			}
		}
	}

}
