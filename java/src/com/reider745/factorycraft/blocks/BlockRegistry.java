package com.reider745.factorycraft.blocks;

import com.reider745.factorycraft.blocks.material.WoodenMachineBlock;
import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.modloader.ObjectFactory;

public class BlockRegistry {
    private static final ObjectFactory FACTORY = Mod.getFactory();

    public static final Block WOODEN_MACHINE_BLOCk = FACTORY.addBlock(WoodenMachineBlock::new);

    public static void init(){};
}
