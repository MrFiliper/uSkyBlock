package us.talabrek.ultimateskyblock.command.island;

import dk.lockfuglsang.minecraft.po.I18nUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import us.talabrek.ultimateskyblock.api.event.AcceptEvent;
import us.talabrek.ultimateskyblock.api.event.RejectEvent;
import us.talabrek.ultimateskyblock.command.InviteHandler;
import us.talabrek.ultimateskyblock.uSkyBlock;

import java.util.Map;

public class AcceptRejectCommand extends RequirePlayerCommand {

    private final uSkyBlock plugin;

    public AcceptRejectCommand(uSkyBlock plugin) {
        super("accept|reject", "usb.party.join", I18nUtil.tr("accept/reject an invitation."));
        this.plugin = plugin;
    }

    @Override
    protected boolean doExecute(String alias, Player player, Map<String, Object> data, String... args) {
        if (alias.equalsIgnoreCase("reject")) {
            plugin.getServer().getPluginManager().callEvent(new RejectEvent(player));
        } else if (alias.equalsIgnoreCase("accept")) {
            plugin.getServer().getPluginManager().callEvent(new AcceptEvent(player));
        }
        return true;
    }
}
