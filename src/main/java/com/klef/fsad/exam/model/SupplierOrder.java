package com.klef.fsad.exam.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "supplier_orders")
public class SupplierOrder {
    
    @Id
    @Column(name = "supplier_order_id", nullable = false)
    private Long supplierOrderId;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "date", nullable = false)
    private LocalDate date;
    
    @Column(name = "status", nullable = false)
    private String status;
    
    @Column(name = "amount")
    private Double amount;
    
    @Column(name = "description")
    private String description;
    
    // Constructors
    public SupplierOrder() {
    }
    
    public SupplierOrder(Long supplierOrderId, String name, LocalDate date, String status, Double amount, String description) {
        this.supplierOrderId = supplierOrderId;
        this.name = name;
        this.date = date;
        this.status = status;
        this.amount = amount;
        this.description = description;
    }
    
    // Getters and Setters
    public Long getSupplierOrderId() {
        return supplierOrderId;
    }
    
    public void setSupplierOrderId(Long supplierOrderId) {
        this.supplierOrderId = supplierOrderId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Double getAmount() {
        return amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "SupplierOrder{" +
                "supplierOrderId=" + supplierOrderId +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
