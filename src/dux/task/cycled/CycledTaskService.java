package dux.task.cycled;

import java.util.Iterator;

import dux.logging.ILogger;
import dux.task.ITask;
import dux.task.base.BaseTaskService;

public abstract class CycledTaskService extends BaseTaskService {

	private final ILogger logger;
	private final int cycleLength;

	protected CycledTaskService(ILogger logger, String threadName, int initialTaskCapacity, int cycleLength) {
		super(threadName, initialTaskCapacity);
		this.logger = logger;
		this.cycleLength = cycleLength;
	}

	protected ILogger getLogger() {
		return logger;
	}

	protected int getCycleLength() {
		return cycleLength;
	}

	@Override
	public void run() {
		long lastCycle = 0;
		long systemTime;

		while (isRunning()) {
			systemTime = System.currentTimeMillis();
			if ((systemTime - lastCycle) > getCycleLength()) {
				if (getTasks().size() > 0) {
					Iterator<ITask> it = getTasks().iterator();
					while (it.hasNext()) {
						if (!it.next().run())
							it.remove();
					}
				}
				long timeTaken = System.currentTimeMillis() - systemTime;
				if (timeTaken > getCycleLength()) {
					logger.warning("Engine overloaded by " + ((timeTaken / cycleLength) * 100) + "%");
				} else {
					try {
						sleep(getCycleLength() - timeTaken);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}