package net.pedroricardo.headed;

import com.kyanite.paragon.api.ConfigOption;
import com.kyanite.paragon.api.interfaces.Config;
import com.kyanite.paragon.api.interfaces.serializers.ConfigSerializer;
import com.kyanite.paragon.api.interfaces.serializers.JSON5Serializer;

public class HeadedConfig implements Config {
    public static final ConfigOption<Boolean> WITHER_SKULL_GRANTS_WITHER_IMMUNITY = new ConfigOption<>("wither_skull_grants_wither_immunity", true);
    public static final ConfigOption<Boolean> FOX_HEADS_TICK = new ConfigOption<>("fox_heads_tick", true);

    @Override
    public ConfigSerializer getSerializer() {
        return JSON5Serializer.builder(this).build();
    }
}
