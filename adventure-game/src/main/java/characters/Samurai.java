package characters;

public class Samurai extends GameCharacter {

    private final static Integer ID = 1;
    private final static String NAME = "Samurai";
    private final static Integer SAMURAI_HEALTH = 21;
    private final static Integer SAMURAI_DAMAGE = 5;
    private final static Integer SAMURAI_MONEY = 15;
    private final static String asciiArt = "  " +
            "/|\n" +
            " |\\|\n" +
            " |||\n" +
            " |||\n" +
            " |||\n" +
            "[{o}]\n" +
            " |/|\n" +
            " `0'";

    public Samurai() {
        super(ID, NAME, SAMURAI_HEALTH, SAMURAI_DAMAGE, SAMURAI_MONEY);
    }

    @Override
    public String toString() {
        return asciiArt + "\n" + getId() +") Name = " + getName() + ", Base Health = " + getHealth() + ", Base Damage = " + getDamage() + ", Money = " + getMoney();
    }
}
