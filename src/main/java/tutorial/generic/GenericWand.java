package tutorial.generic;

import java.util.Random;

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
		setUnlocalizedName("genericWand");
	}

	private void particles(World world, double finX, double finY, double finZ) {
		Random rand = new Random();
		String effect = "smoke";

		for (int i = 0; i < 10; i++) {
			switch (rand.nextInt(4)) {
			case 0:
			case 1:
				effect = "largesmoke";
				break;
			case 2:
				effect = "splash";
				break;
			case 3:
				effect = "witchMagic";
				break;
			}
			world.spawnParticle(effect, finX + rand.nextFloat(), finY, finZ + rand.nextFloat(), 0, 0, 0);
		}
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7,
			float xFloat, float yFloat, float zFloat) {

		double finX = (double) x;
		double finY = (double) y + 1.0D;
		double finZ = (double) z;

		if (!player.canPlayerEdit(x, y, z, par7, itemStack)) {
			return false;
		}

		particles(world, finX, finY, finZ);

		if (!world.isRemote) {
			itemStack.damageItem(1, player);
			player.inventory.setInventorySlotContents(player.inventory.currentItem, itemStack);

			world.playSoundEffect(finX, finY, finZ, "random.fizz", 0.9f, 1f);

			// Args: X, Y, Z, new block ID, new metadata, flags.
			world.setBlock(x, y, z, Generic.genericOre, 0, 2);
		}

		return true;
	}

}
