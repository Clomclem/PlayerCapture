package me.clomclem.playercapture.mixin;

import com.mojang.authlib.GameProfile;
import me.clomclem.playercapture.util.PlayerHeadUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.ProfilePublicKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("unused")
@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends Player {

    private ServerPlayerMixin(Level level, BlockPos blockPos, float f, GameProfile gameProfile, @Nullable ProfilePublicKey profilePublicKey) {
        super(level, blockPos, f, gameProfile, profilePublicKey);
    }

    @Inject(method = "die", at = @At("TAIL"))
    private void onDeath(DamageSource damageSource, CallbackInfo ci) {
        ItemStack head = PlayerHeadUtil.generateHeadFromPlayer(this);
        // It's unnecessary to use "((ServerPlayer)(Object)this)" since the mixin class already has the drop method (inherited from Player).
        this.drop(head, true);
    }
}
