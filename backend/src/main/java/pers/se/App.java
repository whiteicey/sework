package pers.se;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import pers.se.mapper.UserMapper;
import pers.se.entity.User;



@RestController
@SpringBootApplication
public class App 
{
    
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }

}
