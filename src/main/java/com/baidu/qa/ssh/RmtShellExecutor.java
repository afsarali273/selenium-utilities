package com.baidu.qa.ssh;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

/**
 * 
 * @author liangxiaowu
 */
public class RmtShellExecutor {
	private Connection conn;
	private String ip;
	private String usr;
	private String psword;
	private String charset = Charset.defaultCharset().toString();
	private static final int TIME_OUT = 1000 * 5 * 60;

	public RmtShellExecutor(String ip, String usr, String ps) {
		this.ip = ip;
		this.usr = usr;
		this.psword = ps;
	}

	private boolean login() throws IOException {
		conn = new Connection(ip);
		conn.connect();
		return conn.authenticateWithPassword(usr, psword);
	}

	public int exec(String cmds) throws Exception {
		InputStream stdOut = null;
		InputStream stdErr = null;
		String outStr = "";
		String outErr = "";
		int ret = -1;
		try {
			if (login()) {
				// Open a new {@link Session} on this connection
				Session session = conn.openSession();
				// Execute a command on the remote machine.
				session.execCommand(cmds);

				stdOut = new StreamGobbler(session.getStdout());
				outStr = processStream(stdOut, charset);

				stdErr = new StreamGobbler(session.getStderr());
				outErr = processStream(stdErr, charset);

				session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);

				System.out.println("outStr=" + outStr);
				System.out.println("outErr=" + outErr);

				ret = session.getExitStatus();
			} else {
				throw new Exception("" + ip);
			}
		} finally {
			if (conn != null) {
				conn.close();
			}
			stdOut.close();
			stdErr.close();
		}
		return ret;
	}

	/**
	 * @param in
	 * @param charset
	 * @return
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	private String processStream(InputStream in, String charset) throws Exception {
		byte[] buf = new byte[1024];
		StringBuilder sb = new StringBuilder();
		while (in.read(buf) != -1) {
			sb.append(new String(buf, charset));
		}
		return sb.toString();
	}

	public static void main(String args[]) throws Exception {
		RmtShellExecutor exe = new RmtShellExecutor("***.**.**.***", "sshapp", "sshapp");
		System.out.println(exe.exec("sh /webapp/myshell/myTest.sh java Know dummy"));
		// exe.exec("uname -a && date && uptime && who");
	}
}
