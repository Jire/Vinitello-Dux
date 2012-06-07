package dux.network.base;

import java.util.UUID;

import dux.network.INetworkClient;
import dux.network.INetworkSession;

public abstract class BaseNetworkClient implements INetworkClient {

	private final UUID uuid;
	private final INetworkSession session;

	protected BaseNetworkClient(UUID uuid, INetworkSession session) {
		this.uuid = uuid;
		this.session = session;
	}

	protected BaseNetworkClient(INetworkSession session) {
		this(UUID.randomUUID(), session);
	}

	@Override
	public UUID getUUID() {
		return uuid;
	}

	@Override
	public INetworkSession getSession() {
		return session;
	}

}