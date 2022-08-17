package com.caleb.sdk.UDP;

public interface UDPCallback {

    void fromServer(String IP_Address, String recData);
    void fromClient(String IP_Address, String recData);

}
