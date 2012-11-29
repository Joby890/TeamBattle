package be.jamy.teambattle.listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import be.jamy.teambattle.Team;
import be.jamy.teambattle.TeamBattle;


public class TeamBattleBukkitListener implements Listener {
    private TeamBattle plugin;	
    public TeamBattleBukkitListener(TeamBattle instance){
        plugin = instance;
    }
    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
		FileConfiguration config = plugin.getConfig();
    	Player p = e.getPlayer();
    	File f = new File("./plugins/TeamBattle/users/" + p.getName() + ".yml");
    	if (!f.exists()) {
    		try {
				f.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    	} else {
    		int i = config.getInt("TeamBattle.getTeam");
    		Team.PlayerTeam.put(p.getName(), i);
    	}
    	
    }
}
