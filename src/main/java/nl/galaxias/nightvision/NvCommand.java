package nl.galaxias.nightvision;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by wdele on 10-04-15.
 */
public class NvCommand implements CommandExecutor {
    public static boolean toggle = false;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("nv")) {
            Player player = (Player) sender;

            if (sender.hasPermission("nightvision.toggle")) {
                if (args.length != 1) {
                    player.sendMessage(ChatColor.RED + "/" + cmd + " toggle");
                }

                if (toggle == true) {
                    toggle = false;

                    player.removePotionEffect(PotionEffectType.NIGHT_VISION);

                    ChatColor.translateAlternateColorCodes('&', NightVision.getPlugin().getConfig().getString("messages.toggle-off"));
                }

                if (toggle == false) {
                    toggle = true;

                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100000, 1));
                }
            }
            else if (!(sender.hasPermission("nightvision.toggle"))) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', NightVision.getPlugin().getConfig().getString("messages.toggle-on")));
            }
            return true;
        }
        return false;
    }
}
