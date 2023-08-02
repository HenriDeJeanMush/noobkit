package unfair.noobkit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class getCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(s.equalsIgnoreCase("kit")){
            kit.givekit((Player) commandSender,true);
            return true;
        }else if(s.equalsIgnoreCase("givekit")){
            if(args.length==1){
                try {
                    Bukkit.getPlayer(args[0]);
                }catch (NullPointerException nullPointerException){
                    commandSender.sendMessage(ChatColor.RED+"playerが見つかりません");
                    return true;
                }
                kit.givekit(Bukkit.getPlayer(args[0]),false);
            }else {
                commandSender.sendMessage(ChatColor.RED+"/givekit <player>");
                return true;
            }
        }
        return true;
    }
}
