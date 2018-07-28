package com.github.expdev07.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * A command
 */
public abstract class BaseCommand implements CommandExecutor {

    private CommandInfo info;
    private int requiredArgs;

    public BaseCommand(CommandInfo info, int requiredArgs) {
        this.info = info;
        this.requiredArgs = requiredArgs;
    }

    public BaseCommand(CommandInfo info) {
        this(info, 0);
    }

    /**
     * Gets the command's information
     *
     * @return Command's info
     */
    public CommandInfo getInfo() {
        return info;
    }

    /**
     * Gets the required arguments needed to perform command
     *
     * @return Amount of required arguments
     */
    public int getRequiredArgs() {
        return requiredArgs;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        CommandInfo info = this.getInfo();
        if (!this.hasPermission(sender, info.getPermission())) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to do that");
            return true;
        }

        if (!(args.length > (requiredArgs - 1))) {
            sender.sendMessage(ChatColor.RED + "Usage: " + info.getUsage());
            return true;
        }

        // Execute initial command
        perform(sender, alias, args);
        return true;
    }

    /**
     * Checks if a sender has permission
     *
     * @param sender     Command sender to check for
     * @param permission Permission to check for
     * @return True if sender has permission
     */
    protected boolean hasPermission(CommandSender sender, String permission) {
        return permission.isEmpty() || !(sender instanceof Player) || sender.isOp() || sender.hasPermission(permission);
    }

    /**
     * Ran when the command is performed
     */
    public abstract void perform(CommandSender sender, String alias, String[] args);

}