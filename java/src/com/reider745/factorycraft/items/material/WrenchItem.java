package com.reider745.factorycraft.items.material;

import com.reider745.factorycraft.api.ItemType;
import com.reider745.factorycraft.items.ItemRegistry;
import ru.koshakmine.icstd.item.Item;
import ru.koshakmine.icstd.item.ItemGroup;
import ru.koshakmine.icstd.type.CreativeCategory;
import ru.koshakmine.icstd.type.common.Texture;

public class WrenchItem extends Item {
    @Override
    public void onInit() {
        ItemType.set(getNumId(), "wrench");
    }

    @Override
    public Texture getTexture() {
        return new Texture("factory_wrench");
    }

    @Override
    public String getId() {
        return "factory_wrench";
    }

    @Override
    public String getName() {
        return "items.factory_wrench";
    }

    @Override
    public CreativeCategory getCreativeCategory() {
        return CreativeCategory.TOOLS;
    }

    @Override
    public ItemGroup getCreativeItemGroup() {
        return ItemRegistry.MATERIAL;
    }
}
