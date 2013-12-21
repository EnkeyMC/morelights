package morelights.block;

import morelights.lib.Reference;
import morelights.renderers.ModelReflectorRenderer;
import morelights.tileentity.TileBlockReflector;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		this.blockIcon = par1.registerIcon(Reference.modid + this.getUnlocalizedName().substring(5));
	}
}
