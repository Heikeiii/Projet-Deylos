package fr.dirzii.monplugin;

import fr.dirzii.monplugin.commands.CommandInfos;
import fr.dirzii.monplugin.commands.CommandTest;
import org.bukkit.plugin.java.JavaPlugin;

public class Main  extends  JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Le plugin vient de s'allumer");
        getCommand("test").setExecutor(new CommandTest ());
        getCommand("alert").setExecutor(new CommandTest());
        getCommand("infos").setExecutor(new CommandInfos());

    }

    @Override
    public void onDisable() {
        System.out.println("Le plugin vient de s'eteindre");
    }
}
