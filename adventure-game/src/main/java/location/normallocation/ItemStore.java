package location.normallocation;

import Item.Armor;
import Item.Weapon;
import location.Location;
import player.Player;

import java.util.Scanner;

public class ItemStore extends Location {

    private final static String LOCATION_NAME = "Item Store";
    private final static String ITEM_STORE_ASCII_ART = "<+><+><+><+><+><+><+><+><+><+><+><+><+><+><+><+><+><+><+><+>";

    public ItemStore(Player player) {
        super(player, LOCATION_NAME);
    }

    @Override
    public boolean onLocation() {
        System.out.println(ITEM_STORE_ASCII_ART);
        System.out.println("Welcome to the " + LOCATION_NAME);
        boolean stayInShop = true;
        while(stayInShop){
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Exit the store");
            System.out.println(ITEM_STORE_ASCII_ART);
            Scanner scanner = new Scanner(System.in);
            int storeSelectionInput = scanner.nextInt();
            if (storeSelectionInput < 1 || storeSelectionInput > 3) {
                System.out.println("Please use the options available");
                storeSelectionInput = scanner.nextInt();
            }
            switch (storeSelectionInput) {
                case 1:
                    showWeapons();
                    purchaseWeapon();
                    break;
                case 2:
                    showArmors();
                    purchaseArmor();
                    break;
                case 3:
                    exitStore();
                    stayInShop = false;
                    break;
            }
        }
        return true;
    }

    private void showWeapons() {
        System.out.println(ITEM_STORE_ASCII_ART);
        System.out.println("Weapons : ");
        System.out.println("0 to exit");
        for (Weapon w : Weapon.listWeapons()) {
            System.out.println(w.getId() + " name: " + w.getName() + " damage: " + w.getDamage() + " price: " + w.getPrice());
        }
        System.out.println("Please select a weapon:");
        System.out.println(ITEM_STORE_ASCII_ART);
    }

    private void purchaseWeapon(){
        Scanner scanner = new Scanner(System.in);
        int storeWeaponSelectionInput = scanner.nextInt();

        if (storeWeaponSelectionInput < 0 || storeWeaponSelectionInput > Weapon.listWeapons().length) {
            System.out.println("Please use the options available");
            storeWeaponSelectionInput = scanner.nextInt();
        }
        if (storeWeaponSelectionInput != 0){
            Weapon selectedWeapon = Weapon.getWeaponsByID(storeWeaponSelectionInput);

            if (selectedWeapon.getPrice() > getPlayer().getMoney()) {
                System.out.println("Not enough money to make tis purchase");
            } else {
                System.out.println("You purchased the " + selectedWeapon.getName());
                Integer balanceAfterPurchase = getPlayer().getMoney() - selectedWeapon.getPrice();
                getPlayer().setMoney(balanceAfterPurchase);
                System.out.println("Your balance after the purchase " + getPlayer().getMoney());
                System.out.println("Old weapon : " + getPlayer().getInventory().getWeapon().getName());
                getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("New weapon : " + getPlayer().getInventory().getWeapon().getName());
            }
        }
    }

    private void showArmors() {
        System.out.println(ITEM_STORE_ASCII_ART);
        System.out.println("Armor : ");
        System.out.println("0 to exit");
        for (Armor w : Armor.listArmors()) {
            System.out.println(w.getId() + " name: " + w.getName() + " damage: " + w.getBlock() + " price: " + w.getPrice());
        }
        System.out.println("Please select an armor:");
        System.out.println(ITEM_STORE_ASCII_ART);
    }

    private void purchaseArmor(){
        Scanner scanner = new Scanner(System.in);
        int storeArmorSelectionInput = scanner.nextInt();

        if (storeArmorSelectionInput < 0 || storeArmorSelectionInput > Armor.listArmors().length) {
            System.out.println("Please use the options available");
            storeArmorSelectionInput = scanner.nextInt();
        }

        if (storeArmorSelectionInput != 0){
            Armor selectedArmor = Armor.getArmorByID(storeArmorSelectionInput);

            if (selectedArmor.getPrice() > getPlayer().getMoney()) {
                System.out.println("Not enough money to make tis purchase");
            } else {
                System.out.println("You purchased the " + selectedArmor.getName());
                Integer balanceAfterPurchase = getPlayer().getMoney() - selectedArmor.getPrice();
                getPlayer().setMoney(balanceAfterPurchase);
                System.out.println("Your balance after the purchase " + getPlayer().getMoney());
                System.out.println("Old weapon : " + getPlayer().getInventory().getArmor().getName());
                getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("New weapon : " + getPlayer().getInventory().getArmor().getName());
            }
        }
    }

    private void exitStore() {
        System.out.println("Have a good day !");
    }


}
