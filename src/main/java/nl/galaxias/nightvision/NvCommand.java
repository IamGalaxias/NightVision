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
                if (args.length < 1) {
                    player.sendMessage(ChatColor.RED + "/" + cmd.getName() + " toggle");
                }

                if (args.length == 1 && args[0].equals("toggle")) {
                    if (toggle == true) {
                        toggle = false;

                        player.removePotionEffect(PotionEffectType.NIGHT_VISION);

                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', NightVision.getPlugin().getConfig().getString("messages.toggle-off")));
                    }

                    else if (toggle == false) {
                        toggle = true;

                        if (args.length > 1) {
                            int duration = Integer.parseInt(args[1]);
                            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, duration, 1));
                        }

                        if (args.length == 1) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100000, 1));
                        }

                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', NightVision.getPlugin().getConfig().getString("messages.toggle-on")));
                    }
                }
            }
            else if (!(sender.hasPermission("nightvision.toggle"))) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', NightVision.getPlugin().getConfig().getString("messages.no-permission")));
            }
            return true;
        }
        return false;
    }
}

