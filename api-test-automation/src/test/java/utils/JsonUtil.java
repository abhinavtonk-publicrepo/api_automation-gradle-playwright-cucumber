package utils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;

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

    public <T> T jsonStringToPojoDeserialization(String jsonString, Class<T> type){
        JsonParser jp = JsonParser.DEFAULT;
        return jp.parse(jsonString, type);
    }

    public String pojoToJsonSerialization(Object obj){
        JsonSerializer js = JsonSerializer.DEFAULT_READABLE;
        return js.serialize(obj);
    }

    public <T> boolean compareJsons(String json1, String json2, Class<T> type){
        JsonParser jp = JsonParser.DEFAULT;
        T ref1 = jp.parse(json1, type);
        T ref2 = jp.parse(json2, type);

        return ref1.equals(ref2);
    }
}
