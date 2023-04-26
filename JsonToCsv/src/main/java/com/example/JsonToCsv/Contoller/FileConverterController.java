package com.example.JsonToCsv.Contoller;

import com.example.JsonToCsv.PayLoad.User;
import com.example.JsonToCsv.Service.FileConverterService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FileConverterController {
    @Autowired
    private FileConverterService fileConverterService;

    @PostMapping("/post-via-list")
    public String makeChangesUsingList(@RequestBody List<Object> objectList)
            throws JSONException, IOException {
        return fileConverterService.makeChangesUsingList(objectList);
    }

    @PostMapping("/post-via-map")
    public String makeChangesUsingMap( List<Map<String,String>> mapList)
            throws JSONException, IOException {
        return fileConverterService.makeChangesUsingMap(mapList);
    }
}
