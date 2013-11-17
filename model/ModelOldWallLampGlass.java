package morelights.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOldWallLampGlass extends ModelBase {
	
	 ModelRenderer Glass1;
	 ModelRenderer Glass2;
	 ModelRenderer Glass3;
	 ModelRenderer Glass4;
	
	 public ModelOldWallLampGlass()
	 {
		 textureWidth = 64;
		 textureHeight = 32;
		 
		 	Glass1 = new ModelRenderer(this, 52, -3);
		    Glass1.addBox(1.6F, 0F, -1.5F, 0, 6, 3);
		    Glass1.setRotationPoint(0F, 13F, 0F);
		    Glass1.setTextureSize(64, 32);
		    Glass1.mirror = true;
		    setRotation(Glass1, 0F, 0F, 0F);
		    Glass2 = new ModelRenderer(this, 52, -3);
		    Glass2.addBox(-1.6F, 0F, -1.5F, 0, 6, 3);
		    Glass2.setRotationPoint(0F, 13F, 0F);
		    Glass2.setTextureSize(64, 32);
		    Glass2.mirror = true;
		    setRotation(Glass2, 0F, 0F, 0F);
		    Glass3 = new ModelRenderer(this, 52, 0);
		    Glass3.addBox(-1.5F, 0F, -1.6F, 3, 6, 0);
		    Glass3.setRotationPoint(0F, 13F, 0F);
		    Glass3.setTextureSize(64, 32);
		    Glass3.mirror = true;
		    setRotation(Glass3, 0F, 0F, 0F);
		    Glass4 = new ModelRenderer(this, 52, 0);
		    Glass4.addBox(-1.5F, 0F, 1.6F, 3, 6, 0);
		    Glass4.setRotationPoint(0F, 13F, 0F);
		    Glass4.setTextureSize(64, 32);
		    Glass4.mirror = true;
		    setRotation(Glass4, 0F, 0F, 0F);
	 }

	 public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
		  
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    Glass1.render(f5);
	    Glass2.render(f5);
	    Glass3.render(f5);
	    Glass4.render(f5);
	  }
	  
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y; // 3.14 = 180 degrees
	    model.rotateAngleZ = z;
	  }
	  
	  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	  {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	  }
	 
}
