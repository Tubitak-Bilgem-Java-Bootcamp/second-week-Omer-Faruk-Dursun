package location.normallocation;

import player.Player;

public class SafeHouse extends NormalLocation{

    private final static String LOCATION_NAME = "Safe House";

    public SafeHouse(Player player) {
        super(player, LOCATION_NAME);
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are on the " + LOCATION_NAME +" !");
        System.out.println("Your health have been restored to full !");
        return super.onLocation();
    }
}
