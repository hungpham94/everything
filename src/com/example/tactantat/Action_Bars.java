package com.example.tactantat;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

public class Action_Bars extends Activity
{
   private ShareActionProvider share;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionbar=getActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);
	}
    //cai nay ham de hien thi toan menu action bar khai bao
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		//chi de hien thi meny share
		MenuItem menu1=menu.findItem(R.id.action_share);
		share=(ShareActionProvider) menu1.getActionProvider();
		setIntent("This is example text");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
		{
		case R.id.capture_signature:
		{ Intent intent=new Intent(Action_Bars.this,MainActivity.class);
			  startActivity(intent);
			  break;
		}
		case R.id.action_create_folder:
		{
			Intent intent2=new Intent(Action_Bars.this,Categoty.class);
			startActivity(intent2);
			break;
		}
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void setIntent(String text) {
		//goi hien thi va den menu action _Send
		 Intent intent = new Intent(Intent.ACTION_SEND);
		 intent.setType("text/plain");
		 intent.putExtra(Intent.EXTRA_TEXT, text);
		 share.setShareIntent(intent);
		 }
}
