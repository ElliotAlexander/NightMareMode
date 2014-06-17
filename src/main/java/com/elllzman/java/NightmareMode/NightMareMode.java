package com.elllzman.java.NightmareMode;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Created by Elliot on 17/06/2014.
 */
public class NightMareMode extends JavaPlugin implements Listener {

    public static boolean isEnabled;


    public void onEnable()
    {

        isEnabled = false;

        getServer().getPluginManager().registerEvents( this, new EventListeners());
        Logger out = getLogger();
        out.info("Nightmare mode has been invoked!");
    }

    public static boolean getEnabled()
    {
        return isEnabled;
    }
}
