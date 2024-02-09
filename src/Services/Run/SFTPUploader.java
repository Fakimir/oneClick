package Services.Run;

import java.io.IOException;
import java.io.InputStream;

import com.jcraft.jsch.*;

public class SFTPUploader {
  
    public static void uploadFile(String host, String user, String password, String localFilePath, String remoteFilePath) throws JSchException, SftpException, IOException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, 22);
        session.setPassword(password);
        
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        
        ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
        channel.connect();
        channel.put(localFilePath, remoteFilePath);
        
        channel.disconnect(); // Закрыть канал перед завершением сессии
        session.disconnect(); //Закрыть сессию
    
        System.out.println("Файл успешно передан на сервер.");
    }
}