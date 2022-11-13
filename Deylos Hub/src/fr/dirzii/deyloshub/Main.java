package fr.dirzii.deyloshub;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main INSTANCE;

    @Override
    public void onEnable() {

        System.out.println("Deylos Hub a demarre correctement");
        getServer().getPluginManager().registerEvents(new PluginListeners(), this);
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        INSTANCE = this;
    }
}
