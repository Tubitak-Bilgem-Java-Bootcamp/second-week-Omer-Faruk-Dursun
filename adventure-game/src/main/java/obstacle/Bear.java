package obstacle;

public class Bear extends Obstacle{

    private final static Integer ID = 3;
    private final static String NAME = "Bear";
    private final static Integer MAX_HEALTH = 20;
    private final static Integer HEALTH = 20;
    private final static Integer DAMAGE = 7;
    private final static Integer AWARD_ON_DEFEAT = 12;

    public Bear() {
        super(ID, NAME, MAX_HEALTH, HEALTH, DAMAGE, AWARD_ON_DEFEAT);
    }
}
