package com.example.demo.test;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpTest {

    @Test
    void serverIpTest() {
        InetAddress local = null;
        try {
            local = InetAddress.getLocalHost();
            System.out.println("local=" + local);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        if (local == null) {
            System.out.println("null");
        } else {
            String ip = local.getHostAddress();
            System.out.println("ip=" + ip);
        }
    }
}
