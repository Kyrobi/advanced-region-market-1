package net.alex9849.arm.Preseter.commands;

import net.alex9849.arm.Messages;
import net.alex9849.arm.Permission;
import net.alex9849.arm.Preseter.Preset;
import net.alex9849.arm.Preseter.PresetType;
import net.alex9849.arm.exceptions.InputException;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ResetCommand extends BasicPresetCommand {
    private final String rootCommand = "reset";
    private final String regex = "(?i)reset";
    private final String usage = "reset";

    @Override
    public boolean matchesRegex(String command) {
        return command.matches(regex);
    }

    @Override
    public String getRootCommand() {
        return this.rootCommand;
    }

    @Override
    public String getUsage() {
        return this.usage;
    }

    @Override
    public boolean runCommand(Player player, String[] args, String allargs, PresetType presetType) throws InputException {
        if(!player.hasPermission(Permission.ADMIN_PRESET_RESET)) {
            throw new InputException(player, Messages.NO_PERMISSION);
        }

        if(presetType == null) {
            return false;
        }

        Preset preset = Preset.getPreset(presetType, player);

        if(preset == null) {
            player.sendMessage(Messages.PREFIX + Messages.PRESET_REMOVED);
            return true;
        }

        preset.remove();
        player.sendMessage(Messages.PREFIX + Messages.PRESET_REMOVED);
        return true;
    }

    @Override
    public List<String> onTabComplete(Player player, String[] args, PresetType presetType) {
        List<String> returnme = new ArrayList<>();
        if(player.hasPermission(Permission.ADMIN_PRESET_RESET)) {
            if(args.length >= 1) {
                if(args.length == 1) {
                    if(this.rootCommand.startsWith(args[0])) {
                        returnme.add(this.rootCommand);
                    }
                }
            }
        }
        return returnme;
    }
}
