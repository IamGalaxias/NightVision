package nl.galaxias.nightvision;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by wdele on 10-04-15.
 */
public class NightVision extends JavaPlugin {
    private static Plugin plugin;
    FileConfiguration config = getConfig();

    public void onEnable() {
        plugin = this;

        config.addDefault("messages.no-permission", "&cYou do not have permission to toggle Night Vision!");
        config.addDefault("messages.toggle-on", "&aNight Vision was turned on!");
        config.addDefault("messages.toggle-off", "&aNight Vision was turned off!");

        getCommand("nv").setExecutor(new NvCommand());
    }

    public void onDisable() {
        plugin = null;
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}

