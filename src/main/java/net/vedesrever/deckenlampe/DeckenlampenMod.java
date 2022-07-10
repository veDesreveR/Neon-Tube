package net.vedesrever.deckenlampe;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;
import net.vedesrever.deckenlampe.blocks.NeonTube;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeckenlampenMod implements ModInitializer {
  public static final String MOD_ID = "deckenlampe";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  //Blocks
  public static final NeonTube NEON_TUBE = new NeonTube();

  //Items

  @Override
  public void onInitialize() {
    LOGGER.info("Adding blocks and items");

    //Register Blocks
    NEON_TUBE.register("neon_tube");

    //Register Items
    NEON_TUBE.registerBlockItem("neon_tube", ItemGroup.DECORATIONS);
  }
}