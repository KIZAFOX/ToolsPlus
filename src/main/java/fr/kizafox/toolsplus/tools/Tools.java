package fr.kizafox.toolsplus.tools;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public enum Tools {

    WOODEN_SHOVEL(Material.WOODEN_SHOVEL),
    WOODEN_SWORD(Material.WOODEN_SWORD),
    WOODEN_PICKAXE(Material.WOODEN_PICKAXE),
    WOODEN_AXE(Material.WOODEN_AXE),
    WOODEN_HOE(Material.WOODEN_HOE),

    STONE_SWORD(Material.STONE_SWORD),
    STONE_SHOVEL(Material.STONE_SHOVEL),
    STONE_PICKAXE(Material.STONE_PICKAXE),
    STONE_AXE(Material.STONE_AXE),
    STONE_HOE(Material.STONE_HOE),

    IRON_SWORD(Material.IRON_SWORD),
    IRON_SHOVEL(Material.IRON_SHOVEL),
    IRON_PICKAXE(Material.IRON_PICKAXE),
    IRON_AXE(Material.IRON_AXE),
    IRON_HOE(Material.IRON_HOE),

    GOLDEN_SWORD(Material.GOLDEN_SWORD),
    GOLDEN_SHOVEL(Material.GOLDEN_SHOVEL),
    GOLDEN_PICKAXE(Material.GOLDEN_PICKAXE),
    GOLDEN_AXE(Material.GOLDEN_AXE),
    GOLDEN_HOE(Material.GOLDEN_HOE),

    DIAMOND_SWORD(Material.DIAMOND_SWORD),
    DIAMOND_SHOVEL(Material.DIAMOND_SHOVEL),
    DIAMOND_PICKAXE(Material.DIAMOND_PICKAXE),
    DIAMOND_AXE(Material.DIAMOND_AXE),
    DIAMOND_HOE(Material.DIAMOND_HOE),

    NETHERITE_SWORD(Material.NETHERITE_SWORD),
    NETHERITE_SHOVEL(Material.NETHERITE_SHOVEL),
    NETHERITE_PICKAXE(Material.NETHERITE_PICKAXE),
    NETHERITE_AXE(Material.NETHERITE_AXE),
    NETHERITE_HOE(Material.NETHERITE_HOE);

    private final Material material;

    public static final List<Material> TOOLS = new ArrayList<>();

    Tools(final Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

}
