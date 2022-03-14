package obstacle;

public abstract class Obstacle {
    final private Integer id;
    final private String name;
    final private Integer maxHealth;
    private Integer health;
    private Integer damage;
    private Integer awardOnDefeat;

    public Obstacle(Integer id, String name, Integer maxHealth, Integer health, Integer damage, Integer awardOnDefeat) {
        this.id = id;
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
        this.damage = damage;
        this.awardOnDefeat = awardOnDefeat;
    }


    public String getName() {
        return name;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getMaxHealth() {
        return maxHealth;
    }

    public void setHealth(Integer health) {
        if (health < 0)
            health = 0;
        this.health = health;
    }

    public Integer getDamage() {
        return damage;
    }

    public Object getAwardOnDefeat() {
        return awardOnDefeat;
    }

    public abstract Integer calculateDamage();

    public void getStats() {
        System.out.println("\n");
        System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
        System.out.println("Enemy name is " + getName()
                + "\nHealth " + getHealth()
                + "\nDamage " + getDamage()
        );
        System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~\n");
    }


}
