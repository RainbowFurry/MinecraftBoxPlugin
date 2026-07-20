package net.rainbowfurry.boxSMP.builder;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.ChatColor;

public class Translation {

    private String gay = "<gradient:#FF0000:#FF7F00:#FFFF00:#00FF00:#0000FF:#8B00FF><b>Regenbogen</b></gradient>";
    private String trans = "<gradient:#5BCEFA:#F5A9B8:#FFFFFF:#F5A9B8:#5BCEFA><b>Transgender</b></gradient>";
    private String bluepink = "<gradient:#004BFF:#8A2BE2:#FF007F><b>Blau Pink</b></gradient>";

    public String TranslateMessage(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public String TranslateGradientMessage(String message) {

        String text = "<gradient:#ff0055:#5500ff>Das ist ein wunderschöner Farbverlauf!</gradient>";

        Component gradientComponent = MiniMessage.miniMessage().deserialize(text);

        return LegacyComponentSerializer.legacySection().serialize(gradientComponent);
    }

    public String Translate(String message){
        Component gradientComponent = MiniMessage.miniMessage().deserialize(message);
        return TranslateMessage(LegacyComponentSerializer.legacySection().serialize(gradientComponent));
    }

}
