package morelights.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockAirLight extends Block{

	public BlockAirLight(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setBlockBounds(0, 0, 0, 0, 0, 0);
		this.setLightValue(0.8F);
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
	public boolean isAirBlock(World world, int x, int y, int z){
		return true;
	}
	
	
}
