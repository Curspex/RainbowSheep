package com.adamedw.rainbowsheep.configuration;

import java.util.Set;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import com.adamedw.rainbowsheep.RainbowSheep;
import com.google.common.collect.Sets;

public class RSConfiguration {


	private final FileConfiguration config;
	public RSConfiguration()
	{
		this.config = RainbowSheep.get().getConfig();
		this.config.options().copyDefaults(true);
		RainbowSheep.get().saveConfig();
		this.populate();
	}

	private void populate()
	{
		this.spawnReasonBlacklist = Sets.newHashSet();
		for (String str : this.config.getStringList("creatureSpawnReasonBlacklist"))
		{
			this.spawnReasonBlacklist.add(SpawnReason.valueOf(str));
		}
	}

	private Set<SpawnReason> spawnReasonBlacklist;
	public Set<SpawnReason> getBlacklist() { return this.spawnReasonBlacklist; }


}