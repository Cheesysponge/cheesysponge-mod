package name.cheesysponge.block.custom;

import name.cheesysponge.item.ModItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class SpongeWeedBlock extends CropBlock {
    public SpongeWeedBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.SPONGE_SEEDS;
    }
}
