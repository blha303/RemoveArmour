package eu.wServers.RemoveArmour;

import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RemoveArmour extends JavaPlugin
{
	String bad = ChatColor.GOLD + "[RemourArmour] " + ChatColor.RED;
	
	public void onEnable()
	{
		getCommand("removearmour").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if(command.getName().equalsIgnoreCase("removearmour"))
		{
			if(!(sender instanceof BlockCommandSender))
			{
				sender.sendMessage(bad + "Command blocks only.");
				return true;
			}
			
			Player player = getServer().getPlayer(args[0]);
			
			if(player != null)
			{
				player.getInventory().setArmorContents(null);
			}
		}
		
		return true;
	}
}
