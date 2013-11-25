package morelights.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileBlockOldWallLamp extends TileEntity {
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
	{
		return AxisAlignedBB.getAABBPool().getAABB(this.xCoord,this.yCoord,this.zCoord,this.xCoord + 1,this.yCoord + 1,this.zCoord + 1);
	}
}
