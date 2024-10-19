package com.reider745.factorycraft.blocks.material;

import com.reider745.factorycraft.blocks.BlockRegistry;
import com.reider745.factorycraft.items.ItemRegistry;
import ru.koshakmine.icstd.block.Block;
import ru.koshakmine.icstd.item.ItemGroup;
import ru.koshakmine.icstd.recipes.workbench.ItemCraft;
import ru.koshakmine.icstd.recipes.workbench.PatternData;
import ru.koshakmine.icstd.recipes.workbench.ShapedRecipe;
import ru.koshakmine.icstd.recipes.workbench.WorkbenchRecipeBase;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.ItemID;
import ru.koshakmine.icstd.type.block.SoundType;
import ru.koshakmine.icstd.type.tools.BlockMaterials;
import ru.koshakmine.icstd.type.tools.ToolLevel;

public class IronMachineBlock extends Block {
    public static final String ID = "block_machine_iron";
    private static final WorkbenchRecipeBase RECIPE = FACTORY.add(new ShapedRecipe(new ItemCraft(ID, 0))
            .setPattern(new String[]{
                    "xax",
                    "dbd",
                    "xax"
            }, new PatternData[]{
                    new PatternData('a', ItemRegistry.GOLD_GEAR.getNumId()),
                    new PatternData('d', ItemRegistry.BATTERY.getNumId()),
                    new PatternData('b', BlockRegistry.STONE_MACHINE_BLOCK.getNumId()),
                    new PatternData('x', ItemID.IRON_INGOT)
            }));

    @Override
    public String getSoundType() {
        return SoundType.METAL;
    }

    @Override
    public int getToolLevel() {
        return ToolLevel.IRON;
    }

    @Override
    public String getBlockMaterial() {
        return BlockMaterials.STONE;
    }

    @Override
    public float getDestroyTime() {
        return 40;
    }

    @Override
    public String[] getTextures() {
        return new String[]{ID};
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getName() {
        return "blocks."+ID;
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
