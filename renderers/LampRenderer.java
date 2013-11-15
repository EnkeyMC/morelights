package morelights.renderers;

import morelights.MoreLights;
import morelights.block.BlockLamp;
import morelights.proxy.ClientProxy;
import morelights.tileentity.TileOverlayLamp;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
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
		TileOverlayLamp tile = (TileOverlayLamp) world.getBlockTileEntity(x, y, z);
		TileOverlayLamp tileBase = null;
		
		do{
			switch(check){
			case 1:
				blockID = world.getBlockId(x, y -1, z);
				blockBase = Block.blocksList[blockID];
				if(world.getBlockId(x, y, z) == blockID)
					tileBase = (TileOverlayLamp) world.getBlockTileEntity(x, y - 1, z);
					if(tileBase != null)
					{
						icon = tileBase.getBaseIcon();
						if(icon == null)
							blockBase = null;
					}
				if(blockID != 2)
					meta = world.getBlockMetadata(x, y - 1, z);
				break;
			case 2:
				blockID = world.getBlockId(x + 1, y, z);
				blockBase = Block.blocksList[blockID];
				if(world.getBlockId(x, y, z) == blockID)
					tileBase = (TileOverlayLamp) world.getBlockTileEntity(x + 1, y, z);
					if(tileBase != null)
					{
						icon = tileBase.getBaseIcon();
						if(icon == null)
							blockBase = null;
					}
				if(blockID != 2)
					meta = world.getBlockMetadata(x + 1, y, z);
				break;
			case 3:
				blockID = world.getBlockId(x - 1, y, z);
				blockBase = Block.blocksList[blockID];
				if(world.getBlockId(x, y, z) == blockID)
					tileBase = (TileOverlayLamp) world.getBlockTileEntity(x - 1, y, z);
					if(tileBase != null)
					{
						icon = tileBase.getBaseIcon();
						if(icon == null)
							blockBase = null;
					}
				if(blockID != 2)
					meta = world.getBlockMetadata(x - 1, y, z);
				break;
			case 4:
				blockID = world.getBlockId(x, y, z + 1);
				blockBase = Block.blocksList[blockID];
				if(world.getBlockId(x, y, z) == blockID)
					tileBase = (TileOverlayLamp) world.getBlockTileEntity(x, y, z + 1);
					if(tileBase != null)
					{	
						icon = tileBase.getBaseIcon();
						if(icon == null)
							blockBase = null;
					}
				if(blockID != 2)
					meta = world.getBlockMetadata(x, y, z + 1);
				break;
			case 5:
				blockID = world.getBlockId(x, y, z - 1);
				blockBase = Block.blocksList[blockID];
				if(world.getBlockId(x, y, z) == blockID)
					tileBase = (TileOverlayLamp) world.getBlockTileEntity(x, y, z - 1);
					if(tileBase != null)
					{	
						icon = tileBase.getBaseIcon();
						if(icon == null)
							blockBase = null;
					}
				if(blockID != 2)
					meta = world.getBlockMetadata(x, y, z - 1);
				break;
			case 6:
				blockID = world.getBlockId(x, y + 1, z);
				blockBase = Block.blocksList[blockID];
				if(world.getBlockId(x, y, z) == blockID)
					tileBase = (TileOverlayLamp) world.getBlockTileEntity(x, y + 1, z);
					if(tileBase != null)
					{	
						icon = tileBase.getBaseIcon();
						if(icon == null)
							blockBase = null;
					}
				if(blockID != 2)
					meta = world.getBlockMetadata(x, y + 1, z);
				break;
			}
			//TODO do by ternal operator
			if(blockBase != null){
				if(!(blockBase instanceof BlockContainer)){
					if(blockBase.renderAsNormalBlock()){
						if(blockBase.isOpaqueCube()){
							if(blockID != 2){
								check = 10;
							}
						}
					}
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
            	if(world.getBlockId(x, y, z) != blockID)
            		icon = blockBase.getIcon(3, meta);
            	tile.setBaseIcon(icon);
            	renderer.setOverrideBlockTexture(icon);
        		renderer.renderStandardBlock(blockBase, x, y, z);
        		renderer.clearOverrideBlockTexture();
            }
        	else
        	{
        		tile.setBaseIcon(MoreLights.blockLEDBase.getIcon(0, 0));
        		renderer.renderStandardBlock(MoreLights.blockLEDBase, x, y, z); 
        	}
                                                 
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
