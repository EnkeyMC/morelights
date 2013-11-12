package morelights.renderers;

import morelights.MoreLights;
import morelights.block.OverlayBlock;
import morelights.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class LampRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		int blockID = world.getBlockId(x, y -1, z);
		Block blockBase = Block.blocksList[blockID];
		
		//which render pass are we doing?
        if(ClientProxy.renderPass == 0)
        {
            if(blockBase != null)
        		renderer.renderStandardBlock(blockBase, x, y, z);
        	else
        		renderer.renderStandardBlock(MoreLights.blockLEDLamp, x, y, z); 
                                                 
        }
        else                   
        {
        	renderer.renderStandardBlock(MoreLights.blockOverlayTest,x,y,z); 
        }
       
        return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return false;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.lampRenderType;
	}

}
