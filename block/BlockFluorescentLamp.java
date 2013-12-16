package morelights.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import morelights.lib.Reference;
import morelights.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockFluorescentLamp extends Block{

	public BlockFluorescentLamp(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setLightValue(1F);
	}
	
	@Override
    public int getRenderType()
	{
		return ClientProxy.FluorescentLampType;
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
