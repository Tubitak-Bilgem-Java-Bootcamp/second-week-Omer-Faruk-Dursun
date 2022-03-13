package location.battlelocation;

import obstacle.Bear;
import obstacle.Obstacle;
import player.Player;

public class River extends BattleLocation{

    private final static String NAME = "River";
    private final static Obstacle OBSTACLE = new Bear();
    private final static String AWARD = "Water";
    private final static Integer MAX_OBSTACLE = 3;

    public River(Player player) {
        super(player, NAME, OBSTACLE, AWARD, MAX_OBSTACLE);
    }
}
