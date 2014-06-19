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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


/**
 * Created by Elliot on 17/06/2014.
 */
public class EventListeners implements Listener {


    private final NightMareMode plugin;

    public EventListeners(NightMareMode plugin)
    {
        this.plugin = plugin;
    }


    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (NightMareMode.isModeEnabled() == true) {
            if(event.getEntityType() == EntityType.CREEPER) {
                event.getEntity().addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 10000000, 2)));
                return;
            }
            if(event.getEntityType()== EntityType.ZOMBIE) {
                event.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100000000, 2));
                return;
            }
            if(event.getEntityType()==EntityType.SPIDER) {
                event.getEntity().addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 10000000, 4)));
                return;
            }
            if(event.getEntityType()==EntityType.WITCH){
                    event.getEntity().addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 10000000, 5)));
            }
            if(event.getEntityType()==EntityType.ENDERMAN){
                event.getEntity().addPotionEffect((new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10000000, 1)));
            }

        }
    }


    int randomInRange(int max, int min)
    {
        int range = (max - min);
        return (int)(Math.random() * range) + min;

    }

    @EventHandler
    public void onDeath(EntityDeathEvent event)
    {
        if(NightMareMode.isModeEnabled()==true)
        {

            Location loc = event.getEntity().getLocation();

            switch (event.getEntityType()) {
                case CREEPER:
                    int val;
                    int  x = randomInRange(0, 5);
                    for(val = 0; val < x; val++)
                    {
                        loc.getWorld().spawnEntity(loc, EntityType.SILVERFISH);

                    }

                    break;
                case ZOMBIE:
                    loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
                    break;
                case SPIDER:
                    Block b = loc.getBlock();
                    b.getRelative(BlockFace.EAST).setType(Material.WEB);
                    b.getRelative(BlockFace.WEST).setType(Material.WEB);
                    b.getRelative(BlockFace.SOUTH).setType(Material.WEB);
                    b.getRelative(BlockFace.NORTH).setType(Material.WEB);
                    b.getRelative(BlockFace.NORTH_EAST).setType(Material.REDSTONE_WIRE);
                    b.getRelative(BlockFace.NORTH_WEST).setType(Material.REDSTONE_WIRE);
                    b.getRelative(BlockFace.SOUTH_EAST).setType(Material.REDSTONE_WIRE);
                    b.getRelative(BlockFace.SOUTH_WEST).setType(Material.REDSTONE_WIRE);
                    break;
                case ENDERMAN:
                    if(randomInRange(0,2) < 1)
                    {
                        loc.getWorld().spawnEntity(loc, EntityType.BLAZE);
                    }


            }
            loc = null;

        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event)
    {
        if(NightMareMode.isModeEnabled()==true) {
            if (event.getDamager() instanceof Player) {
                Location loc = null;
                switch (event.getEntityType()) {
                    case ENDERMAN:
                        loc = event.getEntity().getLocation();
                        if ((Math.random() * 10) < 3) {
                            loc.getWorld().spawnEntity(loc, EntityType.BLAZE);
                        }
                        Player p = (Player) event.getDamager();
                        p.setFireTicks((int) Math.random() * 200);
                        break;
                }
            }
        }
    }

    @EventHandler
    public void onBurningDamage(EntityDamageEvent event)
    {
        if(event.getEntityType() == EntityType.ZOMBIE && event.getCause() == EntityDamageEvent.DamageCause.FIRE && randomInRange(0 ,10) < 5)
        {
            event.getEntity().setFireTicks(0);
            event.setCancelled(true);
        }
    }

}
