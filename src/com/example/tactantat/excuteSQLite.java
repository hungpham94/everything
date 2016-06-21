package com.example.tactantat;


import java.util.ArrayList;

import model.Drink;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class excuteSQLite extends Activity{
    ListView list;
    Button show,insert,update;
    private SQLites database=new SQLites(this);
    private SQLiteDatabase db;
    private ArrayList<Drink> kiemlai;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlites);
		list=(ListView)findViewById(R.id.sqllist);
		show=(Button)findViewById(R.id.show);
		update=(Button)findViewById(R.id.update);
		insert=(Button)findViewById(R.id.insert);
		db=database.getReadableDatabase();
		//database.onCreate(db);
		batsukien();
		
	}
	private void batsukien() {
		
		show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			    kiemlai=database.truyvan(db);
			    System.out.println("neu co em thien duong se co nang");
			    ArrayAdapter<Drink> chido=new ArrayAdapter<Drink>(
			    		excuteSQLite.this,
			    		android.R.layout.simple_list_item_1, 
			    		kiemlai); 
			  list.setAdapter(chido);
		}
		}
		);}
}
