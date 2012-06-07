package dux.network;

import java.net.Socket;

public interface INetworkSession extends AutoCloseable {

	public Socket getSocket();

}