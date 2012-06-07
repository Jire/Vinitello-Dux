package dux.task.cycled;

import dux.task.base.BaseTask;

public abstract class CycledTask extends BaseTask {

	private final int cycles;
	private int countdown;

	public CycledTask(int cycles) {
		this.cycles = cycles;
		this.countdown = cycles;
	}

	@Override
	public boolean run() {
		if (countdown-- == 0) {
			countdown = cycles;
			return super.run();
		}
		return false;
	}

}