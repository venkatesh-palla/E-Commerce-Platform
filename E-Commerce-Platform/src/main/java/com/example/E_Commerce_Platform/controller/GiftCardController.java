package com.example.E_Commerce_Platform.controller;

import com.example.E_Commerce_Platform.model.GiftCard;
import com.example.E_Commerce_Platform.service.GiftCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/giftcards")
public class GiftCardController {
    @Autowired
    private GiftCardService giftCardService;

    @GetMapping("/{code}")
    public ResponseEntity<GiftCard> getGiftCardByCode(@PathVariable String code) {
        return giftCardService.getGiftCardByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GiftCard> createGiftCard(@RequestBody GiftCard giftCard) {
        return ResponseEntity.ok(giftCardService.saveGiftCard(giftCard));
    }

    @PostMapping("/redeem")
    public ResponseEntity<Void> redeemGiftCard(@RequestParam String code, @RequestParam BigDecimal amount) {
        giftCardService.redeemGiftCard(code, amount);
        return ResponseEntity.ok().build();
    }
}
