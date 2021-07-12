package net.vfyjxf.nechar.transform.transformers;

import net.vfyjxf.nechar.transform.Transformer;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.MethodNode;

public class TransformerString extends Transformer.Configurable {

    public TransformerString(){
        reload();
    }

    @Override
    protected String[] getDefault() {
        return new String[]{
                "extracells.gui.GuiFluidTerminal:updateFluids",
                "extracells.gui.GuiFluidStorage:updateFluids",
                "witchinggadgets.client.ThaumonomiconIndexSearcher:buildEntryList",
                "appeng.client.gui.implementations.GuiInterfaceTerminal:refreshList",
                "appeng.client.gui.implementations.GuiInterfaceTerminal:itemStackMatchesSearchTerm",
                "vswe.stevesfactory.components.ComponentMenuLiquid:updateSearch",  // Steve's Factory Manager liquid search
                "vswe.stevesfactory.components.ComponentMenuItem:updateSearch", // Steve's Factory Manager item search
                "betterquesting.api2.client.gui.panels.lists.CanvasQuestSearch:queryMatches" //Better Questing quest  search --gtnh
        };
    }


    @Override
    protected String getName() {
        return "string contains";
    }

    @Override
    protected void transform(MethodNode n) {
        Transformer.transformInvoke(
                n, "java/lang/String", "contains",
                "net/vfyjxf/nechar/utils/Match", "contains",
                "(Ljava/lang/String;Ljava/lang/CharSequence;)Z",
                false, Opcodes.INVOKESTATIC, "(Ljava/lang/Object;)Z", "(Ljava/lang/String;)Z"
        );
    }
}
