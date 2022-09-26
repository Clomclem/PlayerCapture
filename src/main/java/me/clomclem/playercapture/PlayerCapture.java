package me.clomclem.playercapture;

import net.fabricmc.api.DedicatedServerModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerCapture implements DedicatedServerModInitializer {
	public static final String MOD_ID = PlayerCapture.class.getSimpleName().toLowerCase();
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeServer() {

		LOGGER.info("Hello Fabric world!");
	}
}
