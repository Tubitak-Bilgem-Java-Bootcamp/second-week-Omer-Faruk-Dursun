package location.battlelocation;

import obstacle.Obstacle;
import obstacle.Snake;
import player.Player;

public class Mine extends BattleLocation{

    private final static String NAME = "Mine";
    private final static Obstacle OBSTACLE = new Snake();
    private final static String AWARD = "";
    private final static Integer MAX_OBSTACLE = 5;

    public Mine(Player player) {
        super(player, NAME, OBSTACLE, AWARD, MAX_OBSTACLE);
    }
}
