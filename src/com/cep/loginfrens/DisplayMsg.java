package com.cep.loginfrens;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMsg extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        
        String defaultMsg="";
	    Bundle extras = getIntent().getExtras();
	    if (extras!=null)
	    {
	    	defaultMsg = extras.getString("stream");
	    }
	    TextView tv = (TextView) findViewById(R.id.msg);
			
		  tv.setText("Your Msg is "+defaultMsg);	
		  		
    }
    
    
}