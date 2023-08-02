package unfair.noobkit;

import com.google.common.base.Stopwatch;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Boss;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import sun.jvm.hotspot.opto.CallJavaNode;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class kit {

    public static void givekit(Player player,Boolean cooldown){
        int nullinventory=-5;
        for(int i=0;i<player.getInventory().getSize();i++){
            if(player.getInventory().getItem(i)==null){
                nullinventory++;
            }
        }
        if(player.getInventory().getHelmet()!=null){
            player.sendMessage(ChatColor.RED+"装備をすべて脱いでください");
            return;
        }
        if(player.getInventory().getChestplate()!=null){
            player.sendMessage(ChatColor.RED+"装備をすべて脱いでください");
            return;
        }
        if(player.getInventory().getLeggings()!=null){
            player.sendMessage(ChatColor.RED+"装備をすべて脱いでください");
            return;
        }
        if(player.getInventory().getBoots()!=null){
            player.sendMessage(ChatColor.RED+"装備をすべて脱いでください");
            return;
        }
        if(nullinventory<7){
            player.sendMessage(ChatColor.RED+"inventoryを7つ以上空けてください");
            return;
        }
        if(cooldown){
            try {
                Date d = new Date();
                long oldd = Noobkit.getPl().getConfig().getLong(player.getUniqueId().toString());
                if (d.getTime()-oldd<3600000){
                    //3600000
                    long t = d.getTime()-oldd;
                    long time = 3600000-t;
                    time/=1000;
                    long minnit = time/60;
                    long seccond = time%60;
//                    minnit = 60-minnit;
//                    seccond = 60-seccond;
                    String string = minnit+"分"+seccond+"秒";
                    player.sendMessage(ChatColor.RED+"残り"+ ChatColor.RED+string);
                    return;
                }else {
                    Noobkit.getPl().getConfig().set(player.getUniqueId().toString(),d.getTime());
                    Noobkit.getPl().saveConfig();
                    Noobkit.getPl().reloadConfig();
                }
            }catch (NullPointerException nullPointerException){
                Date d = new Date();
                Noobkit.getPl().getConfig().set(player.getUniqueId().toString(),d.getTime());
                Noobkit.getPl().saveConfig();
                Noobkit.getPl().reloadConfig();
            }
        }
        //givekit
        player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
        player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF,10));
        player.getInventory().addItem(new ItemStack(Material.SHIELD));
        player.getInventory().addItem(new ItemStack(Material.IRON_AXE));
        player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE));
        player.getInventory().addItem(new ItemStack(Material.IRON_SHOVEL));
        player.getInventory().addItem(new ItemStack(Material.IRON_HOE));
        player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
        player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
        player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
        player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));

    }

}
