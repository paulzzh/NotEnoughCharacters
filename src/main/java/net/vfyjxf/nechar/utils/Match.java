/*
 * 基于Towdium的JustEnoughCharacters(https://github.com/Towdium/JustEnoughCharacters/blob/1.12.0/src/main/java/me/towdium/jecharacters/transform/transformers/TransformerRegExp.java)
 * 原文件协议为MIT
 */

package net.vfyjxf.nechar.utils;

import static net.moecraft.nechar.NotEnoughCharacters.context;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Match {

    static final Pattern p = Pattern.compile("a");

    public static boolean isChinese(CharSequence s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isChinese(s.charAt(i))) return true;
        }
        return false;
    }

    public static boolean isChinese(char i) {
        return (0x3000 <= i && i < 0xA000) || (0xE900 <= i && i < 0xEA00);
    }

    public static boolean contains(String s, CharSequence cs) {
        //            NotEnoughCharacters.logger.info("contains(" + s + ',' + cs + ")->" + b);
        return context.contains(s, cs.toString());
    }


    public static Matcher matcher(Pattern test, CharSequence name) {
        return matches(name.toString(), test.toString()) ? p.matcher("a") : test.matcher(name);
    }

    public static boolean matches(String s1, String s2) {
        boolean start = s2.startsWith(".*");
        boolean end = s2.endsWith(".*");
        if (start && end && s2.length() < 4) end = false;
        if (start || end) s2 = s2.substring(start ? 2 : 0, s2.length() - (end ? 2 : 0));
        return contains(s1, s2);
    }
}
