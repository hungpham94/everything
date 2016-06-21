package com.example.tactantat;

import model.Cookie;
import model.Drink;
import model.Food;
import model.common;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Categoty extends ListActivity {
	private ListView list;
	private ArrayAdapter<common> moi;
	private int sochon;
	//private final static String somoi="sochon";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent1=getIntent();
		Bundle conkhi=intent1.getBundleExtra("abc");
		sochon=conkhi.getInt("hu");
		if(sochon==0)
		{
		moi=new ArrayAdapter<common>(this, android.R.layout.simple_list_item_1,Drink.drink);
		}
		else if(sochon==1)
		{
			moi=new ArrayAdapter<common>(this, android.R.layout.simple_list_item_1,Food.food);
		}
		else
		moi=new ArrayAdapter<common>(this, android.R.layout.simple_list_item_1,Cookie.cookie);
		list=getListView();
		list.setAdapter(moi);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				     Intent intent=new Intent(Categoty.this,Detail.class);
				     Bundle bundle=new Bundle();
				     bundle.putInt("giatri", (sochon*10+position));
				     intent.putExtra("goidetail", bundle);
				     startActivity(intent);
			}
		});
}
}
