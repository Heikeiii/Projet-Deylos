package fr.dirzii.deyloscore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandInfos implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String args, String[] args2) {

        if (sender instanceof Player) {
            Player player = (Player)sender;

            if(args2.length == 1){
                Player p2 = Bukkit.getPlayer(args2[0]);
                if(p2 != null) {
                    player.sendMessage("§aNom du joueur : " + p2.getName());
                    player.sendMessage("§aUUID : " + p2.getUniqueId());
                    player.sendMessage("§aAdresse Ip : " + p2.getAddress());
                    player.sendMessage("§aPing : " + p2.getPing());
                } else{
                    player.sendMessage("§4Le joueur n'est pas connecté");
                }
            }

            if(args2.length != 1) {
                player.sendMessage("§4Veuillez utiliser la commande comme ceci : /infos <joueur>");
            }
        }


        return false;
    }
}