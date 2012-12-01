package be.jamy.teambattle.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kitteh.tag.PlayerReceiveNameTagEvent;

import be.jamy.teambattle.Team;
import be.jamy.teambattle.TeamBattle;

public class TeamBattleTagAPIListener implements Listener {
    private TeamBattle plugin;	
    public TeamBattleTagAPIListener(TeamBattle instance){
        plugin = instance;
    }
    @EventHandler
    public void nameTagRecive(PlayerReceiveNameTagEvent e) {
    	Player p = e.getNamedPlayer();
    	Integer team = Team.PlayerTeam.get(p.getName());
    	String color = Team.TeamColor.get(team);
    	e.setTag(color + e.getNamedPlayer().getName());
    }
}