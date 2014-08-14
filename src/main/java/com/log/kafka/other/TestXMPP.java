package com.log.kafka.other;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

/**
 * Created by ahenrick on 8/2/14.
 */
public class TestXMPP {

  public static void main(String args[]) throws Exception {

    ConnectionConfiguration config = new ConnectionConfiguration("192.168.59.103");
    XMPPConnection xmppConnection = new XMPPConnection(config);
    try {
      xmppConnection.connect();
      xmppConnection.login("storm@domain.local", "storm");
      Message msg = new Message("ahenrick@domain.local", Message.Type.normal);
      msg.setBody("Test Message");
      xmppConnection.sendPacket(msg);
      xmppConnection.disconnect();
    } catch (XMPPException e) {
      e.printStackTrace();
    }
  }
}

