package com.reider745.factorycraft.blocks.machine.mechanic.impl;

import com.reider745.factorycraft.FactoryCraft;
import com.reider745.factorycraft.blocks.machine.mechanic.MechanicBaseBlock;
import ru.koshakmine.icstd.block.blockentity.BlockEntity;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.common.Position;
import ru.koshakmine.icstd.ui.IWindow;
import ru.koshakmine.icstd.ui.Window;

public class MinerBlock extends MechanicBaseBlock {
    private static final IWindow window = Window.loadWindow(FactoryCraft.WINDOWS + "miner.json");

    @Override
    public IWindow getWindow() {
        return window;
    }

    @Override
    public BlockEntity createBlockEntity(Position position, Level level) {
        return new MinerBlockEntity(getBlockEntityType(), getBlockEntityType(), getNumId(), position, level);
    }

    @Override
    public String getFrontTextureName() {
        return "block_mechanic_quarry";
    }

    @Override
    public String getId() {
        return "block_mechanic_quarry";
    }
}
