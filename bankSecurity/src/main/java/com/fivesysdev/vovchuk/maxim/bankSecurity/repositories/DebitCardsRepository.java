package com.fivesysdev.vovchuk.maxim.bankSecurity.repositories;

import com.fivesysdev.vovchuk.maxim.bankSecurity.models.DebitCard;
import com.fivesysdev.vovchuk.maxim.bankSecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebitCardsRepository extends JpaRepository<DebitCard, Long> {
    List<DebitCard> findAllByOwner(User owner);
}
