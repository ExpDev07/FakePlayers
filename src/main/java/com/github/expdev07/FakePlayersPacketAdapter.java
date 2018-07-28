package com.github.expdev07;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedServerPing;
import org.bukkit.plugin.Plugin;

import java.util.function.Consumer;

/**
 * A packet adapter for for the ping
 */
public class FakePlayersPacketAdapter extends PacketAdapter {

    // Callback
    private Consumer<WrappedServerPing> callback = joblessConsumer();

    public FakePlayersPacketAdapter(Plugin plugin) {
        super(plugin, PacketType.Status.Server.SERVER_INFO);
    }

    @Override
    public void onPacketSending(PacketEvent event) {
        callback.accept(event.getPacket().getServerPings().read(0));
    }

    public void setCallback(Consumer<WrappedServerPing> callback) {
        this.callback = callback;
    }

    public void clearCallback() {
        this.callback = joblessConsumer();
    }

    /**
     * A consumer with no job
     *
     * @return A consumer which does nothing
     */
    private static Consumer<WrappedServerPing> joblessConsumer() {
        return wrappedServerPing -> { };
    }

}
