package com.adamedw.rainbowsheep;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.adamedw.rainbowsheep.configuration.RSConfiguration;
import com.adamedw.rainbowsheep.listener.ListenerSpawn;

public class RainbowSheep extends JavaPlugin {


	private static RainbowSheep i;
	public static RainbowSheep get() { return RainbowSheep.i; }

	private Random random;
	public Random getRandom() { return this.random; }

	private RSConfiguration config;
	public RSConfiguration getConfigRS() { return this.config; }

	@Override
	public void onEnable()
	{
		RainbowSheep.i = this;
		RainbowSheep.get().random = new Random();
		RainbowSheep.get().config = new RSConfiguration();

		Bukkit.getPluginManager().registerEvents(new ListenerSpawn(), RainbowSheep.get());
	}

	@Override
	public void onDisable()
	{
		RainbowSheep.i = null;
	}

}