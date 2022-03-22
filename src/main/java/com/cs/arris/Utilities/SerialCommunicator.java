package com.cs.arris.Utilities;

import java.io.IOException;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class SerialCommunicator {
	public String mainAP = "/dev/tty.usbserial-142320";
	public String satellite1 = "/dev/tty.usbserial-142330";
	public String satellite2 = "/dev/tty.usbserial-142340";
	public SerialPort serialPort;
	
	public static void main(String args[])
	{
		SerialCommunicator sc = new SerialCommunicator();
		sc.getSerialPorts();
		sc.resetMAXRouter();
	}
	
	public  void getSerialPorts() {
		// getting serial ports list into the array
		String[] portNames = SerialPortList.getPortNames();
		        
		if (portNames.length == 0) {
		    System.out.println("There are no serial-ports ");
		    try {
		        System.in.read();
		    } catch (IOException e) {
		         // TODO Auto-generated catch block
		          e.printStackTrace();
		    }
		    return;
		}

		for (int i = 0; i < portNames.length; i++){
		    System.out.println(portNames[i]);
		}
	}
	
	public void resetMAXRouter() {
		serialPort = new SerialPort(satellite1);
		try {
		    serialPort.openPort();

		    serialPort.setParams(SerialPort.BAUDRATE_115200,
		                         SerialPort.DATABITS_8,
		                         SerialPort.STOPBITS_1,
		                         SerialPort.PARITY_NONE);

		  //  serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | SerialPort.FLOWCONTROL_RTSCTS_OUT);

		 //   serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR);

		    serialPort.writeString("dmcli eRT setv Device.X_ARRIS_COM_HNE.FactoryReset bool 1");
		}
		catch (SerialPortException ex) {
		    System.out.println("There are an error on writing string to port т: " + ex);
		}
	}
}
