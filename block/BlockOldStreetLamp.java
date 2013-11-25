package morelights.block;

import static net.minecraftforge.common.ForgeDirection.UP;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import morelights.MoreLights;
import morelights.lib.Pix;
import morelights.lib.Reference;
import morelights.renderers.ModelOldStreetLampRenderer;
import morelights.tileentity.TileBlockOldStreetLamp;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockOldStreetLamp extends BlockContainer {

	public BlockOldStreetLamp(int ID, Material par2Material) {
		super(ID, par2Material);
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
	
	{
		this.setBlockBounds(0.3125F, 0F, 0.3125F, 0.6875F, Pix.SIXTEEN, 0.6875F);
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	public void onBlockAdded(World world, int x, int y, int z)
	{
		world.setBlock(x, y + 1, z, MoreLights.blockStreetLampPart.blockID, 1, 2);
		world.setBlock(x, y + 2, z, MoreLights.blockStreetLampPart.blockID, 2, 2);
		world.setBlock(x, y + 3, z, MoreLights.blockStreetLampLight.blockID);

	}
	
	public void notifyBase(World world, int x, int y, int z){
		if(this.checkIfBreaked(world, x, y, z))
		{
			this.deleteLamp(world, x, y, z);
		}
	}
	//TODO drop as item in some cases
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		if(!this.canBlockStay(par1World, par2, par3, par4)){
			this.deleteLamp(par1World, par2, par3, par4);
		}
		
		if(this.checkIfBreaked(par1World, par2, par3, par4))
		{
			this.deleteLamp(par1World, par2, par3, par4);
		}
	}

	private boolean checkIfBreaked(World par1World, int par2, int par3, int par4) {
		if(par1World.getBlockId(par2, par3 + 1, par4) == 0)
			return true;
		if(par1World.getBlockId(par2, par3 + 2, par4) == 0)
			return true;
		if(par1World.getBlockId(par2, par3 + 3, par4) == 0)
			return true;
		return false;
	}

	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {		
        return (par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP))&&
        		(par1World.getBlockId(par2, par3 + 1, par4) == 0)&&
        		(par1World.getBlockId(par2, par3 + 2, par4) == 0)&&
        		(par1World.getBlockId(par2, par3 + 3, par4) == 0);
    }
	
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		return (world.isBlockSolidOnSide(x, y - 1, z, UP))&&
				(world.getBlockId(x, y + 1, z) == MoreLights.blockStreetLampPart.blockID)&&
				(world.getBlockId(x, y + 2, z) == MoreLights.blockStreetLampPart.blockID)&&
				(world.getBlockId(x, y + 3, z) == MoreLights.blockStreetLampLight.blockID);
	}
	
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
	{
		this.deleteLamp(par1World, par2, par3, par4);
	}
	
	public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4, Explosion par5Explosion)
	{
		this.onBlockDestroyedByPlayer(par1World, par2, par3, par4, 0);
	}
	
	public void deleteLamp(World par1World, int par2, int par3, int par4)
	{
		par1World.setBlockToAir(par2, par3, par4);
		par1World.setBlockToAir(par2, par3 + 1, par4);
		par1World.setBlockToAir(par2, par3 + 2, par4);
		par1World.setBlockToAir(par2, par3 + 3, par4);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		this.blockIcon = par1.registerIcon(Reference.modid + ":OldLamp");
	}

}
