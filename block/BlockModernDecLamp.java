package morelights.block;

import morelights.lib.Reference;
import morelights.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModernDecLamp extends Block {
	
	public BlockModernDecLamp(int id, Material par2Material) {
		super(id, par2Material);
		this.setLightValue(1.0F);
	}
	
	@Override
    public int getRenderType()
	{
		return ClientProxy.ModernDecLampType;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		this.blockIcon = par1.registerIcon(Reference.modid + ":" + this.getUnlocalizedName().substring(5));
	}
}
