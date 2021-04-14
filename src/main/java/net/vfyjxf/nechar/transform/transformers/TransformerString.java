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
                "witchinggadgets.client.ThaumonomiconIndexSearcher:buildEntryList"
        };
    }

    @Override
    protected String[] getAdditional() {
        return new String[0];
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
