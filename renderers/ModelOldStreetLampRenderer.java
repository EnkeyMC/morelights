package morelights.renderers;

import org.lwjgl.opengl.GL11;

import morelights.lib.Reference;
import morelights.model.ModelOldStreetLamp;
import morelights.model.ModelOldStreetLampLamp;
import morelights.model.ModelOldWallLampFire;
import morelights.model.ModelOldWallLampGlass;
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
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class ModelOldStreetLampRenderer extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler{
	
	public static int renderID;
	
	private final ModelOldStreetLamp model;
	private final ModelOldStreetLampLamp modelLamp;
	private final ModelOldWallLampFire modelFire;
	private final ModelOldWallLampGlass modelGlass;
	
	public ModelOldStreetLampRenderer(int ID) {
		this.renderID = ID;
		this.model = new ModelOldStreetLamp();
		this.modelLamp = new ModelOldStreetLampLamp();
		this.modelFire = new ModelOldWallLampFire();
		this.modelGlass = new ModelOldWallLampGlass();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float scale) {

		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glDisable(GL11.GL_CULL_FACE);
        
        ResourceLocation textures = (new ResourceLocation(Reference.modid + ":textures/models/ModelOldStreetLamp.png")); 
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
        
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        
        this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        
        ResourceLocation textures2 = (new ResourceLocation(Reference.modid + ":textures/models/ModelOldWallLamp.png")); 
        Minecraft.getMinecraft().renderEngine.bindTexture(textures2);
        
        GL11.glTranslatef(0F, -2.96F, 0F);

        
        this.modelLamp.render((Entity)null, 0F, 0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glScalef(0.7F, 1F, 0.7F);
        this.modelFire.render((Entity)null,  0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.015625F);
        GL11.glScalef(1F/0.7F, 1F, 1F/0.7F);
        this.modelGlass.render((Entity)null, 0F, 0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_CULL_FACE);
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
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		float scale = 0.4F;
		
		GL11.glPushMatrix();
		GL11.glTranslatef(0F,- 0.2F,0F);
		GL11.glScalef(scale, scale, scale);
        GL11.glDisable(GL11.GL_CULL_FACE);
        
        ResourceLocation textures = (new ResourceLocation(Reference.modid + ":textures/models/ModelOldStreetLamp.png")); 
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
        
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        
        this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        
        ResourceLocation textures2 = (new ResourceLocation(Reference.modid + ":textures/models/ModelOldWallLamp.png")); 
        Minecraft.getMinecraft().renderEngine.bindTexture(textures2);
        
        GL11.glTranslatef(0F, -2.96F, 0F);

        
        this.modelLamp.render((Entity)null, 0F, 0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glEnable(GL11.GL_BLEND);
        this.modelGlass.render((Entity)null, 0F, 0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_CULL_FACE);
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

}
