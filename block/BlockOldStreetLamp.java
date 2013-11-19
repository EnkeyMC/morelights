package morelights.block;

import static net.minecraftforge.common.ForgeDirection.UP;
import morelights.renderers.ModelOldStreetLampRenderer;
import morelights.tileentity.TileBlockOldStreetLamp;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockOldStreetLamp extends BlockContainer {

	public BlockOldStreetLamp(int ID, Material par2Material) {
		super(ID, par2Material);
		this.setLightValue(1.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileBlockOldStreetLamp();
	}
	
	@Override
	public int getRenderType(){
		return ModelOldStreetLampRenderer.renderID;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		if(!this.canPlaceBlockAt(par1World, par2, par3, par4)){
			this.dropBlockAsItem(par1World, par2, par3, par4, 0, 0);
			par1World.setBlockToAir(par2, par3, par4);
		}
	}
	
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP);
    }

}
