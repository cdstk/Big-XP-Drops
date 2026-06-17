package bigxpdrops.handlers;

import bigxpdrops.BigXPDrops;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = BigXPDrops.MODID)
public class ForgeConfigHandler {
	
	@Config.Comment("Server-Side Options")
	@Config.Name("Server Options")
	public static final ServerConfig server = new ServerConfig();

	public static class ServerConfig {

		@Config.Comment({
				"This value determines when biggest possible xp orb will drop, if the total xp value is this or higher, drop a single orb.",
				"Vanilla has each split step be a prime number that is about 2x more than the previous step.",
				"The largest vanilla orb has a value of 2477",
				"Setting a value lower than a vanilla step will override the limit and drop a big xp orb"
		})
		@Config.Name("Big XP Drop Threshold")
		public int bigStartThreshold = 19853;
	}

	@Mod.EventBusSubscriber(modid = BigXPDrops.MODID)
	private static class EventHandler{

		@SubscribeEvent
		public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
			if(event.getModID().equals(BigXPDrops.MODID)) {
				ConfigManager.sync(BigXPDrops.MODID, Config.Type.INSTANCE);
			}
		}
	}
}