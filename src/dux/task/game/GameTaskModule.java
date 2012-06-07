package dux.task.game;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import dux.task.ITaskService;

public class GameTaskModule extends AbstractModule {

	private static final int CYCLE_LENGTH = 600;

	@Override
	protected void configure() {
		bindConstant().annotatedWith(GameCycleLength.class).to(CYCLE_LENGTH);
		bind(ITaskService.class).to(GameTaskService.class).in(Scopes.SINGLETON);
	}

}