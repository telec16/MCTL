package tutorial.generic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class GenericBlock extends Block {

	public GenericBlock(Material material) {
		super(material);
		setHardness(0.5F);
		setStepSound(Block.soundTypeAnvil);
		setBlockName("genericDirt");
		setHarvestLevel("shovel", 0);

		// minX,minY, minZ,maxX,maxY,maxZ
		setBlockBounds(0.0F, 0.0F, 0.3F, 1F, 0.2F, 0.7F);
		// genericDirt.;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
}
