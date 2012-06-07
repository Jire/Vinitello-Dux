package dux.logging.standard;

import java.util.logging.Logger;

import dux.logging.ILogger;

class StandardLogger implements ILogger {

	private final Logger logger = Logger.getLogger(getClass().getName());

	@Override
	public void info(String message) {
		logger.info(message);
	}

	@Override
	public void warning(String message) {
		logger.warning(message);
	}

	@Override
	public void severe(String message) {
		logger.severe(message);
	}

}