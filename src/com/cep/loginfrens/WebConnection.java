package com.cep.loginfrens;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.Toast;

public class WebConnection {
	String wcUrl;
	
	
	public WebConnection(String geturl) {
		// TODO Auto-generated constructor stub
		wcUrl = geturl;	
	}

	public String DownloadText(Context c,Boolean o, String sid)
	{
	int BUFFER_SIZE = 2000;
	InputStream in = null;
	
	try {
	 in = OpenHTTPConnection(wcUrl, o, sid);
	
	
	} catch (IOException e1) {
	// TODO Auto-generated catch block
		Toast.makeText(c, e1.getLocalizedMessage(),
	            Toast.LENGTH_SHORT).show();
	e1.printStackTrace();
	return "";
	}
	InputStreamReader isr = new InputStreamReader(in);
	int charRead;
	String str = "";
	char[] inputBuffer = new char[BUFFER_SIZE];
	try {
	while ((charRead = isr.read(inputBuffer))>0)
	{
	//---convert the chars to a String---
	String readString =
	String.copyValueOf(inputBuffer, 0, charRead);
	str += readString;
	inputBuffer = new char[BUFFER_SIZE];
	}
	in.close();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return "";
	}
	return str;
	}
	
	//
	public Bitmap DownloadImage(String iurl)
	{
		Bitmap bitmap = null;
		InputStream in = null;
		
		try {
		in = OpenHTTPConnection(iurl, false, "");
		//bitmap = BitmapFactory.decodeByteArray(in);
		
		bitmap = BitmapFactory.decodeStream(in);
		in.close();
		} catch (IOException e1) {
		// TODO Auto-generated catch block
			
		e1.printStackTrace();
		}
		return bitmap;
		}
		
		private InputStream OpenHTTPConnection(String urlString, Boolean isOutput, String setid ) throws IOException
		{
		InputStream in = null;
		StringBuilder sb = new StringBuilder();
		
		sb.append(setid);
		int response = -1;
		
		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();
		if (!(conn instanceof HttpURLConnection))
		throw new IOException("Not an HTTP connection");
		try{
		HttpURLConnection httpConn = (HttpURLConnection) conn;
		httpConn.setAllowUserInteraction(false);
		httpConn.setInstanceFollowRedirects(true);
		httpConn.setDoInput(true);	
		httpConn.setDoOutput(true);	
		httpConn.setRequestMethod("POST");
		if(isOutput){
		OutputStreamWriter wr = new OutputStreamWriter(httpConn.getOutputStream());
                    // this is were we're adding post data to the request		
              wr.write(sb.toString());		    
                wr.close();
		}
		
		httpConn.connect();
		response = httpConn.getResponseCode();
		if (response == HttpURLConnection.HTTP_OK) {			
		in = httpConn.getInputStream();		
		}
		}
		catch (Exception ex)
		{
		throw new IOException("Error connecting");
		}
		return in;
		}
		//
}


