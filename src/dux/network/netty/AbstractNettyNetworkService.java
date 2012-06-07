package dux.network.netty;

import java.net.InetSocketAddress;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipelineFactory;

import dux.network.INetworkProtocol;
import dux.network.base.BaseNetworkService;

public abstract class AbstractNettyNetworkService extends BaseNetworkService {

	private final ServerBootstrap bootstrap;
	private final ChannelPipelineFactory pipelineFactory;

	protected AbstractNettyNetworkService(int port, int initialClientCapacity, INetworkProtocol protocol,
			ChannelFactory channelFactory, ChannelPipelineFactory pipelineFactory) {
		super(port, initialClientCapacity, protocol);
		this.bootstrap = new ServerBootstrap(channelFactory);
		this.pipelineFactory = pipelineFactory;
	}

	protected ServerBootstrap getBootstrap() {
		return bootstrap;
	}

	protected ChannelPipelineFactory getPipelineFactory() {
		return pipelineFactory;
	}

	@Override
	protected void configure() {
		getBootstrap().setPipelineFactory(getPipelineFactory());
	}

	@Override
	protected void bind() {
		getBootstrap().bind(new InetSocketAddress(getPort()));
	}

}