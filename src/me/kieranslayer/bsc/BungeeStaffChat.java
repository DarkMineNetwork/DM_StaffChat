package me.kieranslayer.bsc;

import me.kieranslayer.bsc.commands.AdminChatCommand;
import me.kieranslayer.bsc.commands.StaffChatCommand;
import me.kieranslayer.bsc.metrics.Metrics;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.IOException;


public class BungeeStaffChat extends Plugin {
    @Override
    public void onEnable() {
        try {
            getLogger().info("Trying to start Metrics");

            Metrics metrics = new Metrics(this);
            metrics.start();

            getLogger().info("Metrics started successfully!");
        } catch (IOException exception) {
            getLogger().warning("Failed to start metrics. If you have opted-out, you can safely ignore this message!");
        }

        getProxy().getPluginManager().registerCommand(this, new StaffChatCommand());
        getProxy().getPluginManager().registerCommand(this, new AdminChatCommand());
    }

    @Override
    public void onDisable() {
        //
    }
}
