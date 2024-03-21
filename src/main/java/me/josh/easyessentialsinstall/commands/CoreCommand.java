package me.josh.easyessentialsinstall.commands;

import dev.triumphteam.cmd.core.BaseCommand;
import dev.triumphteam.cmd.core.annotation.Command;
import dev.triumphteam.cmd.core.annotation.Default;
import dev.triumphteam.cmd.core.annotation.SubCommand;
import me.josh.easyessentialsinstall.EasyEssentialsInstall;
import me.josh.easyessentialsinstall.util.Module;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

@Command(value="easyessentialsinstall", alias = {"eei", "easyinstall"})
public class CoreCommand extends BaseCommand {

    @Default
    public void executor(CommandSender sender) {
        ArrayList<String> messages = new ArrayList<>();
        messages.add("§6§lEasyEssentialsInstall §7- §fVersion 1.0");
        messages.add("§eDeveloped by §6Josh &eand &6Square");
        messages.add("§eType §6/eei help §efor a list of commands.");

        messages.forEach(sender::sendMessage);
    }


    @SubCommand("help")
    public void help(CommandSender sender) {
        ArrayList<String> messages = new ArrayList<>();
        messages.add("§6§lEasyEssentialsInstall §7- §fVersion 1.0");
        messages.add("§eDeveloped by §6Josh &eand &6Square");
        messages.add("§eCommands:");
        messages.add("§6/eei help §7- §8Displays this message.");
        messages.add("§6/eei modules §7- §8Lists all Essential modules and their status.");
        messages.add("§6/eei add {module}§8- §fAllows you to choose a module to install.");
        messages.add("§6/eei disable §7- §8Disables EasyEssentials.");
        messages.add("§6/eei reload §7- §8Reloads EasyEssentials.");
        messages.add("§6/eei info §7- §8Displays information about EasyEssentials.");
        messages.add("§7All commands require a manual reload. (§8/eei reload§7)");

        messages.forEach(sender::sendMessage);
    }

    @SubCommand("modules")
    public void modules(CommandSender sender) {
        ArrayList<String> messages = new ArrayList<>();
        messages.add("§6§lEasyEssentialsInstall §7- §fVersion 1.0");
        messages.add("§eDeveloped by §6Josh &eand &6Square");
        messages.add("§eModules:");
        for (Module module : EasyEssentialsInstall.getPlugin().getModuleManager().getModules()) {
            messages.add(module.isEnabled() ? "§a" + module.getName() : "§c" + module.getName() + " §7- §8" + module.getDescription());

        }
        messages.forEach(sender::sendMessage);
    }


    @SubCommand("add")
    public void add(CommandSender sender, String m) {
        Module module = EasyEssentialsInstall.getPlugin().getModuleManager().getModule(m);
        if (module == null) {
            sender.sendMessage("§cModule not found.");
            return;
        }

        if(module.isEnabled()) {
            sender.sendMessage("§cModule is already enabled.");
            return;
        }
        EasyEssentialsInstall.getPlugin().getModuleManager().enableModule(module);
        sender.sendMessage("§aModule enabled.");
        sender.sendMessage("§7Please type §8/eei reload §7to apply changes.");
        sender.sendMessage("§7Use /eei modules to view all modules.");
    }



}
