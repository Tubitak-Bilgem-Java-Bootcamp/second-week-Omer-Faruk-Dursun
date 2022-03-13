package characters;

public class Knight extends GameCharacter {

    private final static Integer ID = 3;
    private final static String NAME = "Knight";
    private final static Integer KNIGHT_HEALTH = 8;
    private final static Integer KNIGHT_DAMAGE = 24;
    private final static Integer KNIGHT_MONEY = 5;

    public Knight() {
        super(ID, NAME, KNIGHT_HEALTH, KNIGHT_DAMAGE, KNIGHT_MONEY);
    }
}
