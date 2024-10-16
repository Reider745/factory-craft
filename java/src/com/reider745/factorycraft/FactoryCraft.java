package com.reider745.factorycraft;

import com.reider745.factorycraft.blocks.BlockRegistry;
import com.reider745.factorycraft.items.ItemRegistry;
import com.zhekasmirnov.apparatus.modloader.LegacyInnerCoreMod;
import ru.koshakmine.icstd.modloader.Mod;
import ru.koshakmine.icstd.modloader.ObjectFactory;
import ru.koshakmine.icstd.utils.TranslationLoader;

public class FactoryCraft extends Mod {
    public FactoryCraft(String dir, LegacyInnerCoreMod mod) {
        super(dir, mod);
    }

    @Override
    public void runMod(ObjectFactory objectFactory) {
        TranslationLoader.loadTranslation(getDir()+"lang", "en");

        BlockRegistry.init();
        ItemRegistry.init();
    }
}
