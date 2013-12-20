package morelights.renderers;

import org.lwjgl.opengl.GL11;

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
		Tessellator tes = Tessellator.instance;
		 
	    tes.startDrawingQuads();
	    
	    tes.addTranslation(-0.3F, 0, -0.3F);
		
		int x = 0;
		int y = 0;
		int z = 0;
		
		float offset = -0.02F;
				
		Icon icon = block.getIcon(0, 0);
		
		tes.setNormal(0.0F, 1.0F, 0.0F);
		
		EasyTess.renderCube(x + Pix.FOUR, y, z + Pix.FOUR, 8, 1, 8, 0, 8, icon, 1, 32, 32);
		
		EasyTess.renderCube(x + Pix.FOUR, y + Pix.ONE, z + Pix.FOUR, 1, 1, 1, 4, 25, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.FOUR, y + Pix.ONE, z + Pix.ELEVEN, 1, 1, 1, 9, 20, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.ELEVEN, y + Pix.ONE, z + Pix.FOUR, 1, 1, 1, 0, 18, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.ELEVEN, y + Pix.ONE, z + Pix.ELEVEN, 1, 1, 1, 6, 22, icon, 1, 32, 32);
		
		EasyTess.renderCube(x + Pix.SIX, y + Pix.ONE + offset, z + Pix.SIX, 1, 1, 1, 16, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.NINE, y + Pix.ONE + offset, z + Pix.SIX, 1, 1, 1, 16, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.SIX, y + Pix.ONE + offset, z + Pix.NINE, 1, 1, 1, 16, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.NINE, y + Pix.ONE + offset, z + Pix.NINE, 1, 1, 1, 16, 0, icon, 1, 32, 32);
		
		EasyTess.renderCube(x + Pix.SEVEN, y + Pix.ONE + offset, z + Pix.SIX, 2, 1, 1, 18, 5, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.SIX, y + Pix.ONE + offset, z + Pix.SEVEN, 1, 1, 2, 26, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.SEVEN, y + Pix.ONE + offset, z + Pix.NINE, 2, 1, 1, 20, 9, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.NINE, y + Pix.ONE + offset, z + Pix.SEVEN, 1, 1, 2, 18, 0, icon, 1, 32, 32);
		
		EasyTess.renderCube(x + Pix.FIVE, y + Pix.TWO, z + Pix.FIVE, 6, 0, 6, 16, 16, icon, 0, 32, 32);
		
		EasyTess.renderCube(x + Pix.ELEVEN, y + Pix.ONE, z + Pix.FIVE, 1, 1, 6, 3, 16, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.FOUR, y + Pix.ONE, z + Pix.FIVE, 1, 1, 6, 8, 18, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.FIVE, y + Pix.ONE, z + Pix.ELEVEN, 6, 1, 1, 2, 20, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.FIVE, y + Pix.ONE, z + Pix.FOUR, 6, 1, 1, 5, 16, icon, 1, 32, 32);
		
		tes.addTranslation(0.3F, 0, 0.3F);
		
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
		double offset = 0.02;
		boolean connected = false;
		
		int bl = world.getBlockId(x + 1, y, z); 
		if(bl == block.blockID){
			connected = true;
			//side 2
			EasyTess.renderCube(x + Pix.TWELVE, y + Pix.FIFTEEN, z + Pix.FOUR, 4, 1, 8, 5, 8, icon, 1, 32, 32);
			EasyTess.renderCube(x + Pix.TWELVE, y + Pix.FOURTEEN, z + Pix.FOUR, 4, 1, 1, 8, 26, icon, 1, 32, 32);
			EasyTess.renderCube(x + Pix.TWELVE, y + Pix.FOURTEEN, z + Pix.ELEVEN, 4, 1, 1, 9, 16, icon, 1, 32, 32);
			EasyTess.renderCube(x + Pix.TEN, y + Pix.FOURTEEN + offset, z + Pix.SIX, 6, 1, 1, 20, 8, icon, 1, 32, 32);
			EasyTess.renderCube(x + Pix.TEN, y + Pix.FOURTEEN + offset, z + Pix.NINE, 6, 1, 1, 26, 7, icon, 1, 32, 32);
			EasyTess.renderCube(x + Pix.ELEVEN, y + Pix.FOURTEEN, z + Pix.FIVE, 5, 0, 6, 27, 16, icon, 0, 32, 32);
		}else{
			EasyTess.renderCube(x + Pix.ELEVEN, y + Pix.FOURTEEN, z + Pix.FIVE, 1, 1, 6, 3, 16, icon, 1, 32, 32);
		}
		
		bl = world.getBlockId(x - 1, y, z);
		if(bl == block.blockID){
			connected = true;
			//side 1
			EasyTess.renderCube(x, y + Pix.FIFTEEN, z + Pix.FOUR, 4, 1, 8, 8, 8, icon, 1, 32, 32);
			EasyTess.renderCube(x, y + Pix.FOURTEEN, z + Pix.FOUR, 4, 1, 1, 0, 26, icon, 1, 32, 32);
			EasyTess.renderCube(x, y + Pix.FOURTEEN, z + Pix.ELEVEN, 4, 1, 1, 10, 27, icon, 1, 32, 32);
			EasyTess.renderCube(x, y + Pix.FOURTEEN + offset, z + Pix.SIX, 6, 1, 1, 22, 9, icon, 1, 32, 32);
			EasyTess.renderCube(x, y + Pix.FOURTEEN + offset, z + Pix.NINE, 6, 1, 1, 19, 6, icon, 1, 32, 32);
			EasyTess.renderCube(x, y + Pix.FOURTEEN, z + Pix.FIVE, 5, 0, 6, 22, 16, icon, 0, 32, 32);
		}else{
			EasyTess.renderCube(x + Pix.FOUR, y + Pix.FOURTEEN, z + Pix.FIVE, 1, 1, 6, 8, 18, icon, 1, 32, 32);
		}
		
		bl = world.getBlockId(x, y, z + 1);
		if(bl == block.blockID){
			connected = true;
			//side 4
			EasyTess.renderCube(x + Pix.FOUR, y + Pix.FIFTEEN, z + Pix.TWELVE, 8, 1, 4, 0, 12, icon, 1, 32, 32); 
			EasyTess.renderCube(x + Pix.FOUR, y + Pix.FOURTEEN, z + Pix.TWELVE, 1, 1, 4, 9, 16, icon, 1, 32, 32);
			EasyTess.renderCube(x + Pix.ELEVEN, y + Pix.FOURTEEN, z + Pix.TWELVE, 1, 1, 4, 2, 21, icon, 1, 32, 32);
			EasyTess.renderCube(x + Pix.SIX, y + Pix.FOURTEEN + offset, z + Pix.TEN, 1, 1, 6, 20, 6, icon, 1, 32, 32);
			EasyTess.renderCube(x + Pix.NINE, y + Pix.FOURTEEN + offset, z + Pix.TEN, 1, 1, 6, 19, 4, icon, 1, 32, 32);
			EasyTess.renderCube(x + Pix.FIVE, y + Pix.FOURTEEN, z + Pix.ELEVEN, 6, 0, 5, 22, 22, icon, 0, 32, 32);
		}else{
			EasyTess.renderCube(x + Pix.FIVE, y + Pix.FOURTEEN, z + Pix.ELEVEN, 6, 1, 1, 2, 20, icon, 1, 32, 32);
		}
		
		bl = world.getBlockId(x, y, z - 1);
		if(bl == block.blockID){
			connected = true;
			//side 3
			EasyTess.renderCube(x + Pix.FOUR, y + Pix.FIFTEEN, z, 8, 1, 4, 0, 12, icon, 1, 32, 32); 
			EasyTess.renderCube(x + Pix.FOUR, y + Pix.FOURTEEN, z, 1, 1, 4, 3, 18, icon, 1, 32, 32);
			EasyTess.renderCube(x + Pix.ELEVEN, y + Pix.FOURTEEN, z, 1, 1, 4, 4, 20, icon, 1, 32, 32);
			EasyTess.renderCube(x + Pix.SIX, y + Pix.FOURTEEN + offset, z, 1, 1, 6, 18, 8, icon, 1, 32, 32);
			EasyTess.renderCube(x + Pix.NINE, y + Pix.FOURTEEN + offset, z, 1, 1, 6, 24, 2, icon, 1, 32, 32);
			EasyTess.renderCube(x + Pix.FIVE, y + Pix.FOURTEEN, z, 6, 0, 5, 16, 22, icon, 0, 32, 32);
		}else{
			EasyTess.renderCube(x + Pix.FIVE, y + Pix.FOURTEEN, z + Pix.FOUR, 6, 1, 1, 5, 16, icon, 1, 32, 32);
		}
		
		//Base
		EasyTess.renderCube(x + Pix.FOUR, y + Pix.FIFTEEN, z + Pix.FOUR, 8, 1, 8, 0, 8, icon, 1, 32, 32);
		
		EasyTess.renderCube(x + Pix.FOUR, y + Pix.FOURTEEN, z + Pix.FOUR, 1, 1, 1, 4, 25, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.FOUR, y + Pix.FOURTEEN, z + Pix.ELEVEN, 1, 1, 1, 9, 20, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.ELEVEN, y + Pix.FOURTEEN, z + Pix.FOUR, 1, 1, 1, 0, 18, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.ELEVEN, y + Pix.FOURTEEN, z + Pix.ELEVEN, 1, 1, 1, 6, 22, icon, 1, 32, 32);
		
		EasyTess.renderCube(x + Pix.SIX, y + Pix.FOURTEEN + offset, z + Pix.SIX, 1, 1, 1, 16, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.NINE, y + Pix.FOURTEEN + offset, z + Pix.SIX, 1, 1, 1, 16, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.SIX, y + Pix.FOURTEEN + offset, z + Pix.NINE, 1, 1, 1, 16, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.NINE, y + Pix.FOURTEEN + offset, z + Pix.NINE, 1, 1, 1, 16, 0, icon, 1, 32, 32);
		
		EasyTess.renderCube(x + Pix.SEVEN, y + Pix.FOURTEEN + offset, z + Pix.SIX, 2, 1, 1, 18, 5, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.SIX, y + Pix.FOURTEEN + offset, z + Pix.SEVEN, 1, 1, 2, 26, 0, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.SEVEN, y + Pix.FOURTEEN + offset, z + Pix.NINE, 2, 1, 1, 20, 9, icon, 1, 32, 32);
		EasyTess.renderCube(x + Pix.NINE, y + Pix.FOURTEEN + offset, z + Pix.SEVEN, 1, 1, 2, 18, 0, icon, 1, 32, 32);
		
		EasyTess.renderCube(x + Pix.FIVE, y + Pix.FOURTEEN, z + Pix.FIVE, 6, 0, 6, 16, 16, icon, 0, 32, 32);
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.FluorescentLampType;
	}

}
