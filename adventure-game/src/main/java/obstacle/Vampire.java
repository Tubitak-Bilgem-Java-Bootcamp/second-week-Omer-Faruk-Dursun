package obstacle;

public class Vampire extends Obstacle {

    private final static Integer ID = 2;
    private final static String NAME = "Vampire";
    private final static Integer HEALTH = 14;
    private final static Integer MAX_HEALTH = 14;
    private final static Integer DAMAGE = 4;
    private final static Integer AWARD_ON_DEFEAT = 7;

    public Vampire() {
        super(ID, NAME, MAX_HEALTH, HEALTH, DAMAGE, AWARD_ON_DEFEAT);
    }

    @Override
    public Integer calculateDamage() {
        return getDamage();
    }

}
