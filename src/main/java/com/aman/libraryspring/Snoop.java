package com.aman.libraryspring;

import java.io.*;
import java.net.*;
import java.util.Date;

public class Snoop extends Thread {

	Socket from_socket;
	Socket to_socket;
	PrintWriter pwriter;
	boolean client_to_server;
	String name;
	StringBuffer traceFileBuffer;
	static String serverName;
	static int serverPort;
	static int snoopPort;
	static boolean showAscii = true;
	static boolean showEbcdic = false;
	static int lineSize = 8;
	static String traceFilePrefix;
	static int maxBytesInTraceFile = -1;
	static boolean showTimestamps = false;
	
	static char hex_map[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'A', 'B', 'C', 'D', 'E', 'F' };

	

	public Snoop(String name, Socket fs, Socket ts, PrintWriter pw,
			StringBuffer buff) {
		from_socket = fs;
		to_socket = ts;
		this.name = name;
		pwriter = pw;
		traceFileBuffer = buff;
	}

	public void run() {
		byte buffer[] = new byte[1024];
		try {
			InputStream is = from_socket.getInputStream();
			OutputStream os = to_socket.getOutputStream();
			do {
				int length = is.read(buffer);
				if (length == -1) {
					String type = name.equals("Send") ? "Client" : "Server";
					System.out.println(String.valueOf(String
							.valueOf((new StringBuffer("  ")).append(type)
									.append(" connection closed."))));
					break;
				}
				log(buffer, length);
				os.write(buffer, 0, length);
			} while (true);
		} catch (SocketException e) {
			System.out.println("  ".concat(String.valueOf(String.valueOf(e
					.getMessage()))));
		} catch (IOException e) {
			System.out.println("  Error: ".concat(String.valueOf(String
					.valueOf(e.getMessage()))));
		} finally {
			try {
				from_socket.close();
				to_socket.close();
			} catch (Exception exception1) {
			}
			if (maxBytesInTraceFile != -1)
				synchronized (traceFileBuffer) {
					pwriter.println(traceFileBuffer.toString());
					traceFileBuffer.setLength(0);
					pwriter.flush();
				}
		}
	}

	synchronized void log(byte buffer[], int length) {
		int pos = 0;
		StringBuffer line = new StringBuffer(64);
		line.setLength(0);
		if (showTimestamps) {
			Date d = new Date(System.currentTimeMillis());
			line.append(String.valueOf(String.valueOf(d.toString()))
					.concat(" "));
		}
		line.append(String.valueOf(String.valueOf((new StringBuffer("\n"))
				.append(name).append(": ").append(length).append(" bytes\n"))));
		do {
			for (int i = pos; i < pos + lineSize; i++) {
				if (i < length)
					line.append(byteToHex(buffer[i]));
				else
					line.append("  ");
				line.append(' ');
			}

			line.append("        ");
			if (showAscii) {
				for (int i = pos; i < pos + lineSize; i++)
					if (i < length)
						line.append(byteToASCII(buffer[i]));
					else
						line.append(' ');

			}
			if (showEbcdic) {
				if (showAscii)
					line.append("        ");
				for (int i = pos; i < pos + lineSize; i++)
					if (i < length)
						line.append(eByteToASCII(buffer[i]));
					else
						line.append(' ');

			}
			line.append("        ");
			line.append("\n");
			pos += lineSize;
		} while (pos <= length);
		line.append("\n");
		if (maxBytesInTraceFile == -1) {
			pwriter.print(line.toString());
			pwriter.flush();
		} else {
			synchronized (traceFileBuffer) {
				if (traceFileBuffer.length() + line.length() > maxBytesInTraceFile) {
					if (line.length() >= maxBytesInTraceFile) {
						traceFileBuffer.setLength(0);
						traceFileBuffer.append(line.substring(line.length()
								- maxBytesInTraceFile, line.length()));
					} else {
						int numBytesToKeepFromTraceBuffer = maxBytesInTraceFile
								- line.length();
						String str = traceFileBuffer.substring(
								traceFileBuffer.length()
										- numBytesToKeepFromTraceBuffer,
								traceFileBuffer.length());
						traceFileBuffer.setLength(0);
						traceFileBuffer.append(str);
						traceFileBuffer.append(line.toString());
					}
				} else {
					traceFileBuffer.append(line.toString());
				}
			}
		}
	}

	static PrintWriter getTraceFile(String trace_file) throws IOException {
		StringBuffer fileName = new StringBuffer();
		if (trace_file != null)
			fileName.append(String.valueOf(String.valueOf(trace_file)).concat(
					"_"));
		int i = 0;
		do {
			File file = new File(String.valueOf(String
					.valueOf((new StringBuffer(String.valueOf(String
							.valueOf(fileName.toString())))).append(
							Integer.toString(i)).append(".out"))));
			if (file.exists())
				i++;
			else
				return new PrintWriter(new FileWriter(file), true);
		} while (true);
	}

	char[] byteToHex(byte b) {
		char hex[] = { hex_map[b >> 4 & 0xf], hex_map[b & 0xf] };
		return hex;
	}

	char byteToASCII(byte b) {
		if (b > 31 && b < 127)
			return (char) b;
		else
			return '.';
	}

