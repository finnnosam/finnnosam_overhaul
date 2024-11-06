package net.finnnosam.finnnosam_overhaul.item;

import net.finnnosam.finnnosam_overhaul.FinnnosamOverhaul;
import net.finnnosam.finnnosam_overhaul.item.custom.ChiselItem;
import net.finnnosam.finnnosam_overhaul.item.custom.FuelItem;
import net.finnnosam.finnnosam_overhaul.item.custom.ModFoodProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

// How to add an Item:
//public static final RegistryObject<Item> TESTITEM = ITEMS.register("test_item",
//        () -> new Item(new Item.Properties()));
//Over here ^

//Then add a name line in lang/en_us.json
//Then copy/paste models/item/xx_.json, rename stuff inside
//add picture

//don't forget
//event.accept(ModItems.TESTITEM);
//over in addCreative inside FinnnosamOverhaul.java

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FinnnosamOverhaul.MOD_ID);

    public static final RegistryObject<Item> TESTITEM = ITEMS.register("test_item",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TESTITEM = ITEMS.register("raw_test_item",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties()
                    .durability(32)
            ));


    public static final RegistryObject<Item> TESTFOOD = ITEMS.register("test_food",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.TESTFOOD)){
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.finnnosam_overhaul.test_food"));

                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });


    public static final RegistryObject<Item> COAL_ASHES = ITEMS.register("coal_ashes",
            () -> new FuelItem(new Item.Properties(), 200));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
