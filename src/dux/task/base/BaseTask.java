package dux.task.base;

import dux.task.ITask;

public abstract class BaseTask implements ITask {

	private boolean running = true;

	public void stop() {
		if (!isRunning()) {
			throw new IllegalStateException("Task is already stopped!");
		}
		running = false;
	}

	public boolean isRunning() {
		return running;
	}

	protected abstract void execute();

	@Override
	public boolean run() {
		execute();
		return isRunning();
	}

}