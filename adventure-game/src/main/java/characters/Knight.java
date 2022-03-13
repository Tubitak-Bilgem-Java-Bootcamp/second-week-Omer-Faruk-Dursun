package characters;

public class Knight extends GameCharacter {

    private final static String NAME = "characters.Knight";
    private final static Integer KNIGHT_HEALTH = 8;
    private final static Integer KNIGHT_DAMAGE = 24;
    private final static Integer KNIGHT_MONEY = 5;

    public Knight() {
        super(NAME, KNIGHT_HEALTH, KNIGHT_DAMAGE, KNIGHT_MONEY);
    }
}