	char eByteToASCII(byte b) {
		int x = 0xff & b;
		if (x >= 129 && x <= 137)
			return (char) (97 + (x - 129));
		if (x >= 145 && x <= 153)
			return (char) (106 + (x - 145));
		if (x >= 162 && x <= 169)
			return (char) (115 + (x - 162));
		if (x >= 193 && x <= 201)
			return (char) (65 + (x - 193));
		if (x >= 209 && x <= 217)
			return (char) (74 + (x - 209));
		if (x >= 226 && x <= 233)
			return (char) (83 + (x - 226));
		if (x >= 240 && x <= 249)
			return (char) (48 + (x - 240));
		switch (x) {
		case 64: // '@'
			return ' ';

		case 76: // 'L'
			return '<';

		case 77: // 'M'
			return '(';

		case 78: // 'N'
			return '+';

		case 79: // 'O'
			return '|';

		case 80: // 'P'
			return '&';

		case 90: // 'Z'
			return '!';

		case 91: // '['
			return '$';

		case 92: // '\\'
			return '*';

		case 93: // ']'
			return ')';

		case 94: // '^'
			return ';';

		case 96: // '`'
			return '-';

		case 97: // 'a'
			return '/';

		case 107: // 'k'
			return ',';

		case 108: // 'l'
			return '%';

		case 109: // 'm'
			return '_';

		case 110: // 'n'
			return '>';

		case 111: // 'o'
			return '?';

		case 122: // 'z'
			return ':';

		case 123: // '{'
			return '#';

		case 124: // '|'
			return '@';

		case 125: // '}'
			return '\'';

		case 126: // '~'
			return '=';

		case 127: // '\177'
			return '"';

		case 185:
			return '`';
		}
		return '.';
	}

	static boolean parseArguments(String args[]) {
		if (args.length < 2) {
			System.out
					.println("Syntax: java Snoop <server_name> <port_number> [optional args]");
			System.out.println("\nPossible values for [optional args]:");
			System.out
					.println("     -snoopPort            <local port number>");
			System.out
					.println("     -showAscii            <true|false>          default=true");
			System.out
					.println("     -showEbcdic           <true|false>          default=false");
			System.out.println("     -traceFilePrefix      <prefix>");
			System.out
					.println("     -lineSize             <line size value>     default=8");
			System.out
					.println("     -maxBytesInTraceFile  <max trace file size>");
			System.out
					.println("     -showTimestamps       <true|false>          default=false");
			return false;
		}
		
		serverName = args[0];
		serverPort = Integer.parseInt(args[1]);
		snoopPort = serverPort;
		traceFilePrefix = null;
		for (int index = 2; index < args.length; index++) {
			String curArg = args[index];
			index++;
			if (curArg.equalsIgnoreCase("-showAscii")) {
				showAscii = Boolean.valueOf(args[index]).booleanValue();
				continue;
			}
			if (curArg.equalsIgnoreCase("-showEbcdic")) {
				showEbcdic = Boolean.valueOf(args[index]).booleanValue();
				continue;
			}
			if (curArg.equalsIgnoreCase("-lineSize")) {
				lineSize = Integer.parseInt(args[index]);
				continue;
			}
			if (curArg.equalsIgnoreCase("-snoopPort")) {
				snoopPort = Integer.parseInt(args[index]);
				continue;
			}
			if (curArg.equalsIgnoreCase("-traceFilePrefix")) {
				traceFilePrefix = args[index];
				continue;
			}
			if (curArg.equalsIgnoreCase("-maxBytesInTraceFile")) {
				maxBytesInTraceFile = Integer.parseInt(args[index]);
				continue;
			}
			if (curArg.equalsIgnoreCase("-showTimestamps"))
				showTimestamps = Boolean.valueOf(args[index]).booleanValue();
		}

		return true;
	}


	
	public static void main(String args[]) {
		if (!parseArguments(args))
			return;
		try {
			InetAddress.getByName(serverName);
			ServerSocket listen_socket = new ServerSocket(snoopPort);
			if (traceFilePrefix != null)
				System.out.println("Trace file prefix to use: ".concat(String
						.valueOf(String.valueOf(traceFilePrefix))));
			System.out.println(String.valueOf(String.valueOf((new StringBuffer(
					"Server to connect = ")).append(serverName).append(":")
					.append(serverPort))));
			System.out.println(String.valueOf(String.valueOf((new StringBuffer(
					"Listening to local port ")).append(snoopPort).append(
					" ..."))));
			do {
				Socket client_socket = listen_socket.accept();
				System.out.println("\nClient connection: ".concat(String
						.valueOf(String.valueOf(client_socket.toString()))));
				Socket server_socket = new Socket(serverName, serverPort);
				PrintWriter pw = getTraceFile(traceFilePrefix);
				pw.println(String.valueOf(String.valueOf((new StringBuffer(
						"Server = ")).append(serverName).append(":")
						.append(serverPort))));
				pw.println();
				pw.println("HEX");
				for (int i = 0; i < lineSize * 3; i++)
					pw.print(" ");

				if (showAscii)
					pw.print("        ASCII");
				if (showEbcdic) {
					if (showAscii) {
						for (int i = 0; i < lineSize - 5; i++)
							pw.print(" ");

					}
					pw.print("        EBCDIC");
				}
				pw.println();
				StringBuffer buff = null;
				if (maxBytesInTraceFile != -1)
					buff = new StringBuffer(maxBytesInTraceFile);
				(new Snoop("Send", client_socket, server_socket, pw, buff))
						.start();
				(new Snoop("Read", server_socket, client_socket, pw, buff))
						.start();
			} while (true);
		} catch (UnknownHostException e) {
			System.out.println(String.valueOf(String.valueOf((new StringBuffer(
					"IP address for ")).append(serverName).append(
					" can't be found."))));
		} catch (Exception e) {
			System.out.println("  Error: ".concat(String.valueOf(String
					.valueOf(e.getMessage()))));
		}
	}

}
