package me.josh.easyessentialsinstall.util;

public class Module {

    private String name;
    private String description;
    private boolean enabled;

    public Module(String name, String description, boolean enabled) {
        this.name = name;
        this.description = description;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
