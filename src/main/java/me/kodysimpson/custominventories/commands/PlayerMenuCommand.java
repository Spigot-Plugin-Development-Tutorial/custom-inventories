package me.kodysimpson.custominventories.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class PlayerMenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){

            //Create the menu
            Inventory menu = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Custom GUI");

            //The options
            ItemStack feed = new ItemStack(Material.BREAD);
            ItemStack death = new ItemStack(Material.TNT);
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);

            //Edit the items
            ItemMeta feedMeta = feed.getItemMeta();
            feedMeta.setDisplayName(ChatColor.GREEN + "Feed");
            feedMeta.setLore(List.of(ChatColor.GOLD + "Hunger no more."));
            feed.setItemMeta(feedMeta);

            ItemMeta deathMeta = death.getItemMeta();
            deathMeta.setDisplayName(ChatColor.RED + "Kill");
            deathMeta.setLore(List.of(ChatColor.GOLD + "Death is inevitable."));
            death.setItemMeta(deathMeta);

            ItemMeta swordMeta = sword.getItemMeta();
            swordMeta.setDisplayName(ChatColor.GOLD + "Give Sword");
            swordMeta.setLore(List.of(ChatColor.GOLD + "The sword of a king."));
            sword.setItemMeta(swordMeta);

            //Put the items in the menu
            menu.setItem(0, feed);
            menu.setItem(4, death);
            menu.setItem(8, sword);

            //Open the menu for the player
            player.openInventory(menu);
        }else{
            sender.sendMessage(ChatColor.RED + "You must be a player to use this command.");
        }

        return true;
    }
}
