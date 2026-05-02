package com.klef.fsad.exam.controller;

import com.klef.fsad.exam.model.SupplierOrder;
import com.klef.fsad.exam.service.SupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/supplier-orders")
public class SupplierOrderController {
    
    @Autowired
    private SupplierOrderService supplierOrderService;
    
    // POST - Add SupplierOrder
    @PostMapping
    public ResponseEntity<?> addSupplierOrder(@RequestBody SupplierOrder supplierOrder) {
        try {
            SupplierOrder savedOrder = supplierOrderService.addSupplierOrder(supplierOrder);
            return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    // GET - Get all SupplierOrders
    @GetMapping
    public ResponseEntity<List<SupplierOrder>> getAllSupplierOrders() {
        List<SupplierOrder> orders = supplierOrderService.getAllSupplierOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    
    // GET - Get SupplierOrder by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getSupplierOrderById(@PathVariable Long id) {
        Optional<SupplierOrder> order = supplierOrderService.getSupplierOrderById(id);
        if (order.isPresent()) {
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("SupplierOrder not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
    }
    
    // PUT - Update SupplierOrder
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSupplierOrder(@PathVariable Long id, @RequestBody SupplierOrder supplierOrder) {
        SupplierOrder updatedOrder = supplierOrderService.updateSupplierOrder(id, supplierOrder);
        if (updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("SupplierOrder not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
    }
    
    // DELETE - Delete SupplierOrder
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplierOrder(@PathVariable Long id) {
        boolean deleted = supplierOrderService.deleteSupplierOrder(id);
        if (deleted) {
            return new ResponseEntity<>("SupplierOrder deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("SupplierOrder not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
    }
}
