package net.vedesrever.deckenlampe.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.vedesrever.deckenlampe.DeckenlampenMod;

public interface IRegisterableBlock {

  default void register(String name) {
    Registry.register(Registry.BLOCK, new Identifier(DeckenlampenMod.MOD_ID, name), (Block) this);
  }

  default void registerBlockItem(String name, ItemGroup group) {
    Registry.register(Registry.ITEM, new Identifier(DeckenlampenMod.MOD_ID, name), new BlockItem((Block) this, new FabricItemSettings().group(group))
    );
  }
}
