package fr.dirzii.monplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player)sender;

            if(cmd.getName().equalsIgnoreCase("test")){
                player.sendMessage("§eBravo tu as réussi §9le test");
            }

            if(cmd.getName().equalsIgnoreCase("alert")){

                if(args.length == 0) {
                    player.sendMessage("La commande est : /alert <message>");
                }
                if(args.length > 0) {
                    StringBuilder bc = new StringBuilder();
                    for(String part : args) {
                        bc.append(part + " ");
                    }
                    Bukkit.broadcastMessage("§4[" + player.getName() + "] §c" + bc.toString());
                }

                return true;
            }
        }
        else {
            if(cmd.getName().equalsIgnoreCase("alert")){
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
        }


        return false;
    }
}
