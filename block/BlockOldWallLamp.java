package morelights.block;

import morelights.proxy.ClientProxy;
import morelights.tileentity.TileBlockOldWallLamp;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

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
		return -1;
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
    public int getRenderBlockPass()
	{
        return 1;
	}
	
	@Override
    public boolean canRenderInPass(int pass)
	{
	    //Set the static var in the client proxy
	    ClientProxy.renderPass = pass;
	    //the block can render in both passes, so return true always
	    return true;
	}
}
