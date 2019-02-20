package com.cep.loginfrens;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class EventsView extends Activity {
    /** Called when the activity is first created. */
	private String ename;
     
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        
        Bundle extras = getIntent().getExtras();
	    if (extras!=null)
	    {
	    	 ename = extras.getString("uname");
	    	
	    }

        TextView tv = (TextView) findViewById(R.id.msg);
        tv.setText(ename);
      
    }
    
 
}