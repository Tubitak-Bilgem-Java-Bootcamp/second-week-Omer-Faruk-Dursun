package Item;

public class Weapon {

    private Integer id;
    private String name;
    private Integer damage;
    private Integer price;

    public Weapon(Integer id, String name, Integer damage, Integer price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDamage() {
        return damage;
    }

    public Integer getPrice() {
        return price;
    }

    public static Weapon[] listWeapons() {
        Weapon[] weapons = {new Weapon(1, "Gun", 5, 10),
                new Weapon(2, "Sword", 3, 5)};
        return weapons;
    }

    public static Weapon getWeaponsByID(Integer id) {
        for (Weapon w : Weapon.listWeapons()) {
            if (w.getId() == id) {
                return w;
            }
        }

        return null;
    }

}
