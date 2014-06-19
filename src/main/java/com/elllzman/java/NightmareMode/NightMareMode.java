package com.elllzman.java.NightmareMode;

import org.bukkit.command.CommandSender;
import org.bukkit.material.Command;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public class NightMareMode extends JavaPlugin  {

    protected static boolean isModeEnabled;

    @Override
    public void onEnable()
    {

        isModeEnabled = false;

        new EventListeners(this);
        new CommandHandler(this);
        getServer().getPluginManager().registerEvents(new EventListeners(this), this);
        Logger out = getLogger();
        out.info("Nightmare mode has been invoked!");

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

}
