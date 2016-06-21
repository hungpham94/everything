package com.example.tactantat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Detail extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent=getIntent();
		Bundle bundle=intent.getBundleExtra("goidetail");
		int sogoi=bundle.getInt("giatri");
        if(sogoi<10)
        {
        	if(sogoi==0)System.out.println("tau vua chon drink coffee");
        	else if(sogoi==1)System.out.println("tau vua chon drink beer");
        	else System.out.println("tau vua chon drink water");
        }
        else if(20<=sogoi&& sogoi<30)
        {
        	if(sogoi==10)System.out.println("tau vua chon cookie bread");
        	else if(sogoi==11)System.out.println("tau vua chon cookie cube");
        	else System.out.println("tau vua chon cookie sanwitch");
        }
        else
        {
        	if(sogoi==10)System.out.println("tau vua chon food fried eeg");
        	else if(sogoi==11)System.out.println("tau vua chon chicken boil");
        	else System.out.println("tau vua chon snake meat");
        }
	}
    
}
