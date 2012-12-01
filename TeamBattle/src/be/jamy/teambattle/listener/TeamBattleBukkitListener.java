package be.jamy.teambattle.listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
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
   @EventHandler
   public void PlayerDamage(EntityDamageByEntityEvent e) {
	   if (e.getEntity() == null) {
		   return;
	   }
	   if (e.getDamager() == null) {
		   return;
	   }
	   if(e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
		   Player h = (Player) e.getEntity();
		   Player d = (Player) e.getDamager();
		   if (!Team.PlayerTeam.containsKey(h) || !Team.PlayerTeam.containsKey(d)) {
			   return;
		   } else {
			   int ha = Team.PlayerTeam.get(h);
			   int da = Team.PlayerTeam.get(d);
			   if (ha == da) {
				   e.setCancelled(true);
			   }
			   
		   }
		   
	   }
	   if (e.getEntity() instanceof Player && e.getDamager() instanceof Arrow) {
   		Entity p1 = e.getEntity();
   		Entity p2 = e.getDamager();
   		p2 = ((Arrow)p2).getShooter();
		   if (!Team.PlayerTeam.containsKey(p1) || !Team.PlayerTeam.containsKey(p2)) {
			   return;
		   } else {
			   int p1a = Team.PlayerTeam.get(p1);
			   int p2a = Team.PlayerTeam.get(p2);
			   if (p1a == p2a) {
				   e.setCancelled(true);
			   }

		   }
	   }
	   if (e.getEntity() instanceof Player && e.getDamager() instanceof Snowball) {
	   		Entity p1 = e.getEntity();
	   		Entity p2 = e.getDamager();
	   		p2 = ((Snowball)p2).getShooter();
			   if (!Team.PlayerTeam.containsKey(p1) || !Team.PlayerTeam.containsKey(p2)) {
				   return;
			   } else {
				   int p1a = Team.PlayerTeam.get(p1);
				   int p2a = Team.PlayerTeam.get(p2);
				   if (p1a == p2a) {
					   e.setCancelled(true);
				   }
			   }
		   }
	   if (e.getEntity() instanceof Player && e.getDamager() instanceof Egg) {
	   		Entity p1 = e.getEntity();
	   		Entity p2 = e.getDamager();
	   		p2 = ((Egg)p2).getShooter();
			   if (!Team.PlayerTeam.containsKey(p1) || !Team.PlayerTeam.containsKey(p2)) {
				   return;
			   } else {
				   int p1a = Team.PlayerTeam.get(p1);
				   int p2a = Team.PlayerTeam.get(p2);
				   if (p1a == p2a) {
					   e.setCancelled(true);
				   }
			   }
	   	  }
   	}
}
