package com.cs.arris.Utilities;

import java.io.IOException;

import com.serialpundit.core.SerialComException;
import com.serialpundit.serial.SerialComManager;
import com.serialpundit.serial.SerialComManager.BAUDRATE;
import com.serialpundit.serial.SerialComManager.DATABITS;
import com.serialpundit.serial.SerialComManager.FLOWCONTROL;
import com.serialpundit.serial.SerialComManager.PARITY;
import com.serialpundit.serial.SerialComManager.STOPBITS;

import jssc.SerialPortList;

public class SerialComPortCommunicator {

	public static void getSerialPorts() {
		String[] portNames = SerialPortList.getPortNames();
    	
		try {
			if (portNames.length == 0) {
			    System.out.println("There are no serial-ports ");
			    try {
			        System.in.read();
			    } catch (IOException e) {
			         e.printStackTrace();
			    }
			    return;
			}
		}catch(Exception e) {e.printStackTrace();}

		for (int i = 0; i < portNames.length; i++){
			System.out.println(portNames[i]);
		}
	}
	
	public static void resetMAXRouter(String portName) {
		try {
			SerialComManager scm = new SerialComManager();
//			long handle = scm.openComPort("/dev/tty.usbserial-142340", true, true, false);
			long handle = scm.openComPort(portName, true, true, false);
			scm.configureComPortData(handle, DATABITS.DB_8, STOPBITS.SB_1, PARITY.P_NONE, BAUDRATE.B115200, 0);
			scm.configureComPortControl(handle, FLOWCONTROL.NONE, 'x', 'x', false, false);
			System.out.println(scm.getPortName(handle));
			try {
				scm.writeString(handle, "dmcli eRT setv Device.X_ARRIS_COM_HNE.FactoryReset bool 1 \n", 100);
			}catch(SerialComException e) {e.getStackTrace();}

			String data = scm.readString(handle);
			System.out.println("data read is :" + data);
			scm.closeComPort(handle);
		} catch (Exception e) {
			e.printStackTrace();}
	}

}
