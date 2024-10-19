package com.reider745.factorycraft.blocks.material;

import com.reider745.factorycraft.items.ItemRegistry;
import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.item.ItemGroup;
import ru.koshakmine.icstd.recipes.workbench.*;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.ItemID;
import ru.koshakmine.icstd.type.block.BlockID;
import ru.koshakmine.icstd.type.block.SoundType;
import ru.koshakmine.icstd.type.tools.BlockMaterials;
import ru.koshakmine.icstd.type.tools.ToolLevel;

public class WoodenMachineBlock extends Block {
    public static final String ID = "block_machine_wooden";
    private static final WorkbenchRecipeBase RECIPE = FACTORY.add(new ShapedRecipe(new ItemCraft(ID, 0))
            .setPattern(new String[]{
                    "xax",
                    "ici",
                    "xax"
            }, new PatternData[]{
                    new PatternData('a', ItemRegistry.WOODEN_GEAR.getNumId()),
                    new PatternData('i', ItemRegistry.STONE_GEAR.getNumId()),
                    new PatternData('c', ItemID.DIAMOND),
                    new PatternData('x', BlockID.PLANKS)
            }));

    @Override
    public String getSoundType() {
        return SoundType.WOOD;
    }

    @Override
    public int getToolLevel() {
        return ToolLevel.STONE;
    }

    @Override
    public String getBlockMaterial() {
        return BlockMaterials.WOOD;
    }

    @Override
    public float getDestroyTime() {
        return 40;
    }

    @Override
    public String[] getTextures() {
        return new String[]{getId()};
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getName() {
        return "blocks."+getId();
    }

    @Override
    public CreativeCategory getCreativeCategory() {
        return CreativeCategory.CONSTRUCTION;
    }

    @Override
    public ItemGroup getCreativeItemGroup() {
        return ItemRegistry.MATERIAL;
    }
}
