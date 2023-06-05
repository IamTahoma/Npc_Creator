package iamtahoma.npc_creator;

import iamtahoma.npc_creator.commands.CreateNpc;
import iamtahoma.npc_creator.commands.DeleteNpc;
import iamtahoma.npc_creator.commands.ListNPC;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Npc_Creator extends JavaPlugin {
    ConsoleCommandSender myCmd = Bukkit.getConsoleSender();
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("create_npc").setExecutor(new CreateNpc());
        this.getCommand("delete_npc").setExecutor(new DeleteNpc());
        this.getCommand("list_npc").setExecutor(new ListNPC());
        myCmd.sendMessage("§aEl plugin se ha [Iniciado]");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        myCmd.sendMessage("§aEl plugin se ha [Desactivado]");

    }
}
