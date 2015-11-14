package tutorial.generic;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GenericWand extends Item {

	public GenericWand() {
		maxStackSize = 1;
        setMaxDamage(32);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("genericWand");
	}

	@Override
	public boolean onItemUse(ItemStack itemStack,
			EntityPlayer player, World world, int x, int y,
			int z, int par7, float xFloat, float yFloat, float zFloat){
		//entityPlayer.
		/*double x = 0;
		double y = 0;
		double z = 0;*/

		if (!player.canPlayerEdit(x, y, z, par7, itemStack))//can the player edit this block? if he cant then dont do anything
		{
			return false;
		}
		
		if (!world.isRemote) {
			itemStack.damageItem(1, player);
			player.inventory.setInventorySlotContents(player.inventory.currentItem, itemStack);
			
			world.spawnParticle("smoke", x, y+1, z, 0.0D, 0.0D, 0.0D);
			//Args: X, Y, Z, new block ID, new metadata, flags. 
			world.setBlock(x, y, z, Blocks.diamond_block, 0, 2);
		}

		return true;
	}

}
