package com.example.JsonToCsv.PayLoad;

import com.example.JsonToCsv.JsonToCsvApplication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_data")
public class User {

//    @Id
//    private String _id;
    private JSONObject obj;
//    private String age;
//    private String emailId;
//    private String country;


}
