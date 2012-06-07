package dux.logging.standard;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import dux.logging.ILogger;

public class StandardLoggerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ILogger.class).to(StandardLogger.class).in(Scopes.SINGLETON);
	}

}