package morelights.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOldStreetLampLamp extends ModelBase
{
  //fields
    ModelRenderer Candle;
    ModelRenderer Body4;
    ModelRenderer Body2;
    ModelRenderer Body3;
    ModelRenderer Body5;
    ModelRenderer Body6;
    ModelRenderer Body7;
    ModelRenderer Body8;
    ModelRenderer Body9;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
  
  public ModelOldStreetLampLamp()
  {
    textureWidth = 64;
    textureHeight = 32;
	    
    Candle = new ModelRenderer(this, 45, 0);
    Candle.addBox(-0.5F, 3F, -0.5F, 1, 3, 1);
    Candle.setRotationPoint(0F, 13F, 0F);
    Candle.setTextureSize(64, 32);
    Candle.mirror = true;
    setRotation(Candle, 0F, 0F, 0F);
    Body4 = new ModelRenderer(this, 0, 4);
    Body4.addBox(-2F, 6.5F, -2F, 4, 1, 4);
    Body4.setRotationPoint(0F, 13F, 0F);
    Body4.setTextureSize(64, 32);
    Body4.mirror = true;
    setRotation(Body4, 0F, 0F, 0F);
    Body2 = new ModelRenderer(this, 0, 0);
    Body2.addBox(-1F, 7.5F, -1F, 2, 1, 2);
    Body2.setRotationPoint(0F, 13F, 0F);
    Body2.setTextureSize(64, 32);
    Body2.mirror = true;
    setRotation(Body2, 0F, 0F, 0F);
    Body3 = new ModelRenderer(this, 8, 0);
    Body3.addBox(-1.5F, 7F, -1.5F, 3, 1, 3);
    Body3.setRotationPoint(0F, 13F, 0F);
    Body3.setTextureSize(64, 32);
    Body3.mirror = true;
    setRotation(Body3, 0F, 0F, 0F);
    Body5 = new ModelRenderer(this, 4, 9);
    Body5.addBox(-2.5F, 6F, -2.5F, 5, 1, 5);
    Body5.setRotationPoint(0F, 13F, 0F);
    Body5.setTextureSize(64, 32);
    Body5.mirror = true;
    setRotation(Body5, 0F, 0F, 0F);
    Body6 = new ModelRenderer(this, 16, 4);
    Body6.addBox(1.2F, 0F, -2.2F, 1, 6, 1);
    Body6.setRotationPoint(0F, 13F, 0F);
    Body6.setTextureSize(64, 32);
    Body6.mirror = true;
    setRotation(Body6, 0F, 0F, 0F);
    Body7 = new ModelRenderer(this, 16, 4);
    Body7.addBox(-2.2F, 0F, 1.2F, 1, 6, 1);
    Body7.setRotationPoint(0F, 13F, 0F);
    Body7.setTextureSize(64, 32);
    Body7.mirror = true;
    setRotation(Body7, 0F, 0F, 0F);
    Body8 = new ModelRenderer(this, 16, 4);
    Body8.addBox(-2.2F, 0F, -2.2F, 1, 6, 1);
    Body8.setRotationPoint(0F, 13F, 0F);
    Body8.setTextureSize(64, 32);
    Body8.mirror = true;
    setRotation(Body8, 0F, 0F, 0F);
    Body9 = new ModelRenderer(this, 16, 4);
    Body9.addBox(1.2F, 0F, 1.2F, 1, 6, 1);
    Body9.setRotationPoint(0F, 13F, 0F);
    Body9.setTextureSize(64, 32);
    Body9.mirror = true;
    setRotation(Body9, 0F, 0F, 0F);
    Shape1 = new ModelRenderer(this, 0, 0);
    Shape1.addBox(-3F, -0.5333334F, -3F, 6, 1, 6);
    Shape1.setRotationPoint(0F, 13F, 0F);
    Shape1.setTextureSize(64, 32);
    Shape1.mirror = true;
    setRotation(Shape1, 0F, 0F, 0F);
    Shape2 = new ModelRenderer(this, 4, 9);
    Shape2.addBox(-2.5F, -1F, -2.5F, 5, 1, 5);
    Shape2.setRotationPoint(0F, 13F, 0F);
    Shape2.setTextureSize(64, 32);
    Shape2.mirror = true;
    setRotation(Shape2, 0F, 0F, 0F);
    Shape3 = new ModelRenderer(this, 0, 0);
    Shape3.addBox(-2F, -1.6F, -2F, 4, 1, 4);
    Shape3.setRotationPoint(0F, 13F, 0F);
    Shape3.setTextureSize(64, 32);
    Shape3.mirror = true;
    setRotation(Shape3, 0F, 0F, 0F);
    Shape4 = new ModelRenderer(this, 0, 5);
    Shape4.addBox(-1.5F, -2.3F, -1.5F, 3, 1, 3);
    Shape4.setRotationPoint(0F, 13F, 0F);
    Shape4.setTextureSize(64, 32);
    Shape4.mirror = true;
    setRotation(Shape4, 0F, 0F, 0F);
    Shape5 = new ModelRenderer(this, 0, 0);
    Shape5.addBox(-1F, -3.1F, -1F, 2, 1, 2);
    Shape5.setRotationPoint(0F, 13F, 0F);
    Shape5.setTextureSize(64, 32);
    Shape5.mirror = true;
    setRotation(Shape5, 0F, 0F, 0F);
    Shape6 = new ModelRenderer(this, 0, 0);
    Shape6.addBox(-0.5F, -4F, -0.5F, 1, 1, 1);
    Shape6.setRotationPoint(0F, 13F, 0F);
    Shape6.setTextureSize(64, 32);
    Shape6.mirror = true;
    setRotation(Shape6, 0F, 0F, 0F);
    
  }
  
  @Override
public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	  
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Candle.render(f5);
    Body4.render(f5);
    Body2.render(f5);
    Body3.render(f5);
    Body5.render(f5);
    Body6.render(f5);
    Body7.render(f5);
    Body8.render(f5);
    Body9.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
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
