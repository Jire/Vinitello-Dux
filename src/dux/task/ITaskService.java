package dux.task;

public interface ITaskService {

	public void start();
	public void shutdown();

	public void submit(ITask task);

}