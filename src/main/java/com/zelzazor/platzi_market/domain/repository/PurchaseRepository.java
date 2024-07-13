package com.zelzazor.platzi_market.domain.repository;

import com.zelzazor.platzi_market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();

    Optional<List<Purchase>> getByCustomerId(String clientId);

    Purchase save(Purchase purchase);
}
