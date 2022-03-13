import location.ItemStore;
import location.Location;
import location.SafeHouse;
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

        Location location;
        while(true){
            System.out.println("Please select the location you want to go.");
            System.out.println("1. Safe House --->  Restores health to full");
            System.out.println("2. Item Store --->  You can buy weapons and armor here");
            System.out.println("-------------------------------------------");

            Scanner scanner = new Scanner(System.in);
            int characterSelectionInput = scanner.nextInt();

            switch (characterSelectionInput) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ItemStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if(!location.onLocation()){
                System.out.println("Game over");
                break;
            }
        }
    }
}
