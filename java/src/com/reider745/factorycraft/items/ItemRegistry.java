package com.reider745.factorycraft.items;

import com.reider745.factorycraft.items.groups.MaterialGroup;
import com.reider745.factorycraft.items.groups.MechanicGroup;
import com.reider745.factorycraft.items.material.FactoryBatteryItem;
import com.reider745.factorycraft.items.material.GearItem;
import com.reider745.factorycraft.items.material.WrenchItem;
import ru.koshakmine.icstd.item.Item;
import ru.koshakmine.icstd.item.ItemGroup;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.modloader.ObjectFactory;
import ru.koshakmine.icstd.recipes.workbench.PatternData;
import ru.koshakmine.icstd.type.ItemID;
import ru.koshakmine.icstd.type.block.BlockID;

public class ItemRegistry {
    private static final ObjectFactory FACTORY = Mod.getFactory();

    public static final ItemGroup MATERIAL = FACTORY.addItemGroup(MaterialGroup::new);
    public static final ItemGroup MECHANIC = FACTORY.addItemGroup(MechanicGroup::new);

    public static final Item WOODEN_GEAR = FACTORY.addItem(() -> new GearItem("gear_wood", new String[]{
      " a ",
      "a a",
      " a "
    }, new PatternData[]{new PatternData('a', ItemID.STICK)}, 0.25f));
    public static final Item STONE_GEAR = FACTORY.addItem(() -> new GearItem("gear_stone", new String[]{
            " a ",
            "aba",
            " a "
    }, new PatternData[]{new PatternData('a', BlockID.STONE), new PatternData('b', WOODEN_GEAR.getNumId())}, .4f));
    public static final Item IRON_GEAR = FACTORY.addItem(() -> new GearItem("gear_iron", new String[]{
            " a ",
            "aba",
            " a "
    }, new PatternData[]{new PatternData('a', ItemID.IRON_INGOT), new PatternData('b', STONE_GEAR.getNumId())}, .8f));
    public static final Item GOLD_GEAR = FACTORY.addItem(() -> new GearItem("gear_gold", new String[]{
            " a ",
            "aba",
            " a "
    }, new PatternData[]{new PatternData('a', ItemID.GOLD_INGOT), new PatternData('b', IRON_GEAR.getNumId())}, 1f));
    public static final Item DIAMOND_GEAR = FACTORY.addItem(() -> new GearItem("gear_diamond", new String[]{
            " a ",
            "aba",
            " a "
    }, new PatternData[]{new PatternData('a', ItemID.DIAMOND), new PatternData('b', GOLD_GEAR.getNumId())}, 1.5f));

    public static final Item BATTERY = FACTORY.addItem(FactoryBatteryItem::new);
    public static final Item WRENCH = FACTORY.addItem(WrenchItem::new);

    public static void init(){};
}
