package net.pedroricardo.headed;

import com.google.gson.GsonBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

public class HeadedConfig {
    public static ConfigClassHandler<HeadedConfig> HANDLER = ConfigClassHandler.createBuilder(HeadedConfig.class)
            .id(new Identifier(Headed.MOD_ID, "headed"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve("headed.json5"))
                    .appendGsonBuilder(GsonBuilder::setPrettyPrinting)
                    .setJson5(true)
                    .build())
            .build();

    @SerialEntry
    public boolean witherSkullsGrantWitherImmunity = true;

    @SerialEntry
    public boolean foxHeadsTick = true;
}
