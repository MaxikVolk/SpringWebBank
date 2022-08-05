package com.fivesysdev.vovchuk.maxim.bankSecurity.services;

import com.fivesysdev.vovchuk.maxim.bankSecurity.models.Entering;
import com.fivesysdev.vovchuk.maxim.bankSecurity.models.Loan;
import com.fivesysdev.vovchuk.maxim.bankSecurity.repositories.LoansRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class LoansService {
    private final LoansRepository loansRepository;

    public LoansService(LoansRepository loansRepository) {
        this.loansRepository = loansRepository;
    }

    @Transactional
    public void save(Loan loan) {
        loan.setOwner(Entering.getUserFromContext());
        loansRepository.save(loan);
    }

    public List<String> myLoansInfo() {
        List<Loan> loans = loansRepository.findAllByOwner(Entering.getUserFromContext());
        List<String> result = new ArrayList<>();
        for (Loan loan : loans) {
            result.add(loan.toString());
        }
        return result;
    }
}
