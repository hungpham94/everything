package com.example.tactantat;


import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class pizzas extends ListFragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ArrayAdapter<String> chuoi=new ArrayAdapter<String>(inflater.getContext(),
				android.R.layout.simple_list_item_1, 
				getResources().getStringArray(R.array.pizzas));
		  setListAdapter(chuoi);
		return super.onCreateView(inflater, container, savedInstanceState);
	}

}
