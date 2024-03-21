package me.josh.easyessentialsinstall;

import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import dev.triumphteam.cmd.core.BaseCommand;
import me.josh.easyessentialsinstall.commands.CoreCommand;
import me.josh.easyessentialsinstall.util.Module;
import me.josh.easyessentialsinstall.util.ModuleManager;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class EasyEssentialsInstall extends JavaPlugin {

    private BukkitCommandManager<CommandSender> manager;
    static EasyEssentialsInstall plugin;

    ModuleManager moduleManager;

    public static EasyEssentialsInstall getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;

        // Initialize the command manager
        manager = BukkitCommandManager.create(this);

        // Register the commands
        registerCommands();

        // Create config
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);


        // Create module manager
        moduleManager = new ModuleManager(this);


    }

    public void registerCommands() {
        manager.registerCommand(new CoreCommand());
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }




    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
