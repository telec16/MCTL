package tutorial.generic;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityRenderWire extends TileEntitySpecialRenderer {

	ResourceLocation textureWire = new ResourceLocation(Generic.MODID, "textures/wire/wire.png");
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double transX, double transY, double transZ, float f) {
		GL11.glTranslated(transX, transY, transZ);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.bindTexture(textureWire);
		
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-transX, -transY, -transZ);
	}

}
