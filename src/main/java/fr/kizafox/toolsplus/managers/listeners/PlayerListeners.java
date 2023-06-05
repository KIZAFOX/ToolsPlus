package fr.kizafox.toolsplus.managers.listeners;

import fr.kizafox.toolsplus.ToolsPlus;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Change this line to a short description of the class
 *
 * @author : KIZAFOX
 * @date : 05/06/2023
 * @project : ToolsPlus
 */
public class PlayerListeners implements Listener {

    @EventHandler (priority = EventPriority.MONITOR)
    public void onPlayerJoin(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        ToolsPlus.TOGGLE_INFOS.remove(player.getUniqueId());
    }
}
