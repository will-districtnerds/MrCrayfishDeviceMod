package com.mrcrayfish.device.init;

import com.mrcrayfish.device.Reference;
import com.mrcrayfish.device.block.BlockLaptop;

import com.mrcrayfish.device.block.BlockPrinter;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DeviceBlocks 
{
	public static Block laptop;
	public static Block printer;
	
	public static void init()
	{
		laptop = new BlockLaptop().setUnlocalizedName("laptop").setRegistryName("laptop");
		printer = new BlockPrinter().setUnlocalizedName("printer").setRegistryName("printer");
	}
	
	public static void register()
	{
		registerBlock(laptop);
		registerBlock(printer);
	}
	
	public static void registerBlock(Block block)
	{
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	public static void registerRenders() 
	{
		registerRender(laptop);
		registerRender(printer);
	}
	
	private static void registerRender(Block blockIn)
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockIn), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + blockIn.getUnlocalizedName().substring(5), "inventory"));
	}
}