import player.Player;

import java.util.Scanner;

public class Game {

    private final Scanner scanner = new Scanner(System.in);

    public void start(){
        System.out.println("Welcome to this adventure game !");
        System.out.println("Please enter the name of your character:");

        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName()+ " welcome to the game !");
        player.selectCharacter();
    }
}
