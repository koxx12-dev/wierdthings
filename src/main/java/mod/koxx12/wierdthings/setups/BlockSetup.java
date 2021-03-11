package mod.koxx12.wierdthings.setups;

import mod.koxx12.wierdthings.WierdThings;
import mod.koxx12.wierdthings.blocks.statue;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockSetup {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            WierdThings.MOD_ID);

    //public static final RegistryObject<redwortiumore> CUSTOM_BLOCK2 = BLOCKS.register("custom_block2",
            //() -> new redwortiumore(AbstractBlock.Properties.create(Material.ORGANIC).harvestTool(ToolType.SHOVEL)
                    //.harvestLevel(3).sound(SoundType.NETHERITE).jumpFactor(2.0f).speedFactor(1.5f).setRequiresTool()));

    public static final RegistryObject<Block> REDWORTIUM_ORE = BLOCKS.register("redwortium_ore",
            () -> new Block(AbstractBlock.Properties.from(Blocks.DIAMOND_ORE)));

    public static final RegistryObject<statue> STATUE = BLOCKS.register("statue",
            () -> new statue(AbstractBlock.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.STONE).setRequiresTool()));
}