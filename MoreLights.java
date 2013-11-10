package morelights;

import morelights.lib.Reference;
import morelights.proxy.CommonProxy;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Reference.modid, name = Reference.name, version = Reference.version)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class MoreLights {
	
	@Instance(value = Reference.modid)
	public static MoreLights instance;
	
	@SidedProxy(clientSide = "morelights.proxy.ClientProxy", serverSide = "morelights.proxy.CommonProxy")
    public static CommonProxy proxy;
	
	//BLOCKS
	
	//ITEMS
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		config.save();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		
		//CREATING BLOCKS
		
		//CREATING ITEMS
		
		//SHAPELESS CRAFTING RECIPES
		
		//SHAPED CRAFTING RECIPES
		
		//SMELTING RECIPES
		
		//GAME REGISTERY
		
			//BLOCKS
				
			//TILE ENTITIES
				
		//LANGUAGE REGISTRY
			
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event){
		proxy.registerRenderers();
	}

}
