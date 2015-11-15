package tutorial.generic;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GenericWire extends BlockContainer {

	protected GenericWire(Material material) {
		super(material);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {

		return null;
	}

	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		world.setTileEntity(x, y, z, this.createNewTileEntity(world, world.getBlockMetadata(x, y, z)));
	}

}
