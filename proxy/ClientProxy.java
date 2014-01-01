package morelights.proxy;

import morelights.renderers.FluorescentLampRenderer;
import morelights.renderers.LampRenderer;
import morelights.renderers.ModelOldStreetLampRenderer;
import morelights.renderers.ModelOldWallLampRenderer;
import morelights.renderers.ModelReflectorRenderer;
import morelights.renderers.ModernDecLampRenderer;
import morelights.renderers.ModernWallLampRenderer;
import morelights.tileentity.TileBlockOldStreetLamp;
import morelights.tileentity.TileBlockOldWallLamp;
import morelights.tileentity.TileBlockReflector;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public static int renderPass;
	public static int lampRenderType;
	public static int ModernDecLampType;
	public static int ModernWallLampType;
	public static int FluorescentLampType;
	
	@Override
	public void registerRenderers() {
			lampRenderType = RenderingRegistry.getNextAvailableRenderId();
		    RenderingRegistry.registerBlockHandler(new LampRenderer());
		    
		    ModernDecLampType = RenderingRegistry.getNextAvailableRenderId();
		    RenderingRegistry.registerBlockHandler(new ModernDecLampRenderer());
		    
		    ModernWallLampType = RenderingRegistry.getNextAvailableRenderId();
		    RenderingRegistry.registerBlockHandler(new ModernWallLampRenderer());
		    
		    FluorescentLampType = RenderingRegistry.getNextAvailableRenderId();
		    RenderingRegistry.registerBlockHandler(new FluorescentLampRenderer());
	    
			int ModelOldWallLampRendererID = RenderingRegistry.getNextAvailableRenderId();
		    ModelOldWallLampRenderer OldWallLampRender = new ModelOldWallLampRenderer(ModelOldWallLampRendererID); 
		    ClientRegistry.bindTileEntitySpecialRenderer(TileBlockOldWallLamp.class, OldWallLampRender);
		    RenderingRegistry.registerBlockHandler(OldWallLampRender);
		    
		    int ModelOldStreetLampRendererID = RenderingRegistry.getNextAvailableRenderId();
		    ModelOldStreetLampRenderer OldStreetLampRender = new ModelOldStreetLampRenderer(ModelOldStreetLampRendererID);
		    ClientRegistry.bindTileEntitySpecialRenderer(TileBlockOldStreetLamp.class, OldStreetLampRender);
		    RenderingRegistry.registerBlockHandler(OldStreetLampRender);
		    
		    int ReflectorType = RenderingRegistry.getNextAvailableRenderId();
		    ModelReflectorRenderer ReflectorRender = new ModelReflectorRenderer(ReflectorType);
		    ClientRegistry.bindTileEntitySpecialRenderer(TileBlockReflector.class, ReflectorRender);
		    RenderingRegistry.registerBlockHandler(ReflectorRender);
	}
}
