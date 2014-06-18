package com.elllzman.java.NightmareMode;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


/**
 * Created by Elliot on 17/06/2014.
 */
public class EventListeners extends JavaPlugin implements Listener {


    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
        if (new NightMareMode().getEnabled()) {
            switch (event.getEntityType()) {

                case CREEPER:
                    event.getEntity().addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 2, 1000000)));

                case ZOMBIE:
                    event.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 2, 10000000));

                case SPIDER:
                    event.getEntity().addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 4, 1000000)));

                case WITCH:
                    event.getEntity().addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 5, 1000000)));
            }

        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event)
    {
        if(new NightMareMode().getEnabled())
        {
            switch (event.getEntityType()) {
                case CREEPER:
                    Location loc = event.getEntity().getLocation();
                    loc.getWorld().spawnEntity(loc, EntityType.SILVERFISH);
                case
            }

        }
    }

}
