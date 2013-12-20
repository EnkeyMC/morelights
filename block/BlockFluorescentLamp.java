package morelights.block;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import morelights.lib.Pix;
import morelights.lib.Reference;
import morelights.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockFluorescentLamp extends Block{

	public BlockFluorescentLamp(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setLightValue(1F);
		this.setBlockBounds(Pix.FOUR, Pix.FOURTEEN, Pix.FOUR, Pix.TWELVE, Pix.SIXTEEN, Pix.TWELVE);
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
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		if(!this.canPlaceBlockAt(par1World, par2, par3, par4)){
			par1World.setBlockToAir(par2, par3, par4);
			this.dropBlockAsItem(par1World, par2, par3, par4, 0, 0);
		}
	}
	
	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {		
        return par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		this.blockIcon = par1.registerIcon(Reference.modid + ":" + this.getUnlocalizedName().substring(5));
	}
}
