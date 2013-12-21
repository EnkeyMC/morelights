package morelights.renderers;

import morelights.lib.Reference;
import morelights.model.ModelReflector;
import morelights.model.ModelReflectorStand;
import morelights.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class ModelReflectorRenderer extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler{
	
	private ModelReflector model;
	private ModelReflectorStand modelStand;
	public static int renderID;
	
	public ModelReflectorRenderer(int type) {
		this.renderID = type;
		model = new ModelReflector();
		modelStand = new ModelReflectorStand();		
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return false;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.ReflectorType;
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y,
			double z, float f) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
       
        ResourceLocation textures = (new ResourceLocation(Reference.modid + ":textures/models/ModelReflector.png")); 
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        
        switch(te.getBlockMetadata()){
        case 2:
        	break;
        case 4:
        	GL11.glRotatef(90F, 0F, 1F, 0F);
        	break;
        case 5:
        	GL11.glRotatef(270F, 0F, 1F, 0F);
        	break;
        case 3:
        	GL11.glRotatef(180F, 0F, 1F, 0F);
        	break;
        default:
        	break;
        }
        
        this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);  
        this.modelStand.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);     

        GL11.glPopMatrix();
        GL11.glPopMatrix();
	}

}
