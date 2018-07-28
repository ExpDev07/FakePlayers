package com.github.expdev07.command.impl;

import com.comphenix.protocol.wrappers.WrappedServerPing;
import com.github.expdev07.FakePlayersPlugin;
import com.github.expdev07.command.BaseCommand;
import com.github.expdev07.command.CommandInfo;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.function.Consumer;

/**
 * A command to add fake players
 */
public class SetPlayersCommand extends BaseCommand {

    private FakePlayersPlugin plugin;

    public SetPlayersCommand(FakePlayersPlugin plugin) {
        super(new CommandInfo("setplayers", "Set fake players", "/setplayers [amount]"), 1);
        this.plugin = plugin;
    }

    @Override
    public void perform(CommandSender sender, String alias, String[] args) {
        // Amount to add
        final int online = Integer.parseInt(args[0]);
        if (online < 1) {
            // Clear the callback, player wants to not modify packet anymore
            plugin.getPacketAdapter().clearCallback();
            return;
        }

        // Set callback to modify the online players
        plugin.getPacketAdapter().setCallback(ping -> ping.setPlayersOnline(Bukkit.getOnlinePlayers().size() + online));
    }
}
