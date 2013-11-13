package morelights.renderers;

import morelights.MoreLights;
import morelights.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;
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
		
		int blockID = 0;
		int meta = 0;
		Block blockBase = null;
		int check = 1;
		Icon icon = null;
		
		do{
			switch(check){
			case 1:
				blockID = world.getBlockId(x, y -1, z);
				blockBase = Block.blocksList[blockID];
				meta = world.getBlockMetadata(x, y - 1, z);
				//icon = blockBase.getIcon(3, meta);
				break;
			case 2:
				blockID = world.getBlockId(x + 1, y, z);
				blockBase = Block.blocksList[blockID];
				meta = world.getBlockMetadata(x + 1, y, z);
				//icon = blockBase.getIcon(3, meta);
				break;
			case 3:
				blockID = world.getBlockId(x - 1, y, z);
				blockBase = Block.blocksList[blockID];
				meta = world.getBlockMetadata(x - 1, y, z);
				//icon = blockBase.getIcon(3, meta);
				break;
			case 4:
				blockID = world.getBlockId(x, y, z + 1);
				blockBase = Block.blocksList[blockID];
				meta = world.getBlockMetadata(x, y, z + 1);
				//icon = blockBase.getIcon(3, meta);
				break;
			case 5:
				blockID = world.getBlockId(x, y, z - 1);
				blockBase = Block.blocksList[blockID];
				meta = world.getBlockMetadata(x, y, z - 1);
				//icon = blockBase.getIcon(3, meta);
				break;
			case 6:
				blockID = world.getBlockId(x, y + 1, z);
				blockBase = Block.blocksList[blockID];
				meta = world.getBlockMetadata(x, y + 1, z);
				//icon = blockBase.getIcon(3, meta);
				break;
			}
			
			if(blockBase != null)
			{
				if((!(blockBase instanceof BlockContainer) == false )||(blockBase.isNormalCube(blockID))||(blockBase.isOpaqueCube())||blockID != 2)
				{
					check = 10;
				}
			}
			check++;
		
		}while(check <= 6);
		
		if(check < 11)
			blockBase = null;
		
		//which render pass are we doing?
        if(ClientProxy.renderPass == 0)
        {
            if(blockBase != null){
            	icon = blockBase.getIcon(3, meta);
            	renderer.setOverrideBlockTexture(icon);
        		renderer.renderStandardBlock(blockBase, x, y, z);
        		renderer.clearOverrideBlockTexture();
            }
        	else
        		renderer.renderStandardBlock(MoreLights.blockLEDBase, x, y, z); 
                                                 
        }
        else                   
        {
        	
        	renderer.renderStandardBlock(MoreLights.blockLEDLamp,x,y,z); 
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
