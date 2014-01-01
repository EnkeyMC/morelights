package morelights.block;

import java.util.Random;

import morelights.lib.Reference;
import morelights.renderers.ModelReflectorRenderer;
import morelights.tileentity.TileBlockReflector;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockReflector extends BlockContainer {
	
	public BlockReflector(int par1, Material par2Material) {
		super(par1, par2Material);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileBlockReflector();
	}
	
	@Override
	public int getRenderType(){
		return ModelReflectorRenderer.renderID;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side)
    {
        return side != -1;
    }

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase LivingBase, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(LivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        
		if(LivingBase.rotationPitch > 60D){
			if((l == 0)||(l == 2)){
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 6, 2);
			}else{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 7, 2);
			}
		}else{			
	        if (l == 0)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
	        }
	
	        if (l == 1)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
	        }
	
	        if (l == 2)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
	        }
	
	        if (l == 3)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
	        }
		}
    }
	
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		if(par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)){
			((TileBlockReflector)par1World.getBlockTileEntity(par2, par3, par4)).isPowered = true;
		}else{
			((TileBlockReflector)par1World.getBlockTileEntity(par2, par3, par4)).isPowered = false;
		}
	}
	
	@Override
	public void onPostBlockPlaced(World par1World, int par2, int par3, int par4, int par5) {
		TileBlockReflector te = (TileBlockReflector) par1World.getBlockTileEntity(par2, par3, par4);
		byte meta = (byte) par1World.getBlockMetadata(par2, par3, par4);
		if(meta < 6){
			te.moves = true;
			te.rotation = 90F;
		}
		if(par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)){
			((TileBlockReflector)par1World.getBlockTileEntity(par2, par3, par4)).isPowered = true;
		}else{
			((TileBlockReflector)par1World.getBlockTileEntity(par2, par3, par4)).isPowered = false;
		}
	}
	
	public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4, Explosion par5Explosion) {
		this.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par1World.getBlockTileEntity(par2, par3, par4).getBlockMetadata());
	}

    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
    	TileBlockReflector te = (TileBlockReflector)par1World.getBlockTileEntity(par2, par3, par4);
    	System.out.println(te);
    	//te.deleteLight(par5);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		this.blockIcon = par1.registerIcon(Reference.modid + this.getUnlocalizedName().substring(5));
	}
}
