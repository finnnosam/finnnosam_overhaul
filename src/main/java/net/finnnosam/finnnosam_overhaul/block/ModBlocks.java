package net.finnnosam.finnnosam_overhaul.block;

import net.finnnosam.finnnosam_overhaul.FinnnosamOverhaul;
import net.finnnosam.finnnosam_overhaul.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

//to make a new block:
//public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
//^ in here

//add to creative tab addCreative inside FinnnosamOverhaul.java
//Then add a name line in lang/en_us.json
//duplicate blockstates/xx.json
//also duplicate models/block/xx.json
//also duplicate models/item/xx_block.json


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FinnnosamOverhaul.MOD_ID);



    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAW_TEST_BLOCK = registerBlock("raw_test_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
