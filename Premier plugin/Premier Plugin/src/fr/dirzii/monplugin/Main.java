package fr.dirzii.monplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main  extends  JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Le plugin vient de s'allumer");
        getServer().getPluginManager().registerEvents(new PlayerConnection(), this);

    }

    @Override
    public void onDisable() {
        System.out.println("Le plugin vient de s'eteindre");
    }


}
