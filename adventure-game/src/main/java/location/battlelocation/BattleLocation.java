package location.battlelocation;

import location.Location;
import obstacle.Obstacle;
import player.Player;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public abstract class BattleLocation extends Location {

    private Obstacle obstacle;
    private String award;
    private Integer maxObstacle;

    public BattleLocation(Player player, String name, Obstacle obstacle, String award, Integer maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public String getAward() {
        return award;
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are on " + getName());
        System.out.println("There are " + generateRandomNumberOfObstacle() + " " + getObstacle().getName() + "s here !" );

        System.out.println("Will you <F>ight or <R>un away ?");
        String battleChoice = scanner.nextLine();
        battleChoice = battleChoice.toUpperCase();

        if (battleChoice.equals("F")){
            System.out.println("Battle starts !");
        }
        else{
            System.out.println("You ran away ... coward.");
        }

        return true;
    }

    public Integer generateRandomNumberOfObstacle(){
        Random random =  new Random();
        return random.nextInt(maxObstacle) + 1;
    }

    public boolean combat(Integer numberOfObstacles){

        return false;
    }
}
