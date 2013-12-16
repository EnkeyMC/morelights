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

public class FluorescentLampRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		Tessellator tes = Tessellator.instance;
		int lightValue = block.getMixedBrightnessForBlock(world, x, y, z);
		tes.setBrightness(lightValue);
		tes.setColorOpaque_F(1.0F, 1.0F, 1.0F);
				
		Icon icon = block.getIcon(0, 0);
		
		//Base
		EasyTess.renderCube(x + Pix.FOUR, y + Pix.FIFTEEN, z + Pix.FOUR, 8, 1, 8, 0, 4, icon, 0, 32, 32);
		
		EasyTess.renderCube(x + Pix.FOUR, y + Pix.FOURTEEN, z + Pix.FOUR, 1, 1, 1, 4, 9, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.FOUR, y + Pix.FOURTEEN, z + Pix.ELEVEN, 1, 1, 1, 9, 4, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.ELEVEN, y + Pix.FOURTEEN, z + Pix.FOUR, 1, 1, 1, 0, 10, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.ELEVEN, y + Pix.FOURTEEN, z + Pix.ELEVEN, 1, 1, 1, 6, 2, icon, 1, 32, 32);
		
		EasyTess.renderCube(x + Pix.SIX, y + Pix.FOURTEEN, z + Pix.SIX, 1, 1, 1, 16, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.NINE, y + Pix.FOURTEEN, z + Pix.SIX, 1, 1, 1, 16, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.SIX, y + Pix.FOURTEEN, z + Pix.NINE, 1, 1, 1, 16, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.NINE, y + Pix.FOURTEEN, z + Pix.NINE, 1, 1, 1, 16, 0, icon, 1, 32, 32);
		
		EasyTess.renderCube(x + Pix.SEVEN, y + Pix.FOURTEEN, z + Pix.SIX, 2, 1, 1, 18, 5, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.SIX, y + Pix.FOURTEEN, z + Pix.SEVEN, 1, 1, 2, 26, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.SEVEN, y + Pix.FOURTEEN, z + Pix.NINE, 2, 1, 1, 20, 9, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.NINE, y + Pix.FOURTEEN, z + Pix.SEVEN, 1, 1, 2, 18, 0, icon, 1, 32, 32);
		//When not connected
		EasyTess.renderCube(x + Pix.FOUR, y + Pix.FOURTEEN, z + Pix.FIVE, 1, 1, 6, 8, 2, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.FIVE, y + Pix.FOURTEEN, z + Pix.FOUR, 6, 1, 1, 5, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.ELEVEN, y + Pix.FOURTEEN, z + Pix.FIVE, 1, 1, 6, 3, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.FIVE, y + Pix.FOURTEEN, z + Pix.ELEVEN, 6, 1, 1, 2, 4, icon, 1, 32, 32);
		
		//side 1
		EasyTess.renderCube(x, y + Pix.FIFTEEN, z + Pix.FOUR, 4, 1, 8, 8, 4, icon, 1, 32, 32);
		EasyTess.renderCube(x, y + Pix.FOURTEEN, z + Pix.FOUR, 4, 1, 1, 0, 10, icon, 1, 32, 32);
		EasyTess.renderCube(x, y + Pix.FOURTEEN, z + Pix.ELEVEN, 4, 1, 1, 10, 8, icon, 1, 32, 32);
		EasyTess.renderCube(x, y + Pix.FOURTEEN, z + Pix.SIX, 6, 1, 1, 22, 9, icon, 1, 32, 32);
		EasyTess.renderCube(x, y + Pix.FOURTEEN, z + Pix.NINE, 6, 1, 1, 19, 6, icon, 1, 32, 32);
		
		//side 2
		EasyTess.renderCube(x + Pix.TWELVE, y + Pix.FIFTEEN, z + Pix.FOUR, 4, 1, 8, 5, 5, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.TWELVE, y + Pix.FOURTEEN, z + Pix.FOUR, 4, 1, 1, 8, 8, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.TWELVE, y + Pix.FOURTEEN, z + Pix.ELEVEN, 4, 1, 1, 9, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.TEN, y + Pix.FOURTEEN, z + Pix.SIX, 6, 1, 1, 20, 8, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.TEN, y + Pix.FOURTEEN, z + Pix.NINE, 6, 1, 1, 26, 7, icon, 1, 32, 32);
		
		//side 3
		EasyTess.renderCube(x + Pix.FOUR, y + Pix.FIFTEEN, z, 8, 1, 4, 0, 3, icon, 1, 32, 32); 
		EasyTess.renderCube(x + Pix.FOUR, y + Pix.FOURTEEN, z, 1, 1, 4, 3, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.ELEVEN, y + Pix.FOURTEEN, z, 1, 1, 4, 4, 4, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.SIX, y + Pix.FOURTEEN, z, 1, 1, 6, 18, 8, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.NINE, y + Pix.FOURTEEN, z, 1, 1, 6, 24, 2, icon, 1, 32, 32);
		
		//side 4
		EasyTess.renderCube(x + Pix.FOUR, y + Pix.FIFTEEN, z + Pix.TWELVE, 8, 1, 4, 0, 3, icon, 1, 32, 32); 
		EasyTess.renderCube(x + Pix.FOUR, y + Pix.FOURTEEN, z + Pix.TWELVE, 1, 1, 4, 9, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.ELEVEN, y + Pix.FOURTEEN, z + Pix.TWELVE, 1, 1, 4, 2, 5, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.SIX, y + Pix.FOURTEEN, z + Pix.TEN, 1, 1, 6, 20, 6, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.NINE, y + Pix.FOURTEEN, z + Pix.TEN, 1, 1, 6, 19, 4, icon, 1, 32, 32);
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return false;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.FluorescentLampType;
	}

}
