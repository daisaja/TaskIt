package de.daisaja.android.taskit.service;

import java.util.ArrayList;
import java.util.List;

import de.daisaja.android.taskit.domain.Task;

public class TaskService {

	public TaskService() {
		tasks.add(new Task(0, "123"));
		tasks.add(new Task(0, "456"));
		tasks.add(new Task(0, "789"));
	}

	private final List<Task> tasks = new ArrayList<Task>();

	public List<String> getAllTasks() {
		// TODO fix it
		return new ArrayList<String>(); // tasks;
	}

	public void addTask(Task task) {
		tasks.add(task);
	}

	public void removeTask(int taskId) {
		tasks.remove(taskId);
	}

}
