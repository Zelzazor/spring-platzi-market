package com.zelzazor.platzi_market.web.controller;

import com.zelzazor.platzi_market.domain.Purchase;
import com.zelzazor.platzi_market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        return new ResponseEntity<>(this.purchaseService.getAllPurchases(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Purchase>> getPurchasesByCustomerId(@PathVariable("id") String customerId) {
        return this.purchaseService.getByCustomerId(customerId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(this.purchaseService.save(purchase), HttpStatus.CREATED);
    }


}
