package com.github.expdev07.command;

import com.github.expdev07.command.BaseCommand;
import com.github.expdev07.command.CommandInfo;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * A command that can only be performed by a player
 */
public abstract class PlayerCommand extends BaseCommand {

    private Player sender;

    public PlayerCommand(CommandInfo info) {
        super(info);
    }

    public PlayerCommand(CommandInfo info, int requiredArgs) {
        super(info, requiredArgs);
    }

    public Player getSender() {
        return sender;
    }

    @Override
    public void perform(CommandSender sender, String alias, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You are not a player");
            return;
        }

        // Execute command for player
        perform((Player) sender, alias, args);
    }

    public abstract void perform(Player sender, String alias, String[] args);

}
