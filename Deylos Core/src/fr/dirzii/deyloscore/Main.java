package fr.dirzii.deyloscore;

import fr.dirzii.deyloscore.commands.CommandBroadcast;
import fr.dirzii.deyloscore.commands.CommandInfos;
import fr.dirzii.deyloscore.commands.CommandPing;
import fr.dirzii.deyloscore.commands.CommandSpawn;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("Deylos Core vient de s'allumer");
        getCommand("infos").setExecutor(new CommandInfos());
        getCommand("spawn").setExecutor(new CommandSpawn());
        getCommand("broadcast").setExecutor(new CommandBroadcast());
        getCommand("ping").setExecutor(new CommandPing());
    }
}
