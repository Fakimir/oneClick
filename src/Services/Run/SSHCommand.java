package Services.Run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jcraft.jsch.*;

public class SSHCommand {
    
    public static int executeSSHCommand(String host, String user, String password, String command) throws JSchException, SftpException, InterruptedException, IOException {
        JSch jsch=new JSch();  
        Session session=jsch.getSession(user, host, 22);
        session.setPassword(password);
        
        java.util.Properties config = new java.util.Properties(); 
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        
        session.connect();
        
        ChannelExec channel=(ChannelExec) session.openChannel("exec");
        channel.setCommand(command);
        
        InputStream in = channel.getInputStream();
        
        channel.connect();

        byte[] tmp = new byte[1024];
        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0) {
                    break;
                }
                System.out.print(new String(tmp, 0, i));

            }
            if (channel.isClosed()) {
                if (in.available() > 0) {
                    continue;
                }
                int exitStatus = channel.getExitStatus();
                System.out.println("exit-status: " + command + " --->" + exitStatus);
                return exitStatus;
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        
        Thread.sleep(1000);
        channel.disconnect();
        
        session.disconnect();
    }
}