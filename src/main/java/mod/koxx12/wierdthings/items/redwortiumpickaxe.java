package mod.koxx12.wierdthings.items;

import mod.koxx12.wierdthings.WierdThings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.ToolType;

public class redwortiumpickaxe extends PickaxeItem {
    public redwortiumpickaxe(Properties properties) {
        super(WierdThings.Redwortium, -1, -3.1F ,properties.maxDamage(3201).addToolType(ToolType.PICKAXE,6).rarity(Rarity.EPIC).isImmuneToFire());
    }

}
