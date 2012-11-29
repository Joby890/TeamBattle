/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.jamy.teambattle;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import be.jamy.teambattle.TeamBattleConfig;
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
        log.info("TeamBattle has been enabled!");
        File data = new File("./plugins/TeamBattle/data.yml");
        if(data.exists()) {
        	FileConfiguration c = this.getConfig();
        	if(c.contains("Teams.Name")) {
        		ConfigurationSection s =c.getConfigurationSection("Teams.Name");
        		String Team1 = (String) c.get("Team.1");
        		Team.CurrentTeams.put(Team1, 1);
        	}
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
