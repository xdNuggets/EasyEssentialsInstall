package me.josh.easyessentialsinstall.util;

import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class ModuleManager {

    ArrayList<Module> modules;

    public ModuleManager(Plugin plugin) {
        modules = new ArrayList<>();
        for(String key : plugin.getConfig().getConfigurationSection("modules").getKeys(false)) {
            String description = plugin.getConfig().getString("modules." + key + ".description");
            boolean enabled = plugin.getConfig().getBoolean("modules." + key + ".enabled");
            modules.add(new Module(key, description, enabled));
        }
    }

    public void enableModule(Module module) {
        module.setEnabled(true);
    }

    public void disableModule(Module module) {
        module.setEnabled(false);
    }

    public Module getModule(String name) {
        return modules.stream().filter(module -> module.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public boolean isModuleEnabled(String name) {
        return getModule(name).isEnabled();
    }

    public boolean isEnabled(Module module) {
        return module.isEnabled();
    }

    public ArrayList<Module> getModules() {
        return modules;
    }
}
