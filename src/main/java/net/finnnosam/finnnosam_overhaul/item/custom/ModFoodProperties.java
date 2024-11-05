package net.finnnosam.finnnosam_overhaul.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties TESTFOOD = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.JUMP, 400), 0.20f)
            .alwaysEdible()
            .build();

}
