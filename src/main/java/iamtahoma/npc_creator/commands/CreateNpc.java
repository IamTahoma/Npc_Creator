package iamtahoma.npc_creator.commands;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateNpc implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Este comando solo puede ser usado por un jugador.");
            return true;
        }

        if (strings.length < 1) {
            sender.sendMessage("Por favor, proporciona un nombre para el NPC.");
            return false;
        }

        Player player = (Player) sender;
        String npcName = strings[0];
        NPCRegistry registry = CitizensAPI.getNPCRegistry();

        NPC npc = registry.createNPC(player.getType(), npcName);

        npc.spawn(player.getLocation());
        player.sendMessage("Se ha creado el NPC con el nombre: " + npcName);
        int npcId = npc.getId();
        sender.sendMessage("El ID del NPC '" + npcName + "' es: " + npcId);

        return true;
    }
}
