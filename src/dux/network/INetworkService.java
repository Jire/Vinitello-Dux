package dux.network;

import java.util.List;

public interface INetworkService {

	public int getPort();
	public List<INetworkClient> getClients();
	public INetworkProtocol getProtocol();

	public void start();
	public boolean started();

}