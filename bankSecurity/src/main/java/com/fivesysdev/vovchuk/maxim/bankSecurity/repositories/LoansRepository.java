package com.fivesysdev.vovchuk.maxim.bankSecurity.repositories;

import com.fivesysdev.vovchuk.maxim.bankSecurity.models.Loan;
import com.fivesysdev.vovchuk.maxim.bankSecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LoansRepository extends JpaRepository<Loan, Long> {
    List<Loan> findAllByOwner(User owner);
}
