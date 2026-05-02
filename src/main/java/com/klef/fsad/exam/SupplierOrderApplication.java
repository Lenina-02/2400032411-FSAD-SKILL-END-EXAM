package com.klef.fsad.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SupplierOrderApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SupplierOrderApplication.class, args);
        System.out.println("Supplier Order Application Started Successfully!");
        System.out.println("Access the application at: http://localhost:8080");
        System.out.println("H2 Console: http://localhost:8080/h2-console");
    }
}
