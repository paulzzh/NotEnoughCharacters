package net.moecraft.nechar;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.towdium.pinin.PinIn;
import net.minecraft.client.Minecraft;
import net.vfyjxf.nechar.NechConfig;
import net.vfyjxf.nechar.utils.Match;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;


@Mod(modid = NotEnoughCharacters.ID, useMetadata = true)
public class NotEnoughCharacters {
    public static final String ID = "nechar";
    public static final String VERSION = NotEnoughCharacters.class.getPackage().getImplementationVersion();
    public static final Logger logger = LogManager.getLogger("NotEnoughCharacters");

    public static final PinIn context = new PinIn().config().accelerate(true).commit();

    private static void onConfigChange() {
        context.config()
                .fZh2Z(NechConfig.EnableFZh2Z)
                .fSh2S(NechConfig.EnableFSh2S)
                .fCh2C(NechConfig.EnableFCh2C)
                .fAng2An(NechConfig.EnableFAng2An)
                .fIng2In(NechConfig.EnableFIng2In)
                .fEng2En(NechConfig.EnableFEng2En)
                .fU2V(NechConfig.EnableFU2V).commit();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("Not Enough Characters - v" + VERSION);
        NechConfig.loadConfig(new File(Minecraft.getMinecraft().mcDataDir, "config/NotEnoughCharacters.cfg"));
        onConfigChange();
    }
}
