package morelights.block;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import morelights.lib.Reference;
import morelights.renderers.ModelOldWallLampRenderer;
import morelights.tileentity.TileBlockOldWallLamp;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockOldWallLamp extends BlockContainer{
	

	public BlockOldWallLamp(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setLightValue(1.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileBlockOldWallLamp();
	}
	
	@Override
	public int getRenderType(){
		return ModelOldWallLampRenderer.renderID;
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
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		if(!this.canPlaceBlockAt(par1World, par2, par3, par4)){
			this.dropBlockAsItem(par1World, par2, par3, par4, 0, 0);
			par1World.setBlockToAir(par2, par3, par4);
		}
	}
	
	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST ) ||
               par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST ) ||
               par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH) ||
               par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH);
    }
	
	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        return this.canPlaceBlockAt(par1World, par2, par3, par4);
    }
	
	@Override
	public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5)
    {
        ForgeDirection dir = ForgeDirection.getOrientation(par5);
        return (dir == NORTH && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH)) ||
               (dir == SOUTH && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH)) ||
               (dir == WEST  && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST )) ||
               (dir == EAST  && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST ));
    }
	
	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        if (par5 == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (par5 == 5)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (par5 == 4)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (par5 == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }
        return par1World.getBlockMetadata(par2, par3, par4);
    }
	
	private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            byte b0 = 3;

            if (par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH))
            {
                b0 = 3;
            }

            if (par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH))
            {
                b0 = 2;
            }

            if (par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST ))
            {
                b0 = 5;
            }

            if (par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST ))
            {
                b0 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
        }
    }
	
	 @Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	    {
	        {
	            byte meta = (byte)par1IBlockAccess.getBlockMetadata(par2, par3, par4);

	            switch (meta)
	            {
	                case 2:
	                	this.setBlockBounds(0.3125F, 0.0625F, 0.3125F, 0.6875F, 0.9375F, 1F);
	                	break;
	                case 3:
	                	this.setBlockBounds(0.3125F, 0.0625F, 0.0F, 0.6875F, 0.9375F, 0.6875F);
	                    break;
	                case 4:
	                	this.setBlockBounds(0F, 0.0625F, 0.3125F, 0.6875F, 0.9375F, 0.6875F);
	                	break;
	                case 5:
	                	this.setBlockBounds(0.3125F, 0.0625F, 0.3125F, 1F, 0.9375F, 0.6875F);
	                	break;
	                default:
	                	System.out.println("Bad metadata of BlockOldWallLamp!" + meta);
	            }
	        }
	    }
	 
	 	@Override
		public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
	    {
	        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
	        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
	    }
	 	
	 	@Override
		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister par1){
			this.blockIcon = par1.registerIcon(Reference.modid + ":OldLamp");
		}
}
