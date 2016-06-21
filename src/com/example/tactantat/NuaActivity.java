package com.example.tactantat;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class NuaActivity extends Activity {
    private ImageView img;
    private ListView list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity);
		img=(ImageView)findViewById(R.id.imageView1);
		list=(ListView) findViewById(R.id.listView1);
		ArrayList<String> component=new ArrayList<String>();
		component.add("Drink");
		component.add("Food");
		component.add("Cookie");
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
				component);
	    list.setAdapter(adapter);
	    list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				  if(position==0)
				  {
					  Intent intent=new Intent(NuaActivity.this, Categoty.class);
					  startActivity(intent);
				  }
			}
		});
	}
   
}
