package com.reider745.factorycraft.blocks.machine.mechanic.impl;

import com.reider745.factorycraft.blocks.machine.mechanic.MechanicBlockEntity;
import com.zhekasmirnov.apparatus.adapter.innercore.game.block.BlockState;
import org.json.JSONException;
import org.json.JSONObject;
import ru.koshakmine.icstd.js.ToolAPI;
import ru.koshakmine.icstd.level.Level;
import ru.koshakmine.icstd.type.ItemID;
import ru.koshakmine.icstd.type.common.BlockData;
import ru.koshakmine.icstd.type.common.EnchantData;
import ru.koshakmine.icstd.type.common.ItemStack;
import ru.koshakmine.icstd.type.common.Position;

public class MinerBlockEntity extends MechanicBlockEntity {
    private int digX, digY, digZ;
    private boolean complete = false;

    public MinerBlockEntity(String type, String localType, int id, Position position, Level level) {
        super(type, localType, id, position, level);

        digX = x - 5;
        digY = y - 1;
        digZ = z - 4;
    }

    @Override
    public void onLoad(JSONObject json) throws JSONException {
        digX = json.getInt("dx");
        digY = json.getInt("dy");
        digZ = json.getInt("dz");
        complete = json.getBoolean("complete");

        super.onLoad(json);
    }

    @Override
    public void onSave(JSONObject json) throws JSONException {
        json.put("dx", digX);
        json.put("dy", digY);
        json.put("dz", digZ);
        json.put("complete", complete);


        super.onSave(json);
    }

    @Override
    public float getTime() {
        return 100;
    }

    private static final ItemStack PICKAXE = new ItemStack(ItemID.STONE_PICKAXE, 1, 0);
    private static final EnchantData ENCHANT_DATA = new EnchantData(0, 0, 0, false, 0);
    private static final int DIGGING = ToolAPI.getToolLevel(PICKAXE.id);

    @Override
    public void onMachineDeploy() {
        if(!complete){
            int radius = 4;
            int modY = 32;

            if(++digX > x + radius){
                digX = x - radius;

                if(++digZ > z + radius){
                    digX = x - radius;
                    digZ = z - radius;
                    if(digY-- < y - modY || digY < 1){
                        complete = true;
                    }
                }
            }

            final BlockState block = level.getBlock(digX, digY, digZ);
            if(block.id == 7 || block.id == 8 || block.id == 9 || block.id == 10 || block.id == 11)
                return;

            final ItemStack[] drops = ToolAPI.getBlockDrop(new Position(digX, digY, digZ), new BlockData(block.id, block.data), level, DIGGING, ENCHANT_DATA, PICKAXE);
            level.destroyBlock(digX, digY, digZ);
            for (ItemStack item : drops) putChest(item);
        }
    }
}
