package com.cs.arris.Utilities;

public class ResetMAXRouter 
{
	public static void main(String args[]) {
		
	//	SerialComPortCommunicator.getSerialPorts();
		SerialComPortCommunicator.resetMAXRouter("/dev/tty.usbserial-142340");



	}

}





















































//Process mProcess;
//public void reset() {
////Process process;
//ProcessBuilder pb;
//try {
//	//process = Runtime.getRuntime().exec("/usr/bin/python3 /Users/rm2652/Documents/ResetMaxRouterScript/reset.py");
//	//process = Runtime.getRuntime().exec(new String[]{"/Users/rm2652/Documents/ResetMaxRouterScript/reset.py"});
//	pb = new ProcessBuilder("/usr/bin/python3", "/Users/rm2652/Documents/ResetMaxRouterScript/reset.py");
//	Process process = pb.start();
//} catch (IOException e) {
//	e.printStackTrace();
//}
//}

//public void reset() {
//Process process;
//
//try {
//	process = Runtime.getRuntime().exec("/usr/bin/python3  /Users/rm2652/Documents/ResetMaxRouterScript/reset.py");
//	mProcess = process;
//} catch (IOException e) {
//	e.printStackTrace();
//}
//InputStream stdout = mProcess.getInputStream();
//   BufferedReader reader = new BufferedReader(new InputStreamReader(stdout, StandardCharsets.UTF_8));
//   String line;
//   try{
//      while((line = reader.readLine()) != null){
//           System.out.println("stdout: "+ line);
//      }
//   }catch(IOException e){
//         System.out.println("Exception in reading output"+ e.toString());
//   }
//}














//public class ResetMAXRouter implements SerialPortEventListener{
//
//	private String portName;
//	private SerialPort port;
//	private CommPortIdentifier portIdentifier;
//	private String command = "dmcli eRT setv Device.X_ARRIS_COM_HNE.FactoryReset bool 1";
//	
//	TestUtils utils = new TestUtils();
//	
//    public void connect (String portName) throws Exception {
//        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
//        if (portIdentifier.isCurrentlyOwned()) {
//            System.out.println("Error: Port is currently in use");
//        } else {
//            CommPort commPort = portIdentifier.open(this.getClass().getName(),6000);
//            if (commPort instanceof SerialPort) {
//                SerialPort serialPort = (SerialPort) commPort;
//                serialPort.setSerialPortParams(115200,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
//                System.out.println("BaudRate: " + serialPort.getBaudRate());
//                System.out.println("DataBIts: " + serialPort.getDataBits());
//                System.out.println("StopBits: " + serialPort.getStopBits());
//                System.out.println("Parity: " + serialPort.getParity());
//                System.out.println("FlowControl: " + serialPort.getFlowControlMode());
//                InputStream in = serialPort.getInputStream();
//                OutputStream out = serialPort.getOutputStream();
//            } else {
//                System.out.println("Error: Only serial ports are handled by this example.");
//            }
//        }     
//    }
//
//	@Override
//	public void serialEvent(SerialPortEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//
//}








//Properties props = new Properties();
//props.put("python.home", "/Users/rm2652/Documents/Softwares/Jython/Lib");
//props.put("python.console.encoding", "UTF-8");
//props.put("python.security.respectJavaAccessibility", "false");
//props.put("python.import.site", "false");
//Properties preprops = System.getProperties();
//PythonInterpreter.initialize(preprops, props, new String[0]);
//
//try (PythonInterpreter pyInterp = new PythonInterpreter()) {
//StringWriter output = new StringWriter();
//pyInterp.setOut(output);
//pyInterp.exec("import serial,sys,os,time\n"
//		+ "baudrate = 115200\n"
//		+ "comport = \"usbserial-142310\"\n"
//		+ "dmCLICMDS = \"dmcli eRT setv Device.X_ARRIS_COM_HNE.FactoryReset bool 1\"\n"
//		+ "ser = serial.Serial()\n"
//		+ "ser.baudrate = baudrate\n"
//		+ "ser.port = comport\n"
//		+ "ser.open()\n"
//		+ "ser.write(dmCLICMDS)\n"
//		+ "#ser.write(\"toish bt devices\")\n"
//		+ "ser.write('\\n')\n"
//		+ "#time.sleep(5)\n"
//		+ "lines = ser.read(300)\n"
//		+ "print (\" the lines ==>\",lines)\n"
//		+ "i = 1\n"
//		+ "if \"Restarting system\" in lines or \"SIGKILL\" in lines:       \n"
//		+ "          print (\"Reset was successful\")\n"
//		+ "else:\n"
//		+ "          print (\"Unable to send reboot command\")\n"
//		+ "ser.close()");
//}