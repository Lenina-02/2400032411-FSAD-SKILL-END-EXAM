package com.klef.fsad.exam.service;

import com.klef.fsad.exam.model.SupplierOrder;
import com.klef.fsad.exam.repository.SupplierOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierOrderService {
    
    @Autowired
    private SupplierOrderRepository supplierOrderRepository;
    
    // Add SupplierOrder
    public SupplierOrder addSupplierOrder(SupplierOrder supplierOrder) {
        if (supplierOrder.getSupplierOrderId() == null) {
            throw new IllegalArgumentException("SupplierOrder ID must be provided manually and cannot be null");
        }
        return supplierOrderRepository.save(supplierOrder);
    }
    
    // Get all SupplierOrders
    public List<SupplierOrder> getAllSupplierOrders() {
        return supplierOrderRepository.findAll();
    }
    
    // Get SupplierOrder by ID
    public Optional<SupplierOrder> getSupplierOrderById(Long id) {
        return supplierOrderRepository.findById(id);
    }
    
    // Update SupplierOrder
    public SupplierOrder updateSupplierOrder(Long id, SupplierOrder supplierOrderDetails) {
        Optional<SupplierOrder> existingOrder = supplierOrderRepository.findById(id);
        if (existingOrder.isPresent()) {
            SupplierOrder order = existingOrder.get();
            order.setName(supplierOrderDetails.getName());
            order.setDate(supplierOrderDetails.getDate());
            order.setStatus(supplierOrderDetails.getStatus());
            order.setAmount(supplierOrderDetails.getAmount());
            order.setDescription(supplierOrderDetails.getDescription());
            return supplierOrderRepository.save(order);
        }
        return null;
    }
    
    // Delete SupplierOrder
    public boolean deleteSupplierOrder(Long id) {
        if (supplierOrderRepository.existsById(id)) {
            supplierOrderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
