package game;

import java.util.Scanner;

public class ManualPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		Scanner cmd = new Scanner(System.in);
		while (game.getGameOver() == false) {
			System.out.println("Please enter a command");
			game.playGame(cmd.nextLine().toLowerCase().trim());
			//print player current position
			System.out.println(game.getPlayer().getPosition()[0] +
					", " + game.getPlayer().getPosition()[1]);
			System.out.println(game.getGameBoard().getMap()[game.getPlayer().getPosition()[0]][game.getPlayer().getPosition()[1]].getClass());
			System.out.println(game.getGameBoard().getMap()[game.getPlayer().getPosition()[0]][game.getPlayer().getPosition()[1]].getChallengeComplete());
			for(Item i:game.getPlayer().getInventory()) {
				System.out.println(i.getName());
			}
		}
		cmd.close();
	}

}
