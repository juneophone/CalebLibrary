package com.caleb.sdk.UDP;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class UDPConfigs {
    private final String TAG = this.getClass().getSimpleName() + " JW";

    public int PORT = 3636;
    public String TOKEN_SERVER = "IsServer";
    public String TOKEN_CLIENT = "IsClient";

    public UDPConfigs() {

    }

    private static class ConfigsLoader {
        private static final UDPConfigs instance = new UDPConfigs();
    }

    public static UDPConfigs getInstance() {
        return ConfigsLoader.instance;
    }

    /**
     * @return String
     * @Title: getIpAddress
     * @Description: 取得本機端 IP Address
     */
    public String getIpAddress() {
        try {
            for (Enumeration<NetworkInterface> enNetI = NetworkInterface.getNetworkInterfaces(); enNetI
                    .hasMoreElements(); ) {
                NetworkInterface netI = enNetI.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = netI.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (inetAddress instanceof Inet4Address && !inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String broadcastIPAddress(String IP) {
        if (!IP.isEmpty()) {
            String[] tmp = IP.split("\\.");
            return tmp[0] + "." + tmp[1] + "." + tmp[2] + ".255";
        } else {
            return null;
        }
    }

}
