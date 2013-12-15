package morelights.proxy;

import morelights.renderers.LampRenderer;
import morelights.renderers.ModelOldStreetLampRenderer;
import morelights.renderers.ModelOldWallLampRenderer;
import morelights.renderers.ModernDecLampRenderer;
import morelights.renderers.ModernWallLampRenderer;
import morelights.tileentity.TileBlockOldStreetLamp;
import morelights.tileentity.TileBlockOldWallLamp;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public static int renderPass;
	public static int lampRenderType;
	public static int oldWallLampRendererType;
	public static int ModernDecLampType;
	public static int ModernWallLampType;
	
	@Override
	public void registerRenderers() {
			lampRenderType = RenderingRegistry.getNextAvailableRenderId();
		    RenderingRegistry.registerBlockHandler(new LampRenderer());
		    
		    ModernDecLampType = RenderingRegistry.getNextAvailableRenderId();
		    RenderingRegistry.registerBlockHandler(new ModernDecLampRenderer());
		    
		    ModernWallLampType = RenderingRegistry.getNextAvailableRenderId();
		    RenderingRegistry.registerBlockHandler(new ModernWallLampRenderer());
	    
			int ModelOldWallLampRendererID = RenderingRegistry.getNextAvailableRenderId();
		    ModelOldWallLampRenderer OldWallLampRender = new ModelOldWallLampRenderer(ModelOldWallLampRendererID); 
		    ClientRegistry.bindTileEntitySpecialRenderer(TileBlockOldWallLamp.class, OldWallLampRender);
		    RenderingRegistry.registerBlockHandler(OldWallLampRender);
		    
		    int ModelOldStreetLampRendererID = RenderingRegistry.getNextAvailableRenderId();
		    ModelOldStreetLampRenderer OldStreetLampRender = new ModelOldStreetLampRenderer(ModelOldStreetLampRendererID);
		    ClientRegistry.bindTileEntitySpecialRenderer(TileBlockOldStreetLamp.class, OldStreetLampRender);
		    RenderingRegistry.registerBlockHandler(OldStreetLampRender);
	}
}
