package com.example.E_Commerce_Platform.service;

import com.example.E_Commerce_Platform.model.GiftCard;
import com.example.E_Commerce_Platform.repository.GiftCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class GiftCardService {
    @Autowired
    private GiftCardRepository giftCardRepository;

    public Optional<GiftCard> getGiftCardByCode(String code) {
        return giftCardRepository.findByCode(code);
    }

    public GiftCard saveGiftCard(GiftCard giftCard) {
        return giftCardRepository.save(giftCard);
    }

    public void redeemGiftCard(String code, BigDecimal amount) {
        GiftCard giftCard = giftCardRepository.findByCode(code).orElseThrow(() -> new RuntimeException("Gift Card not found"));
        if (giftCard.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }
        giftCard.setBalance(giftCard.getBalance().subtract(amount));
        giftCardRepository.save(giftCard);

    }

}
