package net.pedroricardo.headed.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HeadedSkullBlockEntity extends BlockEntity {
    public static final String HAS_LEFT_HORN = "HasLeftHorn";
    public static final String HAS_RIGHT_HORN = "HasRightHorn";

    private boolean hasLeftHorn;
    private boolean hasRightHorn;
    private int poweredTicks;
    private boolean powered;

    public HeadedSkullBlockEntity(BlockPos pos, BlockState state) {
        super(HeadedBlockEntities.SKULL, pos, state);
    }

    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);

        nbt.putBoolean("HasLeftHorn", this.hasLeftHorn);
        nbt.putBoolean("HasRightHorn", this.hasRightHorn);
    }

    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);

        this.hasLeftHorn = nbt.getBoolean("HasLeftHorn");
        this.hasRightHorn = nbt.getBoolean("HasRightHorn");
    }

    public static void tick(World world, BlockPos pos, BlockState state, HeadedSkullBlockEntity blockEntity) {
        if (world.isReceivingRedstonePower(pos)) {
            blockEntity.powered = true;
            ++blockEntity.poweredTicks;
        } else {
            blockEntity.powered = false;
        }

    }

    public float getPoweredTicks(float tickDelta) {
        return this.powered ? (float)this.poweredTicks + tickDelta : (float)this.poweredTicks;
    }

    public boolean getLeftHorn() {
        return this.hasLeftHorn;
    }

    public boolean getRightHorn() {
        return this.hasRightHorn;
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }
}