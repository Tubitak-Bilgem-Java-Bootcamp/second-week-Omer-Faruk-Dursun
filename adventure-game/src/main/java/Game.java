import location.battlelocation.Cave;
import location.battlelocation.Forest;
import location.battlelocation.River;
import location.normallocation.ItemStore;
import location.Location;
import location.normallocation.SafeHouse;
import player.Player;

import java.util.Scanner;

public class Game {

    private final Scanner scanner = new Scanner(System.in);
    private final static String ASCI_ART_MAIN_ART = "-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-";

    public void start() {
        System.out.println("Welcome to this adventure game !");
        System.out.println("Please enter the name of your character:");

        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " welcome to the game !\n");
        player.selectCharacter();

        Location location = new SafeHouse(player);
        while (true) {
            boolean continueGame = true;
            player.getStats();
            System.out.println(ASCI_ART_MAIN_ART);
            System.out.println("Please select the location you want to go.");
            System.out.println("1. Safe House --->  Restores health to full");
            System.out.println("2. Item Store --->  You can buy weapons and armor here");
            System.out.println("3. Cave --->  You can get Food from here");
            System.out.println("4. Forest --->  You can get Firewood' from here");
            System.out.println("5. River --->  You can get Water from here");
            System.out.println("0. Exit the Game");
            System.out.println(ASCI_ART_MAIN_ART + "\n");

            Scanner scanner = new Scanner(System.in);
            int characterSelectionInput = scanner.nextInt();

            switch (characterSelectionInput) {
                case 0:
                    continueGame = false;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ItemStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Please enter a valid location.");
            }

            if (!continueGame) {
                break;
            }

            if (!location.onLocation()) {
                if (player.getHealth() <= 0){
                    System.out.println("Game over");
                }
                else{
                    System.out.println("You won the game congrats !");
                }
                break;
            }
        }
    }
}
