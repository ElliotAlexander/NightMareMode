package com.elllzman.java.NightmareMode;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by Elliot on 17/06/2014.
 */
public class EventListeners extends JavaPlugin implements Listener {


    Random random = new Random();
    int Chance = random.nextInt(200);

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
            Location loc = event.getEntity().getLocation();

            switch (event.getEntityType()) {
                case CREEPER:
                    loc.getWorld().spawnEntity(loc, EntityType.SILVERFISH);
                case ZOMBIE:
                    loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
                case SPIDER:
                    List<Block> toWeb = new ArrayList<Block>();
                    Block b = loc.getBlock().getRelative(BlockFace.UP);
                    toWeb.add(b);


            }

        }
    }

    public void onDamage(EntityDamageByEntityEvent event)
    {
        if(event.getDamager() instanceof Player) {
            Location loc = null;
            switch (event.getEntityType()) {
                case ENDERMAN:
                    loc = event.getEntity().getLocation();
                    if (Chance < 100) {
                        loc.getWorld().spawnEntity(loc, EntityType.BLAZE);
                    }
                    Player p = (Player)event.getDamager();
                    p.setFireTicks((int)Math.random() * 200);
            }
        }
    }


    public void onBurningDamage(EntityDamageEvent event)
    {
        if(event.getEntityType() == EntityType.ZOMBIE && event.getCause() == EntityDamageEvent.DamageCause.FIRE && ((Math.random() * 10) < 5))
        {
            event.setCancelled(true);
        }
    }

}
