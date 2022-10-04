package inksoul;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class MyModDatagen implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		fabricDataGenerator.addProvider(MyTagGenerator::new);
	}

	private static class MyTagGenerator extends FabricModelProvider {
		public MyTagGenerator(FabricDataGenerator dataGenerator) {
			super(dataGenerator);
		}

		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
			for (var i : ExampleMod.iiblock) {
				blockStateModelGenerator.registerSimpleCubeAll(i);
			}
		};

		public void generateItemModels(ItemModelGenerator itemModelGenerator) {
			for (var i : ExampleMod.iiitem) {
				itemModelGenerator.register(i, Models.GENERATED);
			}
		};
	}
}