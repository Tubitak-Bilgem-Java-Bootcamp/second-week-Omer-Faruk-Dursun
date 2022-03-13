package obstacle;

public class Zombie extends Obstacle{

    private final static Integer ID = 1;
    private final static String NAME = "Zombie";
    private final static Integer HEALTH = 10;
    private final static Integer DAMAGE = 3;

    public Zombie() {
        super(ID, NAME, HEALTH, DAMAGE);
    }

}
