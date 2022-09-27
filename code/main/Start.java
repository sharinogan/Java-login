package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

class Start {
    public static void main(String[] args) {
        // ApplicationContext context;
        // context = SpringApplication.run(Setup.class);
        
        Player p = new Player("David B", 7);
        System.out.println(p);
    }
}

record Player(String name, int number) { }

class Student {
    String name;
    Gender gender;
}

enum Gender { MALE, FEMALE }

class Vehicle {  }

class Car extends Vehicle {  }

class Truck extends Vehicle {  }

class Ship extends Vehicle {  }

class Product {
    double price;
    double getSpecialPrice() {
        return 0.90 * price;
    }
}

class Book extends Product {  }
//     '               '--------------> Super class
//     '------------------------------> Sub class


@SpringBootApplication
class Setup {
    @Bean
    DriverManagerDataSource create() {
        DriverManagerDataSource d =
                new DriverManagerDataSource(connectionString);
        return d;
    }
    
    String connectionString = "jdbc:mysql://127.0.0.1" +
            "/company?user=james&password=notime";
    
}

@RestController
class Sample {
    
    @RequestMapping("/check")
    double check() {
        return 123.4567;
    }
}