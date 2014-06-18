package com.elllzman.NightmareMode;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EventListeners extends JavaPlugin implements Listener {

    private final NightMareMode plugin;

    public EventListeners(NightMareMode plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event)
    {
        if(plugin.isModeEnabled()) {
            switch (event.getEntityType()) {
                case CREEPER:
                    event.getEntity().addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 2, 1000000)));
                    break;
                case ZOMBIE:
                    event.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 2, 10000000));
                    break;
                case SPIDER:
                    event.getEntity().addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 4, 1000000)));
                    break;
                case WITCH:
                    event.getEntity().addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 5, 1000000)));
                    break;
            }
        }
    }
}
