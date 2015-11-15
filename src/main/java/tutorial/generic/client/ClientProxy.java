package tutorial.generic.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import tutorial.generic.CommonProxy;
import tutorial.generic.TileEntityRenderWire;
import tutorial.generic.TileEntityWire;

public class ClientProxy extends CommonProxy {

	public void registerRenderers() {
		registerTileWire();
	}
	
	private void registerTileWire()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWire.class, new TileEntityRenderWire());
	}

	public void init() {
		
	}

}
