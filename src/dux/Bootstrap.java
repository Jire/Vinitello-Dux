package dux;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;

import dux.encryption.isaac.ISAACEncryptionModule;
import dux.logging.ILogger;
import dux.logging.standard.StandardLoggerModule;
import dux.network.INetworkService;
import dux.network.netty.NettyNetworkModule;
import dux.packet.game.GamePacketModule;
import dux.task.ITaskService;
import dux.task.game.GameTaskModule;

public final class Bootstrap {

	private final ILogger logger;
	private final ITaskService taskService;
	private final INetworkService networkService;

	@Inject
	private Bootstrap(ILogger logger, ITaskService taskService, INetworkService networkService) {
		this.logger = logger;
		this.taskService = taskService;
		this.networkService = networkService;
	}

	private void start() {
		logger.info("Starting initialization...");

		logger.info("Initializing task service...");
		taskService.start();

		logger.info("Initializing network service...");
		networkService.start();

		logger.info("Initialization has completed.");
	}

	private static final Module[] modules = {
		new StandardLoggerModule(),
		new NettyNetworkModule(),
		new GamePacketModule(),
		new GameTaskModule(),
		new ISAACEncryptionModule()
	};

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(Stage.PRODUCTION, modules);

		injector.getInstance(Bootstrap.class).start();
	}

}