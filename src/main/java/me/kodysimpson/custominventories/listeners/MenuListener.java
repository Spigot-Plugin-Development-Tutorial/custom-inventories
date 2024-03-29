package me.kodysimpson.custominventories.listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){

        //See if the inventory that was clicked was the custom menu
        // by checking the name of the inventory
        if (event.getView().getTitle().equals(ChatColor.AQUA + "Custom GUI")){

            //IMPORTANT! Cancel the event so that players cannot move items
            event.setCancelled(true);

            //We only care about left clicks for this
            if (!event.getClick().isLeftClick()) return;

            Player player = (Player) event.getWhoClicked();

            //Determine which "buttons" were clicked and do something
            switch (event.getCurrentItem().getType()){
                case BREAD:
                    player.setFoodLevel(20);
                    player.sendMessage("YUM! Quite bussing.");
                    break;
                case TNT:
                    player.setHealth(0);
                    player.sendMessage("You just killed yourself.");
                    break;
                case DIAMOND_SWORD:
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                    player.sendMessage("Dont slice yourself");
                    break;
            }

        }else{
            System.out.println(event.getView().getTitle());
        }

    }

}
