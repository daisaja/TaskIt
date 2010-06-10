package de.daisaja.android.taskit.domain;

import java.util.Date;

public class Task {
	private int id;
	private String description;
	private String note;
	private Date dueDate;
	private Date startDate;
	private Date finishedDate;

	public Task(int taskId, String description) {
		this.id = taskId;
		this.description = description;
	}

	public Task(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishedDate() {
		return finishedDate;
	}

	public void setFinishedDate(Date finishedDate) {
		this.finishedDate = finishedDate;
	}

	@Override
	public String toString() {
		return this.description;
	}

}
