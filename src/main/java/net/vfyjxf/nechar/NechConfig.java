package net.vfyjxf.nechar;

import net.minecraftforge.common.config.Configuration;

import java.io.File;


public class NechConfig {

    public static boolean EnableFZh2Z = false;
    public static boolean EnableFSh2S = false;
    public static boolean EnableFCh2C = false;
    public static boolean EnableFAng2An = false;
    public static boolean EnableFIng2In = false;
    public static boolean EnableFEng2En = false;
    public static boolean EnableFU2V = false;

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
            "betterquesting.api2.client.gui.panels.lists.CanvasQuestSearch:queryMatches", //Better Questing quest  search --gtnh
            "me.towdium.jecalculation.utils.Utilities$I18n:contains",// Just Enough Calculation
            "logisticspipes.gui.orderer.GuiOrderer:isSearched",  // Logistics Pipes orderer
            "logisticspipes.gui.orderer.GuiRequestTable:isSearched"  // Logistics Pipes request table
    };

    public static void loadConfig(File configFile) {
        Configuration config = new Configuration(configFile);
        config.load();
        config.get("transformers", "DefaultTransformerRegExp", defaultTransformerRegExp,
                "Default list of methods to transform, of which uses regular expression to match.\n" +
                        "This list is maintained by the mod and will have no effect if you change it.");
        config.get("transformers", "DefaultTransformerString", defaultTransformerStringList,
                "Default list of methods to transform, of which uses \"String.contains\" to match.\n" +
                        "This list is maintained by the mod and will have no effect if you change it.");

        config.getCategory("transformers").get("DefaultTransformerRegExp").set(defaultTransformerRegExp);
        config.getCategory("transformers").get("DefaultTransformerString").set(defaultTransformerStringList);

        transformerRegExpAdditionalList = config.get("transformers", "AdditionalTransformerRegExpList", new String[0],
                "Additional list of methods to transform, of which uses regular expression to match.\n" +
                        "The format is \"full.class.path$InnerClass:methodName\"").getStringList();

        transformerStringAdditionalList = config.get("transformers", "AdditionalTransformerStringList", new String[0],
                "Additional list of methods to transform, of which uses \"String.contains\" to match.\n" +
                        "The format is \"full.class.path$InnerClass:methodName\"").getStringList();

        transformerMethodBlackList = config.get("transformers", "transformerMethodBlackList", new String[0],
                "Blacklist of methods to transform\n" +
                        "The format is \"full.class.path$InnerClass:methodName\"").getStringList();

        //Fuzzy config
        EnableFU2V = config.get("fuzzy", "EnableFU2V", false, "Set to true to enable fuzzy U <=> V").getBoolean();
        EnableFZh2Z = config.get("fuzzy", "EnableFZh2Z", false, "Set to true to enable fuzzy Zh <=> Z").getBoolean();
        EnableFSh2S = config.get("fuzzy", "EnableFSh2S", false, "Set to true to enable fuzzy Sh <=> S").getBoolean();
        EnableFCh2C = config.get("fuzzy", "EnableFCh2C", false, "Set to true to enable fuzzy Ch <=> C").getBoolean();
        EnableFAng2An = config.get("fuzzy", "EnableFAng2An", false, "Set to true to enable fuzzy Ang <=> An").getBoolean();
        EnableFIng2In = config.get("fuzzy", "EnableFIng2In", false, "Set to true to enable fuzzy Ing <=> In").getBoolean();
        EnableFEng2En = config.get("fuzzy", "EnableFEng2En", false, "Set to true to enable fuzzy Eng <=> En").getBoolean();
        if (config.hasChanged()) config.save();
    }
}
