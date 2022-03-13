package location.battlelocation;

import obstacle.Obstacle;
import obstacle.Zombie;
import player.Player;

public class Cave extends BattleLocation{

    private final static String NAME = "Cave";
    private final static Obstacle OBSTACLE = new Zombie();
    private final static String AWARD = "Food";
    private final static Integer MAX_OBSTACLE = 3;

    public Cave(Player player) {
        super(player, NAME, OBSTACLE, AWARD, MAX_OBSTACLE);
    }
}
