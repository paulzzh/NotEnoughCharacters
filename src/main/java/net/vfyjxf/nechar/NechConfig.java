package net.vfyjxf.nechar;

import net.minecraftforge.common.config.Configuration;

import java.io.File;


public class NechConfig {

    private static Configuration config;
    public static String[] transformerRegExp = new String[]{
            "appeng.client.me.ItemRepo:updateView",
            "net.p455w0rd.wirelesscraftingterminal.client.me.ItemRepo:updateView"
    };
    public static String[] transformerString = new String[]{
            "extracells.gui.GuiFluidTerminal:updateFluids",
            "extracells.gui.GuiFluidStorage:updateFluids",
            "witchinggadgets.client.ThaumonomiconIndexSearcher:buildEntryList",
            "appeng.client.gui.implementations.GuiInterfaceTerminal:refreshList",
            "appeng.client.gui.implementations.GuiInterfaceTerminal:itemStackMatchesSearchTerm",
            "vswe.stevesfactory.components.ComponentMenuLiquid:updateSearch",  // Steve's Factory Manager liquid search
            "vswe.stevesfactory.components.ComponentMenuItem:updateSearch", // Steve's Factory Manager item search
            "betterquesting.api2.client.gui.panels.lists.CanvasQuestSearch:queryMatches" //Better Questing quest  search --gtnh
    };

    public static void loadConfig(File configFile) {
        config = new Configuration(configFile);
        config.load();

        transformerRegExp = config.get("transformers", "TransformerRegExp", transformerRegExp,
                "The list of methods to transform, of which uses regular expression to match.\n" +
                        "The format is \"full.class.path$InnerClass:methodName\"").getStringList();
        transformerString = config.get("transformers", "TransformerString", transformerString,
                "The list of methods to transform, of which uses \"String.contains\" to match.\n" +
                        "The format is \"full.class.path$InnerClass:methodName\"").getStringList();

        if(config.hasChanged()){
            config.save();
        }

    }
}
