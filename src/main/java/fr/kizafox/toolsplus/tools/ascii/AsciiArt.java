package fr.kizafox.toolsplus.tools.ascii;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Change this line to a short description of the class
 *
 * @author : KIZAFOX
 * @date : 29/05/2023
 * @project : KZXCore
 */
public class AsciiArt {
    public void draw(final String text, final char artChar, final Settings settings, boolean forBukkit) {
        final BufferedImage image = new BufferedImage(settings.width, settings.height, BufferedImage.TYPE_INT_RGB);
        final Graphics graphics = image.getGraphics();

        graphics.setFont(settings.font);

        final Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.drawString(text, 6, ((int) (settings.height * 0.67)));

        for (int y = 0; y < settings.height; y++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int x = 0; x < settings.width; x++) {
                stringBuilder.append(image.getRGB(x, y) == -16777216 ? " " : artChar);
            }

            if (stringBuilder.toString().trim().isEmpty()) {
                continue;
            }

            if(forBukkit){
                Bukkit.getConsoleSender().sendMessage(settings.color + stringBuilder.toString());
            }else{
                System.out.println(stringBuilder);
            }
        }
    }

    public record Settings(Font font, int width, int height, ChatColor color) {}
}