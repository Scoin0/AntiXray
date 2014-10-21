package net.scoin0.antixray;

import java.util.ArrayList;

import net.canarymod.Canary;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.BlockDestroyHook;
import net.canarymod.plugin.PluginListener;

public class XrayListener implements PluginListener{
	
	ArrayList<String> list = new ArrayList();
	
	@HookHandler
	public boolean onBlockBreak(BlockDestroyHook hook){
		Player player = hook.getPlayer();
		Block block = hook.getBlock();
		
		if(player.hasPermission("antixray.enable")){
			if((block.getTypeId() == 16) && !list.contains(player.getName())){
				//player.notice("Debug: You broke Coal!");
				Canary.getServer().broadcastMessage("§8 " + player.getName() + " found Coal!");
				list.add(player.getName());
				time(list, 5 * 1000, player.getName());
			}else if((block.getTypeId() == 15) && !list.contains(player.getName())){
				//player.notice("Debug: You broke Iron!");
				Canary.getServer().broadcastMessage("§8 " + player.getName() + " found Iron!");
				list.add(player.getName());
				time(list, 5 * 1000, player.getName());
			}else if((block.getTypeId() == 14) && !list.contains(player.getName())){
				//player.notice("Debug: You broke Gold!");
				Canary.getServer().broadcastMessage("§8 " + player.getName() + " found Gold!");
				list.add(player.getName());
				time(list, 5 * 1000, player.getName());
			}else if((block.getTypeId() == 56) && !list.contains(player.getName())){
				//player.notice("Debug: You broke Diamond"!);
				Canary.getServer().broadcastMessage("§8 " + player.getName() + " found Diamond!");
				list.add(player.getName());
				time(list, 5 * 1000, player.getName());
			}else if((block.getTypeId() == 21) && !list.contains(player.getName())){
				//player.notice("Debug: You broke Lapis!");
				Canary.getServer().broadcastMessage("§8 " + player.getName() + " found Iron!");
				list.add(player.getName());
				time(list, 5 * 1000, player.getName());
			}else if((block.getTypeId() == 73) || (block.getTypeId() == 74) && !list.contains(player.getName())){
				//player.notice("Debug: You broke Redstone!");
				Canary.getServer().broadcastMessage("§8 " + player.getName() + " found Redstone!");
				list.add(player.getName());
				time(list, 5 * 1000, player.getName());
			}
		}	
		return false;
	}
	
	
	public void time(final ArrayList<String> list, final int t, final String s){
		new Thread(){
			public void run(){
				try{
					Thread.sleep(t);
					list.remove(s);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}.start();
	}

}
