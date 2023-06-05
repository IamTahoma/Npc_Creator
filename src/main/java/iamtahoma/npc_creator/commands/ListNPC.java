package iamtahoma.npc_creator.commands;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ListNPC implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        Iterable<NPC> npcs = registry;

        if (!npcs.iterator().hasNext()) {
            sender.sendMessage("No se han creado NPCs.");
        } else {
            sender.sendMessage("Lista de NPCs:");
            for (NPC npc : npcs) {
                sender.sendMessage("ID: " + npc.getId() + ", Nombre: " + npc.getName());
            }
        }

        return true;
    }
}
