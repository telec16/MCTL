package tutorial.generic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityWire extends TileEntity{
	
	/**
	 * UP, DOWN, NORTH, SOUTH, EAST, WEST
	 */
	public ForgeDirection[] connection = new ForgeDirection[6];
	private ForgeDirection[] lastRxDir = new ForgeDirection[6];
		
	public TileEntityWire()
	{
		
	}

	public void updateEntity()
	{
		
		this.updateConnection();
	}
	
	@Override
	public boolean canUpdate()
	{
		return true;
	}
	
	public boolean canConnect(ForgeDirection direction)
	{
		TileEntity te = this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord);
		
		if(te != null)
		{
			if(te instanceof TileEntityWire)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public double getMaxRenderDistanceSquared()
	{
		return Double.MAX_VALUE;
	}
	
	/*@Override
	public BlockType getTypeOfBlock()
	{
		return BlockType.WIRE;
	}*/
	
	public void updateConnection()
	{
		if(this.worldObj.getTileEntity(xCoord, yCoord+1, zCoord) instanceof TileEntityWire) connection
	}

}
