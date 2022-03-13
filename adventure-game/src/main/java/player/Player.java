package player;

import characters.Archer;
import characters.GameCharacter;
import characters.Knight;
import characters.Samurai;

public class Player {

    final private String name;
    private String characterName;
    private Integer health;
    private Integer damage;
    private Integer money;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void selectCharacter() {
        GameCharacter[] gameCharacters = {new Archer(), new Knight(), new Samurai()};
        for (GameCharacter e : gameCharacters) {
            System.out.println(e);
        }

    }
}
