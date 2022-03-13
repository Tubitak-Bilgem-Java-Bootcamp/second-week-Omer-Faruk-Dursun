package characters;

public abstract class GameCharacter {
    final private String name;
    private Integer health;
    private Integer damage;
    private Integer money;

    public GameCharacter(String name, Integer health, Integer damage, Integer money) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getDamage() {
        return damage;
    }

    public Integer getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Character name=" + name + " health=" + health + ", damage=" + damage + ", money=" + money ;
    }
}
