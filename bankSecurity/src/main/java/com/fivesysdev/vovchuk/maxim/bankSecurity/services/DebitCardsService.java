package com.fivesysdev.vovchuk.maxim.bankSecurity.services;

import com.fivesysdev.vovchuk.maxim.bankSecurity.models.DebitCard;
import com.fivesysdev.vovchuk.maxim.bankSecurity.models.Entering;
import com.fivesysdev.vovchuk.maxim.bankSecurity.repositories.DebitCardsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DebitCardsService {
    private final DebitCardsRepository debitCardsRepository;

    public DebitCardsService(DebitCardsRepository debitCardsRepository) {
        this.debitCardsRepository = debitCardsRepository;
    }

    @Transactional
    public void save(DebitCard debitCard) {
        debitCard.setOwner(Entering.getUserFromContext());
        debitCardsRepository.save(debitCard);
    }

    public double countMyBalance() {
        List<DebitCard> dc = debitCardsRepository.findAllByOwner(Entering.getUserFromContext());
        double balance = 0;
        for (DebitCard d : dc) {
            balance += d.getBalance();
        }
        return balance;
    }
}
