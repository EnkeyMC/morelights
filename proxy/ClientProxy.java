package morelights.proxy;

import morelights.renderers.LampRenderer;
import morelights.renderers.ModelOldStreetLampRenderer;
import morelights.renderers.ModelOldWallLampRenderer;
import morelights.tileentity.TileBlockOldStreetLamp;
import morelights.tileentity.TileBlockOldWallLamp;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public static int renderPass;
	public static int lampRenderType;
	public static int oldWallLampRendererType;
	
	public static void setCustomRenderers()
    {
		lampRenderType = RenderingRegistry.getNextAvailableRenderId();
	    RenderingRegistry.registerBlockHandler(new LampRenderer());
	}
	
	@Override
	public void registerRenderers() {
			
			int ModelOldWallLampRendererID = RenderingRegistry.getNextAvailableRenderId();
		    ModelOldWallLampRenderer OldWallLampRender = new ModelOldWallLampRenderer(ModelOldWallLampRendererID); //You need to have the id in the class as a variable so you have quick access to it.
		    ClientRegistry.bindTileEntitySpecialRenderer(TileBlockOldWallLamp.class, OldWallLampRender);
		    RenderingRegistry.registerBlockHandler(OldWallLampRender);
		    
		    int ModelOldStreetLampRendererID = RenderingRegistry.getNextAvailableRenderId();
		    ModelOldStreetLampRenderer OldStreetLampRender = new ModelOldStreetLampRenderer(ModelOldStreetLampRendererID); //You need to have the id in the class as a variable so you have quick access to it.
		    ClientRegistry.bindTileEntitySpecialRenderer(TileBlockOldStreetLamp.class, OldStreetLampRender);
		    RenderingRegistry.registerBlockHandler(OldStreetLampRender);
	}
}
