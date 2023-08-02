package unfair.noobkit;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.Date;

public class getJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(!Noobkit.getPl().getConfig().contains(event.getPlayer().getUniqueId().toString())){
            Noobkit.getPl().getConfig().createSection(event.getPlayer().getUniqueId().toString());
            kit.givekit(event.getPlayer(),true);
            Noobkit.getPl().saveConfig();
            Noobkit.getPl().reloadConfig();
        }

    }

}
