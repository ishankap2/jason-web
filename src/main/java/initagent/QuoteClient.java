 package initagent;

import java.io.*;
import java.net.*;

public class QuoteClient {

	public String getCurrentLocation() {
		DatagramPacket mDatagramPacket = null;
		DatagramSocket mDatagramSocket = null;

		String[] splited = null;
		String currentLocation ="";
		boolean isFind = true;

		InetAddress client_adress = null;
		try {
			client_adress = InetAddress.getByName("10.10.22.220");
		} catch (UnknownHostException e) {
			// showDialog(R.string.error_invalidaddr);
		}
		try {
			mDatagramSocket = new DatagramSocket(5555, client_adress);
			mDatagramSocket.setReuseAddress(true);
		} catch (SocketException e) {
			mDatagramSocket = null;
			// showDialog(R.string.error_neterror);
		}
		byte[] buf = new byte[256];
		try {
			mDatagramPacket = new DatagramPacket(buf, buf.length, client_adress, 5555);
		} catch (Exception e) {
			mDatagramSocket.close();
			mDatagramSocket = null;
		}
		while (isFind) {

			try {
				mDatagramSocket.receive(mDatagramPacket);
				String text = new String(mDatagramPacket.getData(), 0, mDatagramPacket.getLength());
				splited = text.split("\\s+");
				if (splited.length > 20) {
					currentLocation = splited[2].replace(",","")+","+splited[3].split(",")[0];
					isFind = false; 
				}
//				System.out.println(text);
				// mBufferwriter.write(text + "\r\n");
				// mBufferwriter.flush();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}

		}
		return currentLocation;
	}
}
