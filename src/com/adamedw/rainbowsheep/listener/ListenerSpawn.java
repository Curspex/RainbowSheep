package com.adamedw.rainbowsheep.listener;

import org.bukkit.DyeColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.adamedw.rainbowsheep.RainbowSheep;

public class ListenerSpawn implements Listener {


	private DyeColor[] values = DyeColor.values();


	@EventHandler
	public void onSpawn(CreatureSpawnEvent event)
	{
		if (!event.getEntityType().equals(EntityType.SHEEP)) return;

		if (RainbowSheep.get().getConfigRS().getBlacklist().contains(event.getSpawnReason())) return;

		((Sheep) event.getEntity()).setColor(values[RainbowSheep.get().getRandom().nextInt(values.length)]);
	}


}