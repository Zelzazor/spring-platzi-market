package com.zelzazor.platzi_market.domain.service;

import com.zelzazor.platzi_market.domain.Purchase;
import com.zelzazor.platzi_market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> getAllPurchases() {
        return this.purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByCustomerId(String id) {
        return this.purchaseRepository.getByCustomerId(id);
    }

    public Purchase save(Purchase purchase) {
        return this.purchaseRepository.save(purchase);
    }
}
