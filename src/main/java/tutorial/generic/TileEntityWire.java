package tutorial.generic;

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
	
	public void updateConnection()
	{
		
	}

}
