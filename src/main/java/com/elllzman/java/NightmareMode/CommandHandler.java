package com.elllzman.java.NightmareMode;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.omg.CORBA.DynAnyPackage.Invalid;


public class CommandHandler implements CommandExecutor {


    private final NightMareMode plugin;

    public CommandHandler(NightMareMode plugin)
    {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
            if(cmd.getName().equalsIgnoreCase("nm")) {
                if(args.length==0) {
                    sender.sendMessage(ChatColor.RED + "Invalid arguments!");
                    return true;
                }
                String subcommand = args[0];
                if (subcommand.equalsIgnoreCase("Enable") || subcommand.equalsIgnoreCase("on")) {
                    NightMareMode.setIsModeEnabled(true);
                    plugin.getServer().broadcastMessage(ChatColor.GRAY + "Nightmare mode has been enabled!");
                    return true;
                }
                if (subcommand.equalsIgnoreCase("disable") || subcommand.equalsIgnoreCase("off")) {
                    NightMareMode.setIsModeEnabled(false);
                    plugin.getServer().broadcastMessage(ChatColor.GRAY + "Nightmare mode has been disabled!");
                    return true;
                }
                else;
                {
                    sender.sendMessage(ChatColor.RED + "Invalid arguments");
                }


        }
        return true;
    }
}
