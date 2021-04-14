package net.vfyjxf.nechar.core;

import net.minecraft.launchwrapper.IClassTransformer;
import net.vfyjxf.nechar.transform.Transformer;
import net.vfyjxf.nechar.transform.TransformerRegistry;

public class NechClassTransformer implements IClassTransformer {
    @SuppressWarnings("SameParameterValue")
    @Override
    public byte[] transform(String s, String s1, byte[] bytes) {
        if (NechCorePlugin.INITIALIZED) {
            for (Transformer t : TransformerRegistry.getTransformer(s)) {
                bytes = t.transform(bytes);
            }
            return bytes;
        } else {
            return bytes;
        }
    }
}
