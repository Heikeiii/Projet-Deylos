package fr.dirzii.deyloscore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBroadcast implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player)sender;
            if(args.length == 0) {
                player.sendMessage("La commande est : /broadcast <message>");
            }
            if(args.length > 0) {
                StringBuilder bc = new StringBuilder();
                for(String part : args) {
                    bc.append(part + " ");
                }
                Bukkit.broadcastMessage("§4[" + player.getName() + "] §f" + bc.toString().replace("&", "§"));
            }

            return true;
        }
        else {
            if(args.length == 0) {
                System.out.println("La commande est : /alert <message>");
            }
            if(args.length > 0) {
                StringBuilder bc = new StringBuilder();
                for(String part : args) {
                    bc.append(part + " ");
                }
                Bukkit.broadcastMessage("§4[Console] §c" + bc.toString());
            }
        }

        return false;
    }
}
