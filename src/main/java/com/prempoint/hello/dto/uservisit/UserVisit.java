package com.prempoint.hello.dto.uservisit;

/**
 * Created by rajjasti on 3/21/17.
 */
public class UserVisit {

    private String name;
    private String ipAddress;

    public UserVisit(String name, String ipAddress) {
        this.name = name;
        this.ipAddress = ipAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
