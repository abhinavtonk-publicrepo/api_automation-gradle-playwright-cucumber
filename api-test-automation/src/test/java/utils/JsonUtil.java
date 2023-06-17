package utils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtil {
    public String readFromJsonFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
    public void writeIntoJsonFile(String filePath, String jsonString) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(jsonString);
        fw.close();
    }

    public Object getJsonAttributeValue(String jsonString, String jsonPath){
        // Return Types can be-
        // 1. net.minidev.json.JSONArray (need to install separate dependency for this)
        // 2. java.util.LinkedHashMap
        // 3. java.lang.Integer
        // 4. java.lang.String
        DocumentContext dc = JsonPath.parse(jsonString);
        return dc.read(jsonPath);
    }
}
