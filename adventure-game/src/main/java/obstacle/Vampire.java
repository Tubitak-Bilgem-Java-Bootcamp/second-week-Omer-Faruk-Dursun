package obstacle;

public class Vampire extends Obstacle{

    private final static Integer ID = 2;
    private final static String NAME = "Vampire";
    private final static Integer HEALTH = 14;
    private final static Integer DAMAGE = 4;

    public Vampire() {
        super(ID, NAME, HEALTH, DAMAGE);
    }
}
