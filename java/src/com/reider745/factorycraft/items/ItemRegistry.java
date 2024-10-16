package com.reider745.factorycraft.items;

import com.reider745.factorycraft.items.material.GearWoodItem;
import ru.koshakmine.icstd.item.Item;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.modloader.ObjectFactory;

public class ItemRegistry {
    private static final ObjectFactory FACTORY = Mod.getFactory();

    public static final Item WOODEN_GEAR = FACTORY.addItem(GearWoodItem::new);

    public static void init(){};
}
