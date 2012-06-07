package dux.boot;

import com.google.inject.Module;

import dux.encryption.isaac.ISAACEncryptionModule;
import dux.logging.standard.StandardLoggerModule;
import dux.network.netty.NettyNetworkModule;
import dux.packet.game.GamePacketModule;
import dux.task.game.GameTaskModule;

public class BootstrapBuilder {

	private static final Module[] DEFAULT_MODULES = {
		new StandardLoggerModule(),
		new ISAACEncryptionModule(),
		new NettyNetworkModule(),
		new GamePacketModule(),
		new GameTaskModule()
	};

	public BootstrapBuilderFinalizer withModules(Module... modules) {
		return new BootstrapBuilderFinalizer(modules);
	}

	public BootstrapBuilderFinalizer withDefaultModules() {
		return withModules(DEFAULT_MODULES);
	}

}