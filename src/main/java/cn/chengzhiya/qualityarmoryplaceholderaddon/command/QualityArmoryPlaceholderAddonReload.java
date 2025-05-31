package cn.chengzhiya.qualityarmoryplaceholderaddon.command;

import cn.chengzhiya.qualityarmoryplaceholderaddon.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public final class QualityArmoryPlaceholderAddonReload implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Main.instance.reloadConfig();
        sender.sendMessage("reload done!");
        return false;
    }
}
