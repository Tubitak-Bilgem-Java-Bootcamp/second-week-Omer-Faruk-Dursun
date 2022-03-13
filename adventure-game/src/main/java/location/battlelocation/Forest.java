package location.battlelocation;

import obstacle.Obstacle;
import obstacle.Vampire;
import player.Player;

public class Forest extends BattleLocation{

    private final static String NAME = "Forest";
    private final static Obstacle OBSTACLE = new Vampire();
    private final static String AWARD = "Firewood";
    private final static Integer MAX_OBSTACLE = 3;

    public Forest(Player player) {
        super(player, NAME, OBSTACLE, AWARD, MAX_OBSTACLE);
    }
}
