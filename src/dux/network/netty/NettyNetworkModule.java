package dux.network.netty;

import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipelineFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import dux.network.INetworkProtocol;
import dux.network.INetworkProtocolDecoder;
import dux.network.INetworkProtocolEncoder;
import dux.network.INetworkService;

public class NettyNetworkModule extends AbstractModule {

	private static final int INITIAL_CLIENT_CAPACITY = 2000;
	private static final int PORT = 43594;

	@Override
	protected void configure() {
		bindConstant().annotatedWith(NettyNetworkInitialClientCapacity.class).to(INITIAL_CLIENT_CAPACITY);
		bindConstant().annotatedWith(NettyNetworkPort.class).to(PORT);

		bind(INetworkService.class).to(NettyNetworkService.class).in(Scopes.SINGLETON);
		bind(INetworkProtocol.class).to(NettyNetworkProtocol.class).in(Scopes.SINGLETON);
		bind(INetworkProtocolDecoder.class).to(NettyNetworkProtocolDecoder.class).in(Scopes.SINGLETON);
		bind(INetworkProtocolEncoder.class).to(NettyNetworkProtocolEncoder.class).in(Scopes.SINGLETON);

		bind(ChannelFactory.class).to(NettyServerChannelFactory.class).in(Scopes.SINGLETON);
		bind(ChannelPipelineFactory.class).to(NettyChannelPipelineFactory.class).in(Scopes.SINGLETON);
	}

}