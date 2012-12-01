/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.jamy.teambattle;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import be.jamy.teambattle.commands.TeamBattleCommandListener;
import be.jamy.teambattle.listener.TeamBattleBukkitListener;
import be.jamy.teambattle.listener.TeamBattleTagAPIListener;

import java.io.File;
import java.util.logging.Logger;
import org.bukkit.Bukkit;

/**
 *
 * @author Jamy, Joby
 */
public class TeamBattle extends JavaPlugin {
    public static Logger log = Bukkit.getLogger();
    
    private TeamBattleCommandListener command;

    @Override
    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("tagAPI").isEnabled()) {
            log.info("tagAPI found enabling!");
            RegistertagAPI();
        }
        command = new TeamBattleCommandListener(this);
        this.getServer().getPluginManager().registerEvents(new TeamBattleBukkitListener(this), this);
        try {
        getCommand("tb").setExecutor(command);
        getCommand("tbadmin").setExecutor(command);
        } catch (Exception e) {
        }
        DataCheck();
        log.info("TeamBattle has been enabled!");
    }
    
    private void DataCheck() {
        File data = new File("./plugins/TeamBattle/data.yml");
        if(data.exists()) {
        	FileConfiguration c = this.getConfig();
        	if(c.contains("Team.1")) {
        		ConfigurationSection s =c.getConfigurationSection("Teams.1");
        		String Team1 = (String) s.get("Team.id");
        		Team.CurrentTeams.put(Team1, 1);
        		String s1 = (String) c.get("Teams.1.color");
        		Team.TeamColor.put(1, s1);
        	}
        	if(c.contains("Team.2")) {
        		ConfigurationSection s =c.getConfigurationSection("Teams.2");
        		String Team1 = (String) s.get("Team.id");
        		Team.CurrentTeams.put(Team1, 2);
        		String s1 = (String) c.get("Teams.2.color");
        		Team.TeamColor.put(2, s1);
        	}
        	if(c.contains("Team.3")) {
        		ConfigurationSection s =c.getConfigurationSection("Teams.3");
        		String Team1 = (String) s.get("Team.id");
        		Team.CurrentTeams.put(Team1, 3);
        		String s1 = (String) c.get("Teams.3.color");
        		Team.TeamColor.put(3, s1);
        	}
        	if(c.contains("Team.4")) {
        		ConfigurationSection s =c.getConfigurationSection("Teams.4");
        		String Team1 = (String) s.get("Team.id");
        		Team.CurrentTeams.put(Team1, 4);
        		String s1 = (String) c.get("Teams.4.color");
        		Team.TeamColor.put(4, s1);
        	}
        } else {
        	createdataconfig();
        }
	}
	private void createdataconfig() {
		File CONFIGURATION = new File("./plugins/TeamBattle/data.yml");
		final YamlConfiguration config = YamlConfiguration.loadConfiguration(CONFIGURATION);
		String Team1 = config.getString("Team1", "name");
		if (Team1.isEmpty()) {

		}
		
	}

	private void RegistertagAPI() {
    	this.getServer().getPluginManager().registerEvents(new TeamBattleTagAPIListener(this), this);
	}
	@Override
    public void onDisable() {
        log.info("TeamBattle has been disabled!");
    }
}
