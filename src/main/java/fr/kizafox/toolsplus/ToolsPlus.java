package fr.kizafox.toolsplus;

import fr.kizafox.toolsplus.managers.commands.DefaultCommand;
import fr.kizafox.toolsplus.tools.Tools;
import fr.kizafox.toolsplus.tools.ascii.AsciiArt;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.util.*;
import java.util.List;

public final class ToolsPlus extends JavaPlugin {

    private static ToolsPlus instance;

    public static final List<UUID> TOGGLE_INFOS = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        Arrays.stream(Tools.values()).forEach(tools -> Tools.TOOLS.add(tools.getMaterial()));

        Objects.requireNonNull(this.getCommand("toolsplus")).setExecutor(new DefaultCommand(this));

        new AsciiArt().draw(this.getDescription().getName(), '/', new AsciiArt.Settings(new Font("SansSerif", Font.BOLD, 24), this.getDescription().getName().length() * 30, 30, ChatColor.AQUA), true);

        super.onEnable();
    }

    @Override
    public void onDisable() {
        Tools.TOOLS.clear();
        TOGGLE_INFOS.clear();
        super.onDisable();
    }

    public static ToolsPlus get() {
        return instance;
    }
}