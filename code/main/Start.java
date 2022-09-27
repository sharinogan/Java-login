package main;

import java.util.Iterator;
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
        RangeIterable r = new RangeIterable();
        r.add(new Range(3, 8));
        r.add(new Range(4, 5));
        r.add(new Range(2, 6));
        
        for (Object e : r) {
            System.out.println(e);
        }
    }
}

class RangeIterable implements Iterable {
    public Iterator iterator() {
        return storage;
    }
    void add(Range r) {
        storage.add(r);
    }
    RangeStorage storage = new RangeStorage();
}

class RangeStorage implements Iterator {
    public Object next() {
        // ver 1
        // Object o = data[count];
        // count++;
        // return o;
        
        // ver 2
        return data[count++];
    }
    int count = 0;
    public boolean hasNext() {
        return count < size ? true : false;
    }
    
    Range[] data = new Range[10];
    int size = 0;
    void add(Range r) {
        data[size] = r;
        size++;
    }
}

record Range(int start, int finish) {  }

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