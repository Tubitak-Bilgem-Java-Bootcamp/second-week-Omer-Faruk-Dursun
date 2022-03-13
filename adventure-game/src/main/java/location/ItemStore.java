package location;

import player.Player;

public class ItemStore extends Location {

    private final static String LOCATION_NAME = "Item Store";

    public ItemStore(Player player) {
        super(player, LOCATION_NAME);
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the " + LOCATION_NAME);
        return true;
    }
}
