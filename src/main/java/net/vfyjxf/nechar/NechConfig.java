package net.vfyjxf.nechar;

import net.minecraftforge.common.config.Configuration;

import java.io.File;


public class NechConfig {

    private static Configuration config;


    public static String[] transformerRegExpAdditionalList = new String[0];
    public static String[] transformerStringAdditionalList = new String[0];
    public static String[] transformerMethodBlackList = new String[0];

    public static String[] defaultTransformerRegExp = new String[]{
            "appeng.client.me.ItemRepo:updateView",//Applied-Energistics-2 search
            "net.p455w0rd.wirelesscraftingterminal.client.me.ItemRepo:updateView"//WirelessCraftingTerminal search
    };
    public static String[] defaultTransformerStringList = new String[]{
            "extracells.gui.GuiFluidTerminal:updateFluids",//Extra Cells FluidTerminal search
            "extracells.gui.GuiFluidStorage:updateFluids", //Extra Cells wireless terminal search
            "witchinggadgets.client.ThaumonomiconIndexSearcher:buildEntryList", //Witching Gadgets Thaumonomicon search
            "appeng.client.gui.implementations.GuiInterfaceTerminal:refreshList", //Applied-Energistics-2 InterfaceTerminal
            "appeng.client.gui.implementations.GuiInterfaceTerminal:itemStackMatchesSearchTerm", //Applied-Energistics-2 InterfaceTerminal
            "vswe.stevesfactory.components.ComponentMenuLiquid:updateSearch",  // Steve's Factory Manager liquid search
            "vswe.stevesfactory.components.ComponentMenuItem:updateSearch", // Steve's Factory Manager item search
            "betterquesting.api2.client.gui.panels.lists.CanvasQuestSearch:queryMatches" //Better Questing quest  search --gtnh
    };

    public static void loadConfig(File configFile) {
        config = new Configuration(configFile);
        config.load();
        config.get("transformers", "DefaultTransformerRegExp", defaultTransformerRegExp,
                "Default list of methods to transform, of which uses regular expression to match.\n" +
                        "This list is maintained by the mod and will have no effect if you change it.");
        config.get("transformers", "DefaultTransformerString", defaultTransformerStringList,
                "Default list of methods to transform, of which uses \"String.contains\" to match.\n" +
                        "This list is maintained by the mod and will have no effect if you change it.");

        config.getCategory("transformers").get("DefaultTransformerRegExp").set(defaultTransformerRegExp);
        config.getCategory("transformers").get("DefaultTransformerString").set(defaultTransformerStringList);

        transformerRegExpAdditionalList = config.get("additional","AdditionalTransformerRegExpList",new String[0],
                "Additional list of methods to transform, of which uses regular expression to match.\n" +
                         "The format is \"full.class.path$InnerClass:methodName\"").getStringList();

        transformerStringAdditionalList = config.get("additional","AdditionalTransformerStringList",new String[0],
                "Additional list of methods to transform, of which uses \"String.contains\" to match.\n" +
                        "The format is \"full.class.path$InnerClass:methodName\"").getStringList();

        transformerMethodBlackList = config.get("blacklist","transformerMethodBlackList",new String[0],
                "Blacklist of methods to transform\n" +
                        "The format is \"full.class.path$InnerClass:methodName\"").getStringList();
        if(config.hasChanged()) config.save();
    }
}
