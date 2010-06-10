package de.daisaja.android.taskit;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import de.daisaja.android.taskit.domain.Task;
import de.daisaja.android.taskit.service.TaskService;

public class TaskIt extends ListActivity {

	private final TaskService taskService = new TaskService();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.taskit_start);

		ListView listView = getListView();
		listView.setTextFilterEnabled(true);

		final Button plusButton = (Button) findViewById(R.id.buttonOk);
		final EditText taskInput = (EditText) findViewById(R.id.taskInput);

		refreshListView();

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				showToast(((TextView) view).getText());
			}
		});

		plusButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				final String taskDescription = taskInput.getText().toString();
				// Reset input field.
				taskInput.setText("");

				taskService.addTask(new Task(taskDescription));

				showToast(taskDescription);

				refreshListView();
			}
		});

		registerForContextMenu(getListView());
	}

	/* -------------- GUI Helper methods ----------------------------------- */

	/**
	 * Calls {@link TaskService} to load all tasks to show and creates and sets
	 * a new {@link ArrayAdapter}.
	 */
	private void refreshListView() {
		setListAdapter(new ArrayAdapter<Task>(this, R.layout.list_item,
				taskService.getAllTasks()));
	}

	/**
	 * Creates and shows a short toast on current activity.
	 * 
	 * @param text
	 *            to show in toast.
	 */
	private void showToast(final CharSequence text) {
		Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT)
				.show();
	}
}