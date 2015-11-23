package com.zhuke.jackson_databind;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by ZHUKE on 2015/10/29.
 */
public class JacksonTreeDemo {
    public static void main(String args[]) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = "{\"name\":\"Mahesh Kumar\", \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
            JsonNode rootNode = mapper.readTree(jsonString);

            JsonNode nameNode = rootNode.path("name");
            System.out.println("Name: " + nameNode.asText());

            JsonNode ageNode = rootNode.path("age");
            System.out.println("Age: " + ageNode.asInt());

            JsonNode verifiedNode = rootNode.path("verified");
            System.out.println("Verified: " + (verifiedNode.asBoolean() ? "Yes" : "No"));

            JsonNode marksNode = rootNode.path("marks");
            Iterator<JsonNode> iterator = marksNode.iterator();
            System.out.print("Marks: [ ");
            while (iterator.hasNext()) {
                JsonNode marks = iterator.next();
                System.out.print(marks.asInt() + " ");
            }
            System.out.println("]");
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
