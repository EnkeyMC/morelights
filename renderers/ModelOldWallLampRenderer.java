package morelights.renderers;

import morelights.lib.Reference;
import morelights.model.ModelOldWallLamp;
import morelights.model.ModelOldWallLampFire;
import morelights.model.ModelOldWallLampGlass;
import morelights.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class ModelOldWallLampRenderer extends TileEntitySpecialRenderer{
	
	private final ModelOldWallLamp model;
	private final ModelOldWallLampGlass modelGlass;
	private final ModelOldWallLampFire modelFire;
	
	public ModelOldWallLampRenderer()
	{
		this.model = new ModelOldWallLamp();
		this.modelGlass = new ModelOldWallLampGlass();
		this.modelFire = new ModelOldWallLampFire();
	}
	
	private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        GL11.glPushMatrix();
        GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
        GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
		//The PushMatrix tells the renderer to "start" doing something.
        GL11.glPushMatrix();
        //This is setting the initial location.
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_CULL_FACE);
        //Use in 1.6.2  this
        ResourceLocation textures = (new ResourceLocation(Reference.modid + ":textures/models/ModelOldWallLamp.png")); 
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
        //This rotation part is very important! Without it, your model will render upside-down! And for some reason you DO need PushMatrix again!                      
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
        this.modelFire.render((Entity)null,  0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.015625F);
        this.modelGlass.render((Entity)null, 0F, 0F, -0.1F, 0.0F, 0.0F, 0.0625F);

        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
	}
	
	//Set the lighting stuff, so it changes it's brightness properly.      
    private void adjustLightFixture(World world, int i, int j, int k, Block block) {
            Tessellator tess = Tessellator.instance;
            float brightness = block.getBlockBrightness(world, i, j, k);
            int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
            int modulousModifier = skyLight % 65536;
            int divModifier = skyLight / 65536;
            tess.setColorOpaque_F(brightness, brightness, brightness);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
    }

}
