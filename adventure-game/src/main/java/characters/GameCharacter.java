package characters;

public abstract class GameCharacter {
    final private Integer id;
    final private String name;
    private Integer health;
    private Integer damage;
    private Integer money;

    public GameCharacter(Integer id, String name, Integer health, Integer damage, Integer money) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.money = money;
    }

    public Integer getId() {
        return id;
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

}
