package obstacle;

import java.util.Random;

public class Snake extends Obstacle {

    private final static Integer ID = 4;
    private final static String NAME = "Snake";
    private final static Integer HEALTH = 12;
    private final static Integer MAX_HEALTH = 12;
    private final static Integer DAMAGE = 0;
    private final static Integer AWARD_ON_DEFEAT = 0;

    public Snake() {
        super(ID, NAME, MAX_HEALTH, HEALTH, DAMAGE, AWARD_ON_DEFEAT);
    }

    public Integer calculateDamage(){
        Random random = new Random();
        return random.nextInt(3) + 3;
    }

    @Override
    public void getStats() {
        System.out.println("\n");
        System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~");
        System.out.println("Enemy name is " + getName()
                + "\nHealth " + getHealth()
                + "\nDamage " + calculateDamage()
                + "\nHealth " + getAwardOnDefeat()
        );
        System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~^~\n");
    }

}
