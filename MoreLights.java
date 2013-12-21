package morelights;

import morelights.block.*;
import morelights.lib.Reference;
import morelights.proxy.ClientProxy;
import morelights.proxy.CommonProxy;
import morelights.tileentity.*;
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
	
	public static Block blockModernDecLamp;
	public int blockModernDecLampID;
	
	public static Block blockModernWallLamp;
	public int blockModernWallLampID;
	
	public static Block blockFluorescentLamp;
	public int blockFluorescentLampID;
	
	public static Block blockAirLight;
	public int blockAirLightID;
	
	public static Block blockReflector;
	public int blockReflectorID;
	
	//ITEMS
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		//BLOCK IDs
		blockLEDLampID = config.getBlock("LED Lamp", 700).getInt();
		blockLEDBaseID = config.getBlock("LED base", 701).getInt();
		blockOldWallLampID = config.getBlock("Old Wall Lamp", 702).getInt();
		blockOldStreetLampID = config.getBlock("Old Street Lamp", 703).getInt();
		blockStreetLampPartID = config.getBlock("Street Lamp Part", 704).getInt();
		blockStreetLampLightID = config.getBlock("Street Lamp Light", 705).getInt();
		blockModernDecLampID = config.getBlock("Modern Dec Lamp", 707).getInt();
		blockModernWallLampID = config.getBlock("Modern Wall Lamp", 708).getInt();
		blockFluorescentLampID = config.getBlock("Fluorescent Lamp", 709).getInt();
		blockAirLightID = config.getBlock("Air Light", 710).getInt();
		blockReflectorID = config.getBlock("Reflector", 711).getInt();
		
		//ITEM IDs
		
		config.save();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		
		//CREATING BLOCKS
		blockLEDLamp = new BlockOverlayLamp(blockLEDLampID, Material.portal)
			.setUnlocalizedName("LEDLamp")
			.setCreativeTab(CreativeTabs.tabDecorations)
			.setHardness(0.4F)
			.setResistance(1.5F)
			.setStepSound(Block.soundStoneFootstep);
		
		blockLEDBase = new BlockLamp(blockLEDBaseID, Material.portal)
			.setUnlocalizedName("LEDBase");
		
		blockOldWallLamp = new BlockOldWallLamp(blockOldWallLampID, Material.coral)
			.setUnlocalizedName("OldWallLamp")
			.setCreativeTab(CreativeTabs.tabDecorations)
			.setHardness(0.4F)
			.setResistance(1.5F)
			.setStepSound(Block.soundMetalFootstep);
		
		blockOldStreetLamp = new BlockOldStreetLamp(blockOldStreetLampID, Material.portal)
			.setUnlocalizedName("OldStreetLamp")
			.setCreativeTab(CreativeTabs.tabDecorations)
			.setHardness(0.5F)
			.setResistance(1.8F)
			.setStepSound(Block.soundMetalFootstep);
		
		blockStreetLampPart = new BlockStreetLampPart(blockStreetLampPartID, Material.portal)
			.setUnlocalizedName("StreetLampPart")
			.setHardness(0.5F)
			.setResistance(1.8F)
			.setStepSound(Block.soundMetalFootstep);
		
		blockStreetLampLight = new BlockStreetLampLight(blockStreetLampLightID, Material.portal)
			.setUnlocalizedName("StreetLampLight")
			.setHardness(0.5F)
			.setResistance(1.8F)
			.setStepSound(Block.soundMetalFootstep);
		
		blockModernDecLamp = new BlockModernDecLamp(blockModernDecLampID, Material.coral)
			.setUnlocalizedName("ModernDecLamp")
			.setCreativeTab(CreativeTabs.tabDecorations)
			.setHardness(0.4F)
			.setResistance(0.4F)
			.setStepSound(Block.soundMetalFootstep);
		
		blockModernWallLamp = new BlockModernWallLamp(blockModernWallLampID, Material.coral)
			.setUnlocalizedName("ModernWallLamp")
			.setCreativeTab(CreativeTabs.tabDecorations)
			.setHardness(0.4F)
			.setResistance(0.4F)
			.setStepSound(Block.soundMetalFootstep);
		
		blockFluorescentLamp = new BlockFluorescentLamp(blockFluorescentLampID, Material.coral)
			.setUnlocalizedName("FluorescentLamp")
			.setCreativeTab(CreativeTabs.tabDecorations)
			.setHardness(0.4F)
			.setResistance(0.4F)
			.setStepSound(Block.soundMetalFootstep);
		
		blockAirLight = new BlockAirLight(blockAirLightID, Material.air)
			.setUnlocalizedName("AirLight")
			.setCreativeTab(CreativeTabs.tabDecorations);
		
		blockReflector = new BlockReflector(blockReflectorID, Material.coral)
			.setUnlocalizedName("Reflector")
			.setCreativeTab(CreativeTabs.tabDecorations)
			.setHardness(0.4F)
			.setResistance(0.4F)
			.setStepSound(Block.soundMetalFootstep);
		
		//CREATING ITEMS
		
		//SHAPELESS CRAFTING RECIPES
		
		//SHAPED CRAFTING RECIPES
			
			//LED Lamp
			GameRegistry.addShapedRecipe(new ItemStack(blockLEDLamp), new Object[]{
				"SGS",
				"GSG",
				"SGS",
				'S', Block.stone,
				'G', Item.glowstone
			});
			
			//Old Wall Lamp
			GameRegistry.addShapedRecipe(new ItemStack(blockOldWallLamp), new Object[]{
				" S ",
				"PTP",
				" S ",
				'S', Block.stone,
				'T', Block.torchWood,
				'P', Block.thinGlass
			});
			
			//Old Street Lamp
			GameRegistry.addShapedRecipe(new ItemStack(blockOldStreetLamp), new Object[]{
				" L ",
				" S ",
				" S ",
				'L', blockOldWallLamp,
				'S', Block.stone
			});
			
			//Modern Decorative Lamp
			GameRegistry.addShapedRecipe(new ItemStack(blockModernDecLamp, 4, 0), new Object[]{
				" W ",
				"GSG",
				" I ",
				'W', new ItemStack(Block.carpet, 1, 4),
				'G', Block.glass,
				'S', Block.glowStone,
				'I', Item.ingotIron
			});
		
		//SMELTING RECIPES
		
		//GAME REGISTERY
		
			//BLOCKS
				GameRegistry.registerBlock(blockLEDLamp, "LEDLamp");
				GameRegistry.registerBlock(blockOldWallLamp, "OldWallLamp");
				GameRegistry.registerBlock(blockOldStreetLamp, "OldStreetLamp");
				GameRegistry.registerBlock(blockModernDecLamp, "ModernDecLamp");
				GameRegistry.registerBlock(blockModernWallLamp, "ModernWallLamp");
				GameRegistry.registerBlock(blockFluorescentLamp, "FluorescentLamp");
				GameRegistry.registerBlock(blockAirLight, "AirLight");
				GameRegistry.registerBlock(blockReflector, "Reflector");
				
			//TILE ENTITIES
				GameRegistry.registerTileEntity(TileOverlayLamp.class, "OverlayLamp");
				GameRegistry.registerTileEntity(TileBlockOldWallLamp.class, "OldWallLamp");
				GameRegistry.registerTileEntity(TileBlockOldStreetLamp.class, "OldStreetLamp");
				GameRegistry.registerTileEntity(TileBlockReflector.class, "Reflector");
						
		//LANGUAGE REGISTRY
			LanguageRegistry.addName(blockLEDLamp, "LED Lamp");
			LanguageRegistry.addName(blockOldWallLamp, "Old Wall Lamp");
			LanguageRegistry.addName(blockOldStreetLamp, "Old Street Lamp");
			LanguageRegistry.addName(blockModernDecLamp, "Modern Decorative Lamp");
			LanguageRegistry.addName(blockModernWallLamp, "Modern Decorative Wall Lamp");
			LanguageRegistry.addName(blockFluorescentLamp, "Fluorescent Lamp");
			LanguageRegistry.addName(blockReflector, "Reflector");
			
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event){
		proxy.registerRenderers();
	}

}
