package dux.packet.game;

import com.google.inject.Inject;

import dux.packet.base.BasePacketService;

class GamePacketService extends BasePacketService {

	@Inject
	protected GamePacketService(@GameRegistryCapacity int initialRegistryCapacity) {
		super(initialRegistryCapacity);
	}

}