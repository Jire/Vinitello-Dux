package dux.task.game;

import com.google.inject.Inject;

import dux.logging.ILogger;
import dux.task.cycled.CycledTaskService;

class GameTaskService extends CycledTaskService {

	@Inject
	protected GameTaskService(ILogger logger, @GameCycleLength int cycleLength) {
		super(logger, "Task Service", 10_000, cycleLength);
	}

}