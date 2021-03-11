package mod.koxx12.wierdthings.world;
import mod.koxx12.wierdthings.WierdThings;
import mod.koxx12.wierdthings.setups.BlockSetup;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

/**
 * Ore generation
 * @author TechOFreak
 *
 */

@Mod.EventBusSubscriber
public class OreGen {

    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();

    public static void registerOres() {
        //BASE_STONE_OVERWORLD is for generating in stone, granite, diorite, and andesite
        //NETHERRACK is for generating in netherrack
        //BASE_STONE_NETHER is for generating in netherrack, basalt and blackstone

        //Overworld Ore Register
        overworldOres.add(register("redwortium_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BlockSetup.REDWORTIUM_ORE.get().getDefaultState(), 3)) //Vein Size
                .range(10).square() //Spawn height start
                .func_242731_b(6))); //Chunk spawn frequency


        //overworldOres.add(register("earthy_deposit", Feature.ORE.withConfiguration(new OreFeatureConfig(
        //new BlockMatchRuleTest(Blocks.DIRT), BlockSetup.EARTHY_DEPOSIT.get().getDefaultState(), 4)) //Vein Size
        /// .range(128).square() //Spawn height start
        //.func_242731_b(64))); //Chunk spawn frequency

        //Nether Ore Register
        //netherOres.add(register("flame_crystal_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
        // OreFeatureConfig.FillerBlockType.NETHERRACK, BlockSetup.FLAME_CRYSTAL_ORE.get().getDefaultState(), 4))
        //.range(48).square()
        //.func_242731_b(64)));

        //The End Ore Register
        //endOres.add(register("air_block", Feature.ORE.withConfiguration(new OreFeatureConfig(
        //new BlockMatchRuleTest(Blocks.END_STONE), BlockSetup.AIR_CRYSTAL_BLOCK.get().getDefaultState(), 4)) //Vein Size
        //.range(128).square() //Spawn height start
        //.func_242731_b(64))); //Chunk spawn frequency
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if (event.getCategory().equals(Biome.Category.NETHER)) {
            for (ConfiguredFeature<?, ?> ore : netherOres) {
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        if (event.getCategory().equals(Biome.Category.THEEND)) {
            for (ConfiguredFeature<?, ?> ore : endOres) {
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        for (ConfiguredFeature<?, ?> ore : overworldOres) {
            if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
        }
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, WierdThings.MOD_ID + ":" + name, configuredFeature);
    }

}