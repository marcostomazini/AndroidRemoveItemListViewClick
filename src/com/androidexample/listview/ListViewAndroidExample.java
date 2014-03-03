package com.androidexample.listview;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewAndroidExample extends Activity {
	ListView listView ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_android_example);
		
		listView = (ListView) findViewById(R.id.list);
		String[] values = new String[] { "Android List View", "Adapter implementation", "Simple List View In Android",
		  "Create List View Android", "Android Example", "List View Source Code", "List View Array Adapter", "Android Example List View" };

		// Define a new Adapter
		// First parameter - Context
		// Second parameter - Layout for the row
		// Third parameter - ID of the TextView to which the data is written
		// Forth - the Array of data

		final ArrayList<String> lst  = new ArrayList<String>();
		lst.addAll(Arrays.asList(values));
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, lst); 
		
		// Assign adapter to ListView
		listView.setAdapter(adapter); 
		
		final Button btnOcupada = (Button) findViewById(R.id.button1);
		btnOcupada.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {				
				lst.remove(adapter.getItem(2));
				adapter.notifyDataSetChanged();
			}
		});
		
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			  @Override
			  public void onItemClick(AdapterView<?> parent, View view,
			    int position, long id) {
				
		       // ListView Clicked item index
			   int itemPosition     = position;
			   
			   // ListView Clicked item value
			   String  itemValue    = (String) listView.getItemAtPosition(position);
				  
			   //adapter.remove((String) listView.getItemAtPosition(position));
			   
			    // Show Alert 
			    Toast.makeText(getApplicationContext(),
			      "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_SHORT)
			      .show();
			 

			    
			    Toast.makeText(getApplicationContext(),
			    		adapter.getItem(2), Toast.LENGTH_SHORT)
					      .show();
					      
				//adapter.remove(adapter.getPosition(2));
				//adapter.notifyDataSetChanged();
			  }

			
			}); 
		
	}

}
