package dux.network.netty;

import java.util.concurrent.Executors;

import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class NettyServerChannelFactory extends NioServerSocketChannelFactory {

	protected NettyServerChannelFactory() {
		super(Executors.newCachedThreadPool(), Executors.newCachedThreadPool());
	}

}