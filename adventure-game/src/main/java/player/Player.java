package player;

import characters.Archer;
import characters.GameCharacter;
import characters.Knight;
import characters.Samurai;
import inventory.Inventory;

import java.util.Scanner;

public class Player {

    final private String name;
    private String characterName;
    private Integer maxHealth;
    private Integer health;
    private Integer damage;
    private Integer money;
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public Integer getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(Integer maxHealth) {
        this.maxHealth = maxHealth;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        if (health < 0)
            health = 0;
        this.health = health;
    }

    public Integer getDamage() {
        return damage ;
    }

    public Integer getTotalDamage() {
        return damage + getInventory().getWeapon().getDamage();
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void selectCharacter() {

        System.out.println("Please select the character you want to play:");
        GameCharacter[] gameCharacters = {new Samurai(), new Archer(), new Knight()};

        boolean flag = true;

        while(flag){
            for (GameCharacter e : gameCharacters) {
                System.out.println(e);
                System.out.println("-------------------------------------------");
            }

            Scanner scanner = new Scanner(System.in);
            int characterSelectionInput = scanner.nextInt();

            switch (characterSelectionInput) {
                case 1:
                    initPlayerStats(new Samurai());
                    flag = false;
                    break;
                case 2:
                    initPlayerStats(new Archer());
                    flag = false;
                    break;
                case 3:
                    initPlayerStats(new Knight());
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter a valid character.");
            }
        }

    }

    private void initPlayerStats(GameCharacter gameCharacter) {
        setCharacterName(gameCharacter.getName());
        setDamage(gameCharacter.getDamage());
        setHealth(gameCharacter.getHealth());
        setMaxHealth(gameCharacter.getHealth());
        setMoney(gameCharacter.getMoney());
    }

    public void getStats() {
        System.out.println("\n");
        System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
        System.out.println("Your selected character is " + this.getCharacterName()
                + "\nHealth " + getHealth()
                + "\nWeapon " + getInventory().getWeapon().getName()
                + "\nDamage " + getDamage()
                + "\nArmor " + getInventory().getArmor().getName()
                + "\nBlock " + getInventory().getArmor().getBlock()
                + "\nMoney " + getMoney());
        System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~\n");
    }

    public void selectLocation() {

    }
}
