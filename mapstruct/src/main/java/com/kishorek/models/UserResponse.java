package com.kishorek.models;

import java.util.Date;

public class UserResponse {
    private String displayName;

    private String token;

    private boolean showMenu;

    private Date lastLoggedOn;

    @Override
    public String toString() {
        return "UserResponse{" +
                "displayName='" + displayName + '\'' +
                ", token='" + token + '\'' +
                ", showMenu=" + showMenu +
                ", lastLoggedOn=" + lastLoggedOn +
                '}';
    }

    public Date getLastLoggedOn() {
        return lastLoggedOn;
    }

    public void setLastLoggedOn(Date lastLoggedOn) {
        this.lastLoggedOn = lastLoggedOn;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isShowMenu() {
        return showMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }
}
