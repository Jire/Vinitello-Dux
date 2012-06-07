package dux.network;

public interface INetworkProtocol {

	public INetworkProtocolEncoder getEncoder();
	public INetworkProtocolDecoder getDecoder();

}