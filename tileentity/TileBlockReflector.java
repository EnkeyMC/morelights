package morelights.tileentity;

import morelights.MoreLights;
import morelights.block.BlockReflector;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class TileBlockReflector extends TileEntity {
	public boolean moves = false;
	public float rotation = 0F;
	public int lenght = -1;
	public boolean isPowered;
	
	public void updateEntity() {
		int meta = this.getBlockMetadata();
		if((this.isPowered)&&(!this.moves)){	
			this.lenght = this.lightUp(meta);
			System.out.println(lenght);
		}else{
			this.deleteLight(meta);
		}
	}
	
	private void deleteLight(int meta){
		int id;
		switch(meta){
		case 2:
			for(int i = 1; i <= this.lenght; i++){
				id = this.getWorldObj().getBlockId(this.xCoord - i, this.yCoord, this.zCoord);
				if(id == MoreLights.blockAirLight.blockID){
					this.getWorldObj().setBlockToAir(this.xCoord - i, this.yCoord, this.zCoord);
				}
			}
			break;
		case 3:
			for(int i = 1; i <= this.lenght; i++){
				id = this.getWorldObj().getBlockId(this.xCoord + i, this.yCoord, this.zCoord);
				if(id == MoreLights.blockAirLight.blockID){
					this.getWorldObj().setBlockToAir(this.xCoord + i, this.yCoord, this.zCoord);
				}
			}
			break;
		case 4:
			for(int i = 1; i <= this.lenght; i++){
				id = this.getWorldObj().getBlockId(this.xCoord, this.yCoord, this.zCoord - i);
				if(id == MoreLights.blockAirLight.blockID){
					this.getWorldObj().setBlockToAir(this.xCoord, this.yCoord, this.zCoord - i);
				}
			}
			break;
		case 5:
			for(int i = 1; i <= this.lenght; i++){
				id = this.getWorldObj().getBlockId(this.xCoord, this.yCoord, this.zCoord + i);
				if(id == MoreLights.blockAirLight.blockID){
					this.getWorldObj().setBlockToAir(this.xCoord, this.yCoord, this.zCoord + i);
				}
			}
			break;
		case 6:
		case 7:
			for(int i = 1; i <= this.lenght; i++){
				id = this.getWorldObj().getBlockId(this.xCoord, this.yCoord + i, this.zCoord);
				if(id == MoreLights.blockAirLight.blockID){
					this.getWorldObj().setBlockToAir(this.xCoord, this.yCoord + i, this.zCoord);
				}
			}
			break;
		}
	}
	
	private int lightUp(int meta){
		int l = 0;
		int id;
		boolean stop = false;
		switch(meta){
		case 2:
			for(int i = 1; i <= MoreLights.reflectorLength; i++){
				id = this.getWorldObj().getBlockId(this.xCoord - i, this.yCoord, this.zCoord);
				if(stop){
					if(id == MoreLights.blockAirLight.blockID){
						this.getWorldObj().setBlockToAir(this.xCoord - i, this.yCoord, this.zCoord);
					}
				}else{
					if(id != MoreLights.blockAirLight.blockID){
						if(id != 0){
							if(Block.blocksList[id].isOpaqueCube()){
								stop = true;
							}
						}else{
							this.getWorldObj().setBlock(this.xCoord - i, this.yCoord, this.zCoord, MoreLights.blockAirLight.blockID);
							l++;
						}
					}else{
						l++;
					}
				}
			}
			break;
		case 3:
			for(int i = 1; i <= MoreLights.reflectorLength; i++){
				id = this.getWorldObj().getBlockId(this.xCoord + i, this.yCoord, this.zCoord);
				if(stop){
					if(id == MoreLights.blockAirLight.blockID){
						this.getWorldObj().setBlockToAir(this.xCoord + i, this.yCoord, this.zCoord);
					}
				}else{
					if(id != MoreLights.blockAirLight.blockID){
						if(id != 0){
							if(Block.blocksList[id].isOpaqueCube()){
								stop = true;
							}
						}else{
							this.getWorldObj().setBlock(this.xCoord + i, this.yCoord, this.zCoord, MoreLights.blockAirLight.blockID);
							l++;
						}
					}else{
						l++;
					}
				}
			}
			break;
		case 4:
			for(int i = 1; i <= MoreLights.reflectorLength; i++){
				id = this.getWorldObj().getBlockId(this.xCoord, this.yCoord, this.zCoord - i);
				if(stop){
					if(id == MoreLights.blockAirLight.blockID){
						this.getWorldObj().setBlockToAir(this.xCoord, this.yCoord, this.zCoord - i);
					}
				}else{
					if(id != MoreLights.blockAirLight.blockID){
						if(id != 0){
							if(Block.blocksList[id].isOpaqueCube()){
								stop = true;
							}
						}else{
							this.getWorldObj().setBlock(this.xCoord, this.yCoord, this.zCoord - i, MoreLights.blockAirLight.blockID);
							l++;
						}
					}else{
						l++;
					}
				}
			}
			break;
		case 5:
			for(int i = 1; i <= MoreLights.reflectorLength; i++){
				id = this.getWorldObj().getBlockId(this.xCoord, this.yCoord, this.zCoord + i);
				if(stop){
					if(id == MoreLights.blockAirLight.blockID){
						this.getWorldObj().setBlockToAir(this.xCoord, this.yCoord, this.zCoord + i);
					}
				}else{
					if(id != MoreLights.blockAirLight.blockID){
						if(id != 0){
							if(Block.blocksList[id].isOpaqueCube()){
								stop = true;
							}
						}else{
							this.getWorldObj().setBlock(this.xCoord, this.yCoord, this.zCoord + i, MoreLights.blockAirLight.blockID);
							l++;
						}
					}else{
						l++;
					}
				}
			}
			break;
		case 6:
		case 7:
			for(int i = 1; i <= MoreLights.reflectorLength; i++){
				id = this.getWorldObj().getBlockId(this.xCoord, this.yCoord + i, this.zCoord);
				if(stop){
					if(id == MoreLights.blockAirLight.blockID){
						this.getWorldObj().setBlockToAir(this.xCoord, this.yCoord + i, this.zCoord);
					}
				}else{
					if(id != MoreLights.blockAirLight.blockID){
						if(id != 0){
							if(Block.blocksList[id].isOpaqueCube()){
								stop = true;
							}
						}else{
							this.getWorldObj().setBlock(this.xCoord, this.yCoord + i, this.zCoord, MoreLights.blockAirLight.blockID);
							l++;
						}
					}else{
						l++;
					}
				}
			}
			break;
		default:
		}
		return l;
	}
}
