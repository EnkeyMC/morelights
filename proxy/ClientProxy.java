package morelights.proxy;

import morelights.renderers.LampRenderer;
import morelights.renderers.ModelOldWallLampRenderer;
import morelights.tileentity.TileBlockOldWallLamp;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {
	
	public static int renderPass;
	public static int lampRenderType;
	
	public static void setCustomRenderers()
    {
		lampRenderType = RenderingRegistry.getNextAvailableRenderId();
	    RenderingRegistry.registerBlockHandler(new LampRenderer());
	}
	
	public void registerRenderers() {
			ClientRegistry.bindTileEntitySpecialRenderer(TileBlockOldWallLamp.class, new ModelOldWallLampRenderer());
	}
}
