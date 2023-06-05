package fr.kizafox.toolsplus.managers.commands.task;

import fr.kizafox.toolsplus.ToolsPlus;
import fr.kizafox.toolsplus.tools.string.StringUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

/**
 * Change this line to a short description of the class
 *
 * @author : KIZAFOX
 * @date : 05/06/2023
 * @project : ToolsPlus
 */
public class ToolsPlusRunnable extends BukkitRunnable {

    private final Player player;
    private final ItemStack itemStack;

    public ToolsPlusRunnable(final Player player) {
        this.player = player;
        this.itemStack = player.getItemInHand();
    }

    @Override
    public void run() {
        if(!ToolsPlus.TOGGLE_INFOS.contains(player.getUniqueId())){
            this.cancel();
            ToolsPlus.TOGGLE_INFOS.remove(player.getUniqueId());
            player.sendMessage(Objects.requireNonNull(ToolsPlus.get().getConfig().getString("disable")).replaceAll("&", "§"));
        }else{
            player.spigot().sendMessage(
                    ChatMessageType.ACTION_BAR,
                    TextComponent.fromLegacyText(Objects.requireNonNull(ToolsPlus.get().getConfig().getString("actionbar.message")).replaceAll("&", "§").replace("%toolName%", StringUtils.capitalize(StringUtils.fromMaterial(itemStack.getType()).replace("_", " "))).replace("%currentDurability%", String.valueOf(itemStack.getDurability())).replace("%maxDurability%", String.valueOf(itemStack.getType().getMaxDurability()))));
        }

        if(player.getItemInHand().getType() == Material.AIR){
            player.sendMessage(Objects.requireNonNull(ToolsPlus.get().getConfig().getString("error")).replaceAll("&", "§"));
            this.cancel();
        }
    }
}
