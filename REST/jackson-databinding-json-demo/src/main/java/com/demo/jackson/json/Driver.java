package com.demo.jackson.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

    public static void main(String[] args) {

        try {

            // create the object mapper
            ObjectMapper mapper = new ObjectMapper();

            //read json file and map or convert it into java pojo
//             Student theStudent = mapper.readValue(new File("data/sample-lite.json"),Student.class);
            Student theStudent = mapper.readValue(new File("data/sample-full.json"),Student.class);
            // print firstName and lastName
            System.out.println("First Name: "+theStudent.getFirstName() );
            System.out.println("Last Name: "+theStudent.getLastName() );
            System.out.println(theStudent.getAddress().toString());
           for(String temp : theStudent.getLanguages())
           {
               System.out.println(temp);
           }


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
