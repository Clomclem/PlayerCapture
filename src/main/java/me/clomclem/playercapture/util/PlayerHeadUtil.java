package me.clomclem.playercapture.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public final class PlayerHeadUtil {

    private PlayerHeadUtil() {}

    public static ItemStack generateHeadFromPlayer(Player player) {
        ItemStack stack = new ItemStack(Items.PLAYER_HEAD);
        CompoundTag data = stack.getOrCreateTag();
        data.putString("SkullOwner", player.getName().getString());
        return stack;
    }
}