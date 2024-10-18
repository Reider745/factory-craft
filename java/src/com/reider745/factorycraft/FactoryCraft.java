package com.reider745.factorycraft;

import com.reider745.factorycraft.api.ItemType;
import com.reider745.factorycraft.blocks.BlockRegistry;
import com.reider745.factorycraft.items.ItemRegistry;
import com.zhekasmirnov.apparatus.modloader.LegacyInnerCoreMod;
import com.zhekasmirnov.innercore.api.runtime.other.PrintStacking;
import org.mozilla.javascript.Scriptable;
import ru.koshakmine.icstd.event.Event;
import ru.koshakmine.icstd.event.Events;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.modloader.ObjectFactory;
import ru.koshakmine.icstd.type.ItemID;
import ru.koshakmine.icstd.utils.TranslationLoader;

public class FactoryCraft extends Mod {
    public static String WINDOWS;

    public FactoryCraft(String dir, LegacyInnerCoreMod mod) {
        super(dir, mod);

        WINDOWS = dir + "windows/";
    }

    @Override
    public void runMod(ObjectFactory objectFactory) {
        TranslationLoader.loadTranslation(getDir()+"lang", "en");

        BlockRegistry.init();
        ItemRegistry.init();

        Event.onCall(Events.ModsLoaded, (args) -> {
            ItemType.set(ItemID.getModId("bronzeWrench", -1), "wrench");
            ItemType.set(ItemID.getModId("bc_wrench", -1), "wrench");
            ItemType.set(ItemID.getModId("utilsWrench", -1), "wrench");
            ItemType.set(ItemID.getModId("rp_screwdriver", -1), "wrench");
        });
    }
}
