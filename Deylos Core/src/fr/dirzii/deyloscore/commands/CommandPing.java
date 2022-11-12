package fr.dirzii.deyloscore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPing implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage("§bPing : " + p.getPing() + "ms");
        }
        return false;
    }
}
