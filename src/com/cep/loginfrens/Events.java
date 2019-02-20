package com.cep.loginfrens;

import android.graphics.Bitmap;

public class Events {
    
    private String eventName;
    private String eventDescript;
    private Number eventPoints;
    private Bitmap eventThumb;
    private String eventId;
    
    
    public String getEventId() {
        return eventId;
    }
    public void setEventId(String eventid) {
        this.eventId = eventid;
    }
    
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public String getEventDescript() {
        return eventDescript;
    }
    public void setEventDescript(String eventDescript) {
        this.eventDescript = eventDescript;
    }
    public Number getEventPoints() {
        return eventPoints;
    }
    public void setEventPoints(Number eventPoints) {
        this.eventPoints = eventPoints;
    }
    public Bitmap getEventThumb() {
        return eventThumb;
    }
    public void setEventThumb(Bitmap eventThumb) {
        this.eventThumb = eventThumb;
    }
}
