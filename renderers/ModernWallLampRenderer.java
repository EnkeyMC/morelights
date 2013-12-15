package morelights.renderers;

import morelights.lib.Pix;
import morelights.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import easytessellator.EasyTess;

public class ModernWallLampRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		//TODO render it properly
		Tessellator tes = Tessellator.instance;
		 
	    tes.startDrawingQuads();
	    
	    tes.addTranslation(-1F, -0.5F, -1F);
		
		int x = 0;
		int y = 0;
		int z = 0;
				
		Icon icon = block.getIcon(0, 0);
		
		tes.setNormal(0.0F, 1.0F, 0.0F);
		
		EasyTess.renderCube(x + Pix.TWO, y + Pix.SIX, z + Pix.TWELVE, 12, 4, 4, 0, 0, icon, 5, 32, 32);
		
		tes.addTranslation(1F, 0.5F, 1F);
		
	    tes.draw();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		
		Tessellator tes = Tessellator.instance;
		int lightValue = block.getMixedBrightnessForBlock(world, x, y, z);
		tes.setBrightness(lightValue);
		tes.setColorOpaque_F(1.0F, 1.0F, 1.0F);
				
		Icon icon = block.getIcon(0, 0);
		
		switch(world.getBlockMetadata(x, y, z)){
		case 5:
			EasyTess.renderCube(x + Pix.TWELVE, y + Pix.TEN, z + Pix.TWO, 4, 4, 12, 0, 0, icon, 2, 32, 32);
			break;
		case 2:
			EasyTess.renderCube(x + Pix.TWO, y + Pix.TEN, z + Pix.TWELVE, 12, 4, 4, 0, 0, icon, 5, 32, 32);
			break;
		case 4:
			EasyTess.renderCube(x, y + Pix.TEN, z + Pix.TWO, 4, 4, 12, 0, 0, icon, 4, 32, 32);
			break;
		case 3:
			EasyTess.renderCube(x + Pix.TWO, y + Pix.TEN, z, 12, 4, 4, 0, 0, icon, 3, 32, 32);
		}
		
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.ModernWallLampType;
	}

}
