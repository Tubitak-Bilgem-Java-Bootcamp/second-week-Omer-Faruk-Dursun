package obstacle;

import Item.Armor;
import Item.Weapon;

import java.util.Random;

public class Snake extends Obstacle {

    private final static Integer ID = 4;
    private final static String NAME = "Snake";
    private final static Integer HEALTH = 12;
    private final static Integer MAX_HEALTH = 12;
    private final static Integer DAMAGE = 4;
    private final static Integer AWARD_ON_DEFEAT = 0;

    public Snake() {
        super(ID, NAME, MAX_HEALTH, HEALTH, DAMAGE, AWARD_ON_DEFEAT);
    }

    public Integer calculateDamage() {
        Random random = new Random();
        return random.nextInt(3) + 3;
    }

    @Override
    public Integer getDamage() {
        Random random = new Random();
        return random.nextInt(3)+3;
    }

    @Override
    public Object getAwardOnDefeat() {
        return calculateAwardProbability();
    }

    private Object calculateAwardProbability() {
        Object award;

        int foo = (int) (Math.random() * 100);

        if (foo < 15)      // 0-14  --> 15%
            award = calculateWeaponAwardProbability();
        else if (foo < 30) // 14-29 --> 15%
            award = calculateArmorAwardProbability();
        else if (foo < 55) // 29-54 --> 25%
            award = calculateMoneyAwardProbability();
        else               // 55-99 Do nothing
            award = null;


        return award;
    }

    private Weapon calculateWeaponAwardProbability() {

        int foo = (int) (Math.random() * 100);

        if (foo < 50)      // 0-49
            return new Weapon(1,"Hand Gun",2,0);
        else if (foo < 80) // 50-79
            return new Weapon(2,"Sword",3,0);
        else              // 79-99
            return new Weapon(3,"Rifle",7,0);

    }

    private Armor calculateArmorAwardProbability() {

        int foo = (int) (Math.random() * 100);

        if (foo < 50)      // 0-49
            return new Armor(1,"Light Armor",1,0);
        else if (foo < 80) // 50-79
            return new Armor(2,"Medium Armor",3,0);
        else              // 79-99
            return new Armor(3,"Heavy Armor",5,0);

    }

    private Integer calculateMoneyAwardProbability() {

        int foo = (int) (Math.random() * 100);

        if (foo < 50)      // 0-49
            return 1;
        else if (foo < 80) // 50-79
            return 5;
        else              // 79-99
            return 10;

    }


}
