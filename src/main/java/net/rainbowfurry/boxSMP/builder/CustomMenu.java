package net.rainbowfurry.boxSMP.builder;

import io.papermc.paper.dialog.Dialog;
import io.papermc.paper.registry.data.dialog.ActionButton;
import io.papermc.paper.registry.data.dialog.DialogBase;
import io.papermc.paper.registry.data.dialog.type.DialogType;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.rainbowfurry.boxSMP.BoxSMP;
import org.bukkit.Bukkit;
import org.bukkit.ServerLinks;
import org.bukkit.entity.Player;

import java.net.URI;

public class CustomMenu {

    public void createCustomMenu(Player player) {
        Dialog dialog = Dialog.create(builder -> builder.empty()
                .base(DialogBase.builder(Component.text("Title")).build())
                .type(DialogType.notice())
        );
        player.showDialog(dialog);
    }

    public void createCustomMenuWithLinks(Player player) {
        // 1. Erstelle die ServerLinks-Sammlung für diesen Spieler
        ServerLinks links = Bukkit.getServerLinks();

        // Einen bekannten Typ hinzufügen (z. B. Discord - Minecraft übersetzt das Label automatisch)
        links.addLink(ServerLinks.Type.FORUMS, URI.create("https://google.de"));
        links.addLink(ServerLinks.Type.FORUMS, URI.create("https://google.de"));

        // Einen komplett eigenen Link mit individuellem Text hinzufügen
        links.addLink(Component.text("§bUnser Webshop"), URI.create("https://google.de"));

        // 2. Schicke die Links an den Spieler-Client
        player.sendLinks(links);

        // 3. Zeige den ServerLinks-Dialog an
        Dialog dialog = Dialog.create(builder -> builder.empty()
                .base(DialogBase.builder(Component.text("§6§lWICHTIGE LINKS")).build())
                .type(DialogType.serverLinks(null, 2, 150)) // Greift automatisch auf die gesendeten Links zu
        );
        player.showDialog(dialog);
    }

}
