package inksoul;

import net.fabricmc.api.ModInitializer;

import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static List<Item> iiitem = new Vector<Item>(Registrys.times);
	public static List<Block> iiblock = new Vector<Block>(Registrys.times);

	@Override
	public void onInitialize() {
		for (var i = 1; i < 23; i++) {
			var o = new Block(FabricBlockSettings.of(Material.METAL, MapColor.WHITE));
			iiblock.add(Registry.register(Registry.BLOCK, new Identifier("inksoul", "ct_machine" + Integer.toString(i)),
					o));
			iiitem.add(Registry.register(Registry.ITEM, new Identifier("inksoul", "ct_machine" + Integer.toString(i)),
					new BlockItem(o, new FabricItemSettings().group(ItemGroup.MISC))));
		}

	}
}
