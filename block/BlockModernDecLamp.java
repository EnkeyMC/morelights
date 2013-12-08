package morelights.block;

import static net.minecraftforge.common.ForgeDirection.UP;
import morelights.lib.Pix;
import morelights.lib.Reference;
import morelights.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModernDecLamp extends Block {
	
	public BlockModernDecLamp(int id, Material par2Material) {
		super(id, par2Material);
		this.setLightValue(1.0F);
		this.setBlockBounds(Pix.FOUR + Pix.ONE/2, 0, Pix.FOUR + Pix.ONE/2, Pix.ELEVEN + Pix.ONE/2, Pix.TWELVE, Pix.ELEVEN + Pix.ONE/2);
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
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		if(!this.canPlaceBlockAt(par1World, par2, par3, par4)){
			par1World.setBlockToAir(par2, par3, par4);
			this.dropBlockAsItem(par1World, par2, par3, par4, 0, 0);
		}
	}
	
	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {		
        return par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		this.blockIcon = par1.registerIcon(Reference.modid + ":" + this.getUnlocalizedName().substring(5));
	}
}
