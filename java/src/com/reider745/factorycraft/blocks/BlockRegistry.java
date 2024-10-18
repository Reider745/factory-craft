package com.reider745.factorycraft.blocks;

import com.reider745.factorycraft.blocks.machine.mechanic.impl.MinerBlock;
import com.reider745.factorycraft.blocks.material.IronMachineBlock;
import com.reider745.factorycraft.blocks.material.StoneMachineBlock;
import com.reider745.factorycraft.blocks.material.WoodenMachineBlock;
import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.modloader.ObjectFactory;

public class BlockRegistry {
    private static final ObjectFactory FACTORY = Mod.getFactory();

    public static final Block WOODEN_MACHINE_BLOCk = FACTORY.addBlock(WoodenMachineBlock::new);
    public static final Block STONE_MACHINE_BLOCK = FACTORY.addBlock(StoneMachineBlock::new);
    public static final Block IRON_MACHINE_BLOCK = FACTORY.addBlock(IronMachineBlock::new);

    // Mechanic
    public static final Block MINER_BLOCK = FACTORY.addBlock(MinerBlock::new);

    public static void init(){};
}
