package dux.packet.game;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import dux.packet.IPacketService;

public class GamePacketModule extends AbstractModule {

	private static final int REGISTRY_CAPACITY = 256;

	@Override
	protected void configure() {
		bindConstant().annotatedWith(GameRegistryCapacity.class).to(REGISTRY_CAPACITY);
		bind(IPacketService.class).to(GamePacketService.class).in(Scopes.SINGLETON);
	}

}