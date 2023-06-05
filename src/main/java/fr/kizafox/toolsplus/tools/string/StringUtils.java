package fr.kizafox.toolsplus.tools.string;

import org.bukkit.Material;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Change this line to a short description of the class
 *
 * @author : KIZAFOX
 * @date : 05/06/2023
 * @project : ToolsPlus
 */
public class StringUtils {

    public static String capitalizeWord(final String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public static String capitalize(final String name){
        if(name == null || name.length() == 0){
            return name;
        }
        return Stream.of(name.trim().split("\\s+")).map(StringUtils::capitalizeWord).collect(Collectors.joining(" "));
    }

    public static String fromMaterial(final Material material) {
        if (material == null) return "";
        return material.name().toLowerCase();
    }
}
