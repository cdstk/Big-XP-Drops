package bigxpdrops.mixin.vanilla;

import bigxpdrops.handlers.ForgeConfigHandler;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.entity.item.EntityXPOrb;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityXPOrb.class)
public abstract class EntityXPOrbMixin {

    @WrapMethod(
            method = "getXPSplit"
    )
    private static int bigXPDrops_vanillaEntityXPOrb_getXPSplitBigDrop(int expValue, Operation<Integer> original){
        if(expValue >= ForgeConfigHandler.server.bigStartThreshold) {
            return expValue;
        }
        return original.call(expValue);
    }
}
