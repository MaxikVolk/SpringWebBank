package com.fivesysdev.vovchuk.maxim.bankSecurity.controllers;

import com.fivesysdev.vovchuk.maxim.bankSecurity.models.DebitCard;
import com.fivesysdev.vovchuk.maxim.bankSecurity.models.Entering;
import com.fivesysdev.vovchuk.maxim.bankSecurity.models.Loan;
import com.fivesysdev.vovchuk.maxim.bankSecurity.services.DebitCardsService;
import com.fivesysdev.vovchuk.maxim.bankSecurity.services.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accountMenu")
public class AccountController {
    private final LoansService loansService;
    private final DebitCardsService debitCardsService;

    @Autowired
    public AccountController(LoansService loansService, DebitCardsService debitCardsService) {
        this.loansService = loansService;
        this.debitCardsService = debitCardsService;
    }

    @GetMapping("/accountMenu")
    public String accountPage() {
        return "accountMenu/accountMenu";
    }

    @GetMapping("/myAcc")
    public String myAcc(Model model) {
        model.addAttribute("user", Entering.getUserFromContext());
        return "accountMenu/myAcc";
    }

    @GetMapping("/myBal")
    public String myBal(Model model) {
        model.addAttribute("balance", debitCardsService.countMyBalance());
        return "accountMenu/myBal";
    }

    @GetMapping("/myLoans")
    public String myLoans(Model model) {
        model.addAttribute("loans", loansService.myLoansInfo());
        return "accountMenu/myLoans";
    }

    @GetMapping("/newDebitCard")
    public String newDebitCard(Model model) {
        model.addAttribute("debitCard", new DebitCard());
        return "accountMenu/newDebitCard";
    }

    @PostMapping("/newDebitCard")
    public String newDebitCard(@ModelAttribute("debitCard") DebitCard debitCard) {
        debitCardsService.save(debitCard);
        return "redirect:/accountMenu/accountMenu";
    }

    @GetMapping("/newLoan")
    public String newLoan(Model model) {
        model.addAttribute("loan", new Loan());
        return "accountMenu/newLoan";
    }

    @PostMapping("/newLoan")
    public String newLoan(@ModelAttribute("loan") Loan loan) {
        loansService.save(loan);
        return "redirect:/accountMenu/accountMenu";
    }
}
