package net.scoin0.antixray;

import net.canarymod.Canary;
import net.canarymod.plugin.Plugin;

public class AntiXray extends Plugin{
	
	public static String Plugin_Name = "AntiXray ";
	public static String Plugin_Version = "1.0.6 ";
	public static String Plugin_Author = "Scoin0 ";
	
	public boolean enable() {
		getLogman().info(Plugin_Name + Plugin_Version + "created by " + Plugin_Author + "has been enabled!");
		
		Canary.hooks().registerListener(new XrayListener(), this);
		
		return true;
	}

	public void disable() {
		getLogman().info(Plugin_Name + "has been Disabled!");
	}
}

//##### To Do List #####//
//1. Rewrite Configuration File <--- This is not implemented during the recode.
//2. Rewrite Plugin (Add the ideas in my idea book)
//3. Find a simpler way to do everything.