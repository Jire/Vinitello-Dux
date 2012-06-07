package dux.network.netty;

import com.google.inject.Inject;

import dux.network.INetworkProtocolDecoder;
import dux.network.INetworkProtocolEncoder;
import dux.network.base.BaseNetworkProtocol;

public class NettyNetworkProtocol extends BaseNetworkProtocol {

	@Inject
	protected NettyNetworkProtocol(INetworkProtocolEncoder encoder, INetworkProtocolDecoder decoder) {
		super(encoder, decoder);
	}

}