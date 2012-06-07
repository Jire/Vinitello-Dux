package dux.logging;

public interface ILogger {

	public void info(String message);
	public void warning(String message);
	public void severe(String message);

}