package com.reider745.factorycraft.items.material;

import ru.koshakmine.icstd.item.Item;
import ru.koshakmine.icstd.recipes.workbench.ItemCraft;
import ru.koshakmine.icstd.recipes.workbench.PatternData;
import ru.koshakmine.icstd.recipes.workbench.ShapedRecipe;
import ru.koshakmine.icstd.recipes.workbench.WorkbenchRecipeBase;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.ItemID;
import ru.koshakmine.icstd.type.common.Texture;

public class GearWoodItem extends Item {
    public static final String ID = "gear_wood";
    private static final WorkbenchRecipeBase RECIPE = FACTORY.add(new ShapedRecipe(new ItemCraft(ID, 0))
            .setPattern(new String[]{
                    "#a#",
                    "a#a",
                    "#a#"
            }, new PatternData[]{
                    new PatternData('a', ItemID.STICK)
            }));

    @Override
    public Texture getTexture() {
        return new Texture("gear_wood");
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getName() {
        return "items.gear_wood";
    }

    @Override
    public CreativeCategory getCreativeCategory() {
        return CreativeCategory.TOOLS;
    }
}
