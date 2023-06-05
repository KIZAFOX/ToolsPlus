package fr.kizafox.toolsplus.managers.commands;

import fr.kizafox.toolsplus.ToolsPlus;
import fr.kizafox.toolsplus.managers.commands.task.ToolsPlusRunnable;
import fr.kizafox.toolsplus.tools.Tools;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

/**
 * Change this line to a short description of the class
 *
 * @author : KIZAFOX
 * @date : 05/06/2023
 * @project : ToolsPlus
 */
public class DefaultCommand implements CommandExecutor {

    protected final ToolsPlus instance;

    public DefaultCommand(final ToolsPlus instance) {
        this.instance = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof final Player player)){
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        if(args.length == 0){
            player.sendMessage(ChatColor.RED + "Usage: /toolsplus <toggle/reload>");
            return true;
        }

        switch (args[0]) {
            case "toggle" -> {
                if(!Tools.TOOLS.contains(player.getItemInHand().getType())){
                    player.sendMessage(Objects.requireNonNull(ToolsPlus.get().getConfig().getString("not-a-tool")).replaceAll("&", "§"));
                    player.sendMessage(Objects.requireNonNull(ToolsPlus.get().getConfig().getString("list-of-tools")).replaceAll("&", "§"));
                    Tools.TOOLS.forEach(tools -> player.sendMessage(Objects.requireNonNull(ToolsPlus.get().getConfig().getString("list")).replaceAll("&", "§").replace("%tool%", String.valueOf(Material.getMaterial(tools.name())))));
                    player.sendMessage(Objects.requireNonNull(ToolsPlus.get().getConfig().getString("scroll-up")).replaceAll("&", "§"));
                }else{
                    if (!ToolsPlus.TOGGLE_INFOS.contains(player.getUniqueId())) {
                        ToolsPlus.TOGGLE_INFOS.add(player.getUniqueId());
                        player.sendMessage(Objects.requireNonNull(ToolsPlus.get().getConfig().getString("enable")).replaceAll("&", "§"));


                        new ToolsPlusRunnable(player).runTaskTimer(this.instance, 1, 1);
                    } else {
                        ToolsPlus.TOGGLE_INFOS.remove(player.getUniqueId());
                    }
                }
            }
            case "reload" -> {
                if(player.isOp()){
                    this.instance.reloadConfig();
                    player.sendMessage(Objects.requireNonNull(ToolsPlus.get().getConfig().getString("reload-config")).replaceAll("&", "§"));
                }else{
                    player.sendMessage(Objects.requireNonNull(ToolsPlus.get().getConfig().getString("no-permission")).replaceAll("&", "§"));
                }
            }
            default -> player.sendMessage(ChatColor.RED + "Usage: /toolsplus <toggle/reload>");
        }
        return false;
    }
}
