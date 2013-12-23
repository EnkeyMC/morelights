package morelights.model;

import morelights.renderers.ModelReflectorRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelReflector extends ModelBase
{
  //fields
    ModelRenderer ref1;
    ModelRenderer ref2;
    ModelRenderer ref3;
    ModelRenderer ref4;
    ModelRenderer ref5;
    ModelRenderer ref6;
    ModelRenderer ref7;
    ModelRenderer ref8;
    ModelRenderer ref9;
    ModelRenderer ref10;
    ModelRenderer ref11;
  
  public ModelReflector()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      ref1 = new ModelRenderer(this, 0, 22);
      ref1.addBox(-0.5F, -0.5F, -4.5F, 1, 1, 9);
      ref1.setRotationPoint(0F, 18F, 0F);
      ref1.setTextureSize(32, 32);
      ref1.mirror = true;
      setRotation(ref1, 0F, 0F, 0F);
      ref2 = new ModelRenderer(this, 0, 5);
      ref2.addBox(-4.5F, -1.5F, -2.5F, 10, 3, 1);
      ref2.setRotationPoint(0F, 18F, 0F);
      ref2.setTextureSize(32, 32);
      ref2.mirror = true;
      setRotation(ref2, 0F, 0F, 0F);
      ref3 = new ModelRenderer(this, 0, 7);
      ref3.addBox(-4.5F, -2.5F, -1.5F, 10, 1, 3);
      ref3.setRotationPoint(0F, 18F, 0F);
      ref3.setTextureSize(32, 32);
      ref3.mirror = true;
      setRotation(ref3, 0F, 0F, 0F);
      ref4 = new ModelRenderer(this, 0, 5);
      ref4.addBox(-4.5F, 1.5F, -1.5F, 10, 1, 3);
      ref4.setRotationPoint(0F, 18F, 0F);
      ref4.setTextureSize(32, 32);
      ref4.mirror = true;
      setRotation(ref4, 0F, 0F, 0F);
      ref5 = new ModelRenderer(this, 0, 5);
      ref5.addBox(-5.5F, -1.5F, -1.5F, 1, 3, 3);
      ref5.setRotationPoint(0F, 18F, 0F);
      ref5.setTextureSize(32, 32);
      ref5.mirror = true;
      setRotation(ref5, 0F, 0F, 0F);
      ref6 = new ModelRenderer(this, 0, 5);
      ref6.addBox(-4.5F, -1.5F, 1.5F, 10, 3, 1);
      ref6.setRotationPoint(0F, 18F, 0F);
      ref6.setTextureSize(32, 32);
      ref6.mirror = true;
      setRotation(ref6, 0F, 0F, 0F);
      ref7 = new ModelRenderer(this, 0, 22);
      ref7.addBox(3.5F, -1.5F, -1.5F, 1, 3, 3);
      ref7.setRotationPoint(0F, 18F, 0F);
      ref7.setTextureSize(32, 32);
      ref7.mirror = true;
      setRotation(ref7, 0F, 0F, 0F);
      ref8 = new ModelRenderer(this, 12, 22);
      ref8.addBox(4.3F, -4.5F, -1F, 1, 2, 2);
      ref8.setRotationPoint(0F, 18F, 0F);
      ref8.setTextureSize(32, 32);
      ref8.mirror = true;
      setRotation(ref8, 0F, 0F, 1.047198F);
      ref9 = new ModelRenderer(this, 12, 22);
      ref9.addBox(4.3F, 2.5F, -1F, 1, 2, 2);
      ref9.setRotationPoint(0F, 18F, 0F);
      ref9.setTextureSize(32, 32);
      ref9.mirror = true;
      setRotation(ref9, 0F, 0F, -1.047198F);
      ref10 = new ModelRenderer(this, 12, 22);
      ref10.addBox(4.3F, -1F, 2.5F, 1, 2, 2);
      ref10.setRotationPoint(0F, 18F, 0F);
      ref10.setTextureSize(32, 32);
      ref10.mirror = true;
      setRotation(ref10, 0F, 1.047198F, 0F);
      ref11 = new ModelRenderer(this, 12, 22);
      ref11.addBox(4.3F, -1F, -4.5F, 1, 2, 2);
      ref11.setRotationPoint(0F, 18F, 0F);
      ref11.setTextureSize(32, 32);
      ref11.mirror = true;
      setRotation(ref11, 0F, -1.047198F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    ref1.render(f5);
    ref2.render(f5);
    ref3.render(f5);
    ref4.render(f5);
    ref5.render(f5);
    ref6.render(f5);
    ref7.render(f5);
    ref8.render(f5);
    ref9.render(f5);
    ref10.render(f5);
    ref11.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  private void setRotation(ModelRenderer model, float z)
  {
	  model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    this.setRotation(this.ref1, f2 * ((float) Math.PI / 180));
    this.setRotation(this.ref2, f2 * ((float) Math.PI / 180));
    this.setRotation(this.ref3, f2 * ((float) Math.PI / 180));
    this.setRotation(this.ref4, f2 * ((float) Math.PI / 180));
    this.setRotation(this.ref5, f2 * ((float) Math.PI / 180));
    this.setRotation(this.ref6, f2 * ((float) Math.PI / 180));
    this.setRotation(this.ref7, f2 * ((float) Math.PI / 180));
    this.setRotation(this.ref8, f2 * ((float) Math.PI / 180) + 1.047198F);
    this.setRotation(this.ref9, f2 * ((float) Math.PI / 180) - 1.047198F);
    this.setRotation(this.ref10, f2 * ((float) Math.PI / 180));
    this.setRotation(this.ref11, f2 * ((float) Math.PI / 180));
  }

}
