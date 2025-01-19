package net.chaniedarray.forgedarsenal.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent CHOCOLATE = new FoodComponent.Builder()
            .saturationModifier(0.5f).alwaysEdible().snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 4, 0), 0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 6, 1), 1f).build();

}
