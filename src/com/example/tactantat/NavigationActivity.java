package com.example.tactantat;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NavigationActivity extends Activity{
    ListView list;
    String titles[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		list=(ListView)findViewById(R.id.drawer);
		titles=getResources().getStringArray(R.array.navigation);
		ArrayAdapter<String> moi=new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_activated_1, 
				titles);
		list.setAdapter(moi);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				selectItem(position);
				
			}
		});
	}
	private void selectItem(int position) {
		 Fragment fragment;
		 switch(position) {
		 case 1:
		 fragment = new pizzas();
		 break;
		 case 2:
		 fragment = new pastafragment();
		 break;
		 case 3:
		 fragment = new store();
		 break;
		 default:
		 fragment = new topfragment();
		 }
		 FragmentTransaction ft = getFragmentManager().beginTransaction();
		 ft.replace(R.id.content_frame, fragment);
		 ft.addToBackStack(null);
		 ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		 ft.commit();
	}
 
}
