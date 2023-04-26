package com.example.JsonToCsv.Service;

import com.example.JsonToCsv.PayLoad.User;
import com.example.JsonToCsv.Repository.FileRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@Service
public class FileConverterService {
    @Autowired
    private FileRepository fileRepository;

    public String makeChangesUsingList(List<Object> objectList)
            throws JSONException, IOException {
        HashSet<String> listOfObject = new HashSet<>();
        for(Object object : objectList){
            JSONObject jsonObject = new JSONObject(object.toString());
            Iterator<String> eachObject = jsonObject.keys();
            while (eachObject.hasNext()){
                listOfObject.add(eachObject.next());
            }
            //String user = object.toString();
            //fileRepository.save(new User(jsonObject));
            //fileRepository.save(object);
        }

        String string = ",";
        Iterator<String> iterator = listOfObject.iterator();
        while (iterator.hasNext()){
            string +=  iterator.next() + ",";
        }
        string = string.substring(0,string.length()-1);
        string += "\n";
        for(Object object : objectList){
            JSONObject jsonObject = new JSONObject(object);
            //JSONObject jsonObject = new JSONObject(object.toString());
            Iterator<String> key = jsonObject.keys();
            Map<String,String> map = new HashMap<>();
            while (key.hasNext()){
                String temp = key.next();
                map.put(temp,jsonObject.get(temp).toString());
            }
            Iterator<String> headers = listOfObject.iterator();
            while (headers.hasNext()){
                String header = headers.next();
                if(map.containsKey(header)){
                    string += map.get(header);
                }
                else {
                    string += "-";
                }
            }
            string = string.substring(0,string.length()-1);
            string += "\n";
        }
        FileWriter fileWriter =
                new FileWriter("/home/albanero/SpringBoot_Practice/JsonToCsv/src/main/resources/Test_File_1");
        fileWriter.write(string);
        //fileRepository.save(objectList);
        fileWriter.close();
        return "Related Changes Has been done(Using list of Json Object.).";
    }

    public String makeChangesUsingMap(List<Map<String,String>> mapList)
            throws JSONException,IOException{
        return "Related Changes Has been done(Using list of map of Json object).";
    }
}
