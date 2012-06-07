package dux.task.base;

import java.util.ArrayList;
import java.util.List;

import dux.task.ITask;
import dux.task.ITaskService;

public abstract class BaseTaskService extends Thread implements ITaskService {

	private final List<ITask> tasks;

	private boolean running;

	protected BaseTaskService(String threadName, int initialTaskCapacity) {
		super(threadName);
		this.tasks = new ArrayList<ITask>(initialTaskCapacity);
	}

	protected synchronized List<ITask> getTasks() {
		return tasks;
	}

	public boolean isRunning() {
		return running;
	}

	@Override
	public void submit(ITask task) {
		tasks.add(task);
	}

	@Override
	public void start() {
		if (running) {
			throw new IllegalStateException("Task service has already been started");
		}
		running = true;
		super.start();
	}

	@Override
	public void shutdown() {
		if (!running) {
			throw new IllegalStateException("Task service has not been started");
		}
		running = false;
	}

}