package com.reider745.factorycraft.items.material;

import com.reider745.factorycraft.blocks.machine.mechanic.MechanicBlockEntity;
import com.reider745.factorycraft.items.ItemRegistry;
import ru.koshakmine.icstd.item.Item;
import ru.koshakmine.icstd.item.ItemGroup;
import ru.koshakmine.icstd.recipes.workbench.ItemCraft;
import ru.koshakmine.icstd.recipes.workbench.PatternData;
import ru.koshakmine.icstd.recipes.workbench.ShapedRecipe;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.common.Texture;

public class GearItem extends Item {
    private final String gear_id;
    private final String[] pattern;
    private final PatternData[] datas;
    private final float upgradeTime;

    public GearItem(String id, String[] pattern, PatternData[] datas, float upgradeTime){
        this.gear_id = id;
        this.pattern = pattern;
        this.datas = datas;

        this.upgradeTime = upgradeTime;
    }

    @Override
    public void onInit() {
        super.onInit();

        MechanicBlockEntity.registerUpgrade(getNumId(), upgradeTime);
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
        return CreativeCategory.MATERIAL;
    }

    @Override
    public ItemGroup getCreativeItemGroup() {
        return ItemRegistry.MATERIAL;
    }
}
