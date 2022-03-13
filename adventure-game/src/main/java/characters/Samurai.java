package characters;

public class Samurai extends GameCharacter {

    private final static String NAME = "characters.Samurai";
    private final static Integer SAMURAI_HEALTH = 5;
    private final static Integer SAMURAI_DAMAGE = 21;
    private final static Integer SAMURAI_MONEY = 15;

    public Samurai() {
        super(NAME, SAMURAI_HEALTH, SAMURAI_DAMAGE, SAMURAI_MONEY);
    }
}
