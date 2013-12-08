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

public class ModernDecLampRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		Tessellator tes = Tessellator.instance;
		 
	    tes.startDrawingQuads();
	    
	    tes.addTranslation(-0.5F, -0.3F, -0.5F);
		
		int x = 0;
		int y = 0;
		int z = 0;
				
		Icon icon = block.getIcon(0, 0);
		
		double minU = icon.getMinU();
		double maxU = icon.getMaxU();
		double minV = icon.getMinV();
		double maxV = icon.getMaxV();
		double p = (maxU - minU) / 32;
		double pv = (maxV - minV) / 32;
		
		tes.setNormal(0.0F, 1.0F, 0.0F);
		//STAND
		this.renderPosZStand(tes, x, y, z, minU, maxU, minV, maxV, p, pv);
		this.renderNegZStand(tes, x, y, z, minU, maxU, minV, maxV, p, pv);
		this.renderPosXStand(tes, x, y, z, minU, maxU, minV, maxV, p, pv);
		this.renderNegXStand(tes, x, y, z, minU, maxU, minV, maxV, p, pv);
		this.rednerTopStand(tes, x, y, z, minU, maxU, minV, maxV, p, pv);
		this.renderBottomStand(tes, x, y, z, minU, minV, p, pv);
		
		//STAND2
		this.renderPosZStand2(tes, x, y, z, minU, minV, p, pv);
		this.renderNegZStand2(tes, x, y, z, minU, minV, p, pv);
		this.renderPosXStand2(tes, x, y, z, minU, minV, p, pv);
		this.renderNegXStand2(tes, x, y, z, minU, minV, p, pv);
		
		//LIGHT
		this.renderPosZLight(tes, x, y, z, minU, minV, p, pv);
		this.renderNegZLight(tes, x, y, z, minU, minV, p, pv);
		this.renderPosXLight(tes, x, y, z, minU, minV, p, pv);
		this.renderNegXLight(tes, x, y, z, minU, minV, p, pv);
		this.renderTopLight(tes, x, y, z, minU, minV, p, pv);
		this.renderBottomLight(tes, x, y, z, minU, minV, p, pv);
		
		tes.addTranslation(0.5F, 0.3F, 0.5F);
		
	    tes.draw();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		
		Tessellator tes = Tessellator.instance;
		int lightValue = block.getMixedBrightnessForBlock(world, x, y, z);
		tes.setBrightness(lightValue);
		tes.setColorOpaque_F(1.0F, 1.0F, 1.0F);
				
		Icon icon = block.getIcon(0, 0);
		
		double minU = icon.getMinU();
		double maxU = icon.getMaxU();
		double minV = icon.getMinV();
		double maxV = icon.getMaxV();
		double p = (maxU - minU) / 32;
		double pv = (maxV - minV) / 32;
		
		//STAND
		this.renderPosZStand(tes, x, y, z, minU, maxU, minV, maxV, p, pv);
		this.renderNegZStand(tes, x, y, z, minU, maxU, minV, maxV, p, pv);
		this.renderPosXStand(tes, x, y, z, minU, maxU, minV, maxV, p, pv);
		this.renderNegXStand(tes, x, y, z, minU, maxU, minV, maxV, p, pv);
		this.rednerTopStand(tes, x, y, z, minU, maxU, minV, maxV, p, pv);
		this.renderBottomStand(tes, x, y, z, minU, minV, p, pv);
		
		//STAND2
		this.renderPosZStand2(tes, x, y, z, minU, minV, p, pv);
		this.renderNegZStand2(tes, x, y, z, minU, minV, p, pv);
		this.renderPosXStand2(tes, x, y, z, minU, minV, p, pv);
		this.renderNegXStand2(tes, x, y, z, minU, minV, p, pv);
		
		//LIGHT
		this.renderPosZLight(tes, x, y, z, minU, minV, p, pv);
		this.renderNegZLight(tes, x, y, z, minU, minV, p, pv);
		this.renderPosXLight(tes, x, y, z, minU, minV, p, pv);
		this.renderNegXLight(tes, x, y, z, minU, minV, p, pv);
		this.renderTopLight(tes, x, y, z, minU, minV, p, pv);
		this.renderBottomLight(tes, x, y, z, minU, minV, p, pv);
		
		
		return true;
	}
	
	private void renderBottomLight(Tessellator tes, int x, int y, int z,
			double minU, double minV, double p, double pv) {
		double X = x + Pix.FOUR + (Pix.ONE/2);
		double Z = z + Pix.FOUR + (Pix.ONE/2);
		double Y = y + Pix.FIVE;
		minU += 21*p;
		minV += 16*pv;
		double maxU = minU + 7*p;
		double maxV = minV + 7*pv;
		tes.addVertexWithUV(X, Y, Z, minU, minV);
		tes.addVertexWithUV(X + Pix.SEVEN, Y, Z, maxU, minV);
		tes.addVertexWithUV(X + Pix.SEVEN, Y, Z + Pix.SEVEN, maxU, maxV);
		tes.addVertexWithUV(X, Y, Z + Pix.SEVEN, minU, maxV);
	}

	private void renderTopLight(Tessellator tes, int x, int y, int z,
			double minU, double minV, double p, double pv) {
		double X = x + Pix.FOUR + (Pix.ONE/2);
		double Z = z + Pix.FOUR + (Pix.ONE/2);
		double Y = y + Pix.TWELVE;
		minV += 16*pv;
		double maxU = minU + 7*p;
		double maxV = minV + 7*pv;
		tes.addVertexWithUV(X, Y, Z + Pix.SEVEN, minU, maxV);
		tes.addVertexWithUV(X + Pix.SEVEN, Y, Z + Pix.SEVEN, maxU, maxV);
		tes.addVertexWithUV(X + Pix.SEVEN, Y, Z, maxU, minV);
		tes.addVertexWithUV(X, Y, Z, minU, minV);
	}

	private void renderNegXLight(Tessellator tes, int x, int y, int z,
			double minU, double minV, double p, double pv) {
		double X = x + Pix.ELEVEN + (Pix.ONE/2);
		double Y = y + Pix.FIVE;
		double Z = z + Pix.ELEVEN + (Pix.ONE/2);
		minU += 14*p;
		minV += 17*pv;
		double maxU = minU + 7*p;
		double maxV = minV + 7*pv;
		tes.addVertexWithUV(X, Y, Z - Pix.SEVEN, maxU, minV);
		tes.addVertexWithUV(X, Y + Pix.SEVEN, Z - Pix.SEVEN, maxU, maxV);
		tes.addVertexWithUV(X, Y + Pix.SEVEN, Z, minU, maxV);
		tes.addVertexWithUV(X, Y, Z, minU, minV);
	}

	private void renderPosXLight(Tessellator tes, int x, int y, int z,
			double minU, double minV, double p, double pv) {
		double X = x + Pix.FOUR + (Pix.ONE/2);
		double Y = y + Pix.FIVE;
		double Z = z + Pix.ELEVEN + (Pix.ONE/2);
		minU += 7*p;
		minV += 17*pv;
		double maxU = minU + 7*p;
		double maxV = minV + 7*pv;
		tes.addVertexWithUV(X, Y, Z, minU, minV);
		tes.addVertexWithUV(X, Y + Pix.SEVEN, Z, minU, maxV);
		tes.addVertexWithUV(X, Y + Pix.SEVEN, Z - Pix.SEVEN, maxU, maxV);
		tes.addVertexWithUV(X, Y, Z - Pix.SEVEN, maxU, minV);
	}

	private void renderNegZLight(Tessellator tes, int x, int y, int z,
			double minU, double minV, double p, double pv) {
		double X = x + Pix.FOUR + (Pix.ONE/2);
		double Y = y + Pix.FIVE;
		double Z = z + Pix.ELEVEN + (Pix.ONE/2);
		minU += 14*p;
		minV += 10*pv;
		double maxU = minU + 7*p;
		double maxV = minV + 7*pv;
		tes.addVertexWithUV(X + Pix.SEVEN, Y, Z, maxU, minV);
		tes.addVertexWithUV(X + Pix.SEVEN, Y + Pix.SEVEN, Z, maxU, maxV);
		tes.addVertexWithUV(X, Y + Pix.SEVEN, Z, minU, maxV);
		tes.addVertexWithUV(X, Y, Z, minU, minV);
	}

	private void renderPosZLight(Tessellator tes, int x, int y, int z,
			double minU, double minV, double p, double pv) {
		double X = x + Pix.FOUR + (Pix.ONE/2);
		double Y = y + Pix.FIVE;
		double Z = z + Pix.FOUR + (Pix.ONE/2);
		minU += 7*p;
		minV += 10*pv;
		double maxU = minU + 7*p;
		double maxV = minV + 7*pv;
		tes.addVertexWithUV(X, Y, Z, minU, minV);
		tes.addVertexWithUV(X, Y + Pix.SEVEN, Z, minU, maxV);
		tes.addVertexWithUV(X + Pix.SEVEN, Y + Pix.SEVEN, Z, maxU, maxV);
		tes.addVertexWithUV(X + Pix.SEVEN, Y, Z, maxU, minV);
	}

	private void renderNegXStand2(Tessellator tes, int x, int y, int z,
			double minU, double minV, double p, double pv) {
		double X = x + Pix.TEN;
		double Y = y + Pix.TWO;
		double Z = z + Pix.TEN;
		minU += 20*p;
		minV += 2*pv;
		double maxU = minU + 4*p;
		double maxV = minV + 4*pv;
		tes.addVertexWithUV(X, Y, Z - Pix.FOUR, maxU, minV);
		tes.addVertexWithUV(X, Y + Pix.FOUR, Z - Pix.FOUR, maxU, maxV);
		tes.addVertexWithUV(X, Y + Pix.FOUR, Z, minU, maxV);
		tes.addVertexWithUV(X, Y, Z, minU, minV);
	}

	private void renderPosXStand2(Tessellator tes, int x, int y, int z,
			double minU, double minV, double p, double pv) {
		double X = x + Pix.SIX;
		double Y = y + Pix.TWO;
		double Z = z + Pix.TEN;
		minU += 12*p;
		minV += 2*pv;
		double maxU = minU + 4*p;
		double maxV = minV + 4*pv;
		tes.addVertexWithUV(X, Y, Z, minU, minV);
		tes.addVertexWithUV(X, Y + Pix.FOUR, Z, minU, maxV);
		tes.addVertexWithUV(X, Y + Pix.FOUR, Z - Pix.FOUR, maxU, maxV);
		tes.addVertexWithUV(X, Y, Z - Pix.FOUR, maxU, minV);
	}

	private void renderNegZStand2(Tessellator tes, int x, int y, int z,
			double minU, double minV, double p, double pv) {
		double X = x + Pix.SIX;
		double Y = y + Pix.TWO;
		double Z = z + Pix.TEN;
		minU += 16*p;
		minV += 2*pv;
		tes.addVertexWithUV(X + Pix.FOUR, Y, Z, minU + 4*p, minV);
		tes.addVertexWithUV(X + Pix.FOUR, Y + Pix.FOUR, Z, minU + 4*p, minV + 4*pv);
		tes.addVertexWithUV(X, Y + Pix.FOUR, Z, minU, minV + 4*pv);
		tes.addVertexWithUV(X, Y, Z, minU, minV);
	}

	private void renderPosZStand2(Tessellator tes, int x, int y, int z,
			double minU, double minV, double p, double pv) {
		double X = x + Pix.SIX;
		double Y = y + Pix.TWO;
		double Z = z + Pix.SIX;
		minU += 8*p;
		minV += 2*pv;
		tes.addVertexWithUV(X, Y, Z, minU, minV);
		tes.addVertexWithUV(X, Y + Pix.FOUR, Z, minU, minV + 4*pv);
		tes.addVertexWithUV(X + Pix.FOUR, Y + Pix.FOUR, Z, minU + 4*p, minV + 4*pv);
		tes.addVertexWithUV(X + Pix.FOUR, Y, Z, minU + 4*p, minV);
	}
	
	private void renderBottomStand(Tessellator tes, int X, int Y, int Z, 
			double minU, double minV, double p, double pv){
		double x = X + Pix.FOUR;
		double z = Z + Pix.FOUR;
		double y = Y;
		minV += 2*pv; 
		tes.addVertexWithUV(x, y, z, minU + 8*p, minV + 8*pv);
		tes.addVertexWithUV(x + Pix.EIGHT, y, z, minU, minV + 8*pv);
		tes.addVertexWithUV(x + Pix.EIGHT, y, z + Pix.EIGHT, minU, minV);
		tes.addVertexWithUV(x, y, z + Pix.EIGHT, minU + 8*p, minV);
	}

	private void rednerTopStand(Tessellator tes, int X, int Y, int Z,
			double minU, double maxU, double minV, double maxV, double p, double pv) {
		double x = X + Pix.FOUR;
		double z = Z + Pix.FOUR;
		double y = Y + Pix.TWO;
		minV += 2*pv; 
		tes.addVertexWithUV(x, y, z + Pix.EIGHT, minU + 8*p, minV);
		tes.addVertexWithUV(x + Pix.EIGHT, y, z + Pix.EIGHT, minU, minV);
		tes.addVertexWithUV(x + Pix.EIGHT, y, z, minU, minV + 8*pv);
		tes.addVertexWithUV(x, y, z, minU + 8*p, minV + 8*pv);
	}

	private void renderNegXStand(Tessellator tes, int X, int y, int Z, double minU,
			double maxU, double minV, double maxV, double p, double pv) 
	{
		double x = X + Pix.FOUR;
		double z = Z + Pix.TWELVE;
		minU += 24*p;
		tes.addVertexWithUV(x, y, z, minU, minV + 2*pv);
		tes.addVertexWithUV(x, y + Pix.TWO, z, minU, minV);
		tes.addVertexWithUV(x, y + Pix.TWO, z - Pix.EIGHT, minU + 8*p, minV);
		tes.addVertexWithUV(x, y, z - Pix.EIGHT, minU + 8*p, minV + 2*pv);
	}

	private void renderPosXStand(Tessellator tes, int X, int y, int Z, double minU,
			double maxU, double minV, double maxV, double p, double pv) 
	{
		double x = X + Pix.TWELVE;
		double z = Z + Pix.TWELVE;
		minU += 8*p;
		tes.addVertexWithUV(x, y, z - Pix.EIGHT, minU + 8*p, minV + 2*pv);
		tes.addVertexWithUV(x, y + Pix.TWO, z - Pix.EIGHT, minU + 8*p, minV);
		tes.addVertexWithUV(x, y + Pix.TWO, z, minU, minV);
		tes.addVertexWithUV(x, y, z, minU, minV + 2*pv);
	}

	private void renderNegZStand(Tessellator tes, int x, int y, int z, double minU,
			double maxU, double minV, double maxV, double p, double pv) 
	{
		double offX = x + Pix.FOUR;
		double offZ = z + Pix.TWELVE;
		tes.addVertexWithUV(offX + Pix.EIGHT, y, offZ, minU + 8*p, minV +2*pv);
		tes.addVertexWithUV(offX + Pix.EIGHT, y + Pix.TWO, offZ, minU + 8*p, minV);
		tes.addVertexWithUV(offX, y + Pix.TWO, offZ, minU, minV);
		tes.addVertexWithUV(offX, y, offZ, minU, minV + 2*pv);
	}

	private void renderPosZStand(Tessellator tes, int x, int y, int z, double minU, double maxU, double minV, double maxV, double p, double pv)
	{
		double offX = x + Pix.FOUR;
		double offZ = z + Pix.FOUR;
		minU += 16*p;
		tes.addVertexWithUV(offX, y, offZ, minU, minV + 2*pv);
		tes.addVertexWithUV(offX, y + Pix.TWO, offZ, minU, minV);
		tes.addVertexWithUV(offX + Pix.EIGHT, y + Pix.TWO, offZ, minU + 8*p, minV);
		tes.addVertexWithUV(offX + Pix.EIGHT, y, offZ, minU + 8*p, minV +2*pv);
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.ModernDecLampType;
	}

}
