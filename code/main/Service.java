package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Service {
    
    @RequestMapping("/list/staff")
    Iterable listStaff() {
        String[] a = { "Mark", "Bill" };
        return engine.findAll();
    }
    
    @Autowired Engine engine;
}

@Repository
interface Engine  extends CrudRepository<Employee, Integer> {
    
}

@Table("staff")
class Employee {
    @Id int number;
    String email;
    
    @Column("first_name")
    public String first_name;
    
    @Column("last_name")
    public String last_name;
    
    public double salary;
}
