package net.rainbowfurry.boxSMP.manager;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.rainbowfurry.boxSMP.BoxSMP;
import org.bukkit.plugin.Plugin;

public class LogManager {

    private final Plugin plugin = BoxSMP.plugin;

    public void info(String message) {
        Component debugMessage = MiniMessage.miniMessage().deserialize(
                "<blue>[INFO]</blue><aqua>" + message + "</aqua>"
        );

        plugin.getComponentLogger().info(debugMessage);
    }

    public void debug(String message) {
        Component debugMessage = MiniMessage.miniMessage().deserialize(
                "<gray>[DEBUG]</gray>" + message
        );

        plugin.getComponentLogger().info(debugMessage);
    }

    public void warning(String message) {
        Component debugMessage = MiniMessage.miniMessage().deserialize(
                "<yellow>[WARNING]</yellow> <orange>" + message + "</orange>"
        );

        plugin.getComponentLogger().info(debugMessage);
    }

    public void error(String message) {
        Component debugMessage = MiniMessage.miniMessage().deserialize(
                "<red>[ERROR]</red> <light_red>" + message + "</light_red>"
        );

        plugin.getComponentLogger().info(debugMessage);
    }

    public void success(String message) {
        Component debugMessage = MiniMessage.miniMessage().deserialize(
                "<dark_green>[ERROR]</dark_green> <green>" + message + "</green>"
        );

        plugin.getComponentLogger().info(debugMessage);
    }

}
