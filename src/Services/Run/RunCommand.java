package Services.Run;

import java.io.IOException;

public class RunCommand {

    public static void run(String cString, String password) throws IOException, InterruptedException {
        String[] sudoCommand = { "/bin/bash", "-c", "echo " + password + " | sudo -S " + cString };
        
        Process process = Runtime.getRuntime().exec(sudoCommand);
        int exitCode = process.waitFor();
        
        System.out.println("Код завершения: " + exitCode);
    }
}