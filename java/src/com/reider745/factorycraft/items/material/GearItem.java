package com.reider745.factorycraft.items.material;

import ru.koshakmine.icstd.item.Item;
import ru.koshakmine.icstd.recipes.workbench.ItemCraft;
import ru.koshakmine.icstd.recipes.workbench.PatternData;
import ru.koshakmine.icstd.recipes.workbench.ShapedRecipe;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.common.Texture;

public class GearItem extends Item {
    private final String gear_id;
    private final String[] pattern;
    private final PatternData[] datas;

    public GearItem(String id, String[] pattern, PatternData[] datas){
        this.gear_id = id;
        this.pattern = pattern;
        this.datas = datas;
    }

    @Override
    public void onInit() {
        super.onInit();
        FACTORY.add(new ShapedRecipe(new ItemCraft(gear_id, 0))
                .setPattern(pattern, datas));
    }

    @Override
    public Texture getTexture() {
        return new Texture(gear_id);
    }

    @Override
    public String getId() {
        return gear_id;
    }

    @Override
    public String getName() {
        return "items."+gear_id;
    }

    @Override
    public CreativeCategory getCreativeCategory() {
        return CreativeCategory.TOOLS;
    }
}
