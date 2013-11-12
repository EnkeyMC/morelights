package morelights.proxy;

import morelights.renderers.LampRenderer;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public static int renderPass;
	public static int lampRenderType;
	
	public static void setCustomRenderers()
    {
		lampRenderType = RenderingRegistry.getNextAvailableRenderId();
	    RenderingRegistry.registerBlockHandler(new LampRenderer());
	}
	
	public void registerRenderers() {
			
	}
}
