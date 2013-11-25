package morelights.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOldWallLampFire extends ModelBase {
	
	 ModelRenderer Fire1;
	 ModelRenderer Fire2;
	 ModelRenderer Fire3;
	 ModelRenderer Fire4;
	
	 public ModelOldWallLampFire()
	 {
		 textureWidth = 64;
		 textureHeight = 32;
		 
		 float x = -2.5F;
		 float y = -5F;
		 float z = -2.5F;
		 
		 	Fire1 = new ModelRenderer(this, 44, 10);
		    Fire1.addBox(x, y, z, 5, 10, 5);
		    Fire1.setRotationPoint(0F, 61F, 0F);
		    Fire1.setTextureSize(64, 32);
		    Fire1.mirror = true;
		    setRotation(Fire1, 0F, 0F, 0F);
	 }

	 @Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
		  
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    Fire1.render(f5);
	  }
	  
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y; // 3.14 = 180 degrees
	    model.rotateAngleZ = z;
	  }
	  
	  @Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	  {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	  }
	 
}
