package eu.wServers.RemoveArmour;

import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RemoveArmour extends JavaPlugin
{
	String bad = ChatColor.GOLD + "[RemoveArmour] " + ChatColor.RED;
	String good = ChatColor.GOLD + "[RemoveArmour] " + ChatColor.GREEN;
	
	public void onEnable()
	{
		getCommand("removearmour").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		Player player = null;
		if(command.getName().equalsIgnoreCase("removearmour"))
		{
			if (args.length != 1) // If player argument not provided...
			{
				if (sender instanceof Player) // If it's a player sending the command
				{
					player = (Player)sender;
					if (!player.hasPermission("removearmour.use")) // If the player doesn't have permission
					{
						sender.sendMessage(bad + "You can't use this command.");
						return true;
					}
				} else // If it's any other source not providing the player argument
				{
					sender.sendMessage(bad + " Player argument required.");
					return false;
				}
			} else // If player argument is provided
			{
				player = getServer().getPlayer(args[0]);
			}

			if(player != null)
			{
				player.getInventory().setArmorContents(null);
			} else
			{
				sender.sendMessage(bad + "Could not find targeted player.");
				return false;
			}
		}
		
		return true;
	}
}
