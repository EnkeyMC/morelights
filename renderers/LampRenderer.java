package morelights.renderers;

import morelights.MoreLights;
import morelights.block.BlockLamp;
import morelights.block.BlockOverlayLamp;
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
		renderer.renderBlockAsItem(block, 1, 0.0F);
	}
	
	private short meta;
	private short blockID;
	private Icon icon = null;
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		Block blockBase = null;
		short baseID = 0;
		byte check = 1;
		short ID = 0;
		
		TileOverlayLamp tile = (TileOverlayLamp) world.getBlockTileEntity(x, y, z);
		
		do{
			switch(check){
			case 1:
				ID = (short)world.getBlockId(x, y, z);
				blockBase = this.checkForBlocks(world, x, y - 1, z, ID);
				break;
			case 2:
				ID = (short)world.getBlockId(x, y, z);
				blockBase = this.checkForBlocks(world, x + 1, y, z, ID);
				break;
			case 3:
				ID = (short)world.getBlockId(x, y, z);
				blockBase = this.checkForBlocks(world, x - 1, y - 1, z, ID);
				break;
			case 4:
				ID = (short)world.getBlockId(x, y, z);
				blockBase = this.checkForBlocks(world, x, y, z + 1, ID);
				break;
			case 5:
				ID = (short)world.getBlockId(x, y, z);
				blockBase = this.checkForBlocks(world, x, y, z - 1, ID);
				break;
			case 6:
				ID = (short)world.getBlockId(x, y, z);
				blockBase = this.checkForBlocks(world, x, y + 1, z, ID);
				break;
			}
			
			if(blockBase == null ? false : (!blockBase.renderAsNormalBlock() ? false : (!blockBase.isOpaqueCube() ? false : (blockID == 2 ? false : true))))
			{
				check = 10;
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
        	renderer.setOverrideBlockTexture(BlockOverlayLamp.OverIcon);
        	renderer.renderStandardBlock(MoreLights.blockLEDLamp,x,y,z); 
        	renderer.clearOverrideBlockTexture();
        }
       
        return true;
	}
	
	private Block checkForBlocks(IBlockAccess world, int x, int y, int z, short ID)
	{
		this.blockID = (short) world.getBlockId(x, y, z);
		TileOverlayLamp tileBase = null;
		Block blockBase = Block.blocksList[blockID];
		if(ID == blockID)
			tileBase = (TileOverlayLamp) world.getBlockTileEntity(x, y, z);
			if(tileBase != null)
			{	
				this.icon = tileBase.getBaseIcon();
				if(this.icon == null)
					blockBase = null;
			}
		if(this.blockID != 2)
			this.meta = (short) world.getBlockMetadata(x, y, z);
		return blockBase;
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
