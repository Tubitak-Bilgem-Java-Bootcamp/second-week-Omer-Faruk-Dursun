package Item;

public class Armor {

    final private int id;
    private String name;
    private int block;
    private int price;

    public Armor(int id, String name, int block, int price) {

        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public int getPrice() {
        return price;
    }

    public static Armor[] listArmors() {
        Armor[] armor = new Armor[3];
        armor[0] = new Armor(1, "Light Armor", 1, 15);
        armor[1] = new Armor(2, "Middle Armor", 3, 25);
        armor[2] = new Armor(3, "Heavy Armor", 5, 40);
        return armor;
    }

    public static Armor getArmorByID(Integer id) {
        for (Armor w : Armor.listArmors()) {
            if (w.getId() == id) {
                return w;
            }
        }

        return null;
    }


}
