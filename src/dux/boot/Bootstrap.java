package dux.boot;

import com.google.inject.Inject;

import dux.logging.ILogger;
import dux.network.INetworkService;
import dux.task.ITaskService;

public class Bootstrap {

	private final ILogger logger;
	private final ITaskService taskService;
	private final INetworkService networkService;

	@Inject
	protected Bootstrap(ILogger logger, ITaskService taskService, INetworkService networkService) {
		this.logger = logger;
		this.taskService = taskService;
		this.networkService = networkService;
	}

	protected ILogger getLogger() {
		return logger;
	}

	protected ITaskService getTaskService() {
		return taskService;
	}

	protected INetworkService getNetworkService() {
		return networkService;
	}

	public void start() {
		getLogger().info("Starting initialization...");

		getLogger().info("Initializing task service...");
		getTaskService().start();

		getLogger().info("Initializing network service...");
		getNetworkService().start();

		getLogger().info("Initialization has completed.");
	}

}