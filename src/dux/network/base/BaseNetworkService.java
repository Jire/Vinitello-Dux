package dux.network.base;

import java.util.ArrayList;
import java.util.List;

import dux.network.INetworkClient;
import dux.network.INetworkProtocol;
import dux.network.INetworkService;

public abstract class BaseNetworkService implements INetworkService {

	private final int port;
	private final List<INetworkClient> clients;
	private final INetworkProtocol protocol;

	private boolean started;

	protected BaseNetworkService(int port, int initialClientCapacity, INetworkProtocol protocol) {
		this.clients = new ArrayList<INetworkClient>(initialClientCapacity);
		this.port = port;
		this.protocol = protocol;
	}

	@Override
	public int getPort() {
		return port;
	}

	@Override
	public List<INetworkClient> getClients() {
		return clients;
	}

	@Override
	public INetworkProtocol getProtocol() {
		return protocol;
	}

	@Override
	public void start() {
		if (started()) {
			throw new IllegalStateException("The network service is already started!");
		}

		configure();
		bind();
		started = true;
	}

	protected abstract void configure();
	protected abstract void bind();

	@Override
	public boolean started() {
		return started;
	}

}