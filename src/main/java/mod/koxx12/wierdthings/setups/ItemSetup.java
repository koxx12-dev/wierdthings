package mod.koxx12.wierdthings.setups;

import mod.koxx12.wierdthings.WierdThings;
import mod.koxx12.wierdthings.items.Redwortiumingot;
import mod.koxx12.wierdthings.items.logotexture;
import mod.koxx12.wierdthings.items.redwortiumchunk;
import mod.koxx12.wierdthings.items.redwortiumpickaxe;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemSetup {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            WierdThings.MOD_ID);

    //public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
    //() -> new Item(new Item.Properties().group(ItemGroup.MISC)));

    public static final RegistryObject<Redwortiumingot> REDWORTIUM_INGOT = ITEMS.register("redwortium_ingot",
            () -> new Redwortiumingot(new Item.Properties().group(WierdThings.WIERD_GROUP)));

    public static final RegistryObject<redwortiumchunk> REDWORTIUM_CHUNK = ITEMS.register("redwortium_chunk",
            () -> new redwortiumchunk(new Item.Properties().group(WierdThings.WIERD_GROUP)));

    public static final RegistryObject<redwortiumpickaxe> REDWORTIUM_PICKAXE = ITEMS.register("redwortium_pickaxe",
            () -> new redwortiumpickaxe(new Item.Properties().group(WierdThings.WIERD_GROUP)));

    public static final RegistryObject<logotexture> LOGO_TEXTURE = ITEMS.register("logo_texture",
            () -> new logotexture(new Item.Properties()));


    public static final RegistryObject<BlockItem> REDWORTIUM_ORE = ITEMS.register("redwortium_ore",
      () -> new BlockItem(BlockSetup.REDWORTIUM_ORE.get(), new Item.Properties().group(WierdThings.WIERD_GROUP)));

    public static final RegistryObject<BlockItem> STATUE = ITEMS.register("statue",
            () -> new BlockItem(BlockSetup.STATUE.get(), new Item.Properties().group(WierdThings.WIERD_GROUP)));

}