package Services.Http;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import Services.Run.RunCommand;

import java.io.File;

public class DownloadCore {

    public static void main(String[] args) {
        
    }

    public static void download(String password, String version, String url) throws InterruptedException {
        String name = "Core-" + version + ".jar";
        String path = "src/Downloads/";
        String fileName = path + name;

        File file = new File(fileName);

        if (file.exists()) {
            return;
        } else {
            FileOutputStream fileOut = null;
            BufferedInputStream fileIn = null;

            try {
                fileIn = new BufferedInputStream(new URL(url).openStream());
                fileOut = new FileOutputStream(fileName);

                byte data[] = new byte[1024];
                int count;

                while((count = fileIn.read(data, 0, 1024)) != -1) {
                    fileOut.write(data, 0, count);
                    fileOut.flush();
                }
            } catch(MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileIn.close();
                } catch(IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                    fileOut.close();
                    String rootPath = System.getProperty("user.dir");
//                    RunCommand.run(("cd " + rootPath + "/" + path), password);
//                    RunCommand.run(("sudo java -jar " + name), password);
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}