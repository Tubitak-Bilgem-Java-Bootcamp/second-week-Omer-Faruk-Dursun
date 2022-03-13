package obstacle;

public class Zombie extends Obstacle {

    private final static Integer ID = 1;
    private final static String NAME = "Zombie";
    private final static Integer MAX_HEALTH = 10;
    private final static Integer HEALTH = 10;
    private final static Integer DAMAGE = 3;
    private final static Integer AWARD_ON_DEFEAT = 4;

    public Zombie() {
        super(ID, NAME, MAX_HEALTH, HEALTH, DAMAGE, AWARD_ON_DEFEAT);
    }

    @Override
    public Integer calculateDamage() {
        return getDamage();
    }

}
