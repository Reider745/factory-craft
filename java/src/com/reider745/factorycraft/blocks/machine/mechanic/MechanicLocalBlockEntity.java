package com.reider745.factorycraft.blocks.machine.mechanic;

import com.zhekasmirnov.apparatus.multiplayer.util.entity.NetworkEntity;
import com.zhekasmirnov.innercore.api.constants.ParticleType;
import org.json.JSONException;
import org.json.JSONObject;
import ru.koshakmine.icstd.block.blockentity.LocalBlockEntity;
import ru.koshakmine.icstd.block.blockentity.ticking.ITickingBlockEntity;
import ru.koshakmine.icstd.level.particle.Particle;
import ru.koshakmine.icstd.type.common.Position;
import ru.koshakmine.icstd.ui.IWindow;

public class MechanicLocalBlockEntity extends LocalBlockEntity implements ITickingBlockEntity {
    private static final Particle REDSTONE = Particle.getParticleById(ParticleType.redstone);

    private final IWindow window;

    public MechanicLocalBlockEntity(String type, int id, Position position, NetworkEntity network, JSONObject data, IWindow window) throws JSONException {
        super(type, id, position, network, data);

        this.window = window;
    }

    @Override
    public IWindow getScreenByName(String name) {
        return window;
    }

    @Override
    public void onTick() {
        level.spawnParticle(REDSTONE, position.add(Math.random(), Math.random(), Math.random()));
    }
}
