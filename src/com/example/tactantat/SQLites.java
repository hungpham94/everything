package com.example.tactantat;

import java.util.ArrayList;

import model.Drink;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLites extends SQLiteOpenHelper{
    private final static String Data_Name="tactantat";
    private final static int Data_version=1;
	public SQLites(Context context) {
		super(context, Data_Name, null, Data_version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql="create table drink ("
				+ "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "NAME TEXT NOT NULL,"
				+ "DESCRIPTION NOT NULL,"
				+ "IMAGE_SOURCE INTEGER NOT NULL )";
	            db.execSQL(sql);
	            themdulieu("Latte", "Espresso and steamed milk",R.drawable.latte, db);
	            themdulieu( "Cappuccino", "Espresso, hot milk and steamed-milk foam",
	             R.drawable.cappuccino,db);
	           themdulieu("Filter", "Our best drip coffee", R.drawable.filter,db);
	          
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	public void themdulieu(String name,String Description,int hinhanh,SQLiteDatabase db)
	{
		ContentValues drinkcontent=new ContentValues();
		drinkcontent.put("Name",name);
		drinkcontent.put("DESCRIPTION",Description);
		drinkcontent.put("IMAGE_SOURCE", hinhanh);
		db.insert("drink", null, drinkcontent);
	}
 
    public ArrayList<Drink> truyvan(SQLiteDatabase db)
   {
	   ArrayList<Drink> layhet=new ArrayList<Drink>();
	   Cursor cs=db.query("drink",new String[]{"NAME","DESCRIPTION","IMAGE_SOURCE"},null, null, null, null, null);
	   if(cs.moveToFirst())
	   {
		  Drink dr=new Drink(cs.getString(0),cs.getString(1),cs.getInt(2));
		  layhet.add(dr);
		  
	   }
	  while(cs.moveToNext())
		   {
		  Drink dr2=new Drink(cs.getString(0),cs.getString(1),cs.getInt(2));
		   layhet.add(dr2);
		   }
	   return layhet;
   }
}
