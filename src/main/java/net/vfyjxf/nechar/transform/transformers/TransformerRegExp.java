/*
 * 基于Towdium的JustEnoughCharacters(https://github.com/Towdium/JustEnoughCharacters/blob/1.12.0/src/main/java/me/towdium/jecharacters/transform/transformers/TransformerRegExp.java)
 * 原文件协议为MIT
 */

package net.vfyjxf.nechar.transform.transformers;

import net.vfyjxf.nechar.NechConfig;
import net.vfyjxf.nechar.transform.Transformer;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.MethodNode;

public class TransformerRegExp extends Transformer.Configurable {

    public TransformerRegExp() {
        reload();
    }


    @Override
    protected String[] getDefault() {
        return NechConfig.transformerRegExp;
    }


    @Override
    protected String getName() {
        return "regular expression";
    }

    @Override
    protected void transform(MethodNode n) {
        Transformer.transformInvoke(
                n, "java/util/regex/Pattern", "matcher",
                "net/vfyjxf/nechar/utils/Match", "matcher",
                "(Ljava/util/regex/Pattern;Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;",
                false, Opcodes.INVOKESTATIC, null, null
        );
        Transformer.transformInvoke(
                n, "java/lang/String", "matches",
                "net/vfyjxf/nechar/utils/Match", "matches",
                "(Ljava/lang/String;Ljava/lang/CharSequence;)Z",
                false, Opcodes.INVOKESTATIC, "(Ljava/lang/Object;)Z", "(Ljava/lang/String;)Z"
        );
    }


}
