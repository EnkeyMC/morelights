package morelights.tileentity;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

public class TileOverlayLamp extends TileEntity {
	
	private Icon IconBase;
	
	public void setBaseIcon(Icon icon)
	{
		this.IconBase = icon;
	}
	
	public Icon getBaseIcon()
	{
		return this.IconBase;
	}
}
