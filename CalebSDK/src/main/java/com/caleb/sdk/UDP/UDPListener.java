package com.caleb.sdk.UDP;

import android.util.Log;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPListener extends Thread {
    private final String TAG = this.getClass().getSimpleName() + " JW";

    private DatagramSocket receiveSocket;
    private UDPConfigs mConfig = UDPConfigs.getInstance();
    private UDPCallback udpCallback = null;
    private String IP_Address;
    private int PORT;
    private boolean listenStatus = true;

    public UDPListener() {
        IP_Address = mConfig.getIpAddress();
        PORT = mConfig.PORT;
    }

    public UDPListener(String ip_address) {
        IP_Address = ip_address;
        PORT = mConfig.PORT;
    }

    public void setUdpCallback(UDPCallback callback){
        udpCallback = callback;
    }

    @Override
    public void run() {
        Log.i(TAG, "UDP Server running~~~");
        try {
            receiveSocket = new DatagramSocket(PORT);
            receiveSocket.setBroadcast(true);
            while (listenStatus) {
                byte[] buf = new byte[1024];
                final DatagramPacket packet = new DatagramPacket(buf, buf.length);
                receiveSocket.receive(packet);
                final String recData = new String(packet.getData()).trim();
                //Log.i(TAG, "IP[" + packet.getAddress().getHostAddress() + "], recData[" + recData + "]");
                if(udpCallback != null) {
                    if(recData.equals(mConfig.TOKEN_SERVER)){
                        udpCallback.fromServer(packet.getAddress().getHostAddress(), recData);
                    }
                    if(recData.equals(mConfig.TOKEN_CLIENT)){
                        udpCallback.fromClient(packet.getAddress().getHostAddress(), recData);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDestroy() {
        Log.d(TAG, "UDP Server Destroy!!");
        listenStatus = false;
        if (receiveSocket != null) {
            receiveSocket.close();
            receiveSocket = null;
        }
    }
}
