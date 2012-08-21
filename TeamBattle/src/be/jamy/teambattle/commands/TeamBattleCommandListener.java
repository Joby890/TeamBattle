/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.jamy.teambattle.commands;

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
           if(lbl.equals("tb") && args.length >= 1) {
               onTbCommand(sender, args);
               return true;
           } else if(lbl.equals("tbadmin") && args.length >= 1) {
               onTbCommand(sender, args);
               return true;
           } else {
               return false;
           }
        } else {
           sender.sendMessage("Please use /tbadmin");
           return false;
        }
    }
    
    private void onTbCommand(CommandSender sender, String[] args) {
        
    }
    
}
