package location.battlelocation;

import Item.Armor;
import Item.Weapon;
import location.Location;
import obstacle.Obstacle;
import obstacle.Snake;
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
                getLocationAward();
                return true;
            }
        }

        if (getPlayer().getHealth() <= 0) {
            return false;
        }

        return true;
    }

    private void getLocationAward() {
        if (this.award == "Food") {
            getPlayer().getInventory().setFood(true);
        } else if (this.award == "Firewood") {
            getPlayer().getInventory().setFirewood(true);
        } else if (this.award == "Water") {
            getPlayer().getInventory().setWater(true);
        }
        if (award.equals("")) {
            System.out.println("This area doesn't contain an special item for clearing it");
        } else {
            System.out.println("You gained the " + getAward() + " for defeating all the monsters in this area");
        }

    }

    public Integer generateRandomNumberOfObstacle() {
        Random random = new Random();
        return random.nextInt(maxObstacle) + 1;
    }

    public boolean combat(Integer numberOfObstacles) {
        for (int i = 0; i < numberOfObstacles; i++) {
            getObstacle().setHealth(getObstacle().getMaxHealth());
            battleInfo();

            boolean isPlayerFirst = determineFirstAttacker();

            while (isBothAlive()) {

                String battleChoice = getBattleChoiceFromPlayer();

                if (battleChoice.equals("A")) {
                    if (isPlayerFirst) {
                        playerFirstBattleRound();
                    } else {
                        playerSecondBattleRound();
                    }
                } else {
                    System.out.println("You ran away ... coward.");
                    return false;
                }
            }

            if (isPlayerAlive()) {
                gainMoneyAwardAfterVictory();
            } else {
                return false;
            }
        }
        return true;
    }

    private void gainMoneyAwardAfterVictory() {
        System.out.println("|| You won ! ||");
        calculatePlayerAward();
    }

    private boolean isPlayerAlive() {
        return getObstacle().getHealth() < getPlayer().getHealth();
    }


    private boolean isBothAlive() {
        return getPlayer().getHealth() > 0 && getObstacle().getHealth() > 0;
    }

    private String getBattleChoiceFromPlayer() {
        String battleChoice;
        System.out.println("<A>ttack or <R>un away ?");
        battleChoice = scanner.nextLine();
        battleChoice = battleChoice.toUpperCase();
        return battleChoice;
    }

    private boolean determineFirstAttacker() {
        boolean isPlayerFirst = generateFirstAttackChance();
        if (isPlayerFirst) {
            System.out.println("You will attack first !");
        } else {
            System.out.println("Enemy will attack first");
        }

        return isPlayerFirst;
    }

    private void playerFirstBattleRound() {
        playerAttacks();
        battleInfo();

        if (isAlive(getObstacle())) {
            obstacleAttacks();
            battleInfo();
        }
    }

    private void playerSecondBattleRound() {
        obstacleAttacks();
        battleInfo();

        if (isAlive(getPlayer())) {
            playerAttacks();
            battleInfo();
        }
    }

    private boolean generateFirstAttackChance() {
        Random random = new Random();
        return random.nextBoolean();
    }

    private void calculatePlayerAward() {
        Object o = getObstacle().getAwardOnDefeat();

        if (o instanceof Weapon) {
            getWeaponAward(o);
        } else if (o instanceof Armor) {
            getArmorAward(o);
        } else if (o instanceof Integer){
            getMoneyAward(o);
        }else{
            getNoAward();
        }
    }

    private void getWeaponAward(Object o) {
        Weapon weaponAward = (Weapon) o;
        System.out.println("|| You gained " + weaponAward.getName() + " for defeating this monster ! ||");

        System.out.println("Chancing your current armor " + getPlayer().getInventory().getWeapon().getName() + ", to "
                + weaponAward.getName());
        getPlayer().getInventory().setWeapon(weaponAward);
    }

    private void getArmorAward(Object o) {
        Armor armorAward = (Armor) o;
        System.out.println("|| You gained " + armorAward.getName() + " for defeating this monster ! ||");

        System.out.println("Chancing your current armor " + getPlayer().getInventory().getArmor().getName() + ", to "
                + armorAward.getName());
        getPlayer().getInventory().setArmor(armorAward);
    }

    private void getMoneyAward(Object o) {
        Integer moneyAward = (Integer) o;
        System.out.println("|| You gained " + moneyAward + " coin for defeating this monster ! ||");

        Integer totalMoney = getPlayer().getMoney() + moneyAward;
        getPlayer().setMoney(totalMoney);
    }

    private void getNoAward() {
        System.out.println("|| You gained nothing for defeating this monster :( ||\n|| Better luck next time ||");
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
        Integer obstacleDamage = getObstacle().calculateDamage() - getPlayer().getInventory().getArmor().getBlock();

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
