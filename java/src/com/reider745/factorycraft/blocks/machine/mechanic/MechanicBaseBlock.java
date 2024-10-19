package com.reider745.factorycraft.blocks.machine.mechanic;

import com.reider745.factorycraft.api.MachineBlock;
import com.reider745.factorycraft.items.ItemRegistry;
import com.zhekasmirnov.apparatus.multiplayer.util.entity.NetworkEntity;
import org.json.JSONException;
import org.json.JSONObject;
import ru.koshakmine.icstd.block.IBlockEntityHolder;
import ru.koshakmine.icstd.block.ILocalBlockEntityHolder;
import ru.koshakmine.icstd.block.blockentity.LocalBlockEntity;
import ru.koshakmine.icstd.item.ItemGroup;
import ru.koshakmine.icstd.type.block.SoundType;
import ru.koshakmine.icstd.type.common.Position;
import ru.koshakmine.icstd.type.tools.BlockMaterials;
import ru.koshakmine.icstd.type.tools.ToolLevel;
import ru.koshakmine.icstd.ui.IWindow;

public abstract class MechanicBaseBlock extends MachineBlock implements IBlockEntityHolder, ILocalBlockEntityHolder {
    public abstract IWindow getWindow();

    @Override
    public String getSoundType() {
        return SoundType.WOOD;
    }

    @Override
    public int getToolLevel() {
        return ToolLevel.WOOD;
    }

    @Override
    public String getBlockMaterial() {
        return BlockMaterials.WOOD;
    }

    @Override
    public String getBaseTexture() {
        return "block_machine_wooden";
    }

    @Override
    public LocalBlockEntity createLocalBlockEntity(Position position, NetworkEntity networkEntity, JSONObject jsonObject) throws JSONException {
        return new MechanicLocalBlockEntity(getBlockEntityType(), getNumId(), position, networkEntity, jsonObject, getWindow());
    }

    @Override
    public ItemGroup getCreativeItemGroup() {
        return ItemRegistry.MECHANIC;
    }
}
