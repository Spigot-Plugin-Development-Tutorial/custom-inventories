package me.kodysimpson.custominventories;

import me.kodysimpson.custominventories.commands.PlayerMenuCommand;
import me.kodysimpson.custominventories.listeners.MenuListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomInventories extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("menu").setExecutor(new PlayerMenuCommand());
        getServer().getPluginManager().registerEvents(new MenuListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
