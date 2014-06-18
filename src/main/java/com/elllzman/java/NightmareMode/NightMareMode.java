package com.elllzman.java.NightmareMode;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class NightMareMode extends JavaPlugin implements Listener {

    private boolean modeEnabled = false;

    public void onEnable()
    {
        modeEnabled = false;

        getServer().getPluginManager().registerEvents(this, new EventListeners(this));
        getLogger().info("Nightmare mode has been invoked!");
    }

    public boolean isModeEnabled()
    {
        return modeEnabled;
    }
}
