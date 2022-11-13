package fr.dirzii.deyloscore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage("§aVous venez d'être téléporté au spawn");
            player.teleport(player.getWorld().getSpawnLocation());
        }
        return false;
    }
}
