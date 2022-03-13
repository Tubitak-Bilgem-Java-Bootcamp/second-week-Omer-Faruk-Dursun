package location;

import player.Player;

public abstract class Location {

    private Player player;
    private String name;

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }

    public abstract boolean onLocation();

    @Override
    public String toString() {
        return "Location name=" + name;
    }
}
