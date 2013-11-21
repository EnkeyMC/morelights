package morelights;

import morelights.block.BlockLamp;
import morelights.block.BlockOldStreetLamp;
import morelights.block.BlockOldWallLamp;
import morelights.block.BlockOverlayLamp;
import morelights.block.BlockStreetLampLight;
import morelights.block.BlockStreetLampPart;
import morelights.lib.Reference;
import morelights.proxy.ClientProxy;
import morelights.proxy.CommonProxy;
import morelights.tileentity.TileBlockOldStreetLamp;
import morelights.tileentity.TileBlockOldWallLamp;
import morelights.tileentity.TileOverlayLamp;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.modid, name = Reference.name, version = Reference.version)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class MoreLights {
	
	@Instance(value = Reference.modid)
	public static MoreLights instance;
	
	@SidedProxy(clientSide = "morelights.proxy.ClientProxy", serverSide = "morelights.proxy.CommonProxy")
    public static CommonProxy proxy;
	
	//BLOCKS
	public static Block blockLEDLamp;
	public int blockLEDLampID;
	
	public static Block blockLEDBase;
	public int blockLEDBaseID;
	
	public static Block blockOldWallLamp;
	public int blockOldWallLampID;
	
	public static Block blockOldStreetLamp;
	public int blockOldStreetLampID;
	
	public static Block blockStreetLampPart;
	public int blockStreetLampPartID;
	
	public static Block blockStreetLampLight;
	public int blockStreetLampLightID;
	
	//ITEMS
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		//BLOCK IDs
		blockLEDLampID = config.getBlock("blockLEDLamp", 700).getInt();
		blockLEDBaseID = config.getBlock("blockLEDbase", 701).getInt();
		blockOldWallLampID = config.getBlock("blockOldeWallLamp", 702).getInt();
		blockOldStreetLampID = config.getBlock("blockOldStreetLamp", 703).getInt();
		blockStreetLampPartID = config.getBlock("blockStreetLampPartID", 704).getInt();
		blockStreetLampLightID = config.getBlock("blockStreetLampLight", 705).getInt();
		
		//ITEM IDs
		
		config.save();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		
		//CREATING BLOCKS
		blockLEDLamp = new BlockOverlayLamp(blockLEDLampID, Material.portal)
			.setUnlocalizedName("LEDLamp")
			.setCreativeTab(CreativeTabs.tabDecorations)
			.setHardness(1.0F)
			.setResistance(1.5F)
			.setStepSound(Block.soundStoneFootstep);
		
		blockLEDBase = new BlockLamp(blockLEDBaseID, Material.portal)
			.setUnlocalizedName("LEDBase");
		
		blockOldWallLamp = new BlockOldWallLamp(blockOldWallLampID, Material.glass)
			.setUnlocalizedName("OldWallLamp")
			.setCreativeTab(CreativeTabs.tabDecorations)
			.setHardness(0.8F)
			.setResistance(1.5F)
			.setStepSound(Block.soundMetalFootstep);
		
		blockOldStreetLamp = new BlockOldStreetLamp(blockOldStreetLampID, Material.portal)
			.setUnlocalizedName("OldStreetLamp")
			.setCreativeTab(CreativeTabs.tabDecorations)
			.setHardness(1F)
			.setResistance(1.8F)
			.setStepSound(Block.soundMetalFootstep);
		
		blockStreetLampPart = new BlockStreetLampPart(blockStreetLampPartID, Material.portal)
			.setUnlocalizedName("StreetLampPart")
			.setHardness(1F)
			.setResistance(1.8F)
			.setStepSound(Block.soundMetalFootstep);
		
		blockStreetLampLight = new BlockStreetLampLight(blockStreetLampLightID, Material.portal)
			.setUnlocalizedName("StreetLampLight")
			.setHardness(1F)
			.setResistance(1.8F)
			.setStepSound(Block.soundMetalFootstep);
		
		//CREATING ITEMS
		
		//SHAPELESS CRAFTING RECIPES
		
		//SHAPED CRAFTING RECIPES
		
			GameRegistry.addShapedRecipe(new ItemStack(blockLEDLamp), new Object[]{
				"SGS",
				"GSG",
				"SGS",
				'S', Block.stone,
				'G', Item.glowstone
			});
			
			GameRegistry.addShapedRecipe(new ItemStack(blockOldWallLamp), new Object[]{
				" S ",
				"PTP",
				" S ",
				'S', Block.stone,
				'T', Block.torchWood,
				'P', Block.thinGlass
			});
		
		//SMELTING RECIPES
		
		//GAME REGISTERY
		
			//BLOCKS
				GameRegistry.registerBlock(blockLEDLamp);
				GameRegistry.registerBlock(blockOldWallLamp);
				GameRegistry.registerBlock(blockOldStreetLamp);
				
			//TILE ENTITIES
				GameRegistry.registerTileEntity(TileOverlayLamp.class, "OverlayLamp");
				GameRegistry.registerTileEntity(TileBlockOldWallLamp.class, "OldWallLamp");
				GameRegistry.registerTileEntity(TileBlockOldStreetLamp.class, "OldStreetLamp");
				
		//LANGUAGE REGISTRY
			LanguageRegistry.addName(blockLEDLamp, "LED Lamp");
			LanguageRegistry.addName(blockOldWallLamp, "Old Wall Lamp");
			LanguageRegistry.addName(blockOldStreetLamp, "Old Street Lamp");
			
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event){
		proxy.registerRenderers();
		ClientProxy.setCustomRenderers();
	}

}
