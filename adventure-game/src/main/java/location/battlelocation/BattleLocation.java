package location.battlelocation;

import location.Location;
import obstacle.Obstacle;
import player.Player;

import java.util.Random;


public abstract class BattleLocation extends Location {

    final private Obstacle obstacle;
    final private String award;
    final private Integer maxObstacle;

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
        Integer numberOfObstacles = generateRandomNumberOfObstacle();
        System.out.println("You are on " + getName());
        System.out.println("There are " + numberOfObstacles + " " + getObstacle().getName() + "s here !");

        System.out.println("Will you <F>ight or <R>un away ?");
        String battleChoice = scanner.nextLine();
        battleChoice = battleChoice.toUpperCase();

        if (battleChoice.equals("F")) {
            if (combat(numberOfObstacles)) {
                System.out.println("You have defeated all the monsters in the " + this.getName());
                return true;
            }
        }

        if (getPlayer().getHealth() <= 0) {
            return false;
        }


        return true;
    }

    public Integer generateRandomNumberOfObstacle() {
        Random random = new Random();
        return random.nextInt(maxObstacle) + 1;
    }

    public boolean combat(Integer numberOfObstacles) {
        for (int i = 0; i < numberOfObstacles; i++) {
            getObstacle().setHealth(getObstacle().getMaxHealth());
            battleInfo();

            while (getPlayer().getHealth() > 0 && getObstacle().getHealth() > 0) {
                System.out.println("<A>ttack or <R>un away ?");
                String battleChoice = scanner.nextLine();
                battleChoice = battleChoice.toUpperCase();

                if (battleChoice.equals("A")) {
                    playerAttacks();
                    battleInfo();

                    if (isAlive(getObstacle())) {
                        obstacleAttacks();
                        battleInfo();
                    }

                } else {
                    System.out.println("You ran away ... coward.");
                    return false;
                }
            }

            if (getObstacle().getHealth() < getPlayer().getHealth()){
                System.out.println("You won !");
                System.out.println("You gained " + getObstacle().getAwardOnDefeat() + " money");
                calculatePlayerMoney();
            }
            else {
                return false;
            }
        }
        return true;
    }

    private void calculatePlayerMoney() {
        Integer playerTotalMoney = getPlayer().getMoney() + getObstacle().getAwardOnDefeat();
        getPlayer().setMoney(playerTotalMoney);
    }

    private boolean isAlive(Object o) {
        Integer health;

        if (o instanceof Obstacle)
            health = ((Obstacle) o).getHealth();
        else
            health = ((Player) o).getHealth();

        if (health > 0)
            return true;

        return false;
    }

    private void battleInfo() {
        playerStats();
        obstacleStats();
    }

    private void obstacleAttacks() {
        System.out.println("Enemy attacks !");
        Integer obstacleDamage = getObstacle().getDamage() - getPlayer().getInventory().getArmor().getBlock();

        if (obstacleDamage < 0)
            obstacleDamage = 0;

        Integer newHealth = getPlayer().getHealth() - obstacleDamage;
        getPlayer().setHealth(newHealth);
    }

    private void playerAttacks() {
        System.out.println("You attack !");
        Integer newHealth = getObstacle().getHealth() - getPlayer().getTotalDamage();
        getObstacle().setHealth(newHealth);
    }

    private void obstacleStats() {
        getObstacle().getStats();
    }

    private void playerStats() {
        getPlayer().getStats();
    }
}
