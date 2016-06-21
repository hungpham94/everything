package com.example.tactantat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends Activity {
    ImageView img;
    ListView list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main1);
		img=(ImageView) findViewById(R.id.imageView1);
		list=(ListView)findViewById(R.id.listView1);
		AdapterView.OnItemClickListener onclick=new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent=new Intent(MainActivity.this,Categoty.class);
				Bundle bundle=new Bundle();
				bundle.putInt("hu",position);
				intent.putExtra("abc",bundle);
         	    startActivity(intent);
			}
		};
		list.setOnItemClickListener(onclick);
		
	}

}
