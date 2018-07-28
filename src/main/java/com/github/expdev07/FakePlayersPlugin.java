package com.github.expdev07;

import com.comphenix.protocol.ProtocolLibrary;
import com.github.expdev07.command.impl.SetPlayersCommand;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main plugin class
 */
public class FakePlayersPlugin extends JavaPlugin {

    private FakePlayersPacketAdapter packetAdapter;

    @Override
    public void onEnable() {
        // Config the packet adapter and set it
        FakePlayersPacketAdapter adapter = new FakePlayersPacketAdapter(this);
        ProtocolLibrary.getProtocolManager().addPacketListener(adapter);
        this.packetAdapter = adapter;

        // Register commands
        getCommand("setplayers").setExecutor(new SetPlayersCommand(this));
    }

    public FakePlayersPacketAdapter getPacketAdapter() {
        return packetAdapter;
    }
}
