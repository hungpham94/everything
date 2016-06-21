package com.example.tactantat;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class tungthanhvien extends Activity{
	
	@SuppressWarnings("unused")
	private TextView tieude,sothanhvien;
	private EditText nhapso,manglay[];
	private Button nhapvao;
	private Handler handlerMain;
	private LinearLayout relativeLayout;
	private AtomicBoolean atomic;
	private String t;
	@SuppressWarnings("unused")
	private String d="";
	private boolean vebutton;
	int sobutton;
	int i=0;
	ArrayList<String> sothich;
	
	@SuppressLint("HandlerLeak")
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//relativeLayout=new RelativeLayout(this);
		setContentView(R.layout.signupfirst);
		relativeLayout = (LinearLayout) findViewById(R.id.toancanh);
		khoitao();
		vebutton=false;
		
		Intent intent=getIntent();
		Bundle bundle=intent.getBundleExtra("bundle");
		t=Integer.toString(bundle.getInt("iduser"));
	    System.out.println("toi muon biet t="+t);
		sothich=new ArrayList<String>();
		handlerMain=new Handler()
		 {
		 
		 @Override
		 public void handleMessage(Message msg) {
		 // TODO Auto-generated method stub
		 super.handleMessage(msg);
		 //Nhận nhãn của Button được gửi về từ tiến trình con
		 String nhan_button=msg.obj.toString();
		 //khởi tạo 1 Button
		 TextView b=new TextView(tungthanhvien.this);
		 //thiết lập nhãn cho Button
		 b.setText(nhan_button);
		 b.setTextSize(22);
		 //thiết lập kiểu Layout : Width, Height
		 LayoutParams params=new
		 LayoutParams(LayoutParams.MATCH_PARENT,
		 LayoutParams.WRAP_CONTENT);
		 
		 //thiết lập layout cho Button
		 b.setLayoutParams(params);
		 
		 //đưa Button vào layoutdevebutton
		 relativeLayout.addView(b);
		 EditText c=new EditText(tungthanhvien.this);
		
		 c.setBackgroundColor(Color.rgb(255,
				 255,
				 255));
		 c.setTextSize(30);
		 c.setLayoutParams(params);
		 relativeLayout.addView(c);
		 d=c.getText().toString();
		 manglay[i]=c;
		 i++;
		if(vebutton){ 
			Button bc=new Button(tungthanhvien.this);
			bc.setText("Cap nhap");
			LayoutParams params1=new
					 LayoutParams(LayoutParams.MATCH_PARENT,
					 LayoutParams.WRAP_CONTENT);
			bc.setLayoutParams(params1);
			relativeLayout.addView(bc);
			bc.setOnClickListener(new View.OnClickListener() 
			{
				@Override
				public void onClick(View v) {
					int n=Integer.parseInt(nhapso.getText().toString());
					for(int i=0;i<n;i++)
					{
					   System.out.println("toi thu xem:"+manglay[i].getText().toString());	
					   sothich.add(manglay[i].getText().toString());
					}
					runOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							new capnhapthanhvien().execute("http://192.168.116.1:8080/php/services/capnhapthanhvien.php");
						}
					});
				}
			});
		 }
		 }
		 };
		nhapvao.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				doStart();
			}
		});
		
	}

	private void khoitao() {
		tieude=(TextView)findViewById(R.id.textView2);
		sothanhvien=(TextView)findViewById(R.id.textView1);
		nhapso=(EditText)findViewById(R.id.editText1);
		nhapvao=(Button)findViewById(R.id.button1);
	}
	private void doStart()
	 {
	 atomic=new AtomicBoolean(false);
	 sobutton=Integer.parseInt(nhapso.getText()+"");
	 manglay=new EditText[sobutton];
	 Thread thCon=new Thread(new Runnable() {
	 
	 @Override
	 public void run() {
	 // TODO Auto-generated method stub
	 for(int i=0;i<sobutton && atomic.get();i++)
	 {
	 //nghỉ 200 mili second
	 SystemClock.sleep(200);
	 //lấy message từ Main Thread
	 Message msg=handlerMain.obtainMessage();
	 //gán dữ liệu cho msg Mainthread, lưu vào biến obj
	 //chú ý ta có thể lưu bất kỳ kiểu dữ liệu nào vào obj
	 msg.obj="SO THICH CUA THANH VIEN "+(i+1);
	 //gửi trả lại message cho Mainthread
	 handlerMain.sendMessage(msg);
	 }
	 vebutton=true;
	 }
	 });
	 atomic.set(true);
	 //thực thi tiến trình
	 thCon.start();
	 }
    class capnhapthanhvien extends AsyncTask<String, Integer, String>
    {

		@Override
		protected String doInBackground(String... params) {
			return makePostRequest(params[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
		}
		@SuppressWarnings({ "unchecked", "rawtypes" })
		private String makePostRequest(String u) {
			
		    HttpClient httpClient = new DefaultHttpClient();
		    
		    // URL của trang web nhận request
		    HttpPost httpPost = new HttpPost(u);
		    
		    // Các tham số truyền
		    
			List nameValuePair = new ArrayList((sobutton+2));
		    nameValuePair.add(new BasicNameValuePair("iduser",t));
		    nameValuePair.add(new BasicNameValuePair("sothanhvien",nhapso.getText().toString()));
		    for(int i=0;i<sobutton;i++)
		    {
		    	//System.out.println("neu co em thien duong se co nang:"+sothich.get(i));
		    	nameValuePair.add(new BasicNameValuePair("thanhvien"+i,sothich.get(i)));
		    }
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
		       
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    
		    return kq;
		}
    }
}
