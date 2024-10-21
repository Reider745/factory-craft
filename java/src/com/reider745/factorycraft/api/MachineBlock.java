package com.reider745.factorycraft.api;

import ru.koshakmine.icstd.block.BlockRotatable;
import ru.koshakmine.icstd.type.CreativeCategory;

public abstract class MachineBlock extends BlockRotatable {

    @Override
    public abstract String getSoundType();
    @Override
    public abstract String getBlockMaterial();
    @Override
    public abstract int getToolLevel();

    public abstract String getFrontTextureName();
    public abstract String getBaseTexture();

    @Override
    public String[] getTextures() {
        return new String[]{getBaseTexture(), getBaseTexture(), getBaseTexture(), getFrontTextureName(), getBaseTexture()};
    }

    @Override
    public float getDestroyTime() {
        return 30;
    }

    @Override
    public String getName() {
        return "blocks."+getId();
    }

    @Override
    public CreativeCategory getCreativeCategory() {
        return CreativeCategory.CONSTRUCTION;
    }
}
