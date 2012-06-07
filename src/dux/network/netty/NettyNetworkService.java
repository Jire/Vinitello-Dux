package dux.network.netty;

import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipelineFactory;

import com.google.inject.Inject;

import dux.network.INetworkProtocol;

public class NettyNetworkService extends AbstractNettyNetworkService {

	@Inject
	protected NettyNetworkService(@NettyNetworkPort int port, @NettyNetworkInitialClientCapacity int initialClientCapacity,
			INetworkProtocol protocol, ChannelFactory channelFactory,
			ChannelPipelineFactory pipelineFactory) {
		super(port, initialClientCapacity, protocol, channelFactory, pipelineFactory);
	}

}