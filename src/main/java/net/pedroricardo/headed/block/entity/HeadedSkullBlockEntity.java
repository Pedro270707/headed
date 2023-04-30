package net.pedroricardo.headed.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class HeadedSkullBlockEntity extends BlockEntity {
    public static final String IS_TAMED_KEY = "Tamed";

    private boolean isTamed;
    @Nullable
    private Text customName;
    private int poweredTicks;
    private boolean powered;

    public HeadedSkullBlockEntity(BlockPos pos, BlockState state) {
        super(HeadedBlockEntities.SKULL, pos, state);
    }

    public HeadedSkullBlockEntity(BlockPos pos, BlockState state, BlockEntityType<? extends HeadedSkullBlockEntity> type) {
        super(type, pos, state);
    }

    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);

        nbt.putBoolean("Tamed", this.isTamed);
        if (this.customName != null) {
            nbt.putString("CustomName", Text.Serializer.toJson(this.customName));
        }
    }

    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);

        this.isTamed = nbt.getBoolean("Tamed");
        if (nbt.contains("CustomName", 8)) {
            this.customName = Text.Serializer.fromJson(nbt.getString("CustomName"));
        }
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

    public boolean isTamed() {
        return this.isTamed;
    }

    public void setCustomName(@Nullable Text customName) {
        this.customName = customName;
    }

    @Nullable
    public Text getCustomName() {
        return this.customName;
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }
}