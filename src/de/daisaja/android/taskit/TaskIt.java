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

		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				taskService.getAllTasks()));

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				Toast.makeText(getApplicationContext(),
						((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});

		plusButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				taskService.addTask(new Task(taskInput.getText().toString()));
				Toast.makeText(getApplicationContext(),
						taskInput.getText().toString(), Toast.LENGTH_SHORT)
						.show();
				setListAdapter(new ArrayAdapter<String>(TaskIt.this,
						R.layout.list_item, taskService.getAllTasks()));
			}
		});

		registerForContextMenu(getListView());
	}
}