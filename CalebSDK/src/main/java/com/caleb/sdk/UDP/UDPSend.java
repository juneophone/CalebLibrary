package com.caleb.sdk.UDP;

import android.util.Log;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSend implements Runnable {
    private final String TAG = this.getClass().getSimpleName() + " JW";

    private DatagramSocket sendSocket;
    private UDPConfigs mConfig = UDPConfigs.getInstance();
    private String IP_Address;
    private int PORT;
    private String message;

    public UDPSend(String msg) {
        IP_Address = mConfig.broadcastIPAddress(mConfig.getIpAddress());
        PORT = mConfig.PORT;
        message = msg;
    }

    public UDPSend(String ip_address, String msg) {
        IP_Address = ip_address;
        PORT = mConfig.PORT;
        message = msg;
    }

    @Override
    public void run() {
        sendMessage();
    }

    private void sendMessage() {
        try {
            sendSocket = new DatagramSocket();
            sendSocket.setBroadcast(true);
            byte[] buf = message.getBytes();
            InetAddress inetAddress = InetAddress.getByName(IP_Address);
            DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, inetAddress, PORT);
            sendSocket.send(sendPacket);
            Log.d(TAG, "Send to [" + inetAddress.getHostAddress() + "]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDestroy() {
        if (sendSocket != null) {
            sendSocket.close();
            sendSocket = null;
        }
    }

}
