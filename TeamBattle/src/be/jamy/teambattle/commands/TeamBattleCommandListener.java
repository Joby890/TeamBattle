/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.jamy.teambattle.commands;

import be.jamy.teambattle.Team;
import be.jamy.teambattle.TeamBattle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Jamy
 */
public class TeamBattleCommandListener implements CommandExecutor {

    private TeamBattle plugin;
 
    public TeamBattleCommandListener(TeamBattle plugin) {
	this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        if (sender instanceof Player) {
           Player player = (Player) sender;
           if(lbl.equalsIgnoreCase("tb")) {
        	   if(lbl.length() == 1) {
        		   showhelp(player);
        		   return true;
        	   }
        	   if(lbl.length() >= 1) {
        		   if(args.length == 0) {
        			   if(args[0].equals("join")) {
        				   if(player.hasPermission("teambattle.join")) {
        					   player.sendMessage("======================================");
        					   player.sendMessage("                  Help                ");
        					   player.sendMessage("Please put a Team name after the join.");
        					   player.sendMessage("======================================");
        					   return true;
        				   }
        			   }
        		   }
        		   if(args.length >= 1) {
        				  if(args[0].equalsIgnoreCase("join")) {
                			  if(player.hasPermission("teambattle.join")) {
        					  String s = args[1];
        					  if(Team.PlayerTeam.containsKey(player)) {
           				   		player.sendMessage("======================================");
           				   		player.sendMessage("                  Help                ");
           				   		player.sendMessage("Please leave the current team to join team.");
           				   		player.sendMessage("======================================");
        					  } else {
        						  if(Team.CurrentTeams.containsKey(s)) {
        							  int a = Team.CurrentTeams.get(s);
        							  Team.PlayerTeam.put(player.getName(), a);
        							  return true;
        						  } else {
             				   		player.sendMessage("======================================");
               				   		player.sendMessage("                  Help                ");
               				   		player.sendMessage("Please put a active team name to join.");
               				   		player.sendMessage("======================================");
               				   	return true;
        					  	}
        					  }
        				  }
        			  }
        		   }
        	   }
           }

           } else if(lbl.equals("tbadmin") && args.length >= 1) {
               return true;
           } else {
        	   
           }
               return false;
    }

	private void showhelp(Player p) {
		p.sendMessage("===============================================");
		p.sendMessage("                      Help                     ");
		p.sendMessage("tb: basic commands for all users.              ");
		p.sendMessage("tb join {name}: join a team.                   ");
		p.sendMessage("tbadmin: Admin commands for admin users.       ");
		p.sendMessage("===============================================");
		
	}
    
    
}
