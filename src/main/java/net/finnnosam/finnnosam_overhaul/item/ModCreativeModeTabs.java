package net.finnnosam.finnnosam_overhaul.item;

import net.finnnosam.finnnosam_overhaul.FinnnosamOverhaul;
import net.finnnosam.finnnosam_overhaul.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FinnnosamOverhaul.MOD_ID);
// Main code to copy
    public static final RegistryObject<CreativeModeTab> TEST_ITEMS_TAB = CREATIVE_MODE_TABS.register("test_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TESTITEM.get()))
                    .title(Component.translatable("creativetab.finnnosam_overhaul.test_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TESTITEM.get());
                        output.accept(ModItems.RAW_TESTITEM.get());

                    }).build());
// End of main code to copy
// don't forget .withTabsBefore(TEST_ITEMS_TAB.getId())
// also don't forget lang/en_us.json

    public static final RegistryObject<CreativeModeTab> TEST_BLOCKS_TAB = CREATIVE_MODE_TABS.register("test_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TEST_BLOCK.get()))
                    .withTabsBefore(TEST_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.finnnosam_overhaul.test_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.TEST_BLOCK.get());
                        output.accept(ModBlocks.RAW_TEST_BLOCK.get());
                        output.accept(ModBlocks.TEST_ORE.get());
                        output.accept(ModBlocks.TEST_DEEPSLATE_ORE.get());

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
