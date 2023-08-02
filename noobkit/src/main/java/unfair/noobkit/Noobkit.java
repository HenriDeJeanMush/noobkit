package unfair.noobkit;

import org.bukkit.plugin.java.JavaPlugin;

public final class Noobkit extends JavaPlugin {
    static Noobkit noobkit;

    @Override
    public void onEnable() {
        noobkit = this;
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("kit").setExecutor(new getCommand());
        getCommand("givekit").setExecutor(new getCommand());
        this.getServer().getPluginManager().registerEvents(new getJoin(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Noobkit getPl(){
        return noobkit;
    }
}
