package net.vfyjxf.nechar;

import com.google.gson.GsonBuilder;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.vfyjxf.nechar.utils.Profiler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class NechCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "nech";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 1 && "profile".equals(args[0])) {
            Thread t = new Thread(() -> {
                sender.addChatMessage(new ChatComponentText(I18n.format("chat.start")));
                Profiler.Report r = Profiler.run();
                try (FileOutputStream fos = new FileOutputStream("logs/necharacters-profiler.txt")) {
                    OutputStreamWriter osw = new OutputStreamWriter(fos);
                    osw.write(new GsonBuilder().setPrettyPrinting().create().toJson(r));
                    osw.flush();
                    sender.addChatMessage(new ChatComponentText(I18n.format("chat.saved")));
                } catch (IOException e) {
                    sender.addChatMessage(new ChatComponentText(I18n.format("chat.save_error")));
                }
            });
            t.setPriority(Thread.MIN_PRIORITY);
            t.start();
        }
    }

    @Override
    public List addTabCompletionOptions(ICommandSender sender, String[] args) {
        return args.length <= 1 ? CommandBase.getListOfStringsMatchingLastWord(args, "profile") : null;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 1;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
