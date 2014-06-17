package com.elllzman.java.NightmareMode;

import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.elllzman.java.NightmareMode.NightMareMode;

/**
 * Created by Elliot on 17/06/2014.
 */
public class EventListeners extends JavaPlugin implements Listener {

    public void onSpawn(CreatureSpawnEvent event)
    {
        if(getEnabled())
            switch(event.getEntityType()) {

                case CREEPER: event.getEntity().addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 2, 1000000)));

                case ZOMBIE: event.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 2, 10000000));

                case SPIDER: event.getEntity().addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 4, 1000000)));

                case WITCH: event.getEntity().addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 5,1000000)));
            }

    }
}
