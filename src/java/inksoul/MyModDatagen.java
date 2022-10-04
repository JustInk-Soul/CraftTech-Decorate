package inksoul;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class MyModDatagen implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		fabricDataGenerator.addProvider(MyModelGenerator::new);
		fabricDataGenerator.addProvider(EnglishLanguageGenerator::new);
		fabricDataGenerator.addProvider(ChineseLanguageGenerator::new);
	}

	private static class MyModelGenerator extends FabricModelProvider {
		public MyModelGenerator(FabricDataGenerator dataGenerator) {
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

	private static class EnglishLanguageGenerator extends FabricLanguageProvider {
		private EnglishLanguageGenerator(FabricDataGenerator dataGenerator) {
			// Specifying en_us is optional, by default is is en_us.
			super(dataGenerator, "en_us");
		}

		@Override
		public void generateTranslations(TranslationBuilder translationBuilder) {
			for (var i : ExampleMod.iiitem) {
				translationBuilder.add(i, "Machine Block");
			}
			translationBuilder.add("tooltip.inksoul.ct_machine", "Just a fake machine.");
		}
	}

	private static class ChineseLanguageGenerator extends FabricLanguageProvider {
		private ChineseLanguageGenerator(FabricDataGenerator dataGenerator) {
			// Specifying en_us is optional, by default is is en_us.
			super(dataGenerator, "zh_cn");
		}

		@Override
		public void generateTranslations(TranslationBuilder translationBuilder) {
			for (var i : ExampleMod.iiitem) {
				translationBuilder.add(i, "机器方块");
			}
			translationBuilder.add("tooltip.inksoul.ct_machine", "只是一台假的机器而已");
		}
	}
}