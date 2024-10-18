package com.reider745.factorycraft.items.material;

import ru.koshakmine.icstd.item.Item;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.common.Texture;

public class FactoryBatteryItem extends Item {
    public static final String ID = "factory_battery";
    @Override
    public Texture getTexture() {
        return new Texture(ID);
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
        return CreativeCategory.TOOLS;
    }
}
