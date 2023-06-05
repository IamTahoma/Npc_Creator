package iamtahoma.npc_creator.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;

public class DeleteNpc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        boolean npcEncontrado = false;
        int npcId;

        if (strings.length < 1) {
            sender.sendMessage("Por favor, proporciona el ID del NPC a eliminar.");
            return false;
        }

        try {
            npcId = Integer.parseInt(strings[0]);
        } catch (NumberFormatException e) {
            sender.sendMessage("El ID del NPC debe ser un número válido.");
            return false;
        }

        NPCRegistry registry = CitizensAPI.getNPCRegistry();

        for (NPC npc : registry) {
            if (npc.getId() == npcId) {
                npc.destroy();
                npcEncontrado = true;
                break;
            }
        }

        if (npcEncontrado) {
            sender.sendMessage("Se eliminó el NPC con el ID: " + npcId);
        } else {
            sender.sendMessage("No se encontró ningún NPC con el ID: " + npcId);
        }

        return true;
    }
}
