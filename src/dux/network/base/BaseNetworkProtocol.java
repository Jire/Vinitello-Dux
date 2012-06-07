package dux.network.base;

import dux.network.INetworkProtocol;
import dux.network.INetworkProtocolDecoder;
import dux.network.INetworkProtocolEncoder;

public abstract class BaseNetworkProtocol implements INetworkProtocol {

	private final INetworkProtocolEncoder encoder;
	private final INetworkProtocolDecoder decoder;

	protected BaseNetworkProtocol(INetworkProtocolEncoder encoder, INetworkProtocolDecoder decoder) {
		this.encoder = encoder;
		this.decoder = decoder;
	}

	@Override
	public INetworkProtocolEncoder getEncoder() {
		return encoder;
	}

	@Override
	public INetworkProtocolDecoder getDecoder() {
		return decoder;
	}

}