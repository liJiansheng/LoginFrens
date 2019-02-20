package com.cep.loginfrens;
import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EventAdapter extends ArrayAdapter<Events> {

        private ArrayList<Events> items;
        private Button btn_e;
        
        public EventAdapter(Context context, int textViewResourceId, ArrayList<Events> items) {
                super(context, textViewResourceId, items);
                this.items = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;
                if (v == null) {
                    LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = vi.inflate(R.layout.eventrow, null);
                }
                Events e = items.get(position);
                final String event_id = e.getEventId();
                if (e != null) {  
                		ImageView eimg = (ImageView) v.findViewById(R.id.ethumb);
                        TextView en = (TextView) v.findViewById(R.id.ename);
                        TextView ed = (TextView) v.findViewById(R.id.edescript);
                        btn_e = (Button) v.findViewById(R.id.btn_evt); 
                        
                        if (eimg != null) {
                            eimg.setImageBitmap(e.getEventThumb()); 
                            }
                        if (en != null) {
                              en.setText("Name: "+e.getEventName()); 
                              }
                        if(ed != null){
                              ed.setText("Description: "+ e.getEventDescript());
                        }
                       
                        
                }
                
                btn_e.setOnClickListener(new OnClickListener() {
        			@Override
        	        public void onClick(View v) {
        			
        				
        	    	}
        		});
                return v;
        }
        		
}