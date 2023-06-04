package iamtahoma.npc_creator;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Npc_Creator extends JavaPlugin {
    ConsoleCommandSender myCmd = Bukkit.getConsoleSender();
    @Override
    public void onEnable() {
        // Plugin startup logic
        myCmd.sendMessage("§aEl plugin se ha [Iniciado]");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        myCmd.sendMessage("§aEl plugin se ha [Desactivado]");

    }
}
