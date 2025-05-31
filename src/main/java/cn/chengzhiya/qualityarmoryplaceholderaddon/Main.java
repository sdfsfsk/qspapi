package cn.chengzhiya.qualityarmoryplaceholderaddon;

import cn.chengzhiya.qualityarmoryplaceholderaddon.command.QualityArmoryPlaceholderAddonReload;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {
    public static Main instance;
    private final PlaceholderHook placeholderAPIHook = new PlaceholderHook();

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        saveDefaultConfig();
        reloadConfig();

        this.placeholderAPIHook.register();

        Objects.requireNonNull(getCommand("qualityarmoryplaceholderaddonreload")).setExecutor(new QualityArmoryPlaceholderAddonReload());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.placeholderAPIHook.unregister();

        instance = null;
    }
}
