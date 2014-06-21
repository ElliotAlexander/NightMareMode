package com.elllzman.java.NightmareMode;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public class NightMareMode extends JavaPlugin  {

    protected static boolean isModeEnabled;

    public static int maxPoisonTime;
    public static int minPoisonTime;

    public static int maxFireTime;


    public static Plugin plugin;


    @Override
    public void onEnable()
    {

        plugin = this;

        isModeEnabled = false;

        new EventListeners(this);
        new CommandHandler(this);
        getServer().getPluginManager().registerEvents(new EventListeners(this), this);
        Logger out = getLogger();
        out.info("Nightmare mode has been invoked!");

        saveDefaultConfig();
        initialiseConfig();

        getCommand("nm").setExecutor(new CommandHandler(this));
    }



    public static boolean isModeEnabled()
    {
        return isModeEnabled;
    }

    public static void  setIsModeEnabled(Boolean x)
    {
        isModeEnabled = x;
    }

    public static void initialiseConfig()
    {
        maxPoisonTime = plugin.getConfig().getInt("Maximum poison time");
        minPoisonTime = plugin.getConfig().getInt("Minimum poison time");
        maxFireTime = plugin.getConfig().getInt("Maximum Fire time");
    }

}
