package characters;

public class Archer extends GameCharacter {

    private final static Integer ID = 2;
    private final static String NAME = "Archer";
    private final static Integer ARCHER_HEALTH = 7;
    private final static Integer ARCHER_DAMAGE = 18;
    private final static Integer ARCHER_MONEY = 20;

    public Archer() {
        super(ID, NAME, ARCHER_HEALTH, ARCHER_DAMAGE, ARCHER_MONEY);
    }
}
