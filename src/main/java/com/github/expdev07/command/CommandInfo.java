package com.github.expdev07.command;

import org.apache.commons.lang.StringUtils;

/**
 * Holds command information
 */
public class CommandInfo {

    private String permission;
    private String description;
    private String usage;

    private String name;
    private String[] aliases;

    public CommandInfo(String name, String description, String usage, String permission, String... aliases) {
        this.name = name;
        this.description = description;
        this.usage = usage;
        this.permission = permission;
        this.aliases = aliases;
    }

    public CommandInfo(String name, String description, String usage, String permission) {
        this(name, description, usage, permission, StringUtils.EMPTY);
    }

    public CommandInfo(String name, String description, String usage) {
        this(name, description, usage, StringUtils.EMPTY, StringUtils.EMPTY);
    }

    public String getPermission() {
        return permission;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getUsage() {
        return usage;
    }

    public String[] getAliases() {
        return aliases;
    }
}
