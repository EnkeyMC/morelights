package morelights.block;

import java.util.List;
import java.util.Random;

import morelights.MoreLights;
import morelights.lib.Pix;
import morelights.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



public class BlockStreetLampLight extends Block{

	public BlockStreetLampLight(int id, Material par2Material) {
		super(id, par2Material);
		this.setLightValue(1.0F);
		this.setBlockBounds(Pix.FIVE,Pix.TWO,Pix.FIVE,Pix.ELEVEN,Pix.FOURTEEN,Pix.ELEVEN);
	}	
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
	{
		par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
	}
	
	public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4, Explosion par5Explosion)
	{
		par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return MoreLights.blockOldStreetLamp.blockID;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		this.blockIcon = par1.registerIcon(Reference.modid + ":TransparentTexture");
	}
}
