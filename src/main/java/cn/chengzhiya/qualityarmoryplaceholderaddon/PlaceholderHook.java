package cn.chengzhiya.qualityarmoryplaceholderaddon;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.zombie_striker.qg.api.QualityArmory;
import me.zombie_striker.qg.guns.Gun;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public final class PlaceholderHook extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "qualityarmoryplaceholder";
    }

    @Override
    public @NotNull String getAuthor() {
        return "白神遥桌上の橙汁";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        Gun gun = QualityArmory.getGunInHand(player);
        if (gun == null) {
            return "";
        }

        return switch (params) {
            case "name" -> gun.getDisplayName();
            case "amount" -> String.valueOf(Gun.getAmount(player));
            case "max" -> String.valueOf(gun.getMaxBullets());
            case "format" -> PlaceholderAPI.setPlaceholders(player, Objects.requireNonNull(Main.instance.getConfig().getString("format")));
            case "total" -> String.valueOf(QualityArmory.getAmmoInInventory(player, gun.getAmmoType()));
            default -> null;
        };
    }
}
