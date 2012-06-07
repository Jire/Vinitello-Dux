package dux.network.base;

import java.io.IOException;
import java.net.Socket;

import dux.network.INetworkSession;

public abstract class BaseNetworkSession implements INetworkSession {

	private final Socket socket;

	protected BaseNetworkSession(Socket socket) {
		this.socket = socket;
	}

	@Override
	public Socket getSocket() {
		return socket;
	}

	@Override
	public void close() throws IOException {
		getSocket().close();
	}

}