package net.pedroricardo.headed;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;

@Modmenu(modId = Headed.MOD_ID)
@Config(name = Headed.MOD_ID, wrapperName = "HeadedConfig")
public class HeadedConfigModel {
    public static final boolean witherSkullGrantsWitherImmunity = true;
    public static final boolean foxHeadsTick = true;
}
