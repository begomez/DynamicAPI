package com.myapps.data;



public class SessionModel extends BaseModel {

    private boolean registered = false;

    public SessionModel() {
        this.setRegistered(false);
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

}
