package obstacle;

public abstract class Obstacle {
    final private Integer id;
    final private String name;
    private Integer health;
    private Integer damage;

    public Obstacle(Integer id, String name, Integer health, Integer damage) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public Integer getId(){
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
}
