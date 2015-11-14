package tutorial.generic;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.material.Material;

public class GenericOre extends Block {
	public GenericOre(Material material) {
		super(material);

		setHardness(4.0F); // 33% harder than diamond
		setStepSound(Block.soundTypeMetal);
		setBlockName("genericOre"); // changed in 1.7
		setCreativeTab(CreativeTabs.tabBlock);
		setHarvestLevel("pickaxe", 3);
	}

	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return Generic.genericIngot;
	}

    public int quantityDroppedWithBonus(int par1, Random random)
    {
        return quantityDropped(random) + random.nextInt(par1 + 1);
	}

    public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(2);
    }
}
