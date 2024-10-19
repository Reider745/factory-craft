package com.reider745.factorycraft.blocks.machine.mechanic;

import com.reider745.factorycraft.api.ItemType;
import com.zhekasmirnov.innercore.api.NativeItem;
import org.json.JSONException;
import org.json.JSONObject;
import ru.koshakmine.icstd.block.blockentity.BlockEntityContainer;
import ru.koshakmine.icstd.block.blockentity.ticking.ITickingBlockEntity;
import ru.koshakmine.icstd.entity.Player;
import ru.koshakmine.icstd.js.StorageInterfaceLib;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.common.ItemStack;
import ru.koshakmine.icstd.type.common.Position;

import java.util.HashMap;

public abstract class MechanicBlockEntity extends BlockEntityContainer implements ITickingBlockEntity {
    private static final HashMap<Integer, Float> upgrades = new HashMap<>();

    public static void registerUpgrade(int id, float upgradeTime){
        upgrades.put(id, upgradeTime);
    }

    protected boolean active = true;
    protected float progress = 0;

    public MechanicBlockEntity(String type, String localType, int id, Position position, Level level) {
        super(type, localType, id, position, level);
    }

    @Override
    public void onInit() {
        super.onInit();
        networkData.putBoolean("active", active);
        networkData.sendChanges();
    }

    @Override
    public void onLoad(JSONObject json) throws JSONException {
        active = json.getBoolean("active");
        progress = (float) json.getDouble("progress");
        super.onLoad(json);
    }

    @Override
    public void onSave(JSONObject json) throws JSONException {
        json.put("active", active);
        json.put("progress", progress);
        super.onSave(json);
    }

    public int addItemToContainer(ItemStack item, int size, String prefix, int i){
        for (int index = i; index <= size; index++) {
            final ItemStack slot = container.getSlot("slot"+prefix + index);

            if(slot.id == 0){
                container.setSlot("slot" + prefix+index, item);
                return 0;
            }

            if (slot.id == item.id && slot.data == item.data) {
                final int maxStack = NativeItem.getMaxStackForId(item.id, 0);

                if (slot.count <= maxStack) {
                    int maxcount = maxStack - slot.count;

                    if(item.count <= maxcount){
                        slot.count += item.count;
                        container.setSlot("slot" + prefix+index, slot);
                        return 0;
                    }

                    slot.count += maxcount;
                    container.setSlot("slot" + prefix + index, slot);
                    item.count -= maxcount;
                }
            }
        }

        return item.count;
    }

    public int addItemToContainer(ItemStack item, int size, String prefix){
        return addItemToContainer(item, size, prefix, 1);
    }

    public int addItemToContainer(ItemStack item, int size){
        return addItemToContainer(item, size, "", 1);
    }

    public int addItemToContainer(ItemStack item){
        return addItemToContainer(item, 28, "", 1);
    }

    public void putChest(ItemStack item){
        item.count = addItemToContainer(item);
        level.spawnDroppedItem(position.add(.5, .5, .5), item);
    }

    @Override
    public void onTick() {
        StorageInterfaceLib.checkHoppers(this);

        if(active){
            final float time = getTime();

            container.setScale("progressScale", progress / time);

            float modeTime = 1;
            for(int i = 1;i < 8;i++){
                final ItemStack slot = container.getSlot("slotU"+i);
                modeTime = Math.min(modeTime + upgrades.getOrDefault(slot.id, 0f), 20);
            }

            progress += modeTime;

            if(progress >= time) {
                onMachineDeploy();
                progress = 0;
            }
        }
        container.sendChanges();
    }

    public abstract float getTime();
    public abstract void onMachineDeploy();

    @Override
    public void onClick(Position position, ItemStack stack, Player player) {
        if(player.isSneaking() && ItemType.is(stack.id, "wrench")){
            level.spawnDroppedItem(position.add(.5, .5, .5), new ItemStack(id, 0));
            level.destroyBlock(position);
            return;
        }
        super.onClick(position, stack, player);
    }

    @Override
    public String getScreenName(Position position, ItemStack stack, Player player) {
        if(ItemType.is(stack.id, "wrench")){
            active = !active;
            networkData.putBoolean("active", active);
            networkData.sendChanges();
            return null;
        }
        return "main";
    }
}
