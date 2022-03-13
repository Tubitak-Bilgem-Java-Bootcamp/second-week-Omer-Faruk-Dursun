package location;

import Item.Weapon;
import player.Player;

import java.util.Scanner;

public class ItemStore extends Location {

    private final static String LOCATION_NAME = "Item Store";

    public ItemStore(Player player) {
        super(player, LOCATION_NAME);
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the " + LOCATION_NAME);
        System.out.println("1 - Weapons");
        System.out.println("2 - Armors");
        System.out.println("3 - Exit the store");
        Scanner scanner = new Scanner(System.in);
        int storeSelectionInput = scanner.nextInt();
        if (storeSelectionInput < 1 || storeSelectionInput > 3) {
            System.out.println("Please use the options available");
            storeSelectionInput = scanner.nextInt();
        }
        switch (storeSelectionInput) {
            case 1:
                showWeapons();
                break;
            case 2:
                showArmors();
                break;
            case 3:
                exitStore();
                return true;
            default:
        }

        return true;
    }

    private void showWeapons() {
        System.out.println("Weapons : ");
        for (Weapon w : Weapon.listWeapons()) {
            System.out.println(w.getId() + " name: " + w.getName() + " damage: " + w.getDamage() + " price: " + w.getPrice());
        }
        System.out.println("Please select a weapon:");

        Scanner scanner = new Scanner(System.in);
        int storeWeaponSelectionInput = scanner.nextInt();

        if (storeWeaponSelectionInput < 1 || storeWeaponSelectionInput > Weapon.listWeapons().length) {
            System.out.println("Please use the options available");
            storeWeaponSelectionInput = scanner.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponsByID(storeWeaponSelectionInput);

        if (selectedWeapon.getPrice() > getPlayer().getMoney()) {
            System.out.println("Not enough money to make tis purchase");
        } else {
            System.out.println("You purchased the " + selectedWeapon.getName());
            Integer balanceAfterPurchase = getPlayer().getMoney() - selectedWeapon.getPrice();
            this.getPlayer().setMoney(balanceAfterPurchase);
            System.out.println("Your balance after the purchase " + getPlayer().getMoney());
        }

    }

    private void showArmors() {
        System.out.println("Armor : ");
    }

    private void exitStore() {
        System.out.println("Have a good day !");
    }


}
