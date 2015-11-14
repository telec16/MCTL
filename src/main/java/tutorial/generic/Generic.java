package tutorial.generic;

// This Import list will grow longer with each additional tutorial.
// It's not pruned between full class postings, unlike other tutorial code.
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "generic", name = "Generic", version = "0.0.0")
public class Generic {
	// See Basic items tutorial for Generic Ingot
	public static Item genericIngot;
	public static Item genericWand;

	public static Block genericDirt;
	public static Block genericOre;

	ItemStack cobbleStack = new ItemStack(Blocks.cobblestone);

	@Instance(value = "generic")
	public static Generic instance;

	/*
	 * @SidedProxy(clientSide="tutorial.generic.client.ClientProxy",
	 * serverSide="tutorial.generic.CommonProxy") public static CommonProxy
	 * proxy;
	 */

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Create objects
		genericDirt = new GenericBlock(Material.ground);
		genericOre = new GenericOre(Material.rock);
		genericWand = new GenericItem().setUnlocalizedName("genericWand");
		genericIngot = new GenericItem().setMaxStackSize(16).setUnlocalizedName("genericIngot");

		// Texturing
		genericDirt.setBlockTextureName("generic:genericDirt");
		genericOre.setBlockTextureName("generic:genericOre");
		genericWand.setTextureName("generic:genericWand");
		genericIngot.setTextureName("generic:genericIngot");

		// Add recipes
		GameRegistry.addShapelessRecipe(new ItemStack(genericWand, 2), new ItemStack(genericIngot), new ItemStack(genericIngot), new ItemStack(genericIngot));

		GameRegistry.addRecipe(new ItemStack(genericOre,10), "xxx", "xyx", "xxx", 'x', genericIngot, 'y', genericWand);
		
		GameRegistry.addSmelting(Blocks.air, new ItemStack(genericOre,2), 25f);

		// Finalizing
		GameRegistry.registerBlock(genericDirt, "genericDirt");
		GameRegistry.registerBlock(genericOre, "genericOre");
		GameRegistry.registerItem(genericWand, "genericItem");
		GameRegistry.registerItem(genericIngot, "genericIngot");

		// proxy.registerRenderers();
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		LanguageRegistry.addName(genericDirt, "Generic dirt");
		LanguageRegistry.addName(genericOre, "Generic ore");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}
