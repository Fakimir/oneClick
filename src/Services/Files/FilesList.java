package Services.Files;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class FilesList {
    public static void main(String[] args) {

    }

    public static List<Map<String, String>> list() {
        String rootPath = System.getProperty("user.dir");
        String directoryPath = rootPath + "/src/Downloads/";
        System.out.println(directoryPath);
        
        File directory = new File(directoryPath);
        
        File[] files = directory.listFiles();

        List<Map<String, String>> array = new ArrayList<>();
        
        for (File file : files) {
            if (file.isDirectory()) {
                ;//dir
            } else {
                String name = file.getName();
                Map<String, String> arr = new HashMap<>();
//
//                String version = name.split(".")[0].substring(Math.max(name.split(".")[0].length() - 4, 0));
                String path = directoryPath + name;
                arr.put("path", path);
                arr.put("name", name);

                array.add(arr);
            }
        }
        return array;
    }
}