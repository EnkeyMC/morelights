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



public class BlockStreetLampPart extends Block{

	public BlockStreetLampPart(int id, Material par2Material) {
		super(id, par2Material);
		this.setLightValue(1F);
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
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		byte meta = (byte)par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		
		if(meta == 1){
			this.setBlockBounds(0.375F, 0F, 0.375F, 0.625F, Pix.SIXTEEN, 0.625F);
		}
		else if(meta == 2){
			this.setBlockBounds(0.4375F, -Pix.FOUR, 0.4375F, 0.5625F, 1.2F, 0.5625F);
		}
		else{
			System.out.println(this.getUnlocalizedName().substring(5) + " have worng metadata!");
		}
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
	{
		Block block = Block.blocksList[par1World.getBlockId(par2, par3 - par5, par4)];
		if(block instanceof BlockOldStreetLamp){
			((BlockOldStreetLamp) block).notifyBase(par1World, par2, par3 - par5, par4);
		}
	}

	@Override
	public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4, Explosion par5Explosion)
	{
		this.onBlockDestroyedByPlayer(par1World, par2, par3, par4, 0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	    for (byte var4 = 0; var4 < 2; ++var4)
	    {
	        par3List.add(new ItemStack(par1, 1, var4));
	    }
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return MoreLights.blockOldStreetLamp.blockID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		this.blockIcon = par1.registerIcon(Reference.modid + ":TransparentTexture");
	}
}
