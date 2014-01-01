package morelights.renderers;

import morelights.lib.Reference;
import morelights.model.ModelReflector;
import morelights.model.ModelReflectorStand;
import morelights.proxy.ClientProxy;
import morelights.tileentity.TileBlockReflector;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class ModelReflectorRenderer extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler{
	
	private ModelReflector model;
	private ModelReflectorStand modelStand;
	public static int renderID;
	public float speed = 7f;
	
	public ModelReflectorRenderer(int type) {
		this.renderID = type;
		model = new ModelReflector();
		modelStand = new ModelReflectorStand();	
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		GL11.glPushMatrix();
        GL11.glTranslatef(0, 1.25F, 0);
        
        ResourceLocation textures = (new ResourceLocation(Reference.modid + ":textures/models/ModelReflector.png")); 
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(90F, 0, 1F, 0);
        
        this.model.render((Entity)null, 0.0F, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);  
        this.modelStand.render((Entity)null, 0.0F, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);     

        GL11.glPopMatrix();
        GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return this.renderID;
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y,
			double z, float f) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        
        TileBlockReflector te = (TileBlockReflector) tile;
        byte meta = (byte) te.getBlockMetadata();
       
        this.adjustLightFixture(te.worldObj, te.xCoord, te.yCoord, te.zCoord, te.blockType);
        
        ResourceLocation textures = (new ResourceLocation(Reference.modid + ":textures/models/ModelReflector.png")); 
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        
        switch(meta){
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
        case 6:
        	GL11.glRotatef(90F, 0, 1F, 0);
        	break;
        default:
        	break;
        }
        
        if(meta < 6){
        	boolean m = te.moves;
        	if(m){
        		te.rotation -= f * speed;
	        	if(te.rotation <= 0F){
	        		te.moves = false;
	        		te.rotation = 0f;
	        	}
        	}
        }else{
        	te.rotation = 90F;
        }
        
        this.model.render((Entity)null, 0.0F, 0.0F, -te.rotation, 0.0F, 0.0F, 0.0625F);  
        this.modelStand.render((Entity)null, 0.0F, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);     

        GL11.glPopMatrix();
        GL11.glPopMatrix();
	}
	
	private void adjustLightFixture(World world, int i, int j, int k, Block block) {
        Tessellator tess = Tessellator.instance;
        float brightness = block.getBlockBrightness(world, i, j, k);
        int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int modulousModifier = skyLight % 65536;
        int divModifier = skyLight / 65536;
        tess.setColorOpaque_F(brightness, brightness, brightness);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  modulousModifier,  divModifier);
	}
}
