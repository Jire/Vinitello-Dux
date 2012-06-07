package dux.network;

import java.util.UUID;

public interface INetworkClient {

	public UUID getUUID();
	public INetworkSession getSession();

}