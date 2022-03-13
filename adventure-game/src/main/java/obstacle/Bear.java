package obstacle;

public class Bear extends Obstacle{

    private final static Integer ID = 3;
    private final static String NAME = "Bear";
    private final static Integer HEALTH = 20;
    private final static Integer DAMAGE = 7;

    public Bear() {
        super(ID, NAME, HEALTH, DAMAGE);
    }
}
