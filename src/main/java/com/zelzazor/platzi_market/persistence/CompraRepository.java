package com.zelzazor.platzi_market.persistence;

import com.zelzazor.platzi_market.domain.Purchase;
import com.zelzazor.platzi_market.domain.repository.PurchaseRepository;
import com.zelzazor.platzi_market.persistence.crud.CompraCrudRepository;
import com.zelzazor.platzi_market.persistence.entity.Compra;
import com.zelzazor.platzi_market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    private final CompraCrudRepository compraCrudRepository;

    private final PurchaseMapper mapper;

    @Autowired
    public CompraRepository(CompraCrudRepository compraCrudRepository, PurchaseMapper mapper) {
        this.compraCrudRepository = compraCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByCustomerId(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId).map(mapper::toPurchases);
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(p -> p.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
