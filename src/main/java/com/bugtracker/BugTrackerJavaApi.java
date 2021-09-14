package com.bugtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BugTrackerJavaApi {

    public static void main(String[] args) {
        try
        {
            SpringApplication.run(BugTrackerJavaApi.class, args);
        }
        catch (Throwable throwable)
        {
            System.out.println(throwable.toString());
            throwable.printStackTrace();
        }
    }

}
