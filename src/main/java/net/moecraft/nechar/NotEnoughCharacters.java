package net.moecraft.nechar;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.vfyjxf.nechar.NechConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;


@Mod(modid = NotEnoughCharacters.ID, useMetadata = true)
public class NotEnoughCharacters {
    public static final String ID = "nechar";
    public static final String VERSION = NotEnoughCharacters.class.getPackage().getImplementationVersion();
    public static final Logger logger = LogManager.getLogger("NotEnoughCharacters");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("Not Enough Characters - v" + VERSION);
        NechConfig.loadConfig(new File(Minecraft.getMinecraft().mcDataDir, "config/NotEnoughCharacters.cfg"));
    }
}
