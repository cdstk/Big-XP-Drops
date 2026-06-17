package bigxpdrops.mixin.vanilla;

import net.minecraft.entity.item.EntityXPOrb;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityXPOrb.class)
public abstract class EntityXPOrbMixin {

    @ModifyConstant(
            method = "getXPSplit",
            constant = @Constant(intValue = 2477, ordinal = 1)
    )
    private static int bigXPDrops_vanillaEntityXPOrb_getXPSplitBigDrop(int constant, int expValue){
        return expValue;
    }
}
