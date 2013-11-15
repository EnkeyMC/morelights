package morelights.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import morelights.lib.Reference;
import morelights.proxy.ClientProxy;
import morelights.tileentity.TileOverlayLamp;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockOverlayLamp extends BlockContainer{
	
	public static Icon OverIcon;

	public BlockOverlayLamp(int id, Material par2Material) {
		super(id, par2Material);
		this.setLightValue(1.0F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileOverlayLamp();
	}	
	
	@Override
    public int getRenderType()
	{
		return ClientProxy.lampRenderType;
	}
	
	@Override
    public boolean canRenderInPass(int pass)
	{
	    //Set the static var in the client proxy
	    ClientProxy.renderPass = pass;
	    //the block can render in both passes, so return true always
	    return true;
	}
	
	@Override
    public int getRenderBlockPass()
	{
        return 1;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		this.OverIcon = par1.registerIcon(Reference.modid + ":" + this.getUnlocalizedName().substring(5) + "_over");
		this.blockIcon = par1.registerIcon(Reference.modid + ":" + this.getUnlocalizedName().substring(5));
	}

	
}
