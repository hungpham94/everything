package com.example.tactantat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tactantat.R;

public class MainActivity2 extends Activity{
    TextView username,password,dangnhap;
    private int success,stv=0,iduser;
    EditText user,pass;
    Button  sigin,sigup;
    private JSONArray json=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		username=(TextView)findViewById(R.id.textView1);
		password=(TextView)findViewById(R.id.textView2);
		dangnhap=(TextView)findViewById(R.id.textView3);
		user=(EditText)findViewById(R.id.editText1);
		pass=(EditText)findViewById(R.id.editText2);
		sigin=(Button)findViewById(R.id.button1);
		sigup=(Button)findViewById(R.id.button2);
		batsukien();
		
	}
	private void batsukien() {
		sigin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(user.getText().equals("")||pass.getText().equals(""))
				{
				 Toast moi=Toast.makeText(MainActivity2.this,"vui long dien day du ten dang nhap "
				 		+ "va password:", Toast.LENGTH_LONG);
				 moi.show();
				}
				else
				{
					runOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							new goiwebservice().execute("http://192.168.116.1:8080/php/services/truyvanten.php");
							
						}
					});
					
				}
			}
		});
		
	}
	class goiwebservice extends AsyncTask<String, Integer, String>
	{

		@Override
		protected String doInBackground(String... params) 
		{
			return makePostRequest(params[0]);
		}
		

		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
		}


		private String makePostRequest(String u) {
			JSONObject jObj=null;
			 success=0;
		    HttpClient httpClient = new DefaultHttpClient();
		    
		    // URL của trang web nhận request
		    HttpPost httpPost = new HttpPost(u);
		    
		    // Các tham số truyền
		    List nameValuePair = new ArrayList(2);
		    nameValuePair.add(new BasicNameValuePair("username",user.getText().toString()));
		    nameValuePair.add(new BasicNameValuePair("password", pass.getText().toString()));
		    
		    //Encoding POST data
		    try {
		        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
		    } catch (UnsupportedEncodingException e) {
		        e.printStackTrace();
		    }

		   String  kq="";
		    try {
		        HttpResponse response = httpClient.execute(httpPost);
		        HttpEntity entity = response.getEntity();
		        kq = EntityUtils.toString(entity);
		        jObj = new JSONObject(kq);
		        success  = jObj.getInt("success");
		        if(success==1)
		        {
		        	json=jObj.getJSONArray("user");
		            iduser=json.getJSONObject(0).getInt("iduser");
		            stv=json.getJSONObject(0).getInt("stv");
		            if(stv!=0)
					{
						Intent intent=new Intent(MainActivity2.this,MainActivity.class);
						Bundle bundle=new Bundle();
						bundle.putInt("iduser", iduser);
						intent.putExtra("bundle", bundle);
						startActivity(intent);
					}
					else
					{
						Intent intent=new Intent(MainActivity2.this,tungthanhvien.class);
						Bundle bundle=new Bundle();
					     //System.out.println("toi muon biet ten="+iduser);
						bundle.putInt("iduser", iduser);
						intent.putExtra("bundle", bundle);
						startActivity(intent);
					}
		           
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    
		    return kq;
		}
		
	}
}
