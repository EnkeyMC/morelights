package morelights;

import morelights.block.BlockLamp;
import morelights.block.BlockOverlayLamp;
import morelights.lib.Reference;
import morelights.proxy.ClientProxy;
import morelights.proxy.CommonProxy;
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
	
	//ITEMS
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		blockLEDLampID = config.getBlock("blockLEDLamp", 700).getInt();
		blockLEDBaseID = config.getBlock("blockLEDbase", 701).getInt();
		
		config.save();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		
		//CREATING BLOCKS
		blockLEDLamp = new BlockOverlayLamp(blockLEDLampID, Material.ground)
			.setUnlocalizedName("LEDLamp")
			.setCreativeTab(CreativeTabs.tabDecorations)
			.setHardness(1.0F)
			.setResistance(1.5F)
			.setStepSound(Block.soundStoneFootstep);
		
		blockLEDBase = new BlockLamp(blockLEDBaseID, Material.ground)
			.setUnlocalizedName("LEDBase");
		
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
		
		//SMELTING RECIPES
		
		//GAME REGISTERY
		
			//BLOCKS
				GameRegistry.registerBlock(blockLEDLamp);
				
			//TILE ENTITIES
				
		//LANGUAGE REGISTRY
			LanguageRegistry.addName(blockLEDLamp, "LED Lamp");
			
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event){
		proxy.registerRenderers();
		ClientProxy.setCustomRenderers();
	}

}
